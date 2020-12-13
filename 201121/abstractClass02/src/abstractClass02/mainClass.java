package abstractClass02;

import write.Ballpen;
import write.Writer;
import write.pencil;

public class mainClass {

	public static void main(String[] args) {
		/*
		
			ballpen, pencil
		
		*/
		Writer w = new pencil();
		MyClass cls = new MyClass(w);
		cls.method();
		
		Writer w2 = new Ballpen();
		MyClass cls2 = new MyClass(w2);
		cls2.method();
		
	}

}
