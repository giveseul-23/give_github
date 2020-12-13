package HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import cls.MyDto;

public class mainClass {

	public static void main(String[] args) {
		
		/*
		
			HashMap : 사전
					
					String	:	Object
					"사과" 	: 	"apple"
					key   	:	value	-> 1 pair	==> web json
					
					list는 index로 접근하지만 HashMap의 경우 key로 접근한다.
					tree 구조  : 장점 - 탐색(탐색속도)이 빠름
					key는 중복되지 않는다.
					
			TreeMap = HashMap + Sorting 
		
		*/
		
		
		HashMap<Integer, String> hMap = new HashMap<Integer, String>();
		Map<Integer, String> map = new HashMap<Integer, String>();	//인터페이스 util
		
		//호환가능
		//트리맵은 해쉬맵보다 무겁다
		//TreeMap<Integer, String> tMap = new TreeMap<Integer, String>(hMap);
		
		//추가	key 	value
		hMap.put(111, "백십일");
		hMap.put(new Integer(222), new String("이백이십이"));
		hMap.put(333, "삼백삼십삼");
		
		//value 취득
		String value = hMap.get(1111); // get 안에는 index값이 아니라 key 값을 넣어줘야 함
		System.out.println("value : "+value);
		
		//검색
			//있다/없다 (t/f)
		boolean b = hMap.containsKey(new Integer(2222));
		System.out.println("b = "+b);
		
		//값을 취득 
		if(hMap.containsKey(333)) {
			value = hMap.get(333);
			System.out.println("value : "+value);
		}
		
		//모든 key값을 취득 -> value
		Iterator<Integer> it = hMap.keySet().iterator();
		
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println("key : "+key);
			
			String val = hMap.get(key);
			System.out.println("val : "+val);
		}
		
		//수정 - value만 가능 , key값은 삭제만 가능하지 key값 수정은 x, 아님 아예 지우고 다시 새로 등록해야 함
		//hMap.replace(111, "100 + 10 + 1");
		
		hMap.put(111, "110 + 1");	// key값이 중복되어 추가하면 덮어쓰기가 되어 기존 값이 유지하지 못하고 변경됨
		
		
		//삭제
		hMap.remove(222);
		
		it = hMap.keySet().iterator();
		
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println("key : "+key);
			
			String val = hMap.get(key);
			System.out.println("val : "+val);
		}
		
		HashMap<String, String> haMap = new HashMap<String, String>();
		
		haMap.put("apple", "사과");
		haMap.put("pear", "배");
		haMap.put("grape", "포도");
		haMap.put("banana", "바나나");
		
		//취득
		value = haMap.get("apple");
		System.out.println("value : " + value);
		
		//sorting
		//TreeMap <--> HashMap
		TreeMap<String, String> treeMap = new TreeMap<>(haMap);
		
		//오름
		//Iterator<String> itKey = treeMap.keySet().iterator();	//오름차순 셋팅
		
		//내림
		Iterator<String> itKey = treeMap.descendingKeySet().iterator();
		
		System.out.println("---------------------------");
		while(itKey.hasNext()) {
			String key = itKey.next();
			System.out.println("key : "+key + ", value : "+treeMap.get(key));
		}
		
		
		HashMap<Integer, MyDto> myMap = new HashMap<Integer, MyDto>();
		
		//추가
		myMap.put(1, new MyDto(1, "홍길동"));
		myMap.put(2, new MyDto(2, "김춘배"));
		myMap.put(3, new MyDto(3, "성춘향"));
		
		//삭제
		myMap.remove(2);
		
		
		//데이터 취득
		Iterator<Integer> iter = myMap.keySet().iterator();
				
		while(iter.hasNext()) {
			Integer key = iter.next();
			System.out.println("데이터 취득, key : "+key + ", value : "+myMap.get(key));
		}
		
		myMap.put(2, new MyDto(2, "김춘배"));
		
		//검색
		
		if(myMap.containsKey(1)) {
			System.out.println(myMap.get(1));
		}
		
		
		//수정
		
		myMap.replace(2, new MyDto(2, "일지매"));
		
		iter = myMap.keySet().iterator();
		
		while(iter.hasNext()) {
			Integer key = iter.next();
			System.out.println("key : "+key + ", value : "+myMap.get(key));
		}
		
		//sort
		TreeMap<Integer, MyDto> tm = new TreeMap<Integer, MyDto>(myMap);
		
		//내림
		Iterator<Integer> it_key = tm.descendingKeySet().iterator();
		
		System.out.println();
		
		while(it_key.hasNext()) {
			Integer key = it_key.next();
			System.out.println("key : "+key + ", value : "+myMap.get(key));
		}
		
		
		
		
	}

}
