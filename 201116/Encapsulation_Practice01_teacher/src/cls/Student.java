package cls;

public class Student {
	
	private String name;
	private int ban;
	private int no;
	private int kor;
	private int math;
	private int eng;
	
	private int total;
	
	public Student() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBan() {
		return ban;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}
	
	
	public int getTotal(int k, int m, int e) {
		total = k+m+e;
		return total;
	}
	
	public int getTotal() {
		total = this.kor + this.math + this.eng;
		return total;
 	}
	
	public double getAverage() {
		double d = (double) total/3;
		return d;
	}
	
}
