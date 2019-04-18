public class LinkedList<T> implements ListADT<T> 
{
   private int count;
   private LinearNode<T> front;
   
   public LinkedList()
   {
      this.count=0;
      this.front = null;
   }
   
   public String toString()
   {
      String s = "{ ";
      LinearNode<T> current=front;
      for (int i = 0; i < size(); i++) 
      {
         s+= current.getElement();
         current=current.getNext();
         if(i< count-1)
         {
            s+=",";
         }
      }
      return s + " }";
   }
   
   public LinearNode<T> getNode(int index)
   {
      if(index <0 || index >= count)
      {
         throw new IndexOutOfBoundsException();
      }
      if(isEmpty())
      {
         throw new IndexOutOfBoundsException();
      }
      LinearNode<T> current=front;
      for (int i = 0; i < index; i++)
      {
         current=current.getNext();
      }
      return current;
   }

   @Override
   public void add(int index, T element) 
   {
      if(index <0 || index > count)
      {
         throw new IndexOutOfBoundsException();
      }
      
      if(index == 0)
      {
         front = new LinearNode<>(element, front);
      }
      else
      {
         LinearNode<T> previous = getNode(index -1);
         LinearNode<T> newNode=new LinearNode<T>(element, previous.getNext());
         previous.setNext(newNode);
      }
      count++;
   }

   @Override
   public void add(T element)
   {
      add(count, element);
   }

   @Override
   public void set(int index, T element) 
   {
      if(index <0 || index >= count)
      {
         throw new IndexOutOfBoundsException();
      }
   LinearNode<T> node=getNode(index);
   node.setElement(element);
   
   }

   @Override
   public T get(int index) 
   {
      LinearNode<T> node=getNode(index);
      return node.getElement();
   }

   @Override
   public T remove(int index) 
   {
      if(index <0 || index >=count)
      {
         throw new IndexOutOfBoundsException();
      }
      if(isEmpty())
      {
         throw new IndexOutOfBoundsException();
      }

      LinearNode<T> node=getNode(index);
      
      if(index>=count)
      {
         getNode(index-1).setNext(null);
      }
      if( index == 0)
      {
         front=front.getNext();
      }
      else
      {
         getNode(index-1).setNext(node.getNext());
      }
      count--;
      return node.getElement();
   }


   @Override
   public T remove(T element) 
   {
      if(indexOf(element) == -1)
      {
         throw new IllegalStateException();
      }
      return remove(indexOf(element));
   }

   @Override
   public int indexOf(T element)
   {
   if(element==null)
   {
      for (int i = 0; i < count; i++) 
      {
         LinearNode<T> node= getNode(i);
         if(element == node.getElement())
         {
            return i;
         }
      }
   }
   else
   {
      for (int i = 0; i < count; i++) 
      {
         LinearNode<T> node= getNode(i);
         if(element.equals(node.getElement()))
         {
            return i;
         }
      }
   }
   return -1;
   }

   @Override
   public boolean contains(T element) 
   {
      for (int i = 0; i < count; i++) 
      {
         if(indexOf(element) == i)
         {
            return true;
         }
      }
      return false;
   }

   @Override
   public boolean isEmpty() {
      return count == 0;
   }

   @Override
   public int size() {
      return count;
   }

}
