public class AVLSearchTree {

	private Node root;

	public AVLSearchTree() {
		this.root = null;
	}

	public AVLSearchTree(int element) {
		Node node = new Node(element);
		this.root = node;

	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return this.root;
	}
	
	public int getHeight(Node n, int height)
	{
		if(isEmpty())
			return 0;
		if(n.get)
		if
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void printPreOrder() {
		printPreOrder(root);
	}

	private void printPreOrder(Node root) {
		if (isEmpty())
			return;
		System.out.println(root);
		printPreOrder(root.getLeft());
		printPreOrder(root.getRight());
	}

	public void add(int i) {
		if (isEmpty())
			root = new Node(i);
		else {
			if (i < root.getElement()) {
				if (root.getLeft() == null)
					root.setLeft(new Node(i));
				else
					add(i, root.getLeft());
			} else {
				if (root.getRight() == null)
					root.setRight(new Node(i));
				else
					add(i, root.getRight());
			}
		}
	}

	private void add(int i, Node n) {
		if (isEmpty())
			root = new Node(i);
		if (i < n.getElement()) {
			if (n.getLeft() == null)
				n.setLeft(new Node(i));
			else
				add(i, n.getLeft());
		} else {
			if (n.getRight() == null)
				n.setRight(new Node(i));
			else
				add(i, n.getRight());
		}
	}

	public boolean contains(int i) {
		Node current = root;
		while (true) {
			if (i == current.getElement())
				return true;
			else if (current.getElement() < i && current.getLeft() != null)
				current = current.getLeft();
			else if (current.getElement() > i && current.getRight() != null)
				current = current.getRight();
		}

	}

	public int findMin() throws Exception {
		if (isEmpty())
			throw new Exception();
		while (root.getLeft() != null)
			root = root.getLeft();
		return root.getElement();
	}

	public int findMax() throws Exception {
		if (isEmpty())
			throw new Exception();
		while (root.getRight() != null)
			root = root.getRight();
		return root.getElement();
	}

	private Node replacement(Node node) {
		Node result = null;

		if (node.getLeft() == null && node.getRight() == null)
			result = null;
		else if (node.getLeft() != null && node.getRight() == null)
			result = node.getLeft();
		else if (node.getLeft() == null && node.getRight() != null)
			result = node.getRight();
		else {
			Node current = node.getRight();
			Node parent = node;

			while (current.getLeft() != null) {
				parent = current;
				current = current.getLeft();
			}
			Node tempCurrent = current.getLeft();
			Node tempParent = parent.getLeft();
			Node tempCurrentRight = current.getRight();
			tempCurrent = node.getLeft();
			if (node.getRight() != current) {
				tempParent = current.getRight();
				tempCurrentRight = node.getRight();
			}
			result = current;

		}
		return result;

	}
}

