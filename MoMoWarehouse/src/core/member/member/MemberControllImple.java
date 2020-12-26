package core.member;

import core.check.Command;
import core.momoinfo.MomoInfoControllerImple;

public class MemberControllImple implements MemberController{
	
	private final MemberViewImple memView;
	private Member member;
	private MemberDao memdao;
	private MomoInfoControllerImple momoInfoControl;
	
	public MemberControllImple(MemberViewImple memView, MemberDao memdao, 
			MomoInfoControllerImple momoInfoControl) {
		this.memView = memView;
		this.memdao = memdao;
		this.momoInfoControl = momoInfoControl;
	}
	
	@Override
	public void indexMenu() {
		boolean b = true;
		while(true) {
			
			String select = memView.index();
			
			//1.회원가입 2.로그인 3.종료
			if("회원가입".equals(select)) {
				member = memView.joinUI();
				join(member); //입력받아 JOIN에서 MEMBER 객체 DB에 저장
			}else if("로그인".equals(select)) {
				String[] userInfo = memView.loginUI(); //로그인해서 ID,PW 배열에 받음
				member = memdao.selecte(userInfo); //다오 셀렉 유저I,P 넣어 찾아서 멤버객체로 받음
				if(member == null) {
					//해당내용없으면 다시 메인메뉴로 넘어감
					continue;
				}else {
					//String grade = member.getGrade();
					login(member); //해당 유저 멤버객체 매개변수
				}
				
			}else if("종료".equals(select)) {
				break;
			}
		}
			
	}


	@Override
	public void join(Member member) {
		int result = memdao.insert(member);
		System.out.println("처리건수 : "+ result);
	}

	@Override
	public void login(Member member) {
		boolean b = true;
		String grade = member.getGrade();
		System.out.println("로그인 완료! " + member.toString());
		while(true) {
			if(grade.equals("USER")) {
				String select = memView.userUI(member);
				b = userMenu(select, member); //로그아웃셀렉한 경우 b는 false를 입력받음
				if(b == false) {
					break;
				}
			}else if(grade.equals("ADMIN")) {
				memView.adminUI();
			}
		}
		
	}
	
	/*회원메뉴*/
	@Override
	public boolean userMenu(String select, Member member) {
		//"회원정보 수정", "입출고", "입출고내역", "충전", "로그아웃"
		String id = member.getMemberId();
		boolean b = true;
		
		if(select.equals("회원정보수정")) {
			b = userUpdating(member, id);
		}else if(select.equals("입출고")) {
			momoInfoControl.inOutMenu(member);
		}else if(select.equals("입출고내역")) {
			momoInfoControl.inOutHistory(member);
		}else if(select.equals("충전")) {
			chargeMoney(member);
		}else if(select.equals("로그아웃")) {
			b = false;
		}
		
		return b;
		
	}
	
	
	/*회원정보 수정*/
	@Override
	public boolean userUpdating(Member member, String id) {
		boolean b = true;
		int result = 0;
		
		String userMenuSelect = memView.userUpdateUI();
		
		if(userMenuSelect.equals("정보수정")) {
			//정보수정 메뉴 뜨고 입력값 받음
			String userRudSelect = memView.userRudUI();
			//정보수정 후 처리건수 int값으로 받음
			result = userUpdatingInput(userRudSelect, id);
			
			if(result > 0) {
				System.out.println("처리건수 : " + result);
			}else {
				
				
				System.out.println("다시 입력해 주세요.");
			}
			
		}else if(userMenuSelect.equals("탈퇴")) {
			String pw = memView.userOutUI(id);
			if(pw.equals(member.getPw())) {
				memdao.delete(id);
				b = false;
				System.out.println("탈퇴완료. 안녕히가십시오...");
			}else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		}
		
		return b;
		
	}

	//정보수정 -> 값 입력 -> dao에서 수정처리
	@Override
	public int userUpdatingInput(String userRudSelect, String id) {
		//입력값의 수정내용을 받음
		String userInfoUp = memView.updateObjectUI(userRudSelect);
		int result = 0;
		
		if(userRudSelect.equals("비밀번호")) {
			member.setPw(userInfoUp);
			result = memdao.update(member, "PW", id);
		}else if(userRudSelect.equals("이름")) {
			member.setName(userInfoUp);
			result = memdao.update(member, "NAME", id);
		}else if(userRudSelect.equals("전화번호")) {
			member.setPhone(userInfoUp);
			result = memdao.update(member, "PHONE", id);
		}else if(userRudSelect.equals("이메일")) {
			member.setEmail(userInfoUp);
			result = memdao.update(member, "EMAIL", id);
		}
		
		return result;
	}
	

	@Override
	public void chargeMoney(Member member) {
		int originCash = member.getCash(); //기존 금액
		int updatingCash = memView.chargeMoneyUI(); //충전금액
		
		if(updatingCash > 0) {
			member.setCash(originCash + updatingCash);
			memdao.updatingCash(member);
			System.out.println(updatingCash+"원을 충전 완료하였습니다. 총 금액 : " + member.getCash());
		}else {
			System.out.println("올바르지 않은 금액입니다. 다시 입력하세요.");
		}
		
	}
	
	
	/*관리자메뉴*/
	@Override
	public void adminMenu() {
		// TODO Auto-generated method stub
		
	}
	
}
