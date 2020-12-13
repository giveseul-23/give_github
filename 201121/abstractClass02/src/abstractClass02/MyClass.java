package abstractClass02;

import write.Writer;

public class MyClass {
	Writer w;
	
	public MyClass(Writer w) {
		this.w = w;
	}
	
	public void method() {
		w.write();
		w.erase();
	}
	
}
