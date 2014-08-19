import edu.ycp.cs320.ClassExtracter.FileListStructure;
import edu.ycp.cs320.ClassExtracter.FileProperties;
import edu.ycp.cs320.ClassExtracter.ProgramReader;
import edu.ycp.cs320.ClassExtracter.SystemControl;
import junit.framework.TestCase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public class SystemTest extends TestCase {

private SystemControl s;
private FileListStructure fls;
private FileProperties fp;
private ProgramReader pr;

	
	public void setUp() throws Exception{
		 s = new SystemControl();
		 fls = new FileListStructure();
		 fp = new FileProperties();
		 pr = new ProgramReader();
		 
	}
	
	public  void uploadTest() throws FileNotFoundException {
		s.setDirectory("H:\\workspace\\CS350_Lab4");
		String startingDirectory = "H:\\workspace\\CS350_Lab4";
		List<String> files = s.scanDirectory(startingDirectory);
		for(String f: files){
			System.out.println(f);
		}
		
		assertEquals("H:\\workspace\\CS350_Lab4", s.getRootDir());
	}
	public void downloadsTest() throws Exception{
		s.setDownloadFileName("testSave");
		s.setDirectory("resource/");
		assertEquals("resource/", s.getDirectory());
		assertEquals("testSave.java",s.getDownloadFileName());
		
	}
	
	public void downloadFLSTest() throws Exception {
		pr.setFileLocation("H:\\workspace\\CS_320_Project_VBP\\src\\edu\\ycp\\cs320\\ClassExtracter\\MethodProperties.java");
		pr.readLines();
		
	}
}
