package core.check;

import java.util.Scanner;

public class Command {
	static Scanner sc = new Scanner(System.in);
	
	public static String inputUserChoice(String[] commands) {
		String select = null;
		
		while(true) {
			for (int i = 0; i < commands.length; i++) {
				System.out.print((i+1) + ". " + commands[i]+" ");
			}
			
			System.out.println();
			select = sc.next().trim();
			boolean b = false;
			
			for (int i = 0; i < commands.length; i++) {
				if(select.equals(commands[i])) { 
					b = true;
					break;
				}
			}
			
			if(b == true) {
				break;
			}else {
				System.out.println("잘못 입력하였습니다. 다시 입력 해 주세요.");
			}
		}
		
		return select;
	}
	
	

}


