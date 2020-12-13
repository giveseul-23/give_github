package Dao.im;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dao.MemberDao;
import Single.SingleClass;
import Util.Util;
import dto.Human;

public class Select implements MemberDao{
	Scanner sc = new Scanner(System.in);
	List<Human> list;
	Util ut;
	
	public Select() {
		SingleClass si = SingleClass.getInstance();
		list = si.getList();
		ut = new Util();
	}
	
	@Override
	public void proc() {
		System.out.print("검색할 선수 이름 : ");
		String name = sc.next();
		
		List<Integer> flist = ut.searchAll(name, list);
		
		for (int i = 0; i < flist.size(); i++) {
			System.out.println(list.get(flist.get(i)));
		}
		
	}

}
