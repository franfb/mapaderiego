package datos;

public class LstData {
	private double[] data;
	private int dimX, dimY;
	private double scaleFactor;

	public LstData(int dimX, int dimY, double scaleFactor) {
		this.dimX = dimX;
		this.dimY = dimY;
		this.scaleFactor = scaleFactor;
		data = new double[dimX * dimY];
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
		for (int i = 0; i < dimX; i++)
			for (int j = 0; j < dimY; j++) {
				this.data[i * dimY + j] = data[i * dimY + j] * scaleFactor;
			}
	}

	public double[] getData() {
		return data;
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
