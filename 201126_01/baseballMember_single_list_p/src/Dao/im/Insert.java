package Dao.im;


import java.util.Scanner;

import Dao.MemberDao;
import Single.SingleClass;
import dto.Batter;
import dto.Pitcher;

public class Insert implements MemberDao{
	
	Scanner sc =  new Scanner(System.in);
	private int memberNumber = 0;
	
	public Insert() {
		SingleClass si = SingleClass.getInstance();
		
		if(si.getList().size() > 0) {
			memberNumber = si.getList().get(si.getList().size() - 1).getNumber();
			
			if(memberNumber >= 2000) {
				memberNumber = memberNumber - 1000;
			}
		}else {
			memberNumber = 1000;
		}
		
		memberNumber = memberNumber + 1;
	}
	
	@Override
	public void proc() {
		SingleClass si = SingleClass.getInstance();
		
		System.out.print("투수(1)/타자(2) = ");
		int position = sc.nextInt();
		
		// human
		System.out.print("이름 = ");
		String name = sc.next();
		
		System.out.print("나이 = ");
		int age = sc.nextInt();
		
		System.out.print("신장 = ");
		double height = sc.nextDouble();
		
		if(position == 1) {
			System.out.print("승 = ");
			int win = sc.nextInt();
			
			System.out.print("패 = ");
			int lose = sc.nextInt();
			
			System.out.print("방어율 = ");
			double defence = sc.nextDouble();
			
			si.getList().add(new Pitcher(memberNumber, name, age, height, win, lose, defence));			
			
		}else if(position == 2){
			Batter b = new Batter();
			
			b.setNumber(memberNumber + 1000);
			b.setName(name);
			b.setAge(age);
			b.setHeight(height);
			
			System.out.print("타수 = ");
			int bat = sc.nextInt();
			b.setBat(bat);
			
			System.out.print("안타 수 = ");
			b.setHit( sc.nextInt() );
			
			System.out.print("타율 = ");
			double batCount = sc.nextDouble();
			b.setBatCount(batCount);

			si.getList().add(b);			
		}
		
		memberNumber++;		
		}
}
