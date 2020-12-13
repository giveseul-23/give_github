package dto;

public class Batter extends Human{
	private int bat;
	private int hit;
	private double batCount;
	
	public Batter(int number, String name, int age, double height, int bat, int hit, double batCount) {
		super(number, name, age, height);
		this.bat = bat;
		this.hit = hit;
		this.batCount = batCount;
	}

	public int getBat() {
		return bat;
	}

	public void setBat(int bat) {
		this.bat = bat;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public double getBatCount() {
		return batCount;
	}

	public void setBatCount(double batCount) {
		this.batCount = batCount;
	}

	@Override
	public String toString() {
		return  super.toString() + bat + "-" + hit + "-" + batCount;
	}
	
	
}
