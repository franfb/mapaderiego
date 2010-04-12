package datos;

import java.lang.Math;

public class LstData {
	// Temperature data
	private double[] data;
	private int dimX, dimY;
	private double scaleFactor;
	// Coordinates data
	private double[] lat;
	private double[] lon;

	public LstData(int dimX, int dimY, double scaleFactor) {
		this.dimX = dimX;
		this.dimY = dimY;
		this.scaleFactor = scaleFactor;
		data = new double[dimX * dimY];
		lat = new double[dimX * dimY];
		lon = new double[dimX * dimY];
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public int getDimX() {
		return dimX;
	}

	public int getDimY() {
		return dimY;
	}

	public double getScaleFactor() {
		return scaleFactor;
	}

	public void setData(short[] data) {
		for (int y = 0; y < dimX; y++)
			for (int x = 0; x < dimY; x++) {
				this.data[y * dimY + x] = data[y * dimY + x] * scaleFactor;
			}
	}

	public double[] getData() {
		return data;
	}
	
	public void setCoordinates() {
		double delta = 1.0 / 1200.0;
		double vllat = LstConstants.vllat;
		double vulat = LstConstants.vulat;
		double vllon = LstConstants.vllon;
		double vrlon = LstConstants.vrlon;
		double r = LstConstants.earthRadius;
		double pi = Math.PI;
		double la, lo;
		for (int y = 0; y < dimY; y++) {
			for (int x = 0; x < dimX; x++) {
				la = y * delta * (vllat - vulat) + vulat;
				lat[y * dimY + x] = (la / r) * (180.0 / pi);
				lo = x * delta * (vrlon - vllon) + vllon;
				lon[y * dimY + x] = (lo / (r * Math.cos(la / r))) * (180.0 / pi);
			}
		}
	}
	
	public double[] getLat() {
		return lat;
	}

	public double[] getLon() {
		return lon;
	}
	
	public void getInterpolatedTemperature(double lat, double lon) {
		int lat1, lat2;
		int y = 0;
		while ((y < dimY) && (lat <= this.lat[y * dimY])) {
			y++;
		}
		lat1 = y - 1;
		lat2 = y;

		System.out.println("Latitudes:");
		System.out.println("lat1 = " + this.lat[lat1 * dimY]);
		System.out.println("lat = " + lat);
		System.out.println("lat2 = " + this.lat[lat2 * dimY]);
		
		int lon1, lon2;
		int x = dimX - 1;
		while ((x >= 0) && (lon <= this.lon[lat1 * dimY + x])) {
			x--;
		}
		lon1 = x + 1;
		lon2 = x;
		

		System.out.println("Longitudes:");
		System.out.println("lon1 = " + this.lon[lat1 * dimY + lon1]);
		System.out.println("lon = " + lon);
		System.out.println("lon2 = " + this.lon[lat1 * dimY + lon2]);
		System.out.println("Temperatura lat1,lon1 = " + (data[lat1 * dimY + lon1] - 273.15));
		System.out.println("Temperatura lat1,lon2 = " + (data[lat1 * dimY + lon2] - 273.15));
		System.out.println("Temperatura lat2,lon1 = " + (data[lat2 * dimY + lon1] - 273.15));
		System.out.println("Temperatura lat2,lon2 = " + (data[lat2 * dimY + lon2] - 273.15));
	}

	public void show(boolean showZeros) {
		if (data != null) {
			for (int i = 0; i < dimX; i++) {
				for (int j = 0; j < dimY; j++) {
					if (showZeros)
						System.out.print(data[i * dimY + j] + " ");
					else if (data[i * dimY + j] != 0) {
						System.out.print(data[i * dimY + j] + " ");
					}
				}
				System.out.println();
			}
		}
		else {
			System.out.println("La variable data no está inicializada");
		}
	}
}
