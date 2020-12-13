package singleton;

import java.util.ArrayList;
import java.util.List;

import dto.Human;

public class SingletonCls {
	
	private static SingletonCls si = null;	
	private List<Human> list = null;
	
	
	private SingletonCls() {
		list = new ArrayList<Human>();
	}
	
	public static SingletonCls getInstance() {
		if(si == null) {
			si = new SingletonCls();
		}
		return si;
	}
	

	public List<Human> getList() {
		return list;
	}	

}
