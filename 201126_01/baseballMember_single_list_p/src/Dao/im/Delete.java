package Dao.im;

import java.util.List;
import java.util.Scanner;

import Dao.MemberDao;
import Single.SingleClass;
import Util.Util;
import dto.Human;

public class Delete implements MemberDao{
	Scanner sc = new Scanner(System.in);
	List<Human> list;
	Util ut;
	
	public Delete() {
		SingleClass si = SingleClass.getInstance();
		list = si.getList();
		ut = new Util();
	}
	
	@Override
	public void proc() {
		System.out.print("삭제할 선수 : ");
		String name = sc.next();
		
		int index = ut.search(name, list);
		
		if(index == -1) {
			System.out.println("선수 명단에 없습니다");
			return;
		}
		
		list.remove(index);
		System.out.println("선수 명단에서 삭제하였습니다");
	}

}
