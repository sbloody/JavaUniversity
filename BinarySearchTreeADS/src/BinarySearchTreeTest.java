import static org.junit.Assert.*;

import org.junit.Test;


public class BinarySearchTreeTest {

//	@Test
//	public void testNodeConstruction()
//	{
//		Node root=new Node(10);
//		Node left= new Node(5);
//		Node right=new Node(15);
//		Node left1=new Node(3);
//		Node right1=new Node(7);
//		Node right2=new Node(20);
//		BinarySearchTree tree=new BinarySearchTree();
//		tree.setRoot(root);
//		tree.getRoot().setLeft(left);
//		tree.getRoot().setRight(right);
//		left.setLeft(left1);
//		left.setRight(right1);
//		right.setRight(right2);
//		root.setLeft(left);
//		root.setRight(right);
//		left.setLeft(left1);
//		left.setRight(right1);
//		right.setRight(right2);
//		tree.printPreOrder();
//	}
	@Test
	public void testAdd()
	{	
		BinarySearchTree tree=new BinarySearchTree();
		tree.add(10);
		tree.add(5);
		tree.add(1);
		tree.add(2);
		tree.add(15);
		tree.add(5);
		tree.add(3);
		tree.add(11);
		System.out.println(tree.getRoot());
		System.out.println(tree.getRoot().getRight());
		System.out.println(tree.getRoot().getRight().getLeft());
		System.out.println(tree.getRoot().getLeft());
		System.out.println(tree.getRoot().getLeft().getLeft());
		
	}
	@Test
	public void testContains()
	{
		BinarySearchTree tree=new BinarySearchTree();
		tree.add(10);
		tree.add(5);
		tree.add(1);
		tree.add(2);
		tree.add(15);
		tree.add(5);
		tree.add(3);
		tree.add(11);
		assertTrue(tree.contains(10));
		assertFalse(tree.contains(13));
		assertTrue(tree.contains(15));
		assertTrue(tree.contains(3));
		assertFalse(tree.contains(50));
	}
	
	@Test
	public void testMin() throws Exception
	{
		BinarySearchTree tree=new BinarySearchTree();
		tree.add(10);
		tree.add(5);
		tree.add(1);
		tree.add(2);
		tree.add(15);
		tree.add(5);
		tree.add(3);
		tree.add(11);
		assertEquals(1,tree.findMin());
		
	}
	@Test
	public void testMax()throws Exception
	{
		BinarySearchTree tree=new BinarySearchTree();
		tree.add(10);
		tree.add(5);
		tree.add(1);
		tree.add(2);
		tree.add(15);
		tree.add(5);
		tree.add(3);
		tree.add(11);
		assertEquals(15,tree.findMax());
	}
}
