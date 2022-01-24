package tree;

public class Node {
	private int data;
	private Node left;
	private Node right;
	
	public Node(int data) {
		this.data = data;
	}
	
	public int getData() {
		return this.data;
	}
	
	public Node getLeftNodeOrNull() {
		return this.left;
	}
	
	public Node getRightNodeOrNull() {
		return this.right;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public void setLeftNode(Node node) {
		this.left = node;
	}
	
	public void setRightNode(Node node) {
		this.right = node;
	}
}
