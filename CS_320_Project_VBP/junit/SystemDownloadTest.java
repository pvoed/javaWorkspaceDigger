import edu.ycp.cs320.ClassExtracter.FileProperties;
import edu.ycp.cs320.ClassExtracter.SystemControl;
import junit.framework.TestCase;


public class SystemDownloadTest extends TestCase{
	private SystemControl sysControl;

	protected void setUp() throws Exception {
		sysControl = new SystemControl();
	}
	
	public void testDownload() throws Exception {
		sysControl.setDownloadFileName("download");
		assertEquals(sysControl.getDownloadFileName().toString(), "download.java");
		sysControl.setDirectory("H:\\Favorites");
		assertEquals(sysControl.getDirectory().toString(), "H:\\Favorites");
		sysControl.save("This is a line of code");
	}




}
