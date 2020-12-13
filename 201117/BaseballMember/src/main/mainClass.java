package main;

import java.util.Scanner;

import human.memberDao;

public class mainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		memberDao md = new memberDao(20);
		
		
		while(true) {
			System.out.println("1.선수정보 등록");
			System.out.println("2.선수정보 삭제");
			System.out.println("3.선수정보 검색");
			System.out.println("4.선수정보 수정");
			System.out.println("5.선수정보 모두출력");
			System.out.println("6.데이터 저장");
			System.out.println("7.종료");
			System.out.println("어떤 작업을 하시겠습니까 : ");
			
			int answerNum = sc.nextInt();
			
			switch(answerNum) {
				case 1 : md.insert();
				break;
				case 2 : md.delete();
				break;
				case 3 : md.search();
				break;
				case 4 : md.update();
				break;
				case 5 : md.allPrint();
				break;
				case 6 : md.datasave();
				break;
					
			}
			if(answerNum==7) {
				break;
			}
		}
		
		
	}

}
