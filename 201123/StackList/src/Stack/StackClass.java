package Stack;

import java.util.ArrayList;
import java.util.List;

public class StackClass {

//	private int top;
	private int maxSize;
//	
//	private Object stackArray[];
	
	private List<Object> list = new ArrayList<Object>();
	
	public StackClass() {
		maxSize = 10;
	}
	
	public boolean isEmpty() {
		return (list.size() == 0);
	}
	
	public boolean isFull() {
		return (list.size() >= 10);
	}
	
	//insert
	public void push(Object obj) {
		if(isFull()) {
			return;
		}
		
		list.add(obj);
	}
	
	//pop 
	public Object pop() {
		Object obj = peek();
		list.remove(obj);
		
		return obj;
	}
	
	//peek
	public Object peek() {
		if(isEmpty()) {
			return null;
		}
		
		return list.get(list.size() - 1); //마지막 것을 뺌
	
	}
	
	
}
