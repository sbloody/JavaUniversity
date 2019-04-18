package utility.collection;

import java.io.Serializable;

public class BoundedArrayQueue<T> implements QueueADT<T>, Serializable
{
   private int front;
   private int count;
   private T[] queue;

   public BoundedArrayQueue()
   {
      this.front = 0;
      this.count = 0;
      this.queue = (T[]) new Object[10];
   }

   public BoundedArrayQueue(int capacity)
   {
      this.front = 0;
      this.count = 0;
      this.queue = (T[]) new Object[capacity];
   }

   @Override
   public void enqueue(T element)
   {
      if (count >= queue.length)
      {
         throw new IllegalStateException("Queue is full");
      }
      if (element == null)
      {
         throw new NullPointerException("Cannot add null");
      }

      int rear = (front + count) % queue.length;
      queue[rear] = element;
      count++;
   }

   @Override
   public T dequeue()
   {
      if (isEmpty())
      {
         throw new IllegalStateException("Queue is empty");
      }
      T temp = queue[front];
      queue[front] = null;
      front++;
      count--;
      return temp;
   }

   @Override
   public T first()
   {
      if (count == 0)
      {
         throw new IllegalStateException("Queue is empty");
      }
      return queue[front];
   }

   @Override
   public int indexOf(T element)
   {
      int countIndexOf = 0;
      for (int i = front; i < queue.length; i++)
      {
         if (queue[i].equals(element) || element == null)
         {
            return countIndexOf;
         }
         if (!(queue[i].equals(element)) || queue[i] == null)
         {
            countIndexOf++;
         }
      }
      if (front != 0)
      {
         for (int i = 0; i < front; i++)
         {
            if (queue[i].equals(element) || element == null)
            {
               return countIndexOf;
            }
            if (!(queue[i].equals(element)) || queue[i] == null)
            {
               countIndexOf++;
            }
         }
      }
      return -1;
   }

   @Override
   public boolean isEmpty()
   {
      return count == 0;
   }

   @Override
   public int size()
   {
      return count;
   }

   public String toString()
   {
      String s = "{";
      for (int i = front; i < queue.length; i++)
      {
         if (queue[i] != null)
         {
            s += queue[i];
         }
         if (i < count - 1)
         {
            s += ", ";
         }
      }
      if (front != 0)
      {
         for (int i = 0; i < front; i++)
         {
            if (queue[i] != null)
            {
               s += queue[i];
            }
            if (i < count - 1)
            {
               s += ", ";
            }
         }
      }
      s += "}";
      return s;
   }

}
