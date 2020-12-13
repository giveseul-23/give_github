package dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dao.MemberDao;
import dto.Batter;
import dto.Human;
import singleton.SingletonCls;

public class SortingCls implements MemberDao{

	@Override
	public void proc() {
		SingletonCls si = SingletonCls.getInstance();
		List<Human> b_list = new ArrayList<Human>();
		
		for (int i = 0; i < si.getList().size(); i++) {
			if(si.getList().get(i) instanceof Batter) {
				
				b_list.add(si.getList().get(i));
			}	
		}
		
		Batter temp;
		
		for (int n = 0; n < b_list.size() -1; n++) {
			for (int j = n+1; j < b_list.size(); j++) {
				 Batter b1 = ((Batter)(b_list).get(n));
				 Batter b2 = ((Batter)(b_list).get(j));
				if(b1.getHitAvg() < b2.getHitAvg()) {
					temp = b1;
					b1 = b2;
					b2 = temp;
				}
			}
		}
		
		System.out.println(b_list.toString());
		
	}

		
		
	}


