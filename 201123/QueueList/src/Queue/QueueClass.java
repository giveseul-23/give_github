package Queue;

import java.util.ArrayList;
import java.util.List;

public class QueueClass {
	//private int front; //앞
	private int rear;	//뒤
	private int maxSize;
	
	private List<Object> q_list = new ArrayList<Object>();	//통
	
	public QueueClass() {
		maxSize = 10;
		rear = -1;
		
	}
	
	public boolean isEmpty() {
		return (q_list.size() == -1);
	}
	
	public boolean isFull() {
		return (q_list.size() >= 10);
	}
}
