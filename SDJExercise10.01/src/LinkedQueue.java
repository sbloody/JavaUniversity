

public class LinkedQueue<T> implements QueueADT<T>
{
   private int count;
   private LinearNode<T> rear;
   private LinearNode<T> front;

   public LinkedQueue()
   {
      count = 0;
      rear = null;
      front = null;
   }

   @Override
   public void enqueue(T element)
   {
      LinearNode<T> node = new LinearNode<T>(element);
      if (count == 0)
      {
       rear = node;
         node.setNext(rear);
         front = node;
      }
      else
      {
         rear.setNext(node);
         node.setNext(front);
         rear = node;
      }
      count++;

   }

   @Override
   public T dequeue()
   {
      T temp = null;
      if (count == 0)
      {
         throw new IllegalStateException();
      }
      if (count == 1)
      {
         temp = front.getElement();
         front = null;
         rear = null;
         count = 0;
      }
      else
      {
         temp = front.getElement();
         front = front.getNext();
         rear.setNext(front);
         count--;
      }
      return temp;
   }

   @Override
   public T first()
   {
      if(count == 0){
         throw new IllegalStateException();
      }
      return front.getElement();
   }

   @Override
   public int indexOf(T element)
   {
      LinearNode<T> current = front;
      
      for (int i = 0; i < count; i++)
      {
         if(element == null){
            if(element == current.getElement()){
               return i;
            }
         }
         else {
         if(element.equals(current.getElement())){
            return i;
         }
         }
         current = current.getNext();
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
   LinearNode <T> current = front;
     String s = "{ ";
    
     for (int i=0; i<count ; i++){
       s+= current.getElement();
       current = current.getNext();
       if (i != count -1 ){
          s+= ", ";
       }
     }
     
     s += " }";
     return s;
   }


}