
public class LinkedList<T> implements ListADT<T> {

	private int count;
	private LinearNode<T> rear;
	
	public LinkedList(){
		this.count = 0;
		this.rear = null;
	}

	@Override
	public void add(int index, T element) {
		
		if (index < 0 || index > count){
			throw new IndexOutOfBoundsException();
		}
	
		
		LinearNode<T> newNode = new LinearNode<T>(element);
		
		if (count == 0){
			newNode.setNext(newNode); // circular
		}
		else{
			LinearNode<T> previous = getNode(index - 1);
			newNode.setNext(previous.getNext());
			previous.setNext(newNode);
		}
		
		if (index == count){
			rear = newNode;
		}
		count++;
	}

	@Override
	public void add(T element) {
		this.add(count, element);
	}

	@Override
	public void set(int index, T element) {
	
		
		if (index < 0 || index >= count){
			throw new IndexOutOfBoundsException();
		}
		
		getNode(index).setElement(element);
		
			
	}

	@Override
	public T get(int index) {
		
		if (index < 0 || index >= count){
			throw new IndexOutOfBoundsException();
		}
		
		return  getNode(index).getElement();
		
	}

	@Override
	public T remove(int index) {
		
		
		if (index < 0 || index >= count){
			throw new IndexOutOfBoundsException();
		}
		
		/*if(isEmpty()){
			throw new IndexOutOfBoundsException();
		}*/
		
		if(this.count == 1){
			T current = getNode(index).getElement();
			this.rear = null;
			count--;
			return current;
		}

		
		LinearNode<T> previous = getNode(index - 1);
	    T current = previous.getNext().getElement();
		previous.setNext(previous.getNext().getNext());
		count--;
		return current;
	}

	@Override
	public T remove(T element) {
		
		if(element == null){
			throw new IllegalStateException();
		}
		
		if(contains(element)){
			
			T temp = element;
			remove(this.indexOf(element));
			return temp;
		}
		else{
			throw new IllegalStateException();
		}
	}

	@Override
	public int indexOf(T element) {
		
		for(int i = 0; i < this.size(); i++){
		  if(this.get(i) == null){
			  if(element == null){
				  return i;
			  }
		  }
		  else if(this.get(i).equals(element)){
				return i;
		  }
		  
		}
		return -1;
	}

	@Override
	public boolean contains(T element) {
		
		for(int i = 0; i < this.size(); i++){
			  if(this.get(i) == null){
				  if(element == null){
					  return true;
				  }
			  }
			  else if(this.get(i).equals(element)){
					return true;
			  }
			  
			}
			return false;
	}

	@Override
	public boolean isEmpty() {
		
		return this.count == 0;
	}

	@Override
	public int size() {
		
		return count;
	}
	
	public String toString(){
		String temp= "";
		for(int i = 0; i < this.size(); i++){
			temp += this.get(i) + "\n";
		}
		return temp;
	}
	
	private LinearNode<T> getNode(int index){
	
	LinearNode<T> current = rear;
	
	for (int i = -1; i < index; i++){
		current = current.getNext();
	}
	
	return current;
	}
		
}
