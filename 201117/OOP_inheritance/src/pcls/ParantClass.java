package pcls;

public class ParantClass {
	
	private int private_num;	//자식클래스에서도 접근x, get & set으로만 접근가능
	public int public_num;
	protected int protected_num;	//자식클래스에서만 접근허용, 외부접근 차단
	
	public int getPrivate_num() {
		return private_num;
	}

	public void setPrivate_num(int private_num) {
		this.private_num = private_num;
	}

	public ParantClass() {
		System.out.println("PareantClass ParantClass()");
	}

	public void parantMethod() {
		System.out.println("PareantClass parantMethod()");
	}
	
	protected void parant_ProtectedMethod() {
		System.out.println("PareantClass parant_ProtectedMethod()");
	}
}
