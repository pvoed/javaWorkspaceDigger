package edu.ycp.cs320.ClassExtracter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.StringTokenizer;
//READS .JAVA FILES AND GENERATES FILEPROP/METHODPROP
public class ProgramReader {
	//private fields
	String[] lines;
	int i = 0;
	private String fileLocation,fileName;
	private Reader fr;
	private BufferedReader br;
	private FileProperties fileProperties; 
	private SystemControl sysControl;
	private FileListStructure flp;



	public ProgramReader() throws FileNotFoundException {
		fileProperties = new FileProperties();
		fileLocation = "";

	}

	public void setFileReader(Reader fr) {
		this.fr = fr;
	}
	public FileProperties getFP(){
		return fileProperties;
	}
	//MAIN READING FUNCTION
	public void readLines() throws IOException {

		FileInputStream fis = new FileInputStream(getFileLocation());
		fr = new InputStreamReader(fis);
		setFileReader(fr);
		br = new BufferedReader(fr);
		String firstLine;
		MethodProperties methodProperties = null;
		Stack<String> s = null;
		fileProperties = new FileProperties();
		fileProperties.setName(getFileName());

		try {
			while (true){
				firstLine = br.readLine();
				if (firstLine == null) {
					break;
				}
				fileProperties.setCode(firstLine);
				//if it is a class
				if (isClassDeclaration(firstLine)){
					parseClassDeclaration(firstLine, fileProperties);
				}
				//creates a new instance of methodProp
				else if (parseMethodDeclaration(firstLine)) {
					try{
						s = new Stack<String>();
						methodProperties= new MethodProperties();
						methodProperties.methodParser(firstLine);
						fileProperties.setMethod(methodProperties);
						s.push("{");
						methodProperties.methodContent(firstLine);
					}catch(NoSuchElementException ex){
						methodProperties= new MethodProperties();
						methodProperties.setMethodName("Unreadable Method");
						fileProperties.setMethod(methodProperties);
					}


				}
				//adds lines of code into methodProp
				else if(isMethodCodeLine(s, firstLine)){
					methodProperties.methodContent(firstLine);

				} else {

				}



			}
		} finally {
			br.close();
		}  

	}


	private boolean isClassDeclaration(String firstLine) {
		boolean determineIfClass = false;
		StringTokenizer st = new StringTokenizer(firstLine);
		while (st.hasMoreTokens()) {
			String token = st.nextToken();

			if (token.equals("class")) {
				determineIfClass = true;	
			}
		}

		if (determineIfClass == true) {
			return true;
		} else {
			return false;
		}
	}

	private boolean parseClassDeclaration(String firstLine, FileProperties property) {
		StringTokenizer st = new StringTokenizer(firstLine);
		while (st.hasMoreTokens()) {
			String token = st.nextToken();

			if (token.equals("class")) {
				try{
					fileProperties.addClass(st.nextToken());
					return true;}
				catch (NoSuchElementException ex){
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * Determine whether or not a line is a method declaration,
	 * and if it is, fill in a MethodProperties object with all of
	 * the information about the method.
	 * 
	 * @param firstLine a line of text
	 * @param methodProperties the MethodProperties object to fill in
	 * @return true if the line is a method declaration, false if not
	 */
	private boolean parseMethodDeclaration(String firstLine) {
		if(isMethodDeclaration(firstLine)) {

			return true;
		} else {
			return false;
		}

	}

	private boolean isMethodDeclaration(String firstLine) {
		StringTokenizer st = new StringTokenizer(firstLine);
		int size =st.countTokens();
		if( size > 3){
			String visibility = st.nextToken();
			if ( visibility.equals("protected") ||  visibility.equals("private") ||  visibility.equals("public")){
				if( firstLine.contains("(") && firstLine.contains(")") && firstLine.contains("{")){
					return true;
				}
			}
		}
		return false;
	}
	//determinds if still in method based off brackets
	private boolean isMethodCodeLine(Stack<String> s, String sentLine)
	{
		if(s == null){
			return false;
		} else {

			char[] line = sentLine.toCharArray();
			Object character;
			for (int i = 0; i < line.length; i++){

				character = line[i];

				if(character.equals("{")){
					s.push("{");}
				else if(character.equals("}")){
					s.pop();}
				if(s.isEmpty()){
					return false;
				}		
			}
			return true;
		}
	}


	public void setFileLocation(String fileToScan) throws FileNotFoundException {
		fileLocation= fileToScan;
		fileProperties.setLocation(fileLocation);
		fr = new FileReader(fileLocation);
		fileName = fileToScan.substring(fileToScan.lastIndexOf("\\")+1);
	}

	public Reader getFileReader() {
		return fr;
	}

	public String getFileName(){
		return fileName;
	}
	public String getFileLocation() {

		return fileLocation;
	}

}
