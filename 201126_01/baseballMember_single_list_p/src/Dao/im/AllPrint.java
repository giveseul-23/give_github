package Dao.im;

import java.util.List;

import Dao.MemberDao;
import Single.SingleClass;
import dto.Human;

public class AllPrint implements MemberDao{
	
	List<Human> list;
	
	public AllPrint() {
		SingleClass si = SingleClass.getInstance();
		list = si.getList();
	}
	
	@Override
	public void proc() {
		System.out.println(list.toString());
	}

}
