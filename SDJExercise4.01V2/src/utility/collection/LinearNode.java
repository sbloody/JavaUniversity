package utility.collection;

public class LinearNode<T> {

	private T element;
	private LinearNode<T> next;
	
	public LinearNode(T element,LinearNode<T> next){
		this.element = element;
		this.next = next;
	}
	
	public LinearNode(T element)
	{
	this.next = null;
	this.element = element;
	}
	
	public LinearNode()
	{
	this.next = null;
	this.element = null;
	
	}
	
	
	public LinearNode<T> getNext(){
		return next;	
	}
	
	public void setNext(LinearNode<T> node){
		next = node;
		
	}
	
	
	public T getElement(){
		return element;
	}
	
	
	
	public void setElement(T element){
		
		this.element = element;
		
	}



	
}
