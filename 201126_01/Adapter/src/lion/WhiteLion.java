package lion;

public class WhiteLion implements Lion {

	@Override
    public void fight() {
		System.out.println("사자가 싸운다");
    }

	@Override
    public void run() {
    	System.out.println("사자가 달린다");
    }
}
