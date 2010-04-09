package datos;

import java.util.List;

import ncsa.hdf.object.*;
import ncsa.hdf.object.h4.*;

public class HdfLoad {
	public void printAttribute(String fname, Integer member) throws Exception {
		// retrieve an instance of H4File
		FileFormat fileFormat = FileFormat
				.getFileFormat(FileFormat.FILE_TYPE_HDF4);

		if (fileFormat == null) {
			System.err.println("Cannot find HDF4 FileFormat.");
			return;
		}

		// open the file with read-only access
		FileFormat testFile = fileFormat.open(fname, FileFormat.READ);

		if (testFile == null) {
			System.err.println("Failed to open file: " + fname);
			return;
		}

		// open the file and retrieve the file structure
		testFile.open();
		Group root = (Group) ((javax.swing.tree.DefaultMutableTreeNode) testFile
				.getRootNode()).getUserObject();

		// retrieve the dataset "2D 32-bit integer 20x10"
		System.out.println("Atributos del grupo raíz");
		printAttributeList(root.getMetadata());
		
		Group group0 = (Group) root.getMemberList().get(0);
		System.out.println("Atributos del grupo MODIS_Grid_Daily_1km_LST");
		printAttributeList(group0.getMetadata());
		
		Group group1 = (Group) group0.getMemberList().get(0);
		System.out.println("Atributos del grupo Data Fields");
		printAttributeList(group0.getMetadata());
		
		Dataset dataset = (Dataset) group1.getMemberList().get(member);

		// read the attribute into memory
		System.out.println("Atributos del dataset LST_Day_1km");
		printAttributeList(dataset.getMetadata());
		

		// printGroup(root, "");

		// close file resource
		testFile.close();
	}
	
	public void printAttributeList(List attrList) {
		for (int i = 0; i < attrList.size(); i++) {
			Attribute attr = (Attribute) attrList.get(i);
			//attr.t
			// print out attribute value
			System.out.println(attr.toString() + " = ");
			System.out.println(attr.toString(" ---- "));
		}
	}

	public void printFileStructure(String fname) throws Exception {
		// retrieve an instance of H4File
		FileFormat fileFormat = FileFormat
				.getFileFormat(FileFormat.FILE_TYPE_HDF4);

		if (fileFormat == null) {
			System.err.println("Cannot find HDF4 FileFormat.");
			return;
		}

		// open the file with read-only access
		FileFormat testFile = fileFormat.open(fname, FileFormat.READ);

		if (testFile == null) {
			System.err.println("Failed to open file: " + fname);
			return;
		}

		// open the file and retrieve the file structure
		testFile.open();
		Group root = (Group) ((javax.swing.tree.DefaultMutableTreeNode) testFile
				.getRootNode()).getUserObject();

		printGroup(root, "");

		// close file resource
		testFile.close();
	}

	/**
	 * Recursively print a group and its members.
	 * 
	 * @throws Exception
	 */
	private static void printGroup(Group g, String indent) throws Exception {
		if (g == null)
			return;

		java.util.List members = g.getMemberList();

		int n = members.size();
		indent += "    ";
		HObject obj = null;
		for (int i = 0; i < n; i++) {
			obj = (HObject) members.get(i);
			System.out.println(indent + obj);
			if (obj instanceof Group) {
				printGroup((Group) obj, indent);
			}
		}
	}
}
