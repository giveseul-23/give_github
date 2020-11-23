package dao;

import java.io.File;
import java.util.Scanner;

import data.dataProc;
import dto.Batter;
import dto.Human;
import dto.Pitcher;

public class Memberdao {
	Scanner sc = new Scanner(System.in);
	
	Human[] human;
	int count;
	File f;
	dataProc d;
	
	public Memberdao() {
		human = new Human[100];
		count = 0;
		
		d = new dataProc("baseball_test_01");
		d.creatFile();
		
		load();
		/*
		human[0] = new Pitcher(1001, "홍길동", 20, 190, 5, 2, 2.5);
		human[1] = new Batter(2001, "일지매", 25, 200, 1, 7, 3.5);
		human[2] = new Pitcher(1002, "홍길동", 21, 191, 6, 3, 3);
		human[3] = new Batter(2002, "성춘향", 25, 200, 1, 7, 3.5);
		*/
	}
	
	//등록
	public void insert() {
		//공통
		System.out.print("등록할 선수의 번호 : ");
		int number = sc.nextInt();
		
		System.out.print("등록할 선수의 이름 : ");
		String name = sc.next();
		
		System.out.print("등록할 선수의 나이 : ");
		int age = sc.nextInt();
		
		System.out.print("등록할 선수의 키 : ");
		int height = sc.nextInt();
		
		//Pitcher & Batter 구분
		
		System.out.print("등록할 선수의 종목은 : (Pitcher(1) | Batter(2))");
		int pb = sc.nextInt();
		
		Human h = null;
		
		if(pb == 1) {
			System.out.print("등록할 선수의 승전 : ");
			int win = sc.nextInt();
			
			System.out.print("등록할 선수의 패전 : ");
			int lose = sc.nextInt();
			
			System.out.print("등록할 선수의 방어율 : ");
			double defence = sc.nextDouble();
			
			h = new Pitcher(number, name, age, height, win, lose, defence);
			
		}else if(pb == 2) {
			System.out.print("등록할 선수의 타수 : ");
			int batCount = sc.nextInt();
			
			System.out.print("등록할 선수의 안타수 : ");
			int hit = sc.nextInt();
			
			System.out.print("등록할 선수의 타율 : ");
			double hitCount = sc.nextDouble();
			
			h = new Batter(number, name, age, height, batCount, hit, hitCount);
		}
		
		human[count] = h;
		count++;
		
	}
	//삭제
	public void delete() {
		System.out.print("삭제할 선수의 이름 : ");
		String name = sc.next();
		
		int index = search(name);
		
		if(index == -1) {
			System.out.println("해당 선수의 데이터가 존재하지 않습니다.");
		}else {
			System.out.println("성공적으로 데이터를 수정하였습니다.");
			if(human[index] instanceof Pitcher) {
				((Pitcher)human[index]).clearPitcher();
			}else if(human[index] instanceof Batter){
				((Batter)human[index]).clearBatter();
			}
		}
		
	}
	
	//검색
	public void select() {
		System.out.print("검색할 선수의 이름 : ");
		String name = sc.next();
		
		int[] data = allSearch(name);
		
		if(data == null) {
			System.out.println("찾으시는 선수의 정보가 없습니다.");
		}else {
			System.out.println("성공적으로 데이터를 찾았습니다.");
			for (int i = 0; i < data.length; i++) {
				System.out.println(human[data[i]]);
			}	
		}
	}
	
	//수정
	public void update() {
		System.out.print("수정할 선수의 이름 : ");
		String name = sc.next();
		
		int index = search(name);
		
		if(human[index] instanceof Pitcher) {
			System.out.print("수정할 승전 : ");
			int win = sc.nextInt();
			((Pitcher)human[index]).setWin(win);
			
			System.out.print("수정할 패전 : ");
			int lose = sc.nextInt();
			((Pitcher)human[index]).setLose(lose);
			
			System.out.print("수정할 방어율 : ");
			double defence = sc.nextDouble();
			((Pitcher)human[index]).setDefence(defence);
		}else if(human[index] instanceof Batter) {
			System.out.print("수정할 타수 : ");
			int batCount = sc.nextInt();
			((Batter)human[index]).setBatCount(batCount);
			
			System.out.print("수정할 안타수 : ");
			int hit = sc.nextInt();
			((Batter)human[index]).setHit(hit);
			
			System.out.print("수정할 타율 : ");
			double hitCount = sc.nextDouble();
			((Batter)human[index]).setHitCount(hitCount);
		}
	}
	
	//search
	public int search(String name) {
		
		int index = -1;
		
		for (int i = 0; i < human.length; i++) {
			if(human[i] != null && !human[i].getName().equals("")) {
				if(human[i].getName().equals(name)) {
					index = i;
				}
			}
		}
		return index;
	}
	
	//allSearch
	public int[] allSearch(String name) {
		int len = 0;
		
		for (int i = 0; i < human.length; i++) {
			if(human[i] != null && human[i].getAge() != 0) {
				if(human[i].getName().equals(name)) {
					len++;
				}
			}
		}
		int[] data = new int[len];
		int j = 0;
		
		for (int i = 0; i < human.length; i++) {
			if(human[i] != null && human[i].getAge() != 0) {
				if(human[i].getName().equals(name)) {
					data[j] = i;
					j++;
				}
			}
		}
		
		return data;
	}
	
	//모두 출력
	public void allPrint() {
		for (int i = 0; i < human.length; i++) {
			System.out.println(human[i]);
		}
	}
	
	//파일 쓰기
	public void dataSvae() {
		int len = 0;
		for (int i = 0; i < human.length; i++) {
			if(human[i] != null && !human[i].getName().equals("")) {
				len++;
			}
		}
		
		String[] datas = new String[len];
		
		int j = 0;
		
		for (int i = 0; i < human.length; i++) {
			if(human[i] != null && !human[i].getName().equals("")) {
				datas[j] = human[i].toString();
				j++;
			}
		}
		
		d.saveData(datas);
		
	}
	
	/**/
	//파일읽기
	public void load() {
		String datas[] = d.loadData();
		
			
		for (int i = 0; i < datas.length; i++) {
			String data[] = datas[i].split("-");
			int number = Integer.parseInt(data[0]);
			
			//System.out.println(data[0]);
				
			if(number < 2000) {	// 투수
				human[i] = new Pitcher(	Integer.parseInt(data[0]),
										data[1], 					
										Integer.parseInt(data[2]), 	
										Integer.parseInt(data[3]), 
										Integer.parseInt(data[4]), 
										Integer.parseInt(data[5]), // 패	
										Double.parseDouble(data[6])); // 방어율
				
			}
			else {				// 타자
				human[i] = new Batter(	Integer.parseInt(data[0]), // 번호
										data[1], 					// 이름
										Integer.parseInt(data[2]), 	// 나이
										Integer.parseInt(data[3]), // 신장 
										Integer.parseInt(data[4]), // 타수
										Integer.parseInt(data[5]), // 안타 수	
										Double.parseDouble(data[6])); // 타율
			}
			
		}
		
	}
}
