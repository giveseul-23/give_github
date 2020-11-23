package main;

public class mainClass {

	public static void main(String[] args) {
		
		Node node1 = new Node(new Integer(111));
		
		/*
			//인스턴스에서 바로 값을 넣을수있는것이 wrapperClass
			int i = new Integer(123);
			int num = i;
			System.out.println(num);
		*/
		
		Node node2 = new Node(new Integer(222));
		Node node2_2 = new Node(223);
		node1.makeLeftSub(node2);//1단계 자식 left에 넣음
		node1.makeRightSub(node2_2);//1단계 자식 right에 넣음
		
		Node node3 = new Node(new Integer(333));
		Node node3_3 = new Node(332);
		node1.getLeftSubTree().makeRightSub(node3);//2단계 자식1의 l,r
		node1.getLeftSubTree().makeLeftSub(node3_3);
		
		Node node4 = new Node(334);
		Node node4_2 = new Node(335);
		node1.getRightSubTree().makeLeftSub(node4);//2단계 자식2의 l,r
		node1.getRightSubTree().makeRightSub(node4_2);
	}

}
