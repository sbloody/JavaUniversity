
public class Node {
	
	private Node left;
	private Node right;
	
	private int element;

	
	public Node(int element) {
		this.element = element;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}
	public String toString()
	{
		return element+"";
	}
	
}
