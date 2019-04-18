

public class BoundedArrayQueue<T> implements QueueADT<T>
{
   private int front;
   private int count;
   private T[] queue;

   public BoundedArrayQueue()
   {
      front = count = 0;
   }

   public BoundedArrayQueue(int capacity)
   {
      front = count = 0;
      this.queue = (T[]) new Object[capacity];
   }

   public String toString()
   {
      String s = "{";
      for (int i = 0; i < count; i++)
      {
         s += queue[(front + i) % queue.length];
         if(i < count)
         {
            s += ", ";
         }
      }
      s += "}";
      return s;
   }

   public void enqueue(T element)
   {
      if (count >= queue.length)
      {
         throw new IllegalStateException("Queue is full");
      }
      int rear = (front + count) % queue.length;
      queue[rear] = element;
      count++;
   }

   public T dequeue()
   {
      T element = first();
      queue[front] = null;
      front = (front+ 1) % queue.length;
      count--;
      return element;
   }

   @Override
   public T first()
   {
      if (isEmpty())
      {
         throw new IllegalStateException("Queue is empty");
      }
      return queue[front];
   }

   @Override
   public int indexOf(T element)
   {
      if (element == null)
      {
         for (int i = 0; i < count; i++)
         {
            if (queue[(front + i) % queue.length] == null)
            {
               return i;
            }
         }
      }
      else
      {
         for (int i = 0; i < count; i++)
         {
            if (element.equals(queue[(front + i) % queue.length]))
            {
               return i;
            }
         }
      }
      return -1;
   }

   public boolean isEmpty()
   {
      if (count == 0)
      {
         return true;
      }
      return false;
   }

   public int size()
   {
      return count;
   }
}
