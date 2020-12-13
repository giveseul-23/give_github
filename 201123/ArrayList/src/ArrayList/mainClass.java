package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

import dto.MemberDto;

public class mainClass {

	public static void main(String[] args) {

		/*
		
			Collection : (Object)수집
			
			List : 	목록		+ Array 
				   	데이터의 관리를 유동적으로 할 수 있는 배열
				   	
			ArrayList(== Vector)
						"검색" 속도가 빠름
						배열처럼 사용할 수 있는 목록
						선형구조	O-O-O-O-O-...
						index로 접근하고 관리됨 	// 범위 : 0 ~ n-1
						추가, 삭제 작업이 무겁다
						
						
			LinkedList 
						"삽입과 삭제"가 빈번히 일어나는 경우 적합
						
						
		*/
		
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		
		//List -> 인터페이스로 구성
		//List<Integer> list = new ArrayList<Integer>();
		
		//추가 - 꼬리부분에 계속 추가
		//첫번째 방법
		arrlist.add(1001); 
		//두번째 방법
		arrlist.add(new Integer(1002));
		//세번째 방법
		Integer in = new Integer(1003);
		arrlist.add(in);	
		
		int len = arrlist.size(); //length가 XXXX
		System.out.println("len : " + len);
		
		//데이터의 산출
		Integer outVal =  arrlist.get(1);
		System.out.println("arrlist.get(1) : " + outVal);
		
		
		for (int i = 0; i < arrlist.size(); i++) {
			Integer n = arrlist.get(i);
			System.out.println(i + " : " + n);
		}
		
		for (Integer i : arrlist) {
			System.out.println(i);
		}
		
		//추가 - 원하는 위치 추가
		Integer inum = new Integer(5002);
		arrlist.add(1, inum);
		
		for (int i = 0; i < arrlist.size(); i++) {
			Integer n = arrlist.get(i);
			System.out.println(i + " : " + n);
		}
		
		
		//삭제
		arrlist.remove(2);
		
		for (int i = 0; i < arrlist.size(); i++) {
			Integer n = arrlist.get(i);
			System.out.println(i + " : " + n);
		}
		
		//검색
		//01방법
		int index = arrlist.indexOf(1003);
		System.out.println("index : "+index);	//2
		System.out.println(arrlist.get(index));	//1003
		
		
		//02방법
		index = -1;
		
		for (int i = 0; i < arrlist.size(); i++) {
			Integer value = arrlist.get(i);
			if(value == 5002) {
				index = i;
				break;
			}
		}
		System.out.println("index : "+index);	//1
		
		
		//수정
		Integer newData = new Integer(1002);	//새로 들어갈 데이터
		arrlist.set(1, newData);
		
		for (int i = 0; i < arrlist.size(); i++) {
			Integer n = arrlist.get(i);
			System.out.println(i + " : " + n);
		}
		
		
		//String
		ArrayList<String> list = new ArrayList<String>();
		
		//추가
		list.add("사과");
		list.add("딸기");
		list.add("멜론");
		list.add("수박");
		
		//데이터 산출
		
		String str = list.get(2);
		System.out.println("list.get(2) : "+str);
		
		//삭제
		list.remove(0);
		
		for (int i = 0; i < list.size(); i++) {
			String fruit = list.get(i);
			System.out.println(i + ":" + fruit);
		}
		
		//검색
		int f_index = list.indexOf("멜론");  //indexOf : 앞에서 부터 훑는 것, lastindexOf : 뒤에서 부터 훑는 것
		System.out.println(list.get(f_index));
		
		//수정
		String f_newd = new String("망고");
		list.set(0, f_newd);
		
		for (int i = 0; i < list.size(); i++) {
			String fruit = list.get(i);
			System.out.println(i + ":" + fruit);
		}
		
		//----------------------------------
		
		ArrayList<MemberDto> memlist = new ArrayList<MemberDto>();
		
		//추가, 삭제, 검색, 수정
		//추가
			//3명만 추가
		Scanner sc = new Scanner(System.in);
		MemberDto mbd = null;
		
		int w = 0;
		while(w<3) {
			
			System.out.print("번호 입력 : ");
			int num = sc.nextInt();
			System.out.print("이름 입력 : ");
			String name =  sc.next();
			System.out.print("나이 입력 : ");
			int age = sc.nextInt();
			
			mbd = new MemberDto(num, name, age);
			
			memlist.add(mbd);
			
			w++;
		}
		
		//데이터 산출
		for (int i = 0; i < memlist.size(); i++) {
			MemberDto n = memlist.get(i);
			System.out.println(i + ":" + n);
		}
		
		//검색 
			//두가지 조건 이름, 나이  [18세 이상 멤버]
		System.out.print("찾으시는 조건을 먼저 선택해주세요. (이름(1) | 성인(2)) ");
		int obj_num = sc.nextInt();
		int mem_index = -1;
		
		if(obj_num == 1) {
			System.out.print("이름 입력 : ");
			String name2 = sc.next();
			
			String value[] = new String[3];
			
			for (int i = 0; i < memlist.size(); i++) {
				if((memlist.get(i)).getName().equals(name2)) {
					mem_index = i;
				}
			}
			
			if(mem_index == -1) {
				System.out.println("찾으시는 정보가 없습니다.");
			}else {
				System.out.println("성공적으로 데이터를 찾았습니다.");
				System.out.println(memlist.get(mem_index));
			}
			
		}else if(obj_num == 2) {
				int len2 = 0;
				for (int i = 0; i < memlist.size(); i++) {
					int age =(memlist.get(i)).getAge();
					if(age >= 18) {
						len2++;
					}
				}
				int mem_indexs[] = new int[len2];
				
				int j = 0;
				for (int i = 0; i < memlist.size(); i++) {
					int age =(memlist.get(i)).getAge();
					if(age >= 18) {
						mem_indexs[j] = i;
						j++;
					}
				}
				
				for (int i = 0; i < mem_indexs.length; i++) {
					if(mem_indexs != null) {
						System.out.println(memlist.get(mem_indexs[i]));
					}
				}
				
			}
	
		//삭제
		System.out.println("삭제할 이름 : ");
		String d_name = sc.next();
		
		
	}
}
