package main;

import java.util.Scanner;

import dao.MemberDao;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MemberDao dao = new MemberDao();
		
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
				case 1 : dao.insert();
				break;
				case 2 : dao.delete();
				break;
				case 3 : dao.select();
				break;
				case 4 : dao.update();
				break;
				case 5 : dao.allPrint();
				break;
				case 6 : dao.save();
				break;
			}
			if(answerNum==7) {
				break;
			}
		}
		
	}

}
