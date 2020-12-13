package dao.impl;

import dao.MemberDao;
import dto.Human;
import singleton.SingletonCls;

public class AllprintCls implements MemberDao {

	@Override
	public void proc() {
		SingletonCls si = SingletonCls.getInstance();
		
		for (int i = 0; i < si.getList().size(); i++) {
			Human h = si.getList().get(i);
			if(h.getNumber() < 2000) {
				System.out.println("투수:" + h.toString());
			}else {
				System.out.println("타자:" + h.toString());
			}
		}

	}

}



