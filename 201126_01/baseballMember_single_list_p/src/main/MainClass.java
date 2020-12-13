package main;

import java.util.Scanner;

import Dao.MemberDao;
import Dao.im.AllPrint;
import Dao.im.Delete;
import Dao.im.Fileload;
import Dao.im.Filesave;
import Dao.im.Insert;
import Dao.im.Select;
import Dao.im.Sorting;
import Dao.im.Update;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MemberDao md = null;
		
		Fileload load = new Fileload("baseball_game_list");
		load.proc();
		
		while(true) {
			System.out.println("1.선수 추가");
			System.out.println("2.선수 삭제");
			System.out.println("3.선수 검색");
			System.out.println("4.선수 수정");
			System.out.println("5.선수 모두 출력");
			System.out.println("6.타율에 따른 정렬");
			System.out.println("7.데이터 저장");
			System.out.println("8.종료");

			System.out.print(">> ");
			int work = sc.nextInt();
			
			switch(work) {
				case 1 : 
					md = new Insert();
					break;
				case 2 : 
					md = new Delete();
					break;
				case 3 :
					md = new Select();
					break;
				case 4 : 
					md = new Update();
					break;
				case 5 : 
					md = new AllPrint();
					break;
				case 6 : 
					md = new Sorting();
					break;
				case 7 : 
					md = new Filesave("baseball_game_list");
					break;
				case 8 :
					System.exit(0);
					break;
			}
			
			md.proc();
		}
		
	}

}
