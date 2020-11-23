package main;

import java.util.Scanner;

import dao.StudentDao;

public class mainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//메뉴(view)
		StudentDao stDao = new StudentDao();
		
		while(true) {
			
			System.out.println("1.학생정보 추가");
			System.out.println("2.학생정보 삭제");
			System.out.println("3.학생정보 검색");
			System.out.println("4.학생정보 수정");
			System.out.println("5.학생정보 모두 출력");
			System.out.println("6.영어점수의 순위");
			System.out.println("7.종료");
			System.out.print("어떤 작업을 하시겠습니까? = ");
			int num = sc.nextInt();
			
			switch (num) {
				case 1:
					stDao.insert();
					break;
				case 2:
					stDao.delete();
					break;
				case 3:
					stDao.select();
					break;
				case 4:
					stDao.update();
					break;
				case 5 :
					stDao.allPrint();
					break;
				case 6 :
					stDao.arraySort();
					break;
			}
			
			
			if(num==7) {
				System.out.println("프로그램을 종료하겠습니다. 안녕히계십시오.");
				break;
			}

			
		}
	
		
		
	}

}
