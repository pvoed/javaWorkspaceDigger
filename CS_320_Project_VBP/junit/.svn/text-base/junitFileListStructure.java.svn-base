import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.junit.After;
import org.junit.Before;

import edu.ycp.cs320.ClassExtracter.FileListStructure;
import edu.ycp.cs320.ClassExtracter.FileProperties;
import edu.ycp.cs320.ClassExtracter.HashDictionary;
import edu.ycp.cs320.ClassExtracter.ProgramReader;
import junit.framework.TestCase;


public class junitFileListStructure extends TestCase {
	//Testing the interaction between 2 FLS
	private FileListStructure PersonalTest,WorkTest;
	private FileProperties FileA,FileB,FileC;
	private ProgramReader p;





	@Before
	public void setUp() throws Exception{
		
//		FileInputStream fis = new FileInputStream("H:\\workspace\\CS_320_Project_VBP\\junit\\resource\\hello.txt");
//		Reader fr = new InputStreamReader(fis);
//		Reader r = new InputStreamReader(
//				this.getClass().getClassLoader().getResourceAsStream("resource/hello.txt")
//		);
		p = new ProgramReader();
//		p.setFileReader(r);
		p.setFileLocation("H:\\workspace\\CS_320_Project_VBP\\junit\\resource\\hello.txt");
		p.readLines();
		FileA = (FileProperties)p.getFP();
		p.getFileReader().close();

		p.setFileLocation("H:\\workspace\\CS_320_Project_VBP\\junit\\resource\\bye.txt");
		p.readLines();
		FileB = (FileProperties)p.getFP();
		p.getFileReader().close();

		p.setFileLocation("H:\\workspace\\CS_320_Project_VBP\\junit\\resource\\helloMethods.txt");
		p.readLines();
		FileC = (FileProperties)p.getFP();
		p.getFileReader().close();


		PersonalTest = new FileListStructure();
		WorkTest = new FileListStructure();

		
		//		FileA = new FileProperties();
		//		FileB = new FileProperties();
		//		FileC = new FileProperties();
		//		
		//		FileA.setName("FileA");
		//		FileB.setName("FileB");
		//		FileC.setName("FileC");
		//		FileA.setLocation("FileAProperties");
		//		FileB.setLocation("FileBProperties");
		//		FileC.setLocation("FileCProperties");

	}

	@After
	public void cleanUp() throws IOException {
		p.getFileReader().close();
	}

	//Methods to test
	//ISEMPTY()
	public void testIsEmpty() throws Exception {
		assertTrue(PersonalTest.isEmpty());
		assertTrue(WorkTest.isEmpty());

	}
	//ADDFILE()
	public void testAddFile() throws Exception{
		PersonalTest.addFile(FileA);
		assertEquals(FileA,PersonalTest.ExamineFile(FileA.getName()));
		
		WorkTest.addFile(FileB);
		assertFalse(PersonalTest.isEmpty());
		assertEquals(FileB,WorkTest.ExamineFile(FileB.getName()));
		WorkTest.addFile(FileC);
		assertFalse(WorkTest.isEmpty());
		assertEquals(FileC,WorkTest.ExamineFile(FileC.getName()));

		
	}
	//COPYLIST()
	public void testCopyList() throws Exception{
		HashDictionary TestHashTable = new HashDictionary<String, FileProperties>();
		assertTrue(PersonalTest.isEmpty());
		PersonalTest.addFile(FileB);
		TestHashTable = PersonalTest.CopyList();
		assertEquals(FileB, TestHashTable.get(FileB.getName()));
	}
	
	public void testSize() throws Exception{
		assertEquals(PersonalTest.getSize(), 20);
	}
	//REMOVEFILE()
//	public void testRemoveFile() throws Exception{
//		PersonalTest.addFile(FileA);
//		assertEquals(PersonalTest.removeFile(FileA.getName()),FileA);
//		assertTrue(PersonalTest.isEmpty());
//		PersonalTest.addFile(FileA);
//		WorkTest.addFile(FileB);
//		WorkTest.addFile(FileC);
//		assertFalse(PersonalTest.isEmpty());
//		assertFalse(WorkTest.isEmpty());
//		WorkTest.addFile(PersonalTest.removeFile(FileB.getName()));
//		assertTrue(PersonalTest.isEmpty());
//		assertEquals(WorkTest.ExamineFile(FileA.getName()),FileA);


//	}

}
