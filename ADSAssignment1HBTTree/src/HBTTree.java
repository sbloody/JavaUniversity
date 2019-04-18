import java.util.Stack;

public class HBTTree {

	private Node root;
	private Node temp;
	private Stack<Object> s;

	public HBTTree() {
		this.root = null;
		this.temp = new Node();
		this.s = new Stack();
	}

	public HBTTree(int element) {
		Node node = new Node(element);
		this.root = node;
		this.temp = new Node();
		// node.setLeft(null);
		// node.setRight(null);

	}

	public void setRootHighest() {
		this.root = highestHit();
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	// public void makeATree(HBTTree tree)
	// {
	// Stack tree1=new Stack<>();
	// tree1.push(tree);
	// System.out.println(tree1);
	// // while(!tree1.isEmpty()){
	// // HBTTree current=new HBTTree();
	// // current.setRoot(root);
	// // }
	// }

	public void putNodesInStack() {
		putNodesInStackRec(root);
	}

	private void putNodesInStackRec(Node currRoot) {
		if (currRoot == null)
			return;
		s.push(currRoot);
		putNodesInStackRec(currRoot.getLeft());
		putNodesInStackRec(currRoot.getRight());
	}

	public HBTTree makeTreeFromStack() {
		HBTTree tree = new HBTTree(highestHit().getElement());
		while (!s.isEmpty()) {
			Node tr = (Node) s.pop();
			tree.add(tr.getElement());
		}
		return tree;

	}

	// public void clearTree() {
	// clearTreeRec(root);
	// }
	//
	// private void clearTreeRec(Node currRoot) {
	// if (currRoot != null) {
	// clearTreeRec(currRoot.getLeft());
	// clearTreeRec(currRoot.getRight());
	// currRoot = null;
	// }
	// }

	public HBTTree balance() {
		if (root.getNumberOfHits() < highestHit().getNumberOfHits()) {
			putNodesInStack();
			HBTTree tr = makeTreeFromStack();
			return tr;
		}
		return null;
	}

	public Node getRoot() {
		return this.root;
	}

	public String toString(Node currRoot) {
		String s = currRoot + "-";
		return s;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void printPreorder() {
		printPreOrderRec(root);
		System.out.println("");
	}

	private void printPreOrderRec(Node currRoot) {
		if (currRoot == null) {
			return;
		}
		System.out.print(currRoot.getElement() + ",hits: "
				+ currRoot.getNumberOfHits() + " ");
		printPreOrderRec(currRoot.getLeft());
		printPreOrderRec(currRoot.getRight());
	}

	public void add(int i) {
		if (isEmpty())
			root = new Node(i);
		else {
			root.incNumberOfHits();
			if (i < root.getElement()) {

				if (root.getLeft() == null)
					root.setLeft(new Node(i));
				else
					add(i, root.getLeft());
			} else {

				if (root.getRight() == null)
					root.setRight(new Node(i));
				else {
					add(i, root.getRight());
				}
			}
		}
	}

	private void add(int i, Node n) {
		if (isEmpty())
			root = new Node(i);
		n.incNumberOfHits();
		if (i < n.getElement()) {

			if (n.getLeft() == null)
				n.setLeft(new Node(i));
			else {
				add(i, n.getLeft());
				// n.getLeft().incNumberOfHits();
			}
		} else {
			if (n.getRight() == null)
				n.setRight(new Node(i));
			else {
				add(i, n.getRight());
				// n.getRight().incNumberOfHits();
			}
		}
	}

	

	public Node highestHit() {
		return highestHit(root);

	}

	private Node highestHit(Node currRoot) {
		if (currRoot == null)
			return null;
		if (temp.getNumberOfHits() < currRoot.getNumberOfHits())
			temp = currRoot;
		highestHit(currRoot.getLeft());
		highestHit(currRoot.getRight());
		return temp;

	}

	// public void balance() {
	// setRoot();
	// Node temp = highestHit();
	// }

	public boolean contains(int i) {
		Node current = root;
		while (current != null) {
			if (i == current.getElement()) {
				current.incNumberOfHits();
				return true;
			} else if (current.getElement() < i)
				current = current.getRight();
			else if (current.getElement() > i)
				current = current.getLeft();
		}
		return false;
	}

	public int findMin() throws Exception {
		Node curr = root;
		if (isEmpty())
			throw new Exception();
		while (curr.getLeft() != null)
			curr = curr.getLeft();
		curr.incNumberOfHits();
		return curr.getElement();
	}

	public int findMax() throws Exception {
		Node curr = root;
		if (isEmpty())
			throw new Exception();
		while (curr.getRight() != null)
			curr = curr.getRight();
		curr.incNumberOfHits();
		return curr.getElement();
	}

	public boolean delete(int i) {
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while (current.getElement() != i) {
			parent = current;
			if (current.getElement() > i) {
				isLeftChild = true;
				current = current.left;
			} else {
				isLeftChild = false;
				current = current.right;
			}
			if (current == null) {
				return false;
			}
		}
		//
		// no children
		if (current.left == null && current.right == null) {
			if (current == root) {
				root = null;
			}
			if (isLeftChild == true) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		// one child
		else if (current.right == null) {
			if (current == root) {
				root = current.left;
			} else if (isLeftChild) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		} else if (current.left == null) {
			if (current == root) {
				root = current.right;
			} else if (isLeftChild) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		} else if (current.left != null && current.right != null) {

			// now we have found the minimum element in the right sub tree
			Node successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			successor.left = current.left;
		}
		return true;
	}

	public Node getSuccessor(Node deleleNode) {
		Node successsor = null;
		Node successsorParent = null;
		Node current = deleleNode.right;
		while (current != null) {
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		// check if successor has the right child, it cannot have left child for
		// sure
		// if it does have the right child, add it to the left of
		// successorParent.
		// successsorParent
		if (successsor != deleleNode.right) {
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}

}
