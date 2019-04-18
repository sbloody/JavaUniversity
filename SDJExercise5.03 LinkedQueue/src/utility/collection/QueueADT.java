package utility.collection;

import java.io.Serializable;

public interface QueueADT<T> extends Serializable {
   
public void enqueue(T element);
public T dequeue();
public T first();
public int indexOf(T element);
public boolean isEmpty();
public int size();

}
