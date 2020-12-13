package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import FileProc.FileProc;
import dto.Batter;
import dto.Human;
import dto.Pitcher;

public class MemberDao {
	Scanner sc = new Scanner(System.in);
	
	List<Human> list = new ArrayList<Human>();
	int p_num = 1;
	int b_num = 1;
	FileProc fp;
	
	public MemberDao() {
		/*
		list.add(new Pitcher(1, "홍길동", 20, 190, 1, 2, 3));
		list.add(new Batter(1001, "성춘향", 20, 190, 1, 2, 3));
		list.add(new Pitcher(2, "일지매", 20, 190, 1, 2, 3));
		list.add(new Batter(1002, "홍길동", 20, 190, 1, 2, 3));
		*/
		fp = new FileProc("baseballMember_list_a");
		fp.creatfile();
		
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
			int number = p_num++;
			
			System.out.print("승리 = ");
			int win = sc.nextInt();
			
			System.out.print("패전 = ");
			int lose =sc.nextInt();
			
			System.out.print("방어율 = ");
			double defence = sc.nextDouble();
			
			list.add(new Pitcher(number, name,age, height, win, lose, defence));
			
		}
		
		if(pos == 2){	//타자 - 2000번대 시작
			
			int number = 1000 + b_num++;
			
			System.out.print("타수 = ");
			int batCount = sc.nextInt();
			
			System.out.print("안타수 = ");
			int hit = sc.nextInt();
			
			System.out.print("타율 = ");
			double hitAvg = sc.nextDouble();
			
			list.add(new Batter(number, name, age, height, batCount, hit, hitAvg));
		}
	}
	
	//delete
	public void delete() {

		
		System.out.print("삭제할 선수이름 : ");
		String name = sc.next();
		
		int index = search(name);
		
		if(index == -1) {
			System.out.println("해당 선수의 데이터를 찾을 수 없습니다.");
			return;
		}else {
			System.out.println("성공적으로 데이터를 삭제하였습니다.");
			list.remove(index);
		}
		
	}
	
	//select
	public void select() {
		System.out.print("검색할 선수이름 : ");
		String name = sc.next();
		
		allSearch(name);
	}
	
	//update
	public void update() {
		System.out.print("수정할 선수이름 : ");
		String name = sc.next();
		
		int index = search(name);
		Human h = list.get(index);
		
		if(index == -1) {
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
	
	//search
	public int search(String name) {
		int index = -1;
		
		for (int i = 0; i < list.size(); i++) {
			if((list.get(i)).getName().equals(name)) {
				index = i;
			}
		}
		
		return index;
	}
	
	//allSearch
	public void allSearch(String name) {
		List<Human> flist = new ArrayList<Human>();
		
		for (int i = 0; i < list.size(); i++) {
			Human h = list.get(i); //h에 list를 하나씩 for문 돌리면서 넣어줌
			if(name.equals(h.getName())) {	//현재 h에 들어간 이름이 매개변수 name과 같다면
				flist.add(h); //flist 리스트 배열에 h를 추가해라
			}
		}
		
		if(flist.isEmpty() == false) {	//flist 리스트 배열이 비어있지 않다면
			System.out.println("검색된 데이터 >>");
			for (int i = 0; i < flist.size(); i++) {	//해당 네임만 들어간 flist만큼 루프를 돌려주고
				System.out.println(flist.get(i).toString()); //flist를 나열
			}
		}else {
			System.out.println("선수 데이터를 찾을 수 없습니다.");
		}
	}
	
	//allprint
	public void allPrint() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	//datasave
	public void save() {
		String datas[] = new String[list.size()];
		for (int i = 0; i < datas.length; i++) {
			datas[i] = (list.get(i)).toString();
		}

		fp.saveData(datas);
	}
	
	//dataload
	public void load() {
		String datas[] = fp.loadDate();
		
		for (int i = 0; i < datas.length; i++) {
			String data[] = datas[i].split("-");
			int number = Integer.parseInt(data[0]);
			
			if(number < 2000) {	// 투수
				Human loadnum = new Pitcher(	Integer.parseInt(data[0])-1000, // 번호
										data[1], 					// 이름
										Integer.parseInt(data[2]), 	// 나이
										Double.parseDouble(data[3]), // 신장 
										Integer.parseInt(data[4]), // 승
										Integer.parseInt(data[5]), // 패	
										Double.parseDouble(data[6])); // 방어율
				list.add(loadnum);
			}
			else {				// 타자
				Human loadnum = new Batter(	Integer.parseInt(data[0])-1000, // 번호
										data[1], 					// 이름
										Integer.parseInt(data[2]), 	// 나이
										Double.parseDouble(data[3]), // 신장 
										Integer.parseInt(data[4]), // 타수
										Integer.parseInt(data[5]), // 안타 수	
										Double.parseDouble(data[6])); // 타율
				list.add(loadnum);
			}
		}
	}
}
