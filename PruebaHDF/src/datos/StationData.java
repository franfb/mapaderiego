package datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class StationData {
	private double lat, lon;
	private int alt;
	private String nombre, year;
	private double[] tmin, tmed, tmax;
	private int maxDays = 365;
	
	public void setData(String nombre, double lat, double lon, int alt, String year, String path) {
		this.nombre = nombre;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.year = year;
		
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			archivo = new File (path + "\\Porestaciones2009et\\" + nombre + year + ".dat");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			String linea;
			double tmin, tmed, tmax;
			int diaJuliano;
			this.tmin = new double[maxDays];
			this.tmed = new double[maxDays];
			this.tmax = new double[maxDays];
			int i = 0;
			while ((linea = br.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(linea);
				diaJuliano = new Integer(tokens.nextToken());
				// Nos saltamos el año, el mes y el dia
				tokens.nextToken();
				tokens.nextToken();
				tokens.nextToken();
				
				tmed = new Double(tokens.nextToken());
				tmax = new Double(tokens.nextToken());
				tmin = new Double(tokens.nextToken());
				
				if ((i + 1) != diaJuliano) {
					for (int j = i; j < diaJuliano; j++) {
						this.tmin[j] = this.tmed[j] = this.tmax[j] = 999.0;
					}
					i = diaJuliano - 1;
				}
				
				this.tmin[i] = tmin;
				this.tmed[i] = tmed;
				this.tmax[i] = tmax;
				i++;
			}
			if (i < maxDays) {
				for (int j = i; j < maxDays; j++) {
					this.tmin[j] = this.tmed[j] = this.tmax[j] = 999.0;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public void show() {
		System.out.println("Estación: " + nombre);
		System.out.println("\tLatitud: " + lat);
		System.out.println("\tLongitud: " + lon);
		System.out.println("Datos:");
		for (int i = 0; i < maxDays; i++) {
			System.out.println("\t" + tmin[i] + " " + tmed[i] + " " + tmax[i]);
		}
	}
}
