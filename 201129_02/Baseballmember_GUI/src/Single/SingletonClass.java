package Single;

import Dao.MemberDao;

public class SingletonClass {
	private static SingletonClass cls = null;
	public MemberDao dao;
	
	private SingletonClass() {
		dao = new MemberDao();
	}
	
	public static SingletonClass getInstance() {
		if(cls == null) {
			cls = new SingletonClass();
		}
		
		return cls;
	}
	
}
