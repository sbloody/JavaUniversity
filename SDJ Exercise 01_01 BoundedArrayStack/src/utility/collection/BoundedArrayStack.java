package utility.collection;

import java.io.Serializable;

public class BoundedArrayStack<T> implements StackADT<T>, Serializable

{
   private int top;
   private T[] stack;

   public BoundedArrayStack(int capacity)
   {
      this.top = 0;
      this.stack = (T[]) new Object[capacity];
   }

   public String toString()
   {
      String s = "{";
      for (int i = top - 1; i >= 0; i--)
      {
         s += stack[i];
         if (i > 0)
         {
            s += ", ";
         }
      }
      s += "}";
      return s;
   }

   @Override
   public void push(T element)
   {
      if (top >= stack.length)
      {
         throw new IllegalStateException("Stack is full");
      }

      // if(element==null)
      // {
      // throw new IllegalArgumentException("Can't be null");
      // }
      stack[top] = element;// could be null
      top++;

   }

   @Override
   public T pop()
   {
      T element = peek();
      top--;
      stack[top] = null;
      return element;
   }

   @Override
   public T peek()
   {
      if (isEmpty())
      {
         throw new IllegalStateException("Stack is empty");
      }
      return stack[top - 1];
   }

   @Override
   public int indexOf(T element)
   {
      if (element == null)
      {
         for (int i = top - 1; i >= 0; i--)
         {
            if (stack[i] == null)
            {
               return top - 1 - i;
            }
         }
      }

      else
      {
         for (int i = top - 1; i >= 0; i--)
         {
            if (element.equals(stack[i]))
            {
               return top - 1 - i;
            }
         }

      }
      return -1;
   }

   @Override
   public boolean isEmpty()
   {
      return top == 0;
   }

   @Override
   public int size()
   {
      return top;
   }

}
