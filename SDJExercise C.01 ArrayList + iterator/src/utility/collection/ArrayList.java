package utility.collection;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> implements ListADT<T>,Serializable
{
		
	private static final int DEFAULT_CAPACITY=100;
	private int size;
	private T[] list;
	
	public ArrayList(int initialCap)
	{
		size=0;
		list=(T[]) (new Object[initialCap]);
	}
	

	public ArrayList()
	{
		size=0;
		list=(T[]) (new Object[DEFAULT_CAPACITY]);
	}
	
	
	public String toString()
	{
		String s="{";
		for (int i = 0; i < size(); i++) 
		{
			s+=list[i];
			if( i < size  -1)
			{
				s+=",";
			}
		}
		return s + "}";
	}
	
	private void expandCapacity()
	{
		T[] larger=(T[])(new Object[list.length*2]);
		for (int i = 0; i < size(); i++) 
		{
			larger[i]=list[i];
			list=larger;
		}
		
	}
	
	@Override
	public void add(int index, T element) 
	{
		if(index > size())
		{
			throw new IndexOutOfBoundsException();
		}
		if(size >= list.length)
		{
			expandCapacity();
		}
		list[index]=element;
		
		size++;
	}

	@Override
	public void add(T element) 
	{
		add(size, element);
	}

	@Override
	public void set(int index, T element) 
	{
		list[index]=element;		
	}

	@Override
	public T get(int index) 
	{
		return list[index];
	}

	
	@Override
	public T remove(int index) 
	{
		if(isEmpty())
		{
			throw new IndexOutOfBoundsException();
		}
		
		T element=list[index];
		for (int i = index; i < size()-1; i++) 
		{
			list[i]=list[i+1];
		}
		size--;	
		return element;
		
	}

	@Override
	public T remove(T element) 
	{
		if(indexOf(element)==-1)
		{
			throw new IndexOutOfBoundsException();
		}
		return remove(indexOf(element));
	}

	@Override
	public int indexOf(T element)
	{
		if(element== null)
		{
			for (int i = 0; i < size; i++) 
			{
				if(element==list[i])
				{
				return i;
				}
				
			}
		}
		else
		{
			for (int i = 0; i < size; i++) 
			{
				if(element.equals(list[i]))
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
		if(indexOf(element)==-1)
		{
			return false;
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public int size() {
		return size;
	}


	@Override
	public Iterator<T> iterator() {
		return new ArrayIterator();
	}
	
	private class ArrayIterator implements Iterator<T>
	{
		private int current;
		
		public ArrayIterator()
		{
			current=0;
		}

		@Override
		public boolean hasNext() 
		{
			return current !=0;
		}

		@Override
		public T next() 
		{
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
		
				T element=list[current];
				current++;
				return element;
		
		}
	}
}
