package main;

import java.util.Scanner;

import dao.MemberDao;

import dao.impl.AllprintCls;
import dao.impl.DeleteCls;
import dao.impl.InsertCls;
import dao.impl.SelectCls;
import dao.impl.SortingCls;
import dao.impl.UpdateCls;

import data.DataLoad;
import data.DataSave;

public class mainClass {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DataLoad load = new DataLoad("baseballTeam");
		//load.proc();
		
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
			
			MemberDao dao = null;	//멤버다오의 객체를 일단 설정
			
			switch(work) {
				case 1:
					dao = new InsertCls();		// 메뉴선택을 할 때마다 그에 맞는 인스턴스를 잠깐 동적할당해주고 			
					break;
				case 2:
					dao = new DeleteCls();
					break;
				case 3:
					dao = new SelectCls();
					break;
				case 4:
					dao = new UpdateCls();
					break;
				case 5:
					dao = new AllprintCls();
					break;
				case 6:
					dao = new SortingCls();
					break;
				case 7:
					dao = new DataSave("baseballTeam");
					break;
				case 8:
					System.exit(0);					
					break;			
			}
			
			dao.proc(); //메뉴선택에 맞는 생성된 인스턴스의 .proc을 사용해주고 
			//프로그램이 다시 돌아갈때마다 동적할당을 해주고 프로그램이 끝나면 가비지콜렉터에 의해 사라짐
			
			//인스턴스를 하나하나 생성하면 프로젝트가 많은 상황에서 데이터가 무거워질 수도 있음
		}
		
	}
}
