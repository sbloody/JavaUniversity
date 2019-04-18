package utility.collection;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoundedArraySetTest {

	BoundedArraySet<String> set;
	@Before
	public void setUp() throws Exception {
		set=new BoundedArraySet<>();
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testAdd() {
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
		assertEquals(4,set.size());
		assertEquals("{A, B, C, D}",set.toString());
		set.add("E");
		set.add("F");
		assertEquals(6,set.size());
		assertEquals("{A, B, C, D, E, F}",set.toString());
		set.add(null);
		assertEquals(7,set.size());
		set.add(null);
		assertEquals(7,set.size());
		set.add("F");
		assertEquals(7,set.size());
		assertEquals("{A, B, C, D, E, F,null}",set.toString());
		set.add("B");
		set.add("C");
		set.add("D");
		set.add("G");
		
		assertEquals(8,set.size());
		assertEquals("{A, B, C, D, E, F, G,null}",set.toString());
		
	}
	
	@Test(expected = IllegalStateException.class)
	   public void testAddException()
	   {
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
		set.add("E");
		set.add("F");
		set.add("H");
		set.add("G");
		set.add("I");
	
	   }
	
	@Test
	public void testRemove()
	{
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
		set.add("E");
		set.remove("D");
		assertEquals("{A, B, C, E}",set.toString());
		set.add("H");
		set.add("G");
		assertEquals("{A, B, C, E, H, G}",set.toString());
		set.remove("H");
		set.add("I");
		assertEquals("{A, B, C, E, G, I}",set.toString());
		set.add(null);
		assertEquals("{A, B, C, E, G, I,null}",set.toString());
		set.remove(null);
		assertEquals("{A, B, C, E, G, I}",set.toString());
		
	}
	@Test(expected = IllegalStateException.class)
	   public void testRemoveException()
	   {
		set.remove("H");
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
		set.remove("I");
		
	   }
	
	@Test
	public void testContains()
	{
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
		assertEquals("{A, B, C, D}",set.toString());
		assertEquals(true, set.contains("B"));
		assertEquals(false, set.contains("E"));
		set.remove("C");
		assertEquals(false,set.contains(null));
		set.add(null);
		assertEquals(true,set.contains(null));
		assertEquals("{A, B, D,null}",set.toString());
	}
	
	@Test
	public void testIsEmpty()
	{
		assertEquals(true, set.isEmpty());
		set.add("A");
		set.add("B");
		set.add("C");
		assertEquals(false, set.isEmpty());
		set.remove("A");
		set.remove("B");
		assertEquals(false, set.isEmpty());
		set.remove("C");
		assertEquals(true, set.isEmpty());
		set.add(null);
		assertEquals(false, set.isEmpty());
		set.remove(null);
		assertEquals(true, set.isEmpty());
		
	}
	@Test
	public void testSize()
	{
		assertEquals(0,set.size());
		set.add("A");
		assertEquals(1,set.size());
		set.add("B");
		set.add("C");
		assertEquals(3,set.size());
		set.add("B");
		set.add("C");
		assertEquals(3,set.size());
		set.add(null);
		assertEquals(4,set.size());
		set.remove("A");
		set.remove("B");
		assertEquals(2,set.size());
		set.add(null);
		assertEquals(2,set.size());
		set.remove(null);
		assertEquals(1,set.size());
		set.remove("C");
		assertEquals(0,set.size());
		set.add(null);
		assertEquals(1,set.size());
	}
	
	@Test
	public void testIsSubset()
	{
		BoundedArraySet<String> setTest=new BoundedArraySet<>();	
		set.add("C");
		set.add("D");
		set.add("E");	
		assertEquals(true,set.isSubset(set));
		setTest.add("A");
		setTest.add("B");
		setTest.add("C");
		setTest.add("D");
		setTest.add("E");
		setTest.add("F");
		setTest.add("H");
		setTest.add("G");
		assertEquals(true,set.isSubset(setTest));
		set.add(null);
		assertEquals(false,set.isSubset(setTest));
		set.add(null);
		assertEquals(false,set.isSubset(setTest));
		set.remove(null);
		assertEquals(true,set.isSubset(setTest));
		set.add("I");
		assertEquals(false,set.isSubset(setTest));
	}
	
	@Test
	public void testIntersection()
	{
		BoundedArraySet<String> setTest=new BoundedArraySet<>();	
		set.add("C");
		set.add("D");
		set.add("E");	
		setTest.add("A");
		setTest.add("D");
		setTest.add("E");
		setTest.add("F");
		setTest.add("H");
		setTest.add("G");
		assertEquals("{D, E}",set.intersection(setTest).toString());
		set.add(null);	
		setTest.add(null);
		assertEquals("{D, E,null}",set.intersection(setTest).toString());
		set.remove(null);
		assertEquals("{D, E}",set.intersection(setTest).toString());
		set.remove("D");
		set.remove("E");
		assertEquals("{}",set.intersection(setTest).toString());
	}
	
	@Test
	public void testUnion()
	{
		BoundedArraySet<String> setTest=new BoundedArraySet<>();	
		set.add("C");
		set.add("D");
		set.add(null);		
		setTest.add("I");
		setTest.add("A");
		setTest.add("D");		
		setTest.add("E");
		assertEquals("{C, D, I, A, E,null}",set.union(setTest).toString());
		setTest.add(null);
		assertEquals("{C, D, I, A, E,null}",set.union(setTest).toString());
		setTest.remove(null);
		set.remove(null);
		assertEquals("{C, D, I, A, E}",set.union(setTest).toString());
	}
	
}
