public class Node {

	Node left;
	Node right;
	private int numberOfHits;
	private int element;

	public Node() {
		this.element = 0;
		this.numberOfHits = 0;
	}

	public Node(int element) {
		this.element = element;
		this.numberOfHits = 0;
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

	public int getNumberOfHits() {
		return numberOfHits;
	}

	public void incNumberOfHits() {
		this.numberOfHits++;
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public String toString() {
		return "Node element: " + element + "";
	}

}
