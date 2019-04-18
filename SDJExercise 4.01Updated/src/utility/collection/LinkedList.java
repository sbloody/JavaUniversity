package utility.collection;

public class LinkedList<T> implements ListADT<T> {

	private int count;
	private DoubleNode<T> front;

	public LinkedList() {
		count = 0;
		front = null;
	}

	private DoubleNode<T> getNode(int index) {
		DoubleNode<T> current = front;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}

	@Override
	public void add(int index, T element)
			throws IllegalStateException, IndexOutOfBoundsException, IllegalArgumentException {
		if (index < 0 || index > count) {
			throw new IndexOutOfBoundsException("Invalid index");
		}

		DoubleNode<T> newNode = new DoubleNode<T>(element);
		if (isEmpty()) {
			newNode.setNext(newNode);
			newNode.setPrevious(newNode);
			front=newNode;
		} else {
			DoubleNode<T> previous;
			DoubleNode<T> next=getNode(index);
			if (index==0) {
			   previous=getNode(size()-1);
			   front=newNode;
			}
			else previous =  next.getPrevious();
         if (index==size()) {
            next=front;
         }
			newNode.setNext(next);
			newNode.setPrevious(previous);
			next.setPrevious(newNode);
			previous.setNext(newNode);
			if (index==size()) {
            newNode.setNext(front);
         }
		}
		count++;
	}
	@Override
	public void add(T element) {
		DoubleNode<T> newNode = new DoubleNode<T>(element);
		if (isEmpty()) {
			front = newNode;
			front.setPrevious(newNode);
			front.setNext(newNode);
		} else {
			DoubleNode<T> previous = getNode(size() - 1);
			newNode.setNext(previous.getNext());
			newNode.setPrevious(previous);
			previous.setNext(newNode);
			front.setPrevious(newNode);
		}

		count++;
	}

	@Override
	public void set(int index, T element) throws IndexOutOfBoundsException {
		if (index >= size() || index<0)
			throw new IndexOutOfBoundsException("Index out of bounds");
		getNode(index).setElement(element);
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException("Index out of bounds");
		return getNode(index).getElement();
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		//Check for the bounds
		if (index >= size()|| index<0 || isEmpty())
			throw new IndexOutOfBoundsException("Index out of bounds");
		
		//Get the element we want to remove
		T temp = getNode(index).getElement();
		
		//Get the previous and the next element of the one we will remove
		DoubleNode<T> previous = getNode(index).getPrevious();
		DoubleNode<T> next = previous.getNext().getNext();

		
		
		//If we are removing the first element update the front variable
      if (index == 0) 
         front = getNode(index).getNext();
         
		//Connect the previous and the next element
         previous.setNext(next);
         next.setPrevious(previous);

      
		count--;
		return temp;
	}

	@Override
	public T remove(T element) throws IllegalStateException {
		if (!contains(element))
			throw new IllegalStateException("Invalid element");

		return remove(indexOf(element));
	}

	@Override
	public int indexOf(T element) {
		if (!isEmpty()) {
			for (int i = 0; i < count; i++) {
			   if (getNode(i).getElement()==null){
			      if (element==null) return i;
			   continue;}
				if (getNode(i).getElement().equals(element)||getNode(i).getElement()==element)
					return i;
			}
			return -1;
		}

		return -1;
	}

	@Override
	public boolean contains(T element) {
		return indexOf(element) != -1;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return this.count;
	}

	public String toString() {
		String s = "{";
		for (int i = 0; i < count; i++) {
			s += getNode(i).getElement();
			if (i != count - 1)
				s += ", ";
		}
		s += "}";
		return s;
	}


}
