package utility.collection;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedSet<T> implements SetADT<T>
{
   private int size;
   private LinearNode<T> front;
   private boolean hasNull;
   public LinkedSet()
   {
      size = 0;
      front = null;
      hasNull = false;
   }
   
   public String toString()
   {
      String s = "{";
      LinearNode<T> current = front;
      for(int i = 0; i < size; i++)
      {
         s += current.getElement().toString();
         if(i < size-1)
            s += ", ";
         current = current.getNext();
      }
      if(hasNull)
      {
         if(size > 0)
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
      if(element == null)
      {
         hasNull = true;
         return;
      }
      if(contains(element))
         return;
      front = new LinearNode<>(element, front);
      size++;
   }

   @Override
   public T remove(T element)
   {
      if(element == null)
      {
         if(hasNull)
         {
            hasNull = false;
            return null;
         }
         throw new IllegalStateException("null not in set");
      }
      LinearNode<T> current = front;
      for(int i = 0; i < size; i++)
      {
         if(current.getElement().equals(element))
         {
            
            current.setElement(front.getElement());
            front = front.getNext();
            size--;
            return element;
         }
         current = current.getNext();
      }
      throw new IllegalStateException(element + " not in set");
   }

   @Override
   public boolean contains(T element)
   {
      if(element == null)
      {
         return hasNull;
      }
      LinearNode<T> current = front;
      for(int i = 0; i < size; i++)
      {
         if(current.getElement().equals(element))
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
      if(hasNull)
      {
         return size+1;
      }
      return size;
   }

   @Override
   public boolean isSubset(SetADT<T> set)
   {
      if(set == null)
      {
         throw new IllegalArgumentException();
      }
      LinearNode<T> current = front;
      for(int i = 0; i < size; i++)
      {
         if(!set.contains(current.getElement()))
         {
            return false;
         }
         current = current.getNext();
      }
      return hasNull == set.contains(null);
   }

   @Override
   public SetADT<T> intersection(SetADT<T> set)
   {
      if(set == null)
      {
         throw new IllegalArgumentException();
      }
      LinearNode<T> current = front;
      SetADT<T> tempSet = new LinkedSet<>();
      for(int i = 0; i < size; i++)
      {
         if(set.contains(current.getElement()))
         {
            tempSet.add(current.getElement());
         }
         
         current = current.getNext();
      }
      if(hasNull && set.contains(null))
         tempSet.add(null);
      return tempSet;
   }

   @Override
   public SetADT<T> union(SetADT<T> set)
   {
      if(set == null)
      {
         throw new IllegalArgumentException();
      }
      
      SetADT<T> tempSet = new LinkedSet<>();
      Iterator<T> it = iterator();
      while(it.hasNext())
      {
         tempSet.add(it.next());
      }
      it = set.iterator();
      while(it.hasNext())
      {
         tempSet.add(it.next());
      }
      if(hasNull && set.contains(null))
      {
         tempSet.add(null);
      }
      return tempSet;
   }
   
   @Override
   public Iterator<T> iterator()
   {
      return new LinkedSetIterator();
   }

   private class LinkedSetIterator implements Iterator<T>, Serializable
   {
      private LinearNode<T> currentNode;
      private boolean checkedNull;
      public LinkedSetIterator()
      {
         checkedNull = false;
         currentNode = front;
      }
      @Override
      public boolean hasNext()
      {
         if(!checkedNull && hasNull)
         {
            return true;
         }
         return currentNode != null;
      }

      @Override
      public T next()
      {
         if(!hasNext())
         {
            throw new NoSuchElementException();
         }
         if(!checkedNull && hasNull)
         {
            checkedNull = true;
            return null;
         }
         T temp = currentNode.getElement();
         currentNode = currentNode.getNext();
         return temp;
      }
      
   }

}
