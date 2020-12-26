package core.member;

import core.check.Command;

public class MemberControllImple implements MemberController{
	
	private final MemberViewImple memView;
	private Member member;
	private MemberDao memdao;
	
	public MemberControllImple(MemberViewImple memView, MemberDao memdao) {
		this.memView = memView;
		this.memdao = memdao;
	}
	
	@Override
	public void indexMenu() {
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
		String grade = member.getGrade();
		System.out.println("로그인 완료! " + member.toString());
		while(true) {
			if(grade.equals("USER")) {
				String select = memView.userUI(member);
				userMenu(select, member);
			}else if(grade.equals("ADMIN")) {
				memView.adminUI();
			}
		}
	}
	
	
	//TODO
	@Override
	public void userMenu(String select, Member member) {
		boolean b = true;
		int result = 0;
		String id = member.getMemberId();
		
		//"회원정보 수정", "입출고", "입출고내역", "충전", "로그아웃"
		while(true) {
			if(select.equals("회원정보수정")) {
				String userMenuSelect = memView.userUpdate();
				
				if(userMenuSelect.equals("정보수정")) {
					//정보수정 메뉴 뜨고 입력값 받음
					String userRudSelect = memView.userRud();
					//입력값의 수정내용을 받음
					String userInfoUp = memView.updateObject(userRudSelect);
					
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
					
					System.out.println("처리건수 : " + result);
					break;
					
				}else if(userMenuSelect.equals("탈퇴")) {
					String pw = memView.userOut(id);
					if(pw.equals(member.getPw())) {
						memdao.delete(id);
						System.out.println("탈퇴완료. 안녕히가십시오...");
						break;
					}else {
						System.out.println("비밀번호가 일치하지 않습니다.");
						continue;
					}
				}
			}	
		}
			
		
	}

	@Override
	public void adminMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chargeMoney() {
		// TODO Auto-generated method stub
		
	}
	
}
