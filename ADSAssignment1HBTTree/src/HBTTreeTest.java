import static org.junit.Assert.*;

import org.junit.Test;

public class HBTTreeTest {

	@Test
	public void testAdd() throws Exception {
		System.out.println("ADD TEST");
		HBTTree tree = new HBTTree();
		tree.add(40);
		tree.add(25);
		tree.add(78);
		tree.add(10);
		tree.add(3);
		tree.add(17);
		tree.add(32);
		tree.add(30);
		tree.add(38);
		tree.add(50);
		tree.add(93);
		// tree.add(45);
		// tree.add(55);
		// tree.add(81);
		// tree.add(94);
		// tree.add(41);
		// tree.add(46);
		tree.printPreorder();
		// tree.contains(78);
		System.out.println(tree.contains(78));
		tree.printPreorder();
		// tree.printPreorder();
		// tree.printPreorder();
		// // tree.delete(40);
		// // System.out.println(tree.contains(40));
		// tree.printPreorder();
		// tree.contains(25);
		// tree.contains(25);
		// tree.contains(25);
		// tree.contains(25);
		// tree.contains(25);
		// tree.contains(25);
		// tree.contains(25);
		// tree.contains(25);
		// tree.contains(25);
		// tree.contains(25);
		// tree.contains(25);
		// tree.contains(25);
		// tree.contains(25);
		// tree.contains(25);
		// tree.contains(25);
		// tree.contains(25);
		// tree.contains(25);
		// tree.printPreorder();
		// // tree.setRoot();
		// tree.printPreorder();
		// // tree.makeATree(tree);
		// // tree.highestHit();
		// // tree.contains(25);
		// // tree.contains(25);
		// // tree.contains(25);
		// // tree.highestHit();
		// //// tree.delete(32);
		// // tree.printPreorder();
		// // tree.putNodesInStack();
		// // HBTTree tr=tree.makeTreeFromStack();
		// // tr.printLevelOrder();
		// HBTTree tr=tree.balance();
		// // tr.printLevelOrder();
		// tr.printPreorder();
		// tr.printLevelOrder();
		// // System.out.println(" ");
		// // tr.printLevelOrder();
		// // System.out.println(tr.highestHit());
	}

	@Test
	public void testFindMax() throws Exception {
		System.out.println("FIND MAX TEST");
		HBTTree tree = new HBTTree();
		tree.add(40);
		tree.add(25);
		tree.add(78);
		tree.add(10);
		tree.add(3);
		tree.add(17);
		tree.add(32);
		tree.add(30);
		tree.add(38);
		tree.add(50);
		tree.add(93);
		System.out.println(tree.findMax());
		tree.printPreorder();
	}

	@Test
	public void testFindMin() throws Exception {
		System.out.println("FIND MINIMUM TEST");
		HBTTree tree = new HBTTree();
		tree.add(40);
		tree.add(25);
		tree.add(78);
		tree.add(10);
		tree.add(3);
		tree.add(17);
		tree.add(32);
		tree.add(30);
		tree.add(38);
		tree.add(50);
		tree.add(93);
		System.out.println(tree.findMin());
		tree.printPreorder();
	}

	@Test
	public void testBalance() {
		System.out.println("BALANCE TEST");
		HBTTree tree = new HBTTree();
		tree.add(40);
		tree.add(25);
		tree.add(78);
		tree.add(10);
		tree.add(3);
		tree.add(17);
		tree.add(32);
		tree.add(30);
		tree.add(38);
		tree.add(50);
		tree.add(93);
		tree.printPreorder();
		tree.contains(25);
		tree.contains(25);
		tree.contains(25);
		tree.contains(25);
		tree.contains(25);
		tree.contains(25);
		tree.contains(25);
		tree.contains(25);
		tree.contains(25);
		tree.contains(25);
		tree.contains(25);
		tree.contains(25);
		tree.contains(25);
		tree.contains(25);
		tree.printPreorder();
		HBTTree tr = tree.balance();
		tr.printPreorder();
	}

	@Test
	public void testHighestHit() {
		System.out.println("HIGHEST HIT TEST");
		HBTTree tree = new HBTTree();
		tree.add(40);
		tree.add(25);
		tree.add(78);
		tree.add(10);
		tree.add(3);
		tree.printPreorder();
		tree.delete(40);
		System.out.println(tree.highestHit());
		tree.printPreorder();
		HBTTree t=tree.balance();
		t.printPreorder();
		
		
	}

	@Test
	public void testDelete() {
		System.out.println("DELETE TEST");
		HBTTree tree = new HBTTree();
		tree.add(40);
		tree.add(25);
		tree.add(78);
		tree.add(10);
		tree.add(3);
		tree.add(17);
		tree.add(32);
		tree.add(30);
		tree.add(38);
		tree.add(50);
		tree.add(93);
		tree.printPreorder();
		tree.delete(40);
		tree.printPreorder();
		HBTTree tr = tree.balance();
		tr.printPreorder();
	}

}
