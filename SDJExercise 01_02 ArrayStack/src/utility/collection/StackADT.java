package utility.collection;

import java.io.Serializable;

public interface StackADT<T> extends Serializable
{

   public void push(T element);

   public T pop();

   public T peek();

   public int indexOf(T element);

   public boolean isEmpty();

   public int size();

}
