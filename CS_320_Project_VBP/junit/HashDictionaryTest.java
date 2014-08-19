import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.ClassExtracter.HashDictionary;



public  class HashDictionaryTest extends TestCase {
	private HashDictionary<String, Integer> dict;
	
	@Before
	public void setUp() throws Exception {
		dict = new HashDictionary();
	}


	@Test
	public void testGetAndInsert() throws Exception {
		assertNull(dict.get("Eli"));
		assertNull(dict.put("Eli", 3));
		assertEquals((Integer) 3, dict.get("Eli"));
	}
	
	@Test
	public void testReplace() throws Exception {
		dict.put("A", 1);
		assertEquals((Integer) 1, dict.get("A"));
		dict.put("B", 2);
		dict.put("C", 3);
		dict.put("D", 4);
		dict.put("E", 5);
		dict.put("F", 6);
		dict.put("G", 7);

		assertEquals((Integer) 1, dict.get("A"));
		assertEquals((Integer) 2, dict.get("B"));
		assertEquals((Integer) 3, dict.get("C"));
		
		assertEquals((Integer) 3, dict.put("C", 42));
		
		assertEquals((Integer) 1, dict.get("A"));
		assertEquals((Integer) 2, dict.get("B"));
		assertEquals((Integer) 42, dict.get("C"));
	}
	@Test
	public void testRemove() throws Exception {
		dict.put("A", 1);
		dict.put("B", 2);
		dict.put("C", 3);
		
		assertEquals((Integer) 2, dict.get("B"));
		assertEquals((Integer) 2, dict.remove("B"));
		assertEquals((Integer) 1, dict.get("A"));
		assertNull(dict.get("B"));
		assertEquals((Integer) 3, dict.get("C"));
	}

	private static final int MAX_KEYS = 1000;
	
	@Test
	public void testLots() throws Exception {
		for (int i = 0; i < MAX_KEYS; i++) {
			dict.put("k" + i, i);
			assertNotNull(dict.get("k" + i));
			assertEquals((Integer) i, dict.get("k" + i));
		}
		
		for (int i = 0; i < MAX_KEYS; i++) {
			assertEquals((Integer) i, dict.remove("k" + i));
		}
	
	}
}
