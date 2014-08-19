package edu.ycp.cs320.ClassExtracter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Constructor
//upload directory to read
//download FLS code chunks into java file


public class System {
//private File fileToSave;
//private FileWriter writer;
private String userFileName,saveLocation;
	

public System() throws IOException{
		userFileName = "default.java";
		saveLocation = "defaultdirectory";
//		fileToSave = new File(saveLocation);
	}

//MANGES DOWNLOAD*****************************************
	public void setDownloadFileName(String name){
		userFileName = name;
		if (!name.endsWith(".java")) {
			userFileName += ".java";
		}
	}
	public void setDirectory(String location){
		saveLocation = location;
	}
	public void save(String code) throws IOException{
		FileWriter writer = null;
		try {
			writer = new FileWriter(saveLocation + "/" +userFileName);
			writer.write(code);
		} finally {
			if (writer != null) {
				// file was opened, so try to close it
				writer.close();
			}
		}
	}
//MANGES UPLOAD SCAN******************************
	public List scanDirectory(String location){
		//while .java does not exist scan everything
		
		List<String> allJavaFiles =
			recursiveFileSearch(location, ".java");
		
		return allJavaFiles;
		
	}
	
	private List<String> recursiveFileSearch(String location, String extension) {
		ArrayList<String> result = new ArrayList<String>();
		
		doRecursiveFileSearch(new File(location), extension, result);
		return result;
	}
	
	private void doRecursiveFileSearch(File file, String extension,
			ArrayList<String> result) {
		if (!file.isDirectory()) {
			// Visiting a file.
			if (file.getName().endsWith(extension)) {
				result.add(file.getPath());
			}
			return;
		} else {
			// Visiting a directory
			File[] contents = file.listFiles();
			for (File child : contents) {
				doRecursiveFileSearch(child, extension, result);
			}
		}
	}
	
	
	
}
