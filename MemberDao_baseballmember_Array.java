package dao;

import java.util.Scanner;

import dto.Batter;
import dto.Human;
import dto.Pitcher;
import file.DataProc;

public class MemberDao {

	Scanner sc = new Scanner(System.in);
	
//	private Pitcher pitcher[];
//	private Batter batter[];
	
	private Human human[] = null;	
	private int mem_count;
	
	DataProc dp;
	
	public MemberDao() {
		human = new Human[100];
		/*
		human[0] = new Pitcher(1001, "홍길동", 24, 180, 10, 2, 0.2);
		human[1] = new Batter(1002, "일지매", 21, 178, 25, 12, 0.5);
		human[2] = new Pitcher(1003, "성춘향", 16, 175, 12, 1, 0.1);
		human[3] = new Batter(1004, "홍길동", 23, 182, 11, 5, 0.4);
		*/
		dp = new DataProc("baseball");
		dp.createFile();
		
		load();
		
		mem_count = 0;
	}
	
	public MemberDao(int count) {
		human = new Human[count];
		mem_count = 0;
	}
	
	public void insert() {
		// 투수/타자 
		System.out.print("투수(1)/타자(2) = ");
		int pos = sc.nextInt();
		
		System.out.print("번호 = ");
		int number = sc.nextInt();
		
		System.out.print("이름 = ");
		String name = sc.next();
		
		System.out.print("나이 = ");
		int age = sc.nextInt();
		
		System.out.print("신장 = ");
		double height = sc.nextDouble();
		
		Human h = null;
		if(pos == 1) {
			System.out.print("승리 = ");
			int win = sc.nextInt();
			
			System.out.print("패전 = ");
			int lose = sc.nextInt();
			
			System.out.print("방어율 = ");
			double defence = sc.nextDouble();
			
			// human[mem_count] = new Pitcher(number, name, age, height, win, lose, defence);
			h = new Pitcher(number, name, age, height, win, lose, defence);			
			
		}else if(pos == 2){			
			System.out.print("타수 = ");
			int batcount = sc.nextInt();
			
			System.out.print("안타 수 = ");
			int hit = sc.nextInt();
			
			System.out.print("타율 = ");
			double hitAvg = sc.nextDouble();
			
			// human[mem_count] = new Batter(number, name, age, height, batcount, hit, hitAvg);
			h = new Batter(number, name, age, height, batcount, hit, hitAvg);
		}	
		human[mem_count] = h;		
		mem_count++;
	}
	
	public void delete() {
		System.out.print("삭제할 이름 = ");
		String name = sc.next();		
		
		int index = search(name);
		if(index == -1) {
			System.out.println("등록되지 않은 선수입니다");
			return;
		}		
		if(human[index] instanceof Pitcher) {
			/*
			Pitcher p = (Pitcher)human[index];
			p.setNumber(0);
			p.setName("");
			p.setAge(0);
			p.setHeight(0.0);
			p.setWin(0);
			p.setLose(0);
			p.setDefence(0.0);
			*/	
			//Pitcher p = (Pitcher)human[index];
			//p.pitcherClear();
			
			((Pitcher)human[index]).pitcherClear();
			
		}else if(human[index] instanceof Batter){
			
		}		
		System.out.println("정상적으로 삭제되었습니다");		
	}
	
	public void select() {
		System.out.println("검색할 선수명을 입력 = ");
		String name = sc.next();
		
		int findIndex[] = searchAll(name);
		
		if(findIndex == null) {
			System.out.println("선수명단에 없습니다");			
		}
		else {
			System.out.println("검색한 선수명단입니다");
			
			for (int i = 0; i < findIndex.length; i++) {
				Human h = human[ findIndex[i] ];
				System.out.println(h.toString());
			}			
		}		
	}
	
	public void update() {
		System.out.print("수정하고 싶은 선수 이름 = ");
		String name = sc.next();
		
		int index = search(name);
		if(index == -1) {
			System.out.println("등록되지 않은 선수입니다");
			return;
		}
		
		// 등록된 선수의 경우
		if(human[index] instanceof Pitcher) {
			System.out.print("승 = ");
			int win = sc.nextInt();
			System.out.print("패 = ");
			int lose = sc.nextInt();
			System.out.print("방어율 = ");
			double defence = sc.nextDouble();
						
			Pitcher p = (Pitcher)human[index];
			p.setWin(win);
			p.setLose(lose);
			p.setDefence(defence);
		}
		else if(human[index] instanceof Pitcher) {
			
		}		
		System.out.println("선수 데이터를 수정하였습니다");
	}
	
	public int search(String name) {		
		int index = -1;
		for (int i = 0; i < human.length; i++) {
			// 		생성안된 객체 첵크			삭제된 데이터를 첵크
			if(human[i] != null && human[i].getNumber() != 0) {
				if(name.equals(human[i].getName())) {
					index = i;
					break;
				}
			}
		}
		return index;
	}
	
	public int[] searchAll(String name) {
		int indexs[] = null;
		int count = 0;	
				
		for (int i = 0; i < human.length; i++) {
			if(human[i] != null && human[i].getAge() != 0) {
				if(human[i].getName().equals(name)) {
					count++;
				}
			}
		}
		
		if(count == 0) {
			System.out.println("작성한 이름의 선수는 없습니다");
			return null;
		}
		
		indexs = new int[count];
		
		int j = 0;
		for (int i = 0; i < human.length; i++) {
			if(human[i] != null && human[i].getAge() != 0) {
				if(human[i].getName().equals(name)) {
					indexs[j] = i;
					j++;
				}
			}
		}
		return indexs;		
	}	
	
	public void allprint() {
		for (int i = 0; i < human.length; i++) {
			if(human[i] != null && !human[i].getName().equals("")) {
				System.out.println(human[i].toString());
			}
		}
	}
	
	
	
	public void save() {	
		// 1001-홍길동-24-
		int len = 0;
		for (int i = 0; i < human.length; i++) {
			if(human[i] != null && human[i].getName().equals("") == false ) {
				len++;				
			}
		}
		
		// String str = human[0].getNumber() + "-" + human[1].getName()
		
		String datas[] = new String[len];
		int j = 0;
		for (int i = 0; i < human.length; i++) {
			if(human[i] != null && human[i].getName().equals("") == false ) {
				datas[j] = human[i].toString();
				j++;
			}
		}
		
		dp.saveData(datas);
				
	}
	public void load() {	
		
		String datas[] = dp.loadData();
		/*
		for (int i = 0; i < datas.length; i++) {
			System.out.println(datas[i]);
		}
		*/
		/*
			datas -> Human
			pos -> "투수"/"타자"
			number 	투수 -> 1001
					타자 -> 1002 + 1000			
		*/
		
		for (int i = 0; i < datas.length; i++) {
			
			/*
			  	datas[0] -> 1001-홍길동-24-180.0-10-2-0.2
			  	
				data[0] : number
				data[1] : name
				data[2] : age
			*/
			String data[] = datas[i].split("-");
			int number = Integer.parseInt(data[0]);
						
			if(number < 2000) {	// 투수
				human[i] = new Pitcher(	Integer.parseInt(data[0]), // 번호
										data[1], 					// 이름
										Integer.parseInt(data[2]), 	// 나이
										Double.parseDouble(data[3]), // 신장 
										Integer.parseInt(data[4]), // 승
										Integer.parseInt(data[5]), // 패	
										Double.parseDouble(data[6])); // 방어율
				
			}
			else {				// 타자
				human[i] = new Batter(	Integer.parseInt(data[0]), // 번호
										data[1], 					// 이름
										Integer.parseInt(data[2]), 	// 나이
										Double.parseDouble(data[3]), // 신장 
										Integer.parseInt(data[4]), // 타수
										Integer.parseInt(data[5]), // 안타 수	
										Double.parseDouble(data[6])); // 타율
			}
			
		}
		
	}
	
	
}
















