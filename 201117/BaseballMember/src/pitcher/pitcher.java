package pitcher;

import member.member;

public class pitcher extends member{

	private int win;
	private int lose;
	private double defence;
	
	public pitcher() {
		
	}
	
	public pitcher(int win, int lose, double defence, int number, String name, int age, double height) {
		super(number, name, age, height);
		this.win = win;
		this.lose = lose;
		this.defence = defence;
	}
	
	@Override
	public String toString() {
		return "pitcher " + "/ 번호 : " + getNumber()
				+ " / 이름 : " + getName() + " / 나이  : " + getAge() + "/ 키  : " + getHeight() 
				+ "/ 승전  : " + win + "/ 패전  : " + lose + "/ 방어  : " + defence;
	}

	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public double getDefence() {
		return defence;
	}
	public void setDefence(double defence) {
		this.defence = defence;
	}
	

}
