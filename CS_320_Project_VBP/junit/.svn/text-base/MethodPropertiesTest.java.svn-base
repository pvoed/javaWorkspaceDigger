import edu.ycp.cs320.ClassExtracter.DataTypes;
import edu.ycp.cs320.ClassExtracter.MethodProperties;
import edu.ycp.cs320.ClassExtracter.MethodTypes;
import edu.ycp.cs320.ClassExtracter.MethodProperties.param;
import junit.framework.TestCase;


public class MethodPropertiesTest extends TestCase {
	private MethodProperties TestCase;	
	private String header1,header2,header3;
	
	protected void setUp() throws Exception{
		TestCase = new MethodProperties();	
	}
	public void testsetVisibilityType() throws Exception{
		TestCase.setVisibilityType("private");
		assertEquals(TestCase.getVisibilityType(),MethodTypes.PRIVATE);
		TestCase.setVisibilityType("public");
		assertEquals(TestCase.getVisibilityType(),MethodTypes.PUBLIC);
		TestCase.setVisibilityType("protected");
		assertEquals(TestCase.getVisibilityType(),MethodTypes.PROTECTED);
	}
	
	public void testsetRType() throws Exception{
	TestCase.setRType("double");
	assertEquals(TestCase.getRType(),DataTypes.DOUBLE);
	TestCase.setRType("Trees");
	assertEquals(TestCase.getRType(),DataTypes.E);
	TestCase.setRType("int");
	assertEquals(TestCase.getRType(),DataTypes.INT);
	TestCase.setRType("String");
	assertEquals(TestCase.getRType(),DataTypes.STRING);
	TestCase.setRType("void");
	assertEquals(TestCase.getRType(),DataTypes.VOID);
	TestCase.setRType("char");
	assertEquals(TestCase.getRType(),DataTypes.CHAR);
	TestCase.setRType("float");
	assertEquals(TestCase.getRType(),DataTypes.FLOAT);
	TestCase.setRType("byte");
	assertEquals(TestCase.getRType(),DataTypes.BYTE);
	TestCase.setRType("short");
	assertEquals(TestCase.getRType(),DataTypes.SHORT);
	TestCase.setRType("long");
	assertEquals(TestCase.getRType(),DataTypes.LONG);
	TestCase.setRType("array");
	assertEquals(TestCase.getRType(),DataTypes.ARRAY);
	TestCase.setRType("interface");
	assertEquals(TestCase.getRType(),DataTypes.INTERFACE);
	}
	
	public void testaddPType() throws Exception{
		TestCase.addPType("int NumElements");
		param p = (param) TestCase.getPList().get(0);
		assertEquals(p.getName(),"NumElements");
		assertEquals(DataTypes.INT,p.getDataType());
		TestCase.addPType("double pi");
		TestCase.addPType("Comparator<E> compare");
		
		p = (param) TestCase.getPList().get(1);
		assertEquals(p.getName(),"pi");
		assertEquals(DataTypes.DOUBLE,p.getDataType());
		
		p = (param) TestCase.getPList().get(2);
		assertEquals(p.getName(),"compare");
		assertEquals(DataTypes.E,p.getDataType());

	}
	public void testToString() throws Exception{
		System.out.println(TestCase.toString());
	}
	public void testMethodParser() throws Exception{
		String header = "private void setVisibilityType(String MethodType){";
		param p;
		TestCase.methodParser(header);
		assertEquals(MethodTypes.PRIVATE, TestCase.getVisibilityType());
		assertFalse(TestCase.getStatic());
		assertFalse(TestCase.getFinal());
		assertFalse(TestCase.getAbstract());
		assertEquals(DataTypes.VOID, TestCase.getRType());
		assertEquals("setVisibilityType", TestCase.getMethodName());
		p = (param) TestCase.getPList().get(0);
		assertEquals(DataTypes.STRING,p.getDataType());
		assertEquals("MethodType",p.getName());
		System.out.println(TestCase.toString());
		
		TestCase = new MethodProperties();
		header = "public static DataTypes determindType(String deterType){";
		TestCase.methodParser(header);
		assertEquals(MethodTypes.PUBLIC, TestCase.getVisibilityType());
		assertTrue(TestCase.getStatic());
		assertFalse(TestCase.getFinal());
		assertFalse(TestCase.getAbstract());
		assertEquals(DataTypes.E, TestCase.getRType());
		assertEquals("determindType", TestCase.getMethodName());
		p = (param) TestCase.getPList().get(0);
		assertEquals("deterType",p.getName());
		assertEquals(DataTypes.STRING,p.getDataType());
		
		System.out.println(TestCase.toString());
		
		header = "protected abstract double methodHeader(String var1, int var2){";
		TestCase = new MethodProperties();
		TestCase.methodParser(header);
		assertEquals(MethodTypes.PROTECTED, TestCase.getVisibilityType());
		assertFalse(TestCase.getStatic());
		assertFalse(TestCase.getFinal());
		assertTrue(TestCase.getAbstract());
		assertEquals(DataTypes.DOUBLE, TestCase.getRType());
		assertEquals("methodHeader", TestCase.getMethodName());
		p = (param) TestCase.getPList().get(0);
		assertEquals("var1",p.getName());
		assertEquals(DataTypes.STRING,p.getDataType());
		p = (param) TestCase.getPList().get(1);
		assertEquals("var2",p.getName());
		assertEquals(DataTypes.INT,p.getDataType());

		System.out.println(TestCase.toString());
		}
	
//	public void methodContent(String firstLine) {
//		methodContent.add(firstLine);
//		codeString = codeString + " \n" + firstLine;
//	}
//	
//	public String toStringCode() {
//		
//		return codeString;
//	}
//	
	public void testMethodContent() throws Exception{
		
		
		
	}
}
