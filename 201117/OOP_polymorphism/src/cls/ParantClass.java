package cls;

public class ParantClass /*extends Object*/{
						//보이지는 않지만 가장 상위에 있는 class
	
	private int pnumber;
	
	public ParantClass() {
		System.out.println("ParantClass ParantClass()");
	}

	public ParantClass(int pnumber) {
		this();
		this.pnumber = pnumber;
		System.out.println("ParantClass ParantClass(int pnumber)");
	}
	
	
}
