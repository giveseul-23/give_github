package dice;

public class Dice {

	private int number;
	
	public void diceRand() {
		number = (int)(Math.random()*6)+1;
	}

	public int getNumber() {
		return number;
	}
	
	
}
