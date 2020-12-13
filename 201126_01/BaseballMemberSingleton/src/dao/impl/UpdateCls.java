package dao.impl;

import java.util.Scanner;

import dao.MemberDao;
import dto.Batter;
import dto.Human;
import dto.Pitcher;
import singleton.SingletonCls;
import util.UtilCls;

public class UpdateCls implements MemberDao {
	Scanner sc = new Scanner(System.in);
		
	@Override
	public void proc() {
		SingletonCls si = SingletonCls.getInstance();
		
		System.out.print("수정하고 싶은 선수의 이름 = ");
		String name = sc.next();
		
		int index = UtilCls.search(name, si.getList());
		
		if(index == -1) {
			System.out.println("선수 명단에 없습니다");
			return;
		}
		
		Human h = si.getList().get(index);
		if(h instanceof Pitcher) {
			System.out.print("승 = ");
			int win = sc.nextInt();
			
			System.out.print("패 = ");
			int lose = sc.nextInt();
			
			System.out.print("방어율 = ");
			double defence = sc.nextDouble();
			
			((Pitcher)h).setWin(win);
			((Pitcher)h).setLose(lose);
			((Pitcher)h).setDefence(defence);
		}
		else if(h instanceof Batter) {
			System.out.print("타수 = ");
			int batcount = sc.nextInt();
			
			System.out.print("안타 수 = ");
			int hit = sc.nextInt();
			
			System.out.print("타율 = ");
			double hitAvg = sc.nextDouble();
			
			Batter bat = (Batter)h;
			bat.setBatcount(batcount);
			bat.setHit(hit);
			bat.setHitAvg(hitAvg);			
		}
		System.out.println("수정되었습니다");
	}

}
