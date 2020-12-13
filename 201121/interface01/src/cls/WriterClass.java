package cls;

import inter.WriteMode;

public class WriterClass {
	public WriterClass() {
		
	}
	
	public void write_mode(WriteMode wm) {
		wm.write();
		//wm에는 implement된 데이터 클래스가 들어옴
	}
}
