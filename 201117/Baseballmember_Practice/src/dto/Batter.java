package dto;

public class Batter  extends Human{
	private int batCount;
	private int hit;
	private double hitCount;
	
	public Batter() {
		
	}

	public Batter(int number, String name, int age, int height, int batCount, int hit, double hitCount) {
		super(number, name, age, height);
		this.batCount = batCount;
		this.hit = hit;
		this.hitCount = hitCount;
	}

	public int getBatCount() {
		return batCount;
	}

	public void setBatCount(int batCount) {
		this.batCount = batCount;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public double getHitCount() {
		return hitCount;
	}

	public void setHitCount(double hitCount) {
		this.hitCount = hitCount;
	}
	
	public void clearBatter() {
		setNumber(0);
		setName("");
		setAge(0);
		setHeight(0);
		setBatCount(0);
		setHit(0);
		setHitCount(0);
	}
	

	@Override
	public String toString() {
		return super.toString() + batCount + "-" + hit + "-" + hitCount ;
	}
	
	
}
