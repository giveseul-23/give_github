package Dao.im;

import java.util.List;
import java.util.Scanner;

import Dao.MemberDao;
import Single.SingleClass;
import Util.Util;
import dto.Batter;
import dto.Human;
import dto.Pitcher;


public class Update implements MemberDao{
	Scanner sc = new Scanner(System.in);
	Util us;
	List<Human> list;
	
	public Update() {
		
		us = new Util();
		SingleClass si = SingleClass.getInstance();
		list = si.getList();
	}
	
	@Override
	public void proc() {
		
		System.out.print("수정하실 선수의 이름 : ");
		String name = sc.next();
		
		int index = us.search(name, list);
		Human h = list.get(index);
		
		if(h instanceof Pitcher) {
			
			System.out.print("승 : ");
			((Pitcher)h).setWin(sc.nextInt());
			
			System.out.print("패 : ");
			((Pitcher)h).setLose(sc.nextInt());

			System.out.print("방어율 : ");
			((Pitcher)h).setDefence(sc.nextDouble());
			
		}else if(list.get(index) instanceof Batter) {
			
			System.out.print("타수 : ");
			((Batter)h).setBat(sc.nextInt());
			
			System.out.print("안타수 : ");
			((Batter)h).setHit(sc.nextInt());

			System.out.print("타율 : ");
			((Batter)h).setBatCount(sc.nextDouble());
		}
		
	}

}
