package types;

import bomb.Bomb;
import bomb.C4;
import weapon.Gun;
import weapon.Weapon;

public class Atype implements AbstractItem {

	@Override
	public Weapon createWeapon() {		
		return new Gun();
	}

	@Override
	public Bomb createBomb() {		
		return new C4();
	}

}
