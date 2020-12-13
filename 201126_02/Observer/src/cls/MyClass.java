package cls;

import java.util.Observable;

public class MyClass extends Observable{
	
	private String id;
	private String password;
	
	private String preArg = null;
	
	public MyClass() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//마이클래스에 옵저버를 심어놓은 상태
	@Override
	public void notifyObservers(Object arg) {
		
		String str = (String)arg;
		
		//변화가 없었을 경우 -> 감시자에게 통지 x
		if(str.equals(preArg))	return;
		
		//변화가 있는 경우
		preArg = str;
		
		this.setChanged();//reset
		
		super.notifyObservers(arg);
		
		clearChanged();
	}
	
}
