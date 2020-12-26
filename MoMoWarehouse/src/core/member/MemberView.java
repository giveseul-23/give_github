package core.member;

public interface MemberView {
	
	String index();
	Member joinUI();
	String[] loginUI(); //배열에 id , password 받아서 출력
	
	String userUI(Member member); //메뉴 출력하고  선택값 리턴
	
	//userUI - 1. 회원정보 수정
	String userUpdateUI(); //회원정보 수정 메뉴 전체 화면
	String userRudUI();// 회원정보 수정 메뉴 선택하고 select한 내용 리턴하고 udateObject에 매개변수로 넘겨줌
	String updateObjectUI(String select); // 회원정보 수정사항 선택 후 수정내용 return
	String userOutUI(String id);// 비밀번호 입력 후 비밀번호 맞을 시, 회원 탈퇴됨

	int chargeMoneyUI();//금액 충전 및 충전할 금액 리턴 
	
	String adminUI(); //admin메뉴 출력하고 선택값 리턴
	
}
