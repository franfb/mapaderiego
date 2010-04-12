package datos;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		HdfLoad loader = new HdfLoad();
//		loader.openFile("C:\\Documents and Settings\\Fran_Javi\\Escritorio\\PFC\\Datos\\Aqua11A1\\MYD11A1.A2009001.h16v06.005.2009013150259.hdf");
//		//loader.printFileStructure("C:\\Documents and Settings\\Fran_Javi\\Escritorio\\PFC\\Datos\\Aqua11A1\\MYD11A1.A2009001.h16v06.005.2009013150259.hdf");
//		loader.printAttribute(HdfLoad.LstDay1km);
//		LstData dataDay = new LstData(LstConstants.dimX, LstConstants.dimY, LstConstants.scaleFactor);
//		loader.readDataset(dataDay, HdfLoad.LstDay1km);
//		dataDay.setCoordinates();
//		dataDay.getInterpolatedTemperature(28.2230644372507, -16.75267301976);
		
		AllStations stations = new AllStations();
		stations.readStationsData("C:\\Documents and Settings\\Fran_Javi\\Escritorio\\PFC\\Estaciones\\estacionesagrocabildo.txt");
		
//		System.out.println("Coordenada[0,0] = (" + dataDay.getLat()[0] + ", " + dataDay.getLon()[0] + ")");
//		System.out.println("Coordenada[0,1199] = (" + dataDay.getLat()[1199] + ", " + dataDay.getLon()[1199] + ")");
//		System.out.println("Coordenada[1199,0] = (" + dataDay.getLat()[1199 * 1200] + ", " + dataDay.getLon()[1199 * 1200] + ")");
//		System.out.println("Coordenada[1199,1199] = (" + dataDay.getLat()[1199 * 1200 + 1199] + ", " + dataDay.getLon()[1199 * 1200 + 1199] + ")");
//		dataDay.show(false);
		
//		LstData dataNight = new LstData(LstConstants.dimX, LstConstants.dimY, LstConstants.scaleFactor);
//		loader.readDataset(dataNight, HdfLoad.LstNight1km);
//		dataNight.setCoordinates();
//		System.out.println("Coordenada[0,0] = (" + dataNight.getLat()[0] + ", " + dataNight.getLon()[0] + ")");
//		System.out.println("Coordenada[0,1199] = (" + dataNight.getLat()[1199] + ", " + dataNight.getLon()[1199] + ")");
//		System.out.println("Coordenada[1199,0] = (" + dataNight.getLat()[1199 * 1200] + ", " + dataNight.getLon()[1199 * 1200] + ")");
//		System.out.println("Coordenada[1199,1199] = (" + dataNight.getLat()[1199 * 1200 + 1199] + ", " + dataNight.getLon()[1199 * 1200 + 1199] + ")");
//		dataNight.show(false);
		
//		loader.closeFile();
	}
}
