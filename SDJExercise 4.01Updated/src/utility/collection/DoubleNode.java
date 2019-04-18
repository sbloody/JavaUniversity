package utility.collection;

public class DoubleNode<T> {
	private T element;
	private DoubleNode<T> next;
	private DoubleNode<T> previous;

	public DoubleNode() {
		element = null;
		next = null;
		previous = null;
	}

	public DoubleNode(T element) {
		this.element = element;
		this.next = new DoubleNode<T>();
		this.previous = null;
	}

	public DoubleNode(T element, DoubleNode<T> next) {
		this.element = element;
		this.previous = null;
		this.next = next;
	}

	public DoubleNode<T> getNext() {
		return this.next;
	}

	public void setNext(DoubleNode<T> element) {
		this.next = element;
	}

	public DoubleNode<T> getPrevious() {
		return this.previous;
	}

	public void setPrevious(DoubleNode<T> element) {
		this.previous = element;
	}

	public T getElement() {
		return this.element;
	}

	public void setElement(T element) {
		this.element = element;
	}
}
