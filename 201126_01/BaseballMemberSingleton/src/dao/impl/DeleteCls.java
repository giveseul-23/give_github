package dao.impl;

import java.util.Scanner;

import dao.MemberDao;
import singleton.SingletonCls;
import util.UtilCls;

public class DeleteCls implements MemberDao {
	Scanner sc = new Scanner(System.in);
	
	public DeleteCls() {		
	}
	
	@Override
	public void proc() {
		SingletonCls si = SingletonCls.getInstance();
		
		System.out.print("삭제하고 싶은 선수의 이름 = ");
		String name = sc.next();
		
		int index = UtilCls.search(name, si.getList());
		
		if(index == -1) {
			System.out.println("선수 명단에 없습니다");
			return;
		}
		
		si.getList().remove(index);
		System.out.println("선수 명단에서 삭제하였습니다");
	}

}
