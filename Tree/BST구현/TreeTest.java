package tree;

public class TreeTest {

	public static void main(String[] args) {
		Tree tree = new Tree();
		
		tree.insertNode(tree.getRootOrNull(), 7);
		tree.insertNode(tree.getRootOrNull(), 5);
		tree.insertNode(tree.getRootOrNull(), 6);
		tree.insertNode(tree.getRootOrNull(), 3);
		tree.insertNode(tree.getRootOrNull(), 4);
		tree.insertNode(tree.getRootOrNull(), 2);
		tree.insertNode(tree.getRootOrNull(), 9);
		tree.insertNode(tree.getRootOrNull(), 10);
		tree.insertNode(tree.getRootOrNull(), 8);
		tree.insertNode(tree.getRootOrNull(), 1);
		
		boolean b = tree.searchNodeOrNull(tree.getRootOrNull(), 9); // true
		System.out.println(b);
		
		b = tree.searchNodeOrNull(tree.getRootOrNull(), 11); // false
		System.out.println(b);
		
		tree.deleteNode(tree.getRootOrNull(), 9);
		
		tree.traversePreorder(tree.getRootOrNull());
		System.out.println();
		
		tree.traverseInorder(tree.getRootOrNull());
		System.out.println();
		
		tree.traversePostorder(tree.getRootOrNull());
	}
}
