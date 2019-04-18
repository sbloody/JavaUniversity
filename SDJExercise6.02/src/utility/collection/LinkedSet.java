package utility.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class LinkedSet<T> implements SetADT<T>
{
   private int size;
   private LinearNode<T> front;
   private boolean hasANullElement;

   public LinkedSet()
   {
      this.size = 0;
      this.front = null;
      this.hasANullElement = false;
   }

   public String toString()
   {
      String s = "{";
      LinearNode<T> current = front;
      for (int i = 0; i < size; i++)
      {
         s += current.getElement();
         if (i < size - 1)
         {
            s += ", ";
         }
         current = current.getNext();
      }
      if (hasANullElement)
      {
         if (size > 0)
         {
            s += ", ";
         }
         s += "null";
      }
      s += "}";
      return s;
   }

   @Override
   public void add(T element)
   {
      if (element == null)
      {
         hasANullElement = true;
         return;
      }
      if (!contains(element))
      {
         front = new LinearNode<>(element, front);
         size++;
      }

   }

   @Override
   public T remove(T element)
   {
      if (element == null)
      {

         if (hasANullElement)
         {
            hasANullElement = false;
            return null;
         }
         throw new IllegalStateException(element + "not in the set");
      }
      LinearNode<T> current = front;
      for (int i = 0; i < size; i++)
      {
         if (element.equals(current.getElement()))
         {
            current.setElement(front.getElement());
            front = front.getNext();
            size--;
            return element;
         }
         current = current.getNext();
      }
      throw new IllegalStateException(element + "not in the set");
   }

   @Override
   public boolean contains(T element)
   {
      if (element == null)
      {
         return hasANullElement;
      }
      LinearNode<T> current = front;
      for (int i = 0; i < size; i++)
      {
         if (element.equals(current.getElement()))
         {
            return true;
         }
         current = current.getNext();
      }
      return false;
   }

   @Override
   public boolean isEmpty()
   {
      return size() == 0;
   }

   @Override
   public int size()
   {
      if (hasANullElement)
      {
         return size + 1;
      }
      return size;
   }

   @Override
   public boolean isSubset(SetADT<T> set)
   {

      LinearNode<T> current = front;
      for (int i = 0; i < size; i++)
      {
         if (!set.contains(current.getElement()))
         {
            return false;
         }
         current = current.getNext();
      }
      return hasANullElement == set.contains(null);
   }

   @Override
   public SetADT<T> intersection(SetADT<T> set)
   {
      SetADT<T> intersectionSet = new LinkedSet<>();
      LinearNode<T> current = front;
      for (int i = 0; i < size; i++)
      {
         if (set.contains(current.getElement()))
         {
            intersectionSet.add(current.getElement());
         }
         current = current.getNext();
      }
      if (hasANullElement && set.contains(null))
      {
         intersectionSet.add(null);
      }
      return intersectionSet;
   }

   @Override
   public Iterator<T> iterator()
   {
      return new LinkedSetIterator();
   }

   @Override
   public SetADT<T> union(SetADT<T> set)
   {
      SetADT<T> unionSet = new LinkedSet();
      Iterator<T> iterator = this.iterator();
      while (iterator.hasNext())
      {
         unionSet.add(iterator.next());
      }

      iterator = set.iterator();
      while (iterator.hasNext())
      {
         unionSet.add(iterator.next());
      }
      return unionSet;
   }

   private class LinkedSetIterator implements Iterator<T>
   {
      private LinearNode<T> current;
      private boolean hasCheckedNull;

      public LinkedSetIterator()
      {
         this.current = front;
         hasCheckedNull=false;
      }

      @Override
      public boolean hasNext()
      {
         if (!hasCheckedNull && hasANullElement)
         {
            hasCheckedNull=true;
            return true;
         }
            return current != null;
      }

      @Override
      public T next()
      {
         if (!hasNext())
         {
            throw new NoSuchElementException();
         }
         if(hasANullElement&& !hasCheckedNull)
         {
            hasCheckedNull=true;
            return null;
         }
         T element = current.getElement();
         current = current.getNext();
         return element;
      }

   }

}
