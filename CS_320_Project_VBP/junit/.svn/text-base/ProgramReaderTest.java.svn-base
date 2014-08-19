import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.ClassExtracter.FileProperties;
import edu.ycp.cs320.ClassExtracter.ProgramReader;
import edu.ycp.cs320.ClassExtracter.SystemControl;
import junit.framework.TestCase;


public class ProgramReaderTest extends TestCase {
	private ProgramReader p;
	private SystemControl sysControl;

	@Before
	public void setUp() throws Exception{
		Reader r = new InputStreamReader(
				this.getClass().getClassLoader().getResourceAsStream("resource/hello.txt")
		);
		p = new ProgramReader();
		p.setFileReader(r);
		sysControl = new SystemControl();
	}
	
	@After
	public void cleanUp() throws IOException {
		p.getFileReader().close();
	}

	@Test
	public void testParseFile() throws Exception {
		Reader r = new InputStreamReader(
				this.getClass().getClassLoader().getResourceAsStream("resource/bye.txt")
		);
		p.setFileReader(r);
		assertEquals(p.getFileReader(), r);

	}

	@Test
	public void testReadLines() throws Exception {
		
		List<String> s = sysControl.scanDirectory("H:/workspace/CS_320_Project_VBP/src/edu/ycp/cs320/ClassExtracter");

		for (int i = 0; i < s.size(); i++) {
			
		p.setFileLocation(s.get(i));
		
		FileInputStream fis = new FileInputStream(p.getFileLocation());
		Reader r = new InputStreamReader(fis);
		p.setFileReader(r);
		p.readLines();
		FileProperties f = (FileProperties)p.getFP();
		System.out.println(f.toString());

		}
//		p.setFileReader(i);
//		p.readLines();
//		FileProperties f = (FileProperties)p.getFP();
//		System.out.println(f.toString());
//		

		
	}
	
	@Test
	public void selectFileToScan() throws Exception{
		
	}
	
}
