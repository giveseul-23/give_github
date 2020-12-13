package human;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import batter.batter;
import file.DataProc;
import member.member;
import pitcher.pitcher;

public class memberDao {
	Scanner sc = new Scanner(System.in);
	
	public memberDao() {}
	
	member humanArr[] = null;
	member b = new batter();
	member p = new pitcher();
	
	DataProc d = new DataProc();
	File f;
	
	private int memberNumber;
	
	
	//배열 갯수
	//생성자
	public memberDao(int count) {
		humanArr = new member[count];
		memberNumber = 0; //초기화
	}
	
	public void insert() {	//create - 베이스볼멤버 기본 정보 입력
		System.out.println("선수의 종목을 입력 = (pitcher(1)|batter(2))");
		int pb = sc.nextInt();
		member human = null;
		int num = 0;
		String name = null;
		int age = 0;
		double hei = 0;
		// 공통
		if(pb == 1 ) {
			human = new pitcher();
			System.out.print("선수의 번호를 입력 = ");
			num = sc.nextInt();
			p.setNumber(num);
			
			System.out.print("선수의 이름을 입력 = ");
			name = sc.next();
			p.setName(name);
			
			System.out.print("선수의 나이를 입력 = ");
			age = sc.nextInt();
			p.setAge(age);
			
			System.out.print("선수의 키를 입력 = ");
			hei = sc.nextDouble();
			p.setHeight(hei);
			
			
		} else if(pb == 2) {
			human = new batter();
			System.out.print("선수의 번호를 입력 = ");
			num = sc.nextInt();
			p.setNumber(num);
			
			System.out.print("선수의 이름을 입력 = ");
			name = sc.next();
			p.setName(name);
			
			System.out.print("선수의 나이를 입력 = ");
			age = sc.nextInt();
			p.setAge(age);
			
			System.out.print("선수의 키를 입력 = ");
			hei = sc.nextDouble();
			p.setHeight(hei);
		}
		
		//따로 
		if(human instanceof pitcher) {
			System.out.print("승전  = ");
			int win = sc.nextInt();
			((pitcher)p).setWin(win);
			
			System.out.print("패전 = ");
			int lose = sc.nextInt();
			((pitcher)p).setLose(lose);
			
			System.out.print("방어 = ");
			int defence = sc.nextInt();
			((pitcher)p).setDefence(defence);
			
			humanArr[memberNumber] = new pitcher(win, lose, defence, num, name, age, hei);
			memberNumber++;
			
			
		} else if(human instanceof batter) {
			System.out.print("타수  = ");
			int bat = sc.nextInt();
			((batter)b).setBat(bat);
			
			System.out.print("안타수 = ");
			int hit = sc.nextInt();
			((batter)b).setHit(hit);
			
			System.out.print("타율 = ");
			int batAvg = sc.nextInt();
			((batter)b).setBatAvg(batAvg);
			humanArr[memberNumber] = new batter(num, name, age, hei, bat, hit, batAvg);
			//System.out.println(humanArr);
			memberNumber++;
		}
		
		
	}
	
	//선수정보 삭제
	public void delete() {
		System.out.print("삭제할 선수이름 = ");
		String name = sc.next();
		
		int index = -1;	//초기화, -1이면 null
		
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null) {
				//비어있지 않다면
				if(name.equals(humanArr[i].getName())) {
					index = 1;
					break;
				}
			}
		}
		
		if(index != -1) {
			humanArr[index].setNumber(0);
			humanArr[index].setName("");
			humanArr[index].setAge(0);
			humanArr[index].setHeight(0);
			
			if(humanArr[index] instanceof pitcher) {
				((pitcher)humanArr[index]).setWin(0);
				((pitcher)humanArr[index]).setLose(0);
				((pitcher)humanArr[index]).setDefence(0);
			}else if(humanArr[index] instanceof batter) {
				((batter)humanArr[index]).setBat(0);
				((batter)humanArr[index]).setHit(0);
				((batter)humanArr[index]).setBatAvg(0);
			}
			System.out.println("성공적으로 삭제하였습니다.");
		}else {
			System.out.println("선수 데이터를 찾을 수 없습니다.");
		}
		
	}
	
	//선수정보 검색
	public void search() {
		System.out.print("검색할 선수이름 = ");
		String name = sc.next();
		
		int index = -1;	//초기화, -1이면 null
		
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null) {
				//비어있지 않다면
				if(name.equals(humanArr[i].getName())) {
					System.out.println(humanArr[i]);
					break;
				}
			}
		}
		
	}
	
	//선수정보 수정
	public void update() {
		System.out.print("수정할 선수이름 = ");
		String name = sc.next();
		
		int index = -1;
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null) {
				if(name.equals(humanArr[i].getName())) {
					index = i;
					break;
				}
			}
		}
		
		
		System.out.print("해당 선수의 수정할 정보를 입력하세요 = ");
		String upName = sc.next();
		System.out.print("수정할 내용을 입력하세요 = ");
		int upInfo = sc.nextInt();
		
		if(index == -1) {
			System.out.println("해당 정보가 없습니다.");
		}else {
			member m = humanArr[index];
			if(upName.equals("이름")) {
				m.setName(upName);	
			}else if(upName.equals("번호")) {
				m.setNumber(upInfo);
			}else if(upName.equals("나이")) {
				m.setAge(upInfo);
			}else if(upName.equals("키")) {
				m.setHeight(upInfo);
			}
		}
			
		if(humanArr[index] instanceof pitcher) {
			pitcher p = (pitcher)humanArr[index];
			
			if(upName.equals("승전")) {
				p.setWin(upInfo);
			}else if(upName.equals("패전")) {
				p.setLose(upInfo);
			}else if(upName.equals("방어")) {
				p.setDefence(upInfo);
			}
		}
		
		if(humanArr[index] instanceof batter) {
			batter b = (batter)humanArr[index];
			if(upName.equals("타수")) {
				b.setBat(upInfo);
			}else if(upName.equals("안타수")) {
				b.setHit(upInfo);
			}else if(upName.equals("타율")) {
				b.setBatAvg(upInfo);
			}
		}
		
	}
	
	//데이터 저장
	public void datasave() {
		f = d.createFile("baseballMemberInfo");
		String datas[] = new String[memberNumber];//복사하기 위해 만들어준 배열
		
		for (int i = 0; i < memberNumber; i++) {
			datas[i] = humanArr[i].toString();
		}
		
		for (String string : datas) {
			System.out.println(string);
			System.out.println();
		}
		d.dataSave(f, datas);
	}
	
	//모두 출력
	public void allPrint() {
		for (int i = 0; i < memberNumber; i++) {
			System.out.println(humanArr[i].toString());
		}
	}

}


