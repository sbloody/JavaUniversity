package utility.collection;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements ListADT<T>, Serializable
{
   private DoubleNode<T> front;
   private int count;

   public LinkedList()
   {
      front = null;
      count = 0;
   }

   @Override
   public void add(int index, T element)
   {
      if (index < 0 || index > count)
      {
         throw new IndexOutOfBoundsException();
      }

      DoubleNode<T> next = getNode(index);
      DoubleNode<T> prev;
      DoubleNode<T> newNode = new DoubleNode<T>(element);

      if (index == 0)
      {
         prev = getNode(count - 1);
         front = newNode;
      }
      else
      {
         prev = getNode(index - 1);
      }
      if (index == count)
         next = front;
      if (count == 0)
      {
         newNode.setNext(newNode);
         newNode.setPrevious(newNode);
         front = newNode;
      }
      else
      {
         newNode.setNext(next);
         newNode.setPrevious(prev);
         next.setPrevious(newNode);
         prev.setNext(newNode);
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
      if (index >= count || index < 0)
         throw new IndexOutOfBoundsException("Index out of bound");

      getNode(index).setElement(element);

   }

   @Override
   public T get(int index)
   {
      if (index >= count || index < 0)
         throw new IndexOutOfBoundsException("Index out of bound");
      
      return getNode(index).getElement();

   }

   @Override
   public T remove(int index)
   {
      if (index >= count || index < 0)
         throw new IndexOutOfBoundsException("Index out of bound");
      DoubleNode<T> node = getNode(index);
      DoubleNode<T> next = node.getNext();
      DoubleNode<T> prev = node.getPrevious();
      if (index == 0)
         front = node.getNext();
      node.setNext(null);
      node.setPrevious(null);
      prev.setNext(next);
      next.setPrevious(prev);
      count--;
      return node.getElement();
   }

   @Override
   public T remove(T element)
   {
      if (indexOf(element) == -1)
         throw new IllegalStateException("Element is not in the list");
      return remove(indexOf(element));
   }

   @Override
   public int indexOf(T element)
   {
      DoubleNode<T> current = front;
      if (element == null)
      {
         for (int i = 0; i < count; i++)
         {
            if (element == current.getElement())
            {
               return i;
            }
            current = current.getNext();
         }
      }
      else
      {
         for (int i = 0; i < count; i++)
         {
            if (element.equals(current.getElement()))
            {
               return i;
            }
            current = current.getNext();
         }
      }

      return -1;
   }

   @Override
   public boolean contains(T element)
   {
      return indexOf(element) >= 0;
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

   private DoubleNode<T> getNode(int index)
   {

      DoubleNode<T> current = front;
      for (int i = 0; i < index; i++)
      {
         current = current.getNext();
      }
      return current;
   }

   public String toString()
   {
      String s = "{";
      for (int i = 0; i < count; i++)
      {
         s += getNode(i).getElement();
         if (i < count - 1)
            s += ", ";
      }
      return s += "}";
   }

   @Override
   public Iterator<T> iterator()
   {
      return new LinkedListIterator();
   }

   private class LinkedListIterator implements Iterator<T>
   {
      private DoubleNode<T> current;
      private boolean frontWasNotPassed;

      public LinkedListIterator()
      {
         current = front;
         frontWasNotPassed = true;
      }

      @Override
      public boolean hasNext()
      {
         if (current == null)
            return false;
         return current != front || frontWasNotPassed;
      }

      @Override
      public T next()
      {
         if (!hasNext())
            throw new NoSuchElementException();
         T element = current.getElement();
         current = current.getNext();
         frontWasNotPassed = false;
         return element;
      }

   }
}
