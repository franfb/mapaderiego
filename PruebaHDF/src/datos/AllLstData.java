package datos;

import java.io.File;
import java.io.FilenameFilter;

public class AllLstData {
	private LstData[] lstDay;
	private LstData[] lstNight;
	private ModisLoader loader;
	private static final int MAX_LST_FILES = 365;

	public AllLstData() {
		loader = new ModisLoader();
	}

	public void readHdfDir(String dirName) {
		// Buscamos todos los ficheros HDF del directorio que queremos usar
		FilenameFilter hdfFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".hdf");
			}
		};

		File dir = new File(dirName);
		String[] children = dir.list(hdfFilter);
		if (children != null) {
			if (children.length > MAX_LST_FILES) {
				System.out
						.println("AVISO: Hay más de 365 ficheros HDF en el directorio");
			}
			lstDay = new LstData[children.length];
			lstNight = new LstData[children.length];
			for (int i = 0; i < children.length; i++) {
				System.out.println("Leyendo " + children[i]);
				try {
					loader.openFile(dir.getAbsolutePath() + "\\" + children[i]);
					lstDay[i] = readDataset(ModisLoader.LST_DAY_1KM);
					lstNight[i] = readDataset(ModisLoader.LST_NIGHT_1KM);
					loader.closeFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	private LstData readDataset(int datasetType) throws Exception {
		LstData data = new LstData(LstConstants.DIM_X, LstConstants.DIM_Y,
				LstConstants.SCALE_FACTOR);
		loader.readDataset(data, datasetType);
		data.setCoordinates();
		return data;
	}
}
