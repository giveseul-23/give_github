package Single;

import java.util.ArrayList;
import java.util.List;

import dto.Human;

public class SingleClass {
	
	private static SingleClass si = null;
	private List<Human> list = null;
	
	private SingleClass() {
		list = new ArrayList<Human>();
	}
	
	public static SingleClass getInstance() {
		if(si == null) {
			si = new SingleClass();
		}
		return si;
	}

	public List<Human> getList() {
		return list;
	}
	
}
