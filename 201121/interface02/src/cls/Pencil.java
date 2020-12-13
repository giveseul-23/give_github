package cls;

import inter.WriteMode;

public class Pencil implements WriteMode {

	@Override
	public void write() {
		System.out.println("Pencil 연필로 기입합니다.");
		delete();
	}
	
	public void delete() {
		System.out.println("지우개를 사용합니다.");
	}

}
