package Singleton;

import Dao.MemberDao;

public class SingletonClass {
	
	private static SingletonClass si = null;
	public MemberDao dao = new MemberDao();
	
	
	private SingletonClass() {
	}
	
	public static SingletonClass getInstance() {
		if(si == null) {
			si = new SingletonClass();
		}
		return si;
	}

}
