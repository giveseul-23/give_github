package student;

public class Student {
	
	private int number;
	private String name;
	private int lang;
	private int math;
	private int eng;
	
	public Student() {
		
	}

	public Student(int number, String name, int lang, int math, int eng) {
		super();	//일단 지금은 신경x
		this.number = number;
		this.name = name;
		this.lang = lang;
		this.math = math;
		this.eng = eng;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLang() {
		return lang;
	}

	public void setLang(int lang) {
		this.lang = lang;
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

	
	//어떤 값이 들어가있는지 확인
	@Override
	public String toString() {
		return "Student [number=" + number + ", name=" + name + ", lang=" + lang + ", math=" + math + ", eng=" + eng
				+ "]";
	}
	
	
	
	
}
