package Generic;

public class mainClass {

	public static void main(String[] args) {
		  
		/*
		
			Generic == template(형태)
						: 자료형 변수 -> <안에 무슨 글자든, 타입의 매개변수 이름>설정해 놓고 나중에 결정함
						: 같은 클래스에서 다양한 자료형을 사용하고 싶은 경우에 사용함
						: 사용목적 - 어떤 object를 사용할지 모르기때문에 사용함
						<타입 매개변수>라고 생각하면 됨

		*/
		
		Box<Integer> box = new Box<Integer>(111);
		//일반 자료형 - int.. 은 안됨
		//<안에는 자료형은 wrapper class>만 넣을수 있음
		System.out.println(box.getTemp() + 1); //112
		
		Box<String> str = new Box<String>("my World!");
		System.out.println(str.getTemp());
		
		
		BoxMap<Integer, String> bmap = new BoxMap<Integer, String>(1001, "hello");
		System.out.println(bmap.getKey());
		System.out.println(bmap.getValue());
		
		BoxMap<String, Object>boxM = new BoxMap<String, Object>(new String("world"), new Integer(235));
		System.out.println(boxM.getKey());
		System.out.println(boxM.getValue());
	}

}


class Box<T>{
	
	T temp;

	public Box(T temp) {
		this.temp = temp;
	}

	public T getTemp() {
		return temp;
	}

	public void setTemp(T temp) {
		this.temp = temp;
	}
	
	
}

class BoxMap<Key, Value>{
	
	Key key;
	Value value;
	
	public BoxMap(Key key, Value value) {
		this.key = key;
		this.value = value;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}
	
	public void method() {
		int result;
		
	//	result = key + value; -> 오류, 연산은 x
		
	}
	
	
}
