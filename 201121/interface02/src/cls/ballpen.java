package cls;

import inter.WriteMode;

public class ballpen implements WriteMode {

	@Override
	public void write() {
		System.out.println("ballpen 볼펜으로 기입합니다.");
		erase();
	}
	
	public void erase() {
		System.out.println("화이트를 사용합니다.");
	}
	
}
