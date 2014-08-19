package edu.ycp.cs320.ClassExtracter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//upload directory and filters out all .java files in subdirectory
//downloads code chunks into java file


public class SystemControl {

	private String userFileName,saveLocation,rootDir;



	public SystemControl(){
		userFileName = "default.java";
		saveLocation = "defaultdirectory";
		rootDir = "defaultreoot";
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
	public String getDownloadFileName(){
		return userFileName;
	}
	public String getDirectory(){
		return saveLocation;
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
	public List<String> scanDirectory(String location){
		//for everything in this main directory recursively do the same
		// if its another folder and add it to the list if its a .java file
		rootDir = location;
		List<String> allJavaFiles =
			recursiveFileSearch(location, ".java");

		return allJavaFiles;

	}
	public String getRootDir(){
		return rootDir;
	}

	private List<String> recursiveFileSearch(String location, String extension) {
		List<String> result = new ArrayList<String>();
		result = doRecursiveFileSearch(location, extension, result);
		return result;
	}
	//recursive search
	private List<String> doRecursiveFileSearch(String fileDir, String extension,
			List<String> result) {

		File root = new File(fileDir);
		File[] allContents = root.listFiles();
		List<File> allFiles = Arrays.asList(allContents);

		for(File file : allFiles) {
			if (!file.isDirectory()) {
				// Visiting a file.
				if (file.getName().endsWith(extension)) {
					result.add(file.getPath());
				}

			} else {
				// Visiting a directory

				result = doRecursiveFileSearch(file.getPath(), extension, result);

			}
		}
		return result;
	}
}




