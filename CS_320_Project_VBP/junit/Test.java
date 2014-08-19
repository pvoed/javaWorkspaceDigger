import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.ClassExtracter.SystemControl;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SystemControl s = new SystemControl();
		String startingDirectory = "H:\\workspace\\CS350_Lab4";
		List<String> files = s.scanDirectory(startingDirectory);
		for(String f: files){
			System.out.println(f);
		}
		System.out.println(s.getRootDir());
		
//		public void setDownloadFileName(String name){
//		public void setDirectory(String location){
//		public String getDownloadFileName(){
//		public String getDirectory(){
//		public void save(String code) 
		System.out.println("Download phase...");
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Enter downloadFile name: ");
		s.setDownloadFileName(keyboard.nextLine());
		System.out.printf("Enter Directory to save to: ");
		s.setDirectory(keyboard.nextLine());
		System.out.printf("Code to save: ");
		try {
			s.save(keyboard.nextLine());
			System.out.println("Sucess!");
		} catch (IOException e) {
			System.out.println("Error could not save!");
		}
		

		
		
		
	}

}
