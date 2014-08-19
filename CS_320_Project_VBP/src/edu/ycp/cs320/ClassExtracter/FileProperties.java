package edu.ycp.cs320.ClassExtracter;

import java.util.ArrayList;
import java.util.Iterator;
//FOR JAVA FILE:  FILE ATTRIBUTES, 
//STORES METHODPROPERTIES
import edu.ycp.cs320.ClassExtracter.MethodProperties.param;

public class FileProperties {

	private String name,location,code;
	private ArrayList<MethodProperties>methodlist; 
	private ArrayList<String>classFields;
	private ArrayList<String>classes;
	private int sizeMethod;
	private int sizeVar;
	private int classesSize;




	public FileProperties(){
		this.name = "";
		this.location = "";
		classes = new ArrayList<String>();
		methodlist = new ArrayList<MethodProperties>();
		classFields = new ArrayList<String>();
		sizeMethod=0;
		sizeVar=0;
		classesSize=0;
		code = "";
	}
	public String toString(){
		String toReturn = " FileName: "+name+"\n File Path: "+location+"\n # of Methods: "+ sizeMethod+"\n";

		toReturn = toReturn+" Class Name: ";
		Iterator itr = classes.iterator();
		while (itr.hasNext()){
			String c = (String) itr.next();
			toReturn = toReturn+ c.toString() + "\n";
		}

		itr = methodlist.iterator();
		while (itr.hasNext()){
			MethodProperties m = (MethodProperties) itr.next();
			toReturn = toReturn+ m.toString();
		}
		return toReturn;
	}
	public String methodCodesToString(){
		String code = "";
		Iterator itr = methodlist.iterator();
		while (itr.hasNext()){
			MethodProperties m = (MethodProperties) itr.next();
			code = code + m.toStringCode();
		}
		return code;
	}



	public void removeMethod(int i){
		methodlist.remove(i);
		sizeMethod--;
	}
	public void setName(String name){
		this.name = name;
	}
	public void addClass(String name){
		classes.add(classesSize, name);
		classesSize++;
	}
	public void setLocation(String location){
		this.location = location;
	}
	public int getMethodSize(){
		return sizeMethod;
	}
	public String getName() {
		return name;
	}	
	public String getLocation() {
		return location;
	}	
	public MethodProperties getMethod(int index) {
		return methodlist.get(index);
	}
	public void setMethod( MethodProperties name) {
		methodlist.add(sizeMethod,name);
		sizeMethod++;		
	}
	public String getVariable(int index){
		return classFields.get(index);
	}
	public void setVariable(int sizeVar, MethodProperties name) {
		methodlist.set(sizeVar,name);
		sizeVar++;		
	}

	public void setCode(String firstLine) {
		code = code + " \n" + firstLine;
	}
	public String getCode(){
		return code;
	}

}


