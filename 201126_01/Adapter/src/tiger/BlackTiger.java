package tiger;

public class BlackTiger implements Tiger{
	
	@Override
    public void fight() {
		System.out.println("호랑이가 싸운다");
    }

    @Override
    public void run() {
    	System.out.println("호랑이가 달린다");
    }
}
