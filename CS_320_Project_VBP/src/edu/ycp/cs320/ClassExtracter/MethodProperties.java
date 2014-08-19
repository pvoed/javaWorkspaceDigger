package edu.ycp.cs320.ClassExtracter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
//STORES THE PROPERTIES OF A METHOD
public class MethodProperties {	
	private MethodTypes Method_visiblityType;
	private ArrayList<param> ParamList;

	private DataTypes Return_Type;
	private String methodName, codeString;
	private boolean finalInstance,staticInstance,abstractInstance;

	//PARAMETER OBJECT********************************************************
	public class param{
		private String name;
		private DataTypes type;
		public param(){
			name = "";
			type = DataTypes.VOID;
		}
		public void setName(String name){
			this.name = name;
		}
		public void setDataType(String type){

			this.type = determindType(type);
		}
		public String getName(){
			return name;
		}
		public DataTypes getDataType(){
			return type;
		}
	}
	//CONSTRUCTOR****************************************************************
	public MethodProperties(){
		Method_visiblityType = MethodTypes.DEFAULT;
		ParamList = new ArrayList<param>();
		;
		methodName = "";
		Return_Type = DataTypes.VOID;
		finalInstance = false;
		staticInstance = false;
		abstractInstance = false;
		codeString = "";
	}
	public String toString(){
		String toReturn = "\n MethodName: "+methodName+"\nVisibility : "+ Method_visiblityType.toString() + "\n Static: " + staticInstance + "\n Final: " + finalInstance +"\n Abstract: "+ abstractInstance+"\n ReturnType: "+Return_Type.toString()+ "\n Parameter(s): ";

		Iterator itr = ParamList.iterator();
		while (itr.hasNext()){
			param p = (param) itr.next();
			toReturn = toReturn+ p.getDataType()+" " +p.getName()+ "; ";
		}
		return toReturn;
	}
	//INSTANCE OF METHOD********************************************************
	public void isFinal(){
		finalInstance =true;
	}
	public void isStatic(){
		staticInstance=true;
	}
	public void isAbstract(){
		abstractInstance =true;
	}
	public boolean getFinal(){
		return finalInstance;
	}
	public boolean getStatic(){
		return staticInstance;
	}
	public boolean getAbstract(){
		return abstractInstance;
	}
	//SETTERS***************************************************************************
	//METHOD VISIBILITY
	public void setVisibilityType(String MethodType){
		if(MethodType.equals("public")){
			Method_visiblityType=MethodTypes.PUBLIC;				
		}
		else if(MethodType.equals("private")){
			Method_visiblityType=MethodTypes.PRIVATE;
		}			

		else if(MethodType.equals("protected")){
			Method_visiblityType=MethodTypes.PROTECTED;			
		}		
	}
	//METHOD RETURN TYPE
	public void setRType(String type){		
		Return_Type = determindType(type);		
	}
	//PARAMETER
	public void addPType(String paramPhrase){		
		param p = new param();
		StringTokenizer st = new StringTokenizer(paramPhrase);
		p.setDataType(st.nextToken());
		p.setName(st.nextToken());
		ParamList.add(p);
	}
	public void setMethodName(String name){
		methodName = name;
	}
	//GETTERS****************************************************************************
	public MethodTypes getVisibilityType(){
		return Method_visiblityType;
	}
	public ArrayList getPList(){			
		return ParamList;		
	}
	public DataTypes getRType(){		
		return Return_Type;
	}
	public String getMethodName(){
		return methodName;
	}

	//TYPE DETERMINDING DATATYPES**************************************************
	public static DataTypes determindType(String deterType){
		if(deterType.equals("int")){
			return DataTypes.INT;				
		}
		else if(deterType.equals("double")){
			return DataTypes.DOUBLE;				
		}
		else if(deterType.equals("String")){
			return DataTypes.STRING;				
		}
		else if(deterType.equals("char")){
			return DataTypes.CHAR;				
		}
		else if(deterType.equals("float")){
			return DataTypes.FLOAT;	
		}
		else if(deterType.equals("byte")){
			return DataTypes.BYTE;
		}
		else if(deterType.equals("short")){
			return DataTypes.SHORT;
		}
		else if(deterType.equals("long")){
			return DataTypes.LONG;
		}
		else if(deterType.equals("void")){
			return DataTypes.VOID;
		}
		else if(deterType.equals("array")){
			return DataTypes.ARRAY;
		}
		else if(deterType.equals("interface")){
			return DataTypes.INTERFACE;
		}
		else if(deterType.equals("boolean")){
			return DataTypes.BOOLEAN;
		}
		else{
			return DataTypes.E;
		}		
		//The rest of them.... as well...
	}
	//ACESSOR*******************************************************************************
	public void methodParser(String methodHeader){
		//methodHeader  = [visibility] ["static"] returnType methodName "(" [parameterList] ")" . 

		String beforeParen = methodHeader.substring(0,methodHeader.lastIndexOf("("));
		//System.out.println(beforeParen);
		String insideParen = methodHeader.substring(methodHeader.lastIndexOf( "(")+1, methodHeader.lastIndexOf(")"));
		//System.out.println(insideParen);
		insideParen = insideParen.replace(",", " ");


		StringTokenizer st = new StringTokenizer(beforeParen);
		//set visiblity
		setVisibilityType(st.nextToken());
		//check for if an existing instance of the method
		//System.out.println(beforeParen.length());
		if(beforeParen.indexOf(" ")!=beforeParen.lastIndexOf(" ")){
			String instance= st.nextToken();
			if(instance.equals("static")){
				isStatic();
				instance= st.nextToken();
			}else if(instance.equals("abstract")){
				isAbstract();
				instance= st.nextToken();
			}else if(instance.equals("final")){
				isFinal();
				instance= st.nextToken();
			}else{
				//then it is a return type
				setRType(instance);
			}


			//set method name
			String methodName = st.nextToken();
			setMethodName(methodName);
		}else{
			//constructor
			String methodName = st.nextToken();
			setMethodName(methodName);
		}

		//set param
		st = new StringTokenizer(insideParen);
		while(st.hasMoreElements()){
			String paramSet = st.nextToken() + " " + st.nextToken();
			addPType(paramSet);
		}
	}

	public void methodContent(String firstLine) {
		codeString = codeString + " \n" + firstLine;
	}

	public String toStringCode() {

		return codeString;
	}


}
