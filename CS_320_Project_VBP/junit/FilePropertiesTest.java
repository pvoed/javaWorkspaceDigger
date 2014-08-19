import edu.ycp.cs320.ClassExtracter.FileProperties;
import edu.ycp.cs320.ClassExtracter.MethodProperties;
import junit.framework.TestCase;


public class FilePropertiesTest extends TestCase {
	private FileProperties fileA;
	private MethodProperties methodA,methodB;


	protected void setUp() throws Exception{
		
		
		fileA = new FileProperties();
		methodA = new MethodProperties();	
		methodB = new MethodProperties();	
		methodA.methodParser("public static DataTypes determindType(String deterType){");
		methodB.methodParser("private void setVisibilityType(String MethodType){");
	}
	public void toStringTest() throws Exception{
		System.out.println(fileA.toString());
	}
	
	public void testGetsSets() throws Exception{
		fileA.setLocation("c:/ycp/Test.txt");
		fileA.setMethod(methodA);
		fileA.setMethod(methodB);
		fileA.setName("Test");
		
		assertEquals("c:/ycp/Test.txt",fileA.getLocation());
		assertEquals("Test",fileA.getName());
		assertEquals(methodA,fileA.getMethod(0));
		assertEquals(methodB,fileA.getMethod(1));
		System.out.println(fileA.toString());
	
	}
	
	

}

