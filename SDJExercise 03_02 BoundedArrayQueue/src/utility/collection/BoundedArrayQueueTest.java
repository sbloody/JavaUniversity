package utility.collection;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoundedArrayQueueTest {
   private BoundedArrayQueue queue = new BoundedArrayQueue();

   @Test
   public void testBoundedArrayQueue() {
      BoundedArrayQueue queue = new BoundedArrayQueue();
   }

   @Test
   public void testBoundedArrayQueueInt() {
      BoundedArrayQueue queue1 = new BoundedArrayQueue(15);
   }

   @Test
   public void testEnqueue() {
      queue.enqueue("Denis");
      queue.enqueue("Je");
      queue.enqueue("Frajeris");
      assertEquals(3, queue.size());
   }

   @Test
   public void testDequeue() {
      queue.enqueue("Denis");
      queue.enqueue("Je");
      queue.enqueue("Frajeris");
      queue.dequeue();
      queue.dequeue();
      assertEquals(1, queue.size());
   }

   @Test
   public void testFirst() {
      queue.enqueue("Denis");
      queue.enqueue("Je");
      queue.enqueue("Frajeris");
      assertEquals("Denis", queue.first());
      queue.dequeue();
      assertEquals("Je", queue.first());
   }

   @Test
   public void testIndexOf() {
      queue.enqueue("Denis");
      queue.enqueue("Je");
      queue.enqueue("Frajeris");
      assertEquals(2, queue.indexOf("Frajeris"));
   }

   @Test
   public void testIsEmpty() {
      queue.enqueue("Denis");
      queue.enqueue("Je");
      queue.enqueue("Frajeris");
      assertFalse(queue.isEmpty());
   }

   @Test
   public void testSize() {
      queue.size();
   }

   @Test
   public void testToString() {
      queue.enqueue("Denis");
      queue.enqueue("Je");
      queue.enqueue("Frajeris");
      queue.enqueue("Denis");
      queue.enqueue("Je");
      queue.enqueue("Frajeris");
      assertEquals("{Denis, Je, Frajeris, Denis, Je, Frajeris}", queue.toString());
   }

}
