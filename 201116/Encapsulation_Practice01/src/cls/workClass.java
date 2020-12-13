package cls;

public class workClass {

	public String name;
	public int ban;
	public int no;
	public int kor;
	public int eng;
	public int math;
	
	
	
	public int getTotal(int kor, int eng, int math) {
		int result = kor + eng + math;
		
		return result;
	}
	
	public double getAverage() {
		int result = getTotal(kor, eng, math);
		double avg = (double)result/3;
		
		return avg;
	}
	
	
	
}
