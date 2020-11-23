package main;

public class Node {
	
	private Node left;
	private Node right;
	private Object data;
	
	public Node(Object data) {
		left = null;
		right = null;
		this.data = data;
	}
	
	//왼쪽 자식 Node와 연결해주는메서드
	public void makeLeftSub(Node sub) {
		this.left = sub;
	}
	
	//오른쪽 자식 Node와 연결해주는메서드
	public void makeRightSub(Node sub) {
		this.right = sub;
	}

	public Object getData() {
		return data;
	}
	
	
	public Node getLeftSubTree() {
		return this.left;
	}
	
	public Node getRightSubTree() {
		return this.right;
	}
}
