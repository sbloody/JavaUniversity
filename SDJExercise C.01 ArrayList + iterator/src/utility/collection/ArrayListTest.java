package utility.collection;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTest 
{
	ListADT<String> list;
	@Before
	public void setUp() throws Exception 
	{
		list=new ArrayList<>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd()
	{
		list.add(0,"a");
		list.add(1,"b");
		list.add(2,"c");
		list.add(3,"d");
		list.add(4,"e");
		
		list.add(5,"g");
		
		System.out.println(list.toString());
		assertEquals(6, list.size());
		System.out.println(list.size());
		
	}

	@Test
	public void testRemove()
	{
		list.add(0,"a");
		list.add(1,"b");
		list.add(2,"c");
		list.add(3,"d");
		list.add(4,"e");
		list.add(5,"g");
		
		System.out.println(list.toString());
		assertEquals(6, list.size());
		
		list.remove(2);
		//list.remove("g");
		assertEquals(5, list.size());
		System.out.println(list.remove(2));
		
		System.out.println(list.toString() + "sd");
	
	}
	
	@Test
	public void testGet()
	{
		list.add(0,"a");
		list.add(1,"b");
		list.add(2,"c");
		list.add(3,"d");
		
		assertEquals("b", list.get(1));
		System.out.println(list.get(1));
	}
	
	@Test
	public void testIndexOf()
	{
		list.add(0,"a");
		list.add(1,"b");
		list.add(2,"c");
		list.add(3,"d");
		
		assertEquals(1, list.indexOf("b"));
		System.out.println(list.indexOf("b"));
	}
	
	@Test
	public void testContains()
	{
		list.add(0,"a");
		list.add(1,"b");
		list.add(2,"c");
		list.add(3,"d");
		
		assertTrue(list.contains("b"));
		
		assertFalse(list.contains("dasasd"));
		
	}
	
}
