package utility.collection;

import org.omg.CORBA.Current;

public class LinkedList<T> implements ListADT<T>
{

   private int count;
   private LinearNode<T> front;

   public LinkedList()
   {
      front = new LinearNode<T>();
      this.count = 0;

   }

   public String toString()
   {

      LinearNode<T> current = front;
      String temp = "";
      for (int i = -1; i < count; i++)
      {
         temp += current.getElement();
         current = current.getNext();
      }
      return temp;

   }

   private LinearNode<T> getNode(int index)
   {
      LinearNode<T> current = front;
      for (int i = -1; i < index; i++)
      {
         current = current.getNext();
      }

      return current;

   }

   @Override
   public void add(int index, T element)
   {

      if (index < 0 || index > count)
      {

         throw new IndexOutOfBoundsException();
      }

      LinearNode<T> Prev = getNode(index - 1);
      LinearNode<T> newNode = new LinearNode<T>(element, Prev.getNext());
      Prev.setNext(newNode);
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

      LinearNode<T> current = front;

      for (int i = -1; i < index; i++)
      {

         current = current.getNext();

      }
      current.setElement(element);

   }

   @Override
   public T get(int index)
   {

      LinearNode<T> current = front;

      for (int i = -1; i < index; i++)
      {
         current = current.getNext();

      }

      return current.getElement();
   }

   @Override
   public T remove(int index)
   {

      LinearNode<T> current = front;
      LinearNode<T> deleted = new LinearNode<T>();

      if (index > count)
      {
         throw new IndexOutOfBoundsException();
      }

      for (int i = -1; i < index; i++)
      {
         current = current.getNext();

      }

      deleted = current;
      current.setElement(null);
      return deleted.getElement();

   }

   @Override
   public T remove(T element)
   {

      LinearNode<T> current = front;

      for (int i = -1; i < count; i++)
      {

         if (current.getElement() == element)
         {

            current.setElement(null);

         }

         current.getNext();

      }

      throw new IllegalStateException();
   }

   @Override
   public int indexOf(T element)
   {

      for (int i = -1; i < count; i++)
      {

         if (getNode(i).getElement().equals(element))
         {

            return i;
         }

      }

      return -1;
   }

   @Override
   public boolean contains(T element)
   {

      LinearNode<T> current = front;

      for (int i = -1; i < count; i++)
      {

         if (current.getElement() == element)
         {
            return true;
         }
         current.getNext();

      }

      return false;
   }

   @Override
   public boolean isEmpty()
   {

      LinearNode<T> current = front;
      int tempCount = 0;

      for (int i = -1; i < count; i++)
      {

         if (current.getElement() == null)
         {
            tempCount++;
         }
         else if (tempCount == count)
         {
            return true;
         }
         current.getNext();

      }
      return false;
   }

   @Override
   public int size()
   {

      LinearNode<T> current = front;
      int tempCount = 0;

      for (int i = -1; i < count; i++)
      {

         if (!(current.getElement() == null))
         {
            tempCount++;
         }
         current.getNext();

      }

      return tempCount;
   }

}
