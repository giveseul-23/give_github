package adapter;

import lion.Lion;
import tiger.Tiger;

public class TigerAdapter implements Lion{

	Tiger tiger;
	
    public TigerAdapter(Tiger tiger) {
    	this.tiger = tiger;
    }

    @Override
	public void fight() {		
		tiger.fight();
	}
    
	@Override
	public void run() {		
		tiger.run();
	}

}
