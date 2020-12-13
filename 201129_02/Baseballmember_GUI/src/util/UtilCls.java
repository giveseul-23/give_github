package util;

import java.util.ArrayList;
import java.util.List;

import dto.Human;

public class UtilCls {
	
	//static -> list를 계속 공유하고 있는 상황
	//search부분도 select, delete, update 에서 계속 공유되고 있어서 static을 사용하는 것이 데이터부분에서 ㄱㅊ
	public static int search(String name, List<Human> list) {
		int index = -1;		
		for (int i = 0; i < list.size(); i++) {
			Human h = list.get(i);
			if(name.equals(h.getName())) {
				index = i;
				break;
			}
		}		
		return index; 
	}
	
	public static List<Integer> searchAll(String name, List<Human> list) {		
		List<Integer> indexList = new ArrayList<Integer>();		
		for (int i = 0; i < list.size(); i++) {
			Human h = list.get(i);
			if(name.equals(h.getName())) {
				indexList.add( i );
			}			
		}		
		return indexList; // 동일한 네이밍에 있는 주소 i의 위치를 indexList에 넣어줌
	}	
}
