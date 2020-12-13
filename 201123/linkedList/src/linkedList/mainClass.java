package linkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class mainClass {
	public static void main(String[] args) {
		/*
			ArrayList : 검색, 대입		== Vector (Standard Template Library)
			
			LinkedList : 실시간 추가, 삭제가 빠르다
		*/
		
		Vector<String> vec = new Vector<String>();		
		vec.add(new String("hello"));		
		vec.add(0, "world");		
		vec.size();
		
		LinkedList<String> list = new LinkedList<String>();
	//	List<String> list = new LinkedList<String>();
		list.add("Tigers");
		list.add("Giants");
		list.add("Twins");
		
		for (String s : list) {
			System.out.println(s);			
		}
		
		// 맨 앞에 element(요소)를 추가
		list.addFirst("Lions");		
		for (String s : list) {
			System.out.println(s);			
		}
		
		list.addLast("Bears");		
		for (String s : list) {
			System.out.println(s);			
		}
		
	//	ArrayList<String> alist = new ArrayList<String>(list);
	//	LinkedList<String> llist = new LinkedList<String>(alist);
		
		// iterator : 반복자 == 포인터	0x10 -> 0x14
		//							[0]		[1]
		
		Iterator<String> it;
		it = list.iterator();
		
		while(it.hasNext()) {
			String value = it.next();
			System.out.println("it:" + value);
		}
		
		
	}
}









