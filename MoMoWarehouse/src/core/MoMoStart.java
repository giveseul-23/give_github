package core;

import core.member.MemberControllImple;
import core.member.MemberDao;
import core.member.MemberViewImple;
import core.spot.SpotControllerImpl;

public class MoMoStart {
	public static void main(String[] args) {
		SpotControllerImpl spotcontrol = new SpotControllerImpl();
		MemberViewImple memView = new MemberViewImple(spotcontrol);
		MemberDao memdao = new MemberDao();
		MemberControllImple memControl = new MemberControllImple(memView, memdao);
		
		memControl.indexMenu();
	}
}


