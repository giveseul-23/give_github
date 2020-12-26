package core;

import core.member.MemberController;

public class ApplicationConfig {
	private final MemberController memberController = null;
	
	public void start() {
		memberController.indexMenu();
	}
}
