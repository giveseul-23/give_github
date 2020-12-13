package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import FileProc.FileProc;
import dto.Batter;
import dto.Human;
import dto.Pitcher;

public class MemberDao {
	Scanner sc = new Scanner(System.in);
	
	//List<Human> list = new ArrayList<Human>();
	HashMap<String, Human> hmap = new HashMap<String, Human>();
	
	int p_num;
	int b_num;
	FileProc fp;
	
	int nameNum = 1;
	
	public MemberDao() {
		
		/*
		hmap.put("홍길동", new Pitcher(1001, "홍길동", 20, 190, 1, 2, 3));
		hmap.put("성춘향", new Batter(2001, "성춘향", 20, 190, 1, 2, 3));
		hmap.put("일지매", new Pitcher(1002, "일지매", 20, 190, 1, 2, 3));
		*/
		
		fp = new FileProc("baseballMember_map_a");
		fp.creatfile();
		
		p_num = 1;
		b_num = 1;
		
		load();
		
	}
	
	//insert
	public void insert() {
		
		//공통
		System.out.print("투수(1)|타자(2) = ");
		int pos = sc.nextInt();
		
		System.out.print("이름 = ");
		String name = sc.next();
		
		System.out.print("나이 = ");
		int age = sc.nextInt();
		
		System.out.print("신장 = ");
		double height  = sc.nextDouble();
		
		if(pos == 1) {	//투수   1000번대 시작
			int number = 1000 + p_num++;
			
			System.out.print("승리 = ");
			int win = sc.nextInt();
			
			System.out.print("패전 = ");
			int lose =sc.nextInt();
			
			System.out.print("방어율 = ");
			double defence = sc.nextDouble();
			
			
			if(hmap.containsKey(name)) {
				name = name + nameNum++;
			}
			
			hmap.put(name,(new Pitcher(number, name, age, height, win, lose, defence)));
			
		}
		
		if(pos == 2){	//타자 - 2000번대 시작
			
			int number = 2000 + b_num++;
			
			System.out.print("타수 = ");
			int batCount = sc.nextInt();
			
			System.out.print("안타수 = ");
			int hit = sc.nextInt();
			
			System.out.print("타율 = ");
			double hitAvg = sc.nextDouble();
			
			if(hmap.containsKey(name)) {
				name = name + nameNum++;
			}
			
			hmap.put(name,(new Batter(number, name, age, height, batCount, hit, hitAvg)));
		}
	}
	
	//delete
	public void delete() {

		
		System.out.print("삭제할 선수이름 : ");
		String name = sc.next();
		
		//Human h = search(name);
		
		if(hmap.get(name) == null) {
			System.out.println("해당 선수의 데이터를 찾을 수 없습니다.");
			return;
		}else {
			System.out.println("성공적으로 데이터를 삭제하였습니다.");
			hmap.remove(name);
		}
		
	}
	
	/**/
	//select
	public void select() {
		System.out.print("검색할 선수이름 : ");
		String name = sc.next();
		
		System.out.println(hmap.get(name));
	}
	
	
	//update
	public void update() {
		System.out.print("수정할 선수이름 : ");
		String name = sc.next();
		
		Human h = hmap.get(name);
		
		if(h == null) {
			System.out.println("해당 선수의 데이터를 찾을 수 없습니다.");
			return;
		}else {
			if(h instanceof Pitcher) {
				System.out.print("승 = ");
				int win = sc.nextInt();
				System.out.print("패 = ");
				int lose = sc.nextInt();
				System.out.print("방어율 = ");
				double defence = sc.nextDouble();
				
				((Pitcher) h).setWin(win);
				((Pitcher) h).setLose(lose);
				((Pitcher) h).setDefence(defence);
			}else if(h instanceof Batter) {
				System.out.print("타수 = ");
				int bat = sc.nextInt();
				System.out.print("안타수 = ");
				int hit = sc.nextInt();
				System.out.print("타율 = ");
				double batCount = sc.nextDouble();
				
				((Batter) h).setBat(bat);
				((Batter) h).setHit(hit);
				((Batter) h).setBatCount(batCount);
			}
		}
		
		System.out.println("성공적으로 해당선수의 데이터를 수정하였습니다.");
	}

	
	//allprint
	public void allPrint() {
		Iterator<String> iter = hmap.keySet().iterator();
		
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(hmap.get(key)+" ");
		}
	}
	
	
	//datasave
	public void save() {
	
		fp.saveData(hmap);
	}
	
	
	//dataload
	public void load() {
		List<String> strList = fp.loadDate();
		
		for (int i = 0; i < strList.size(); i++) {
			String data[] = strList.get(i).trim().split("-");
			int number = Integer.parseInt(data[1]);
			
			if(number < 2000) {	// 투수
				hmap.put(data[2], new Pitcher(Integer.parseInt(data[1]), 
																data[2], 
											  Integer.parseInt(data[3]), 
											  Double.parseDouble(data[4]), 
											  Integer.parseInt(data[5]), 
											  Integer.parseInt(data[6]), 
											  Double.parseDouble(data[7])));
				p_num++;
			}
			else {				// 타자
				hmap.put(data[2], new Batter(Integer.parseInt(data[1]), 
																data[2], 
											  Integer.parseInt(data[3]), 
											  Double.parseDouble(data[4]), 
											  Integer.parseInt(data[5]), 
											  Integer.parseInt(data[6]), 
											  Double.parseDouble(data[7])));
				b_num++;
			}
		}
	}

}
