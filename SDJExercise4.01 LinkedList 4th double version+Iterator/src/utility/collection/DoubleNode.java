package utility.collection;

import java.io.Serializable;

public class DoubleNode<T> implements Serializable
{
   private T element;
   private DoubleNode<T> next;
   private DoubleNode<T> previous;

   public DoubleNode()
   {
      element = null;
      next = null;
      previous = null;
   }

   public DoubleNode(T element)
   {
      this.element = element;
      next = null;
      previous = null;
   }

   public DoubleNode(T element, DoubleNode<T> next, DoubleNode<T> previous)
   {
      this.element = element;
      this.next = next;
      this.previous = previous;
   }

   public DoubleNode<T> getNext()
   {
      return next;
   }

   public void setNext(DoubleNode<T> next)
   {
      this.next = next;
   }

   public DoubleNode<T> getPrevious()
   {
      return previous;
   }

   public void setPrevious(DoubleNode<T> previous)
   {
      this.previous = previous;
   }

   public T getElement()
   {
      return element;
   }

   public void setElement(T element)
   {
      this.element = element;
   }
}
