package Dao.im;

import java.util.ArrayList;
import java.util.List;

import Dao.MemberDao;
import Single.SingleClass;
import dto.Batter;
import dto.Human;

public class Sorting implements MemberDao{
	List<Human> list;
	
	public Sorting() {
		SingleClass si = SingleClass.getInstance();
		list = si.getList();
	}
	
	@Override
	public void proc() {
		List<Human> b_list = new ArrayList<Human>();

		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) instanceof Batter) {
				b_list.add(list.get(i));
			}
		} 

		
		Batter temp;
		
		for (int i = 0; i < b_list.size() - 1; i++) {
			for (int j = i+1; j < b_list.size(); j++) {
				Batter b1 = ((Batter)(b_list).get(i));
				Batter b2 = ((Batter)(b_list).get(j));
				if(b1.getBatCount() < b2.getBatCount()) {
					temp = b1;
					b1 = b2;
					b2 = temp; 
				}
			}
		}
		
		System.out.println(b_list.toString());
		
	}
	
}
