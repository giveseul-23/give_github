package main;

import factory.CharFactory;
import types.Atype;
import types.Btype;

public class mainClass {
	public static void main(String[] args) {
		 
		CharFactory char1 = new CharFactory();
		char1.create(new Atype());
		
		char1.m_weapon.drawWeapon();
		char1.m_bomb.drawBomb();
		
		// list
		char1.create(new Btype());
		
		char1.m_weapon.drawWeapon();
		char1.m_bomb.drawBomb();
		
		
	}
}
