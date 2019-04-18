package utility.collection;

public class ArrayQueue<T> implements QueueADT<T>
{
   private static final int DEFAULT_CAPACITY = 100;
   private int front;
   private int count;
   private T[] queue;

   public ArrayQueue()
   {
      this(DEFAULT_CAPACITY);
   }

   public ArrayQueue(int initialCapacity)
   {
      this.front = 0;
      this.queue = (T[]) new Object[initialCapacity];
      this.count = 0;
   }

   public String toString()
   {
      String all = "";
      for (int i = front; i < count; i++)
      {
         all += queue[i] + ", ";
      }
      return all;
   }

   private void expandCapacity()
   {
      T[] larger = (T[]) (new Object[queue.length * 2]);
      for (int index = 0; index < queue.length; index++)
         larger[index] = queue[index];
      queue = larger;
   }

   @Override
   public void enqueue(T element)
   {
      if ((count + front) % queue.length == front)
      {
         expandCapacity();
      }
      if (element == null)
      { // these lines of codes doesnt allow u to push Null as element
         throw new IllegalArgumentException("Not allowed to push null");
      }
      queue[(count + front) % queue.length] = element;
      count++; // update the count.

   }

   @Override
   public T dequeue()
   {
      if (isEmpty())
         throw new IllegalStateException("Empty Queue.");

      T result = queue[front];
      queue[front] = null;
      front++;
      count--;
      return result;

   }

   @Override
   public T first()
   {

      return queue[front];
   }

   @Override
   public int indexOf(T element)
   {
      if (element == null)
      {
         for (int i = front; i < count; i++)
         {
            if (element == (queue[i]))
            {
               return i;
            }
         }
      }
      else
      {
         for (int i = front; i < count; i++)
         {
            if (element.equals(queue[i]))
            {
               return i;
            }
         }
      }
      return -1;
   }

   @Override
   public boolean isEmpty()
   {
      if (count == 0)
      {
         return true;
      }
      else
         return false;
   }

   @Override
   public int size()
   {
      return count;
   }

}
