public class StackListBased<T> implements StackADT<T>
{
   private ListADT<T> list;

   
   public StackListBased()
   {
      this.list=new LinkedList<>();
    
   }
   @Override
   public synchronized void push(T element)
   {
      list.add(0, element);

   }

   @Override
   public synchronized T pop()
   {
      
      return list.remove(0);
   }

   @Override
   public synchronized T peek()
   {
      return list.get(0);
   }

   @Override
   public synchronized int indexOf(T element)
   {
      return list.indexOf(element);
     
   }

   @Override
   public synchronized boolean isEmpty()
   {
     return list.isEmpty();
   }

   @Override
   public synchronized int size()
   {
      return list.size();
   }
   
   public synchronized String toString()
   {
      return list.toString();
   }

}
