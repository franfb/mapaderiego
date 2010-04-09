package datos;

public class Principal {
	private static final int dimX = 1200;
	private static final int dimY = 1200;
	private static final double scaleFactor = 0.02;
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HdfLoad loader = new HdfLoad();
		loader.openFile("C:\\Documents and Settings\\Fran_Javi\\Escritorio\\PFC\\Datos\\Aqua11A1\\MYD11A1.A2009001.h16v06.005.2009013150259.hdf");
		//loader.printFileStructure("C:\\Documents and Settings\\Fran_Javi\\Escritorio\\PFC\\Datos\\Aqua11A1\\MYD11A1.A2009001.h16v06.005.2009013150259.hdf");
//		loader.printAttribute(loader.LstDay1km);
		LstData dataDay = new LstData(dimX, dimY, scaleFactor);
		loader.readDataset(dataDay, loader.LstDay1km);
		dataDay.show(false);
		
		LstData dataNight = new LstData(dimX, dimY, scaleFactor);
		loader.readDataset(dataNight, loader.LstNight1km);
		dataNight.show(false);
		
		loader.closeFile();
	}
}
