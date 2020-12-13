package factory;

import bomb.Bomb;
import types.AbstractItem;
import weapon.Weapon;

public class CharFactory {

	public Weapon m_weapon;
	public Bomb m_bomb;
	
	public void create(AbstractItem ai) {
		m_weapon = ai.createWeapon();
		m_bomb = ai.createBomb();		
	}
	
}







