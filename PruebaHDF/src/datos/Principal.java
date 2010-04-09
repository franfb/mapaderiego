package datos;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HdfLoad loader = new HdfLoad();
		loader.printFileStructure("C:\\Documents and Settings\\Fran_Javi\\Escritorio\\PFC\\Datos\\Aqua11A1\\MYD11A1.A2009001.h16v06.005.2009013150259.hdf");
		loader.printAttribute("C:\\Documents and Settings\\Fran_Javi\\Escritorio\\PFC\\Datos\\Aqua11A1\\MYD11A1.A2009001.h16v06.005.2009013150259.hdf", 0);	
	}
}
