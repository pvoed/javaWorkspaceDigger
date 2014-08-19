package edu.ycp.cs320.ClassExtracter;

//import java.util.ArrayList;
import java.lang.*;
import java.util.Arrays;

//CLASS WHICH STORES FILEPROPERTIES CLASSES
public  class FileListStructure {
	private int size,maxCap;
	private HashDictionary<String, FileProperties> dict;
	private FileProperties[] allFiles;
	private boolean empty;

	public FileListStructure(){
		maxCap = 20;
		allFiles = new FileProperties[maxCap];
		size = 0;
		empty = false;
		dict = new HashDictionary<String, FileProperties>();
	}
	public FileProperties removeFile(String FileName){
		size--;
		return dict.remove(FileName);

	}
	public FileProperties ExamineFile(String FileName){
		return dict.get(FileName);
	}
	public void addFile(FileProperties File){
		//if(File.getName()!=""){
		dict.put(File.getName(), File);
		if(size+1==maxCap){
			maxCap=maxCap*2;
			FileProperties[] temp = new FileProperties[maxCap];
			System.arraycopy(temp, 0, allFiles, 0, allFiles.length);
                        //Arrays.copyOfRange(temp, 0, allFiles, 0, allFiles.length);
                        //Arrays.copyOf(allFiles, allFiles.length);
			allFiles=temp;
		}
		allFiles[size]= File;
		size++;
		//}
}

	public HashDictionary CopyList(){
		return dict;

	}
	public boolean isEmpty(){
		if (size==0){
			empty=true; 
		}
		else if (size>0){
			empty=false;
		}
		return empty;

	}
	public int getSize(){
		return allFiles.length;
	}
	public FileProperties[] getFileProperties() {

		FileProperties[] temp = new FileProperties[size];
		System.arraycopy(allFiles, 0,temp , 0, size);
		return temp;
	}

	public String toString() {
		// this should return the name of the Java source file
		return "The file name";
	}

}

