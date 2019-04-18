public class BlockingQueue<T> implements Buffer<T>
{
   private BoundedArrayQueue<T> queue;
   private int capacity;

   public BlockingQueue(int capacity)
   {
      this.queue = new BoundedArrayQueue<>();
      this.capacity = capacity;
   }

   @Override
   public synchronized void put(T element)
   {
      if (element == null)
         throw new IllegalArgumentException();
      while (isFull())
         try
         {
            wait();
         }
         catch (InterruptedException e)
         {

         }
      notifyAll();
      queue.enqueue(element);

   }

   @Override
   public synchronized T take()
   {
      while (isFull())
         try
         {
            wait();
         }
         catch (InterruptedException e)
         {

         }
      notifyAll();
      return queue.dequeue();
   }

   @Override
   public T look()
   {

      if (isEmpty())
         return null;
      else
         return queue.first();
   }

   @Override
   public boolean isFull()
   {
      return size() == capacity;
   }

   @Override
   public boolean isEmpty()
   {
      return queue.isEmpty();
   }

   @Override
   public int size()
   {

      return queue.size();
   }
   
   public String toString()
   {
      return queue.toString();
   }
}
