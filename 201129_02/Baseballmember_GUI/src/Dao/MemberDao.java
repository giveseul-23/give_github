package Dao;

import java.util.ArrayList;
import java.util.List;

import dto.Batter;
import dto.Human;
import dto.Pitcher;

public class MemberDao {
	
	public List<Human> list;
	private int p_num = 1;
	private int b_num = 1;
	
	public MemberDao() {
		list = new ArrayList<Human>();
	}
	
	public boolean insert(Human h) {
		if(h instanceof Pitcher) {
			h.setNumber(1000+p_num);
			p_num++;
		}else if(h instanceof Batter) {
			h.setNumber(2000+b_num);
			b_num++;
		}
		
		boolean b = list.add(h);
		
		for (Human hu : list) {
			System.out.println(hu.toString());
		}
		
		return b;
	}
}
