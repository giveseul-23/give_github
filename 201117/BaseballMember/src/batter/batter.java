package batter;

import member.member;

public class batter extends member{
	
	private int bat;	//타수
	private int hit;	//안타수
	private double batAvg;	//타율
	
	public batter() {
		
	}
	
	public batter(int number, String name, int age, double height, int bat, int hit, double batAvg) {
		super(number, name, age, height);
		this.bat = bat;
		this.hit = hit;
		this.batAvg = batAvg;
	}
	
	public int getBat() {
		return bat;
	}
	@Override
	public String toString() {
		return "batter / "  + " 번호 : " + getNumber()
				+ " / 이름  : " + getName() + " / 나이 : " + getAge() + " / 키 : " + getHeight() + 
				" / 타수  : " +bat + " / 안타수 : " + hit + " / 타율  : " + batAvg;
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
	public double getBatAvg() {
		return batAvg;
	}
	public void setBatAvg(double batAvg) {
		this.batAvg = batAvg;
	}
	
	
	
}
