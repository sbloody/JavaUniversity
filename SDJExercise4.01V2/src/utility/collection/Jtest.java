package utility.collection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Jtest {

	@Before
	public void setUp(){
		LinkedList<String> list = new LinkedList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		

		
	}
	
	@Test
	public void checkElements(){
		LinkedList<String> list = new LinkedList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");		
		assertEquals("A", list.get(0));
		assertEquals("D", list.get(3));
		
		
	
		
	}
	@Test
	public void indexOfTest(){
		LinkedList<String> list = new LinkedList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		System.out.println(list.indexOf("A"));
		//assertEquals(0, list.indexOf("A"));
		
		
	}

}
