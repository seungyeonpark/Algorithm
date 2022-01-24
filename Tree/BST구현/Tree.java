package tree;

public class Tree {
	private Node root;
	
	public Node getRootOrNull() {
		return this.root;
	}
	
	// 탐색
	public boolean searchNodeOrNull(Node node, int data) {
		if (node == null) {
			return false;
		}
		
		if (data < node.getData()) {
			return searchNodeOrNull(node.getLeftNodeOrNull(), data);
		} else if (node.getData() < data) {
			return searchNodeOrNull(node.getRightNodeOrNull(), data);
		}
		
		return true;
	}
	
	// 삽입
	public Node insertNode(Node node, int data) {
		if (root == null) {
			this.root = new Node(data);
		}
		
		if (node == null) {
			return new Node(data);
		}
		
		if (data < node.getData()) {
			node.setLeftNode(insertNode(node.getLeftNodeOrNull(), data));
		} else if (node.getData() < data) {
			node.setRightNode(insertNode(node.getRightNodeOrNull(), data));
		}
		
		return node;
	}
	
	// 삭제
	public Node deleteNode(Node node, int data) {
		if (node == null) {
			return null;
		}
		
		if (data < node.getData()) {
			node.setLeftNode(deleteNode(node.getLeftNodeOrNull(), data));
		} else if (node.getData() < data) {
			node.setRightNode(deleteNode(node.getRightNodeOrNull(), data));
		} else {
			if (node.getLeftNodeOrNull() == null && node.getRightNodeOrNull() == null) {
				return null;
			} else if (node.getLeftNodeOrNull() == null) {
				return node.getRightNodeOrNull();
			} else if (node.getRightNodeOrNull() == null) {
				return node.getLeftNodeOrNull();
			}
			
			Node temp = getBeforeNode(node.getLeftNodeOrNull());
			node.setData(temp.getData());
			node.setLeftNode(deleteNode(node.getLeftNodeOrNull(), temp.getData()));
		}
		
		return node;
	}
	
	// in-order successor
	private Node getBeforeNode(Node node) {
		if (node.getRightNodeOrNull() == null) {
			return node;
		}
		
		return getBeforeNode(node.getRightNodeOrNull());
	}
	
	// 전위 순회
	public void traversePreorder(Node node) {
		if (node == null) {
			return;
		}
		
		System.out.print(node.getData() + " ");
		traversePreorder(node.getLeftNodeOrNull());
		traversePreorder(node.getRightNodeOrNull());
	}
	
	// 중위 순회
	public void traverseInorder(Node node) {
		if (node == null) {
			return;
		}
		
		traverseInorder(node.getLeftNodeOrNull());
		System.out.print(node.getData() + " ");
		traverseInorder(node.getRightNodeOrNull());
	}
	
	// 후위 순회
	public void traversePostorder(Node node) {
		if (node == null) {
			return;
		}
		
		traversePostorder(node.getLeftNodeOrNull());
		traversePostorder(node.getRightNodeOrNull());
		System.out.print(node.getData() + " ");
	}
}
