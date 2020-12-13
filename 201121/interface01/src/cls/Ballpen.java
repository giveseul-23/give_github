package cls;

import inter.WriteMode;

public class Ballpen implements WriteMode{

	@Override
	public void write() {
		System.out.println("볼펜으로 씁니다.");
		erase();
	}
	
	public void erase() {
		System.out.println("마카로 지웁니다.");
	}
}
