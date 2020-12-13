package cls;

import inter.WriteMode;

public class Pencil implements WriteMode{

	@Override
	public void write() {
		System.out.println("연필로 씁니다.");
		delete();
	}
	
	public void delete() {
		System.out.println("지우개로 지웁니다.");
	}

}
