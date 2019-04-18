package utility.collection;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedQueueTest {
	private QueueADT<String> queue;
	   @Before
	   public void setUp() throws Exception
	   {
		  queue = new LinkedQueue<>();
	   }

	   @After
	   public void tearDown() throws Exception
	   {
	   }
	

	@Test
	public void testToString() {
		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");
		queue.enqueue("4");
		assertEquals("{ 1, 2, 3, 4 }", queue.toString());
		queue.enqueue(null);
		assertEquals("{ 1, 2, 3, 4, null }", queue.toString());
	}

	@Test
	public void testEnqueue() {
		 queue.enqueue("1");
		 assertEquals(1, queue.size());
		 queue.enqueue("2");
		 queue.enqueue("3");
		 assertEquals(3, queue.size());
		 queue.enqueue("4");
		 assertEquals(4, queue.size());
		 queue.dequeue();
		 queue.dequeue();
		 assertEquals(2, queue.size());
		 queue.enqueue(null);
		 assertEquals(3, queue.size());
	}

	@Test
	public void testDequeue() {
		 queue.enqueue("1");
		 queue.enqueue("2");
		 queue.enqueue("3");
		 queue.enqueue("4");
		 assertEquals(4, queue.size());
		 queue.dequeue();
		 queue.dequeue();
		 assertEquals(2, queue.size());
		 queue.enqueue(null);
		 assertEquals(3, queue.size());
		 queue.dequeue();
		 queue.dequeue();
		 assertEquals(1, queue.size());
		 queue.dequeue();
		 assertEquals(0, queue.size());
	}

	@Test
	public void testFirst() {
		 queue.enqueue("1");
		 queue.enqueue("2");
		 queue.enqueue("3");
		 queue.enqueue("4");
		 assertEquals("1", queue.first());	 
		 queue.dequeue();
		 assertEquals("2", queue.first());
		 queue.dequeue();
		 queue.dequeue();
		 assertEquals("4", queue.first());
	}

	@Test
	public void testIndexOf() {
		 queue.enqueue("1");
		 queue.enqueue("2");
		 queue.enqueue("3");
		 queue.enqueue("4");
		 assertEquals(0, queue.indexOf("1"));
		 assertEquals(1, queue.indexOf("2"));
		 assertEquals(2, queue.indexOf("3"));
		 assertEquals(3, queue.indexOf("4"));
		 queue.dequeue();
		 assertEquals(0, queue.indexOf("2"));
		 assertEquals(-1, queue.indexOf("sth"));
	}

	@Test
	public void testIsEmpty() {
		assertTrue(queue.isEmpty());
		queue.enqueue("1");
		assertFalse(queue.isEmpty());
		queue.dequeue();
		assertTrue(queue.isEmpty());
	}

	@Test
	public void testSize() {
		 assertEquals(0, queue.size());
	      queue.enqueue("1");
	      assertEquals(1, queue.size());
	      queue.enqueue(null);
	      assertEquals(2, queue.size());
	}

	 @Test(expected = IllegalStateException.class)
	   public void TestFirstEmptyException()
	   {
	    queue.first();
	   }
	 
	 @Test(expected = IllegalStateException.class)
	   public void TestDequeEmptyException()
	   {
	    queue.dequeue();
	   }
}
