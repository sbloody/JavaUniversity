package utility.collection;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	public ListADT<String> list;
	@Before
	public void setUp() throws Exception {
		list = new LinkedList<String>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		try{
			list.add(-5, "Bob");
		}catch(IndexOutOfBoundsException e){
			assertEquals("Invalid index", e.getMessage());
		}
		
		try{
			list.add(4, "Bob");
		}catch(IndexOutOfBoundsException e){
			assertEquals("Invalid index", e.getMessage());
		}
		
		list.add(0, "Wendy");
		assertEquals(1, list.size());
		list.add(1, "Bob");
		list.add(1, "Rob");
		list.add("Hans");
		list.add("John");
		assertEquals("{Wendy, Rob, Bob, Hans, John}", list.toString());
	}

	@Test
	public void testSet() {
		for(int i = 0; i < 5; i++){
			list.add("Element " + i);
		}
		
		list.set(2, "Changed");
		assertEquals("Changed", list.get(2));
		list.set(0, "First");
		list.set(list.size() - 1, "Last");
		assertEquals("{First, Element 1, Changed, Element 3, Last}", list.toString());
		try{
			list.set(list.size(), "Dummy");
		}catch(IndexOutOfBoundsException e){
			assertEquals("Index out of bounds", e.getMessage());
		}
	}

	@Test
	public void testGet() {
		for(int i = 0; i < 5; i++){
			list.add("Element " + i);
		}
		assertEquals("Element 0", list.get(0));
		assertEquals("Element 4", list.get(4));
		
		try{
			list.get(6);
		}catch(IndexOutOfBoundsException e){
			assertEquals("Index out of bounds", e.getMessage());
		}
	}

	@Test
	public void testRemove() {
		for(int i = 0; i < 5; i++){
			list.add("Element " + i);
		}
		
		assertEquals("Element 0", list.remove(0));
		
		list.remove(4);
		
		assertEquals("Element 2", list.get(1));
	}

	@Test
	public void testIndexOf() {
		for(int i = 0; i < 5; i++){
			list.add("Element " + i);
		}
		
		assertEquals(0, list.indexOf("Element 0"));
		assertEquals(4, list.indexOf("Element 4"));
		assertEquals(-1, list.indexOf("Element 5"));
	}

	@Test
	public void testContains() {
		for(int i = 0; i < 5; i++){
			list.add("Element " + i);
		}
		
		assertEquals(true, list.contains("Element 0"));
		assertEquals(true, list.contains("Element 4"));
		assertEquals(false, list.contains("Bob"));
	}

}
