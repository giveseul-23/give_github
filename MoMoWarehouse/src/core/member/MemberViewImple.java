package core.member;

import java.util.List;
import java.util.Scanner;

import core.check.Command;
import core.spot.Spot;
import core.spot.SpotControllerImpl;

public class MemberViewImple implements MemberView {
	
	Scanner sc = new Scanner(System.in);
	private Member member;
	private MemberDao memdao;
	private SpotControllerImpl spotcontrol;
	
	public MemberViewImple(SpotControllerImpl spotcontrol) {
		this.spotcontrol = spotcontrol;
	}
	
	@Override
	public String index() {
		
		System.out.println("------MAIN MENU------");
		String[] commands = { "회원가입", "로그인", "종료"};
		
		String select = Command.inputUserChoice(commands);
		
		return select;
	}

	@Override
	public Member joinUI() {
		String id;
		String pw;
		String name;
		String phone;
		String email;
		int spot_id;
		
		List<Spot> list;
		
		while(true) {
			System.out.println("------회원가입------");
			System.out.print("ID : ");
			id = sc.next().trim();
			
			System.out.print("PASSWORD : ");
			pw = sc.next().trim();
			
			if(pw.length() < 4) {
				System.out.println("비밀번호는 4자리 이상 입력하시오.");
				continue;
			}
			
			System.out.print("NAME : ");
			name = sc.next().trim();
			/*
			for (int i = 0; i < name.length(); i++) {
				int num = (int)name.charAt(i);
				if((num < 65 || num > 90) && (num < 97 || num >122) ) {
					System.out.println("오류! 다시 입력하세요.");
					continue;
				}
				continue;
			}
			*/
			System.out.print("PHONE : ");
			phone = sc.next().trim();
			
			System.out.print("EMAIL : ");
			email = sc.next().trim();
			
			list = spotcontrol.findAll();
			System.out.println("원하시는 보관소 id 번호를 입력하세요.");
			System.out.print(list.toString() + " :");
			spot_id = sc.nextInt();
			
			System.out.println("정상적으로 가입이 완료되었습니다.");
			break;
		}
		
		member =  new Member(id, pw, name, phone, email, spot_id);
		
		return member;
	}

	@Override
	public String[] loginUI() {
		String[] userInfo = new String[2];
		
		System.out.println("------로그인------");
		
		System.out.print("id : ");
		userInfo[0] = sc.next().trim();
		
		System.out.println("password : ");
		userInfo[1] = sc.next().trim();
		
		return userInfo;
	}

	@Override
	public String userUI(Member member) {
		
		String[] commands = {"회원정보수정", "입출고", "입출고내역", "충전", "로그아웃"};
		
		System.out.println("------USER MENU------");
		String select = Command.inputUserChoice(commands);
		
		return select;
	}
	
	@Override
	public String userUpdate() {
		System.out.println("------회원정보------");
		String[] commands = { "정보수정", "탈퇴"};
		
		String select = Command.inputUserChoice(commands);
		
		return select;
	}

	@Override
	public String userRud() {
		System.out.println("------정보수정------");
		String[] commands = { "비밀번호", "이름", "전화번호", "이메일"};
		
		String select = Command.inputUserChoice(commands);
		
		return select;
	}

	@Override
	public String updateObject(String select) {
		
		System.out.print("수정하실 " + select + "의 내용을 입력 해 주세요 :");
		String userInfoUp =  sc.next().trim();
		
		return userInfoUp;
		
	}
	
	@Override
	public String userOut(String id) {
		System.out.println("------탈퇴------");
		
		System.out.print("확인을 위해 비밀번호를 입력하세요 : ");
		
		String pw = sc.next().trim();
		
		return pw;
	}

	
	@Override
	public String adminUI() {
		System.out.println("관리자님 안녕하세요!");
		
		String[] commands = {"물건관리", "SPOT관리", "회원로그", "입출고내역", "로그아웃"};
		
		System.out.println("------ADMIN MENU------");
		String select = Command.inputUserChoice(commands);
		
		return select;
	}

	@Override
	public Member changeInfoUI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int chargeMoneyUI() {
		// TODO Auto-generated method stub
		return 0;
	}


}
