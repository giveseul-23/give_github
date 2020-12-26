package core.member;

public interface MemberView {
	
	String index();
	Member joinUI();
	String[] loginUI(); //배열에 id , password 받아서 출력
	
	String userUI(Member member); //회원정보 출력, 메뉴 출력하고  선택값 리턴
	//userUI - 1. 회원정보 수정
	String userUpdate(); //회원정보 수정 메뉴 전체 화면
	
	String userRud();// 회원정보 수정 메뉴 선택하고 select한 내용 리턴하고 udateObject에 매개변수로 넘겨줌
	String updateObject(String select); // 회원정보 수정사항 선택 후 수정내용 return
	String userOut(String id);// 비밀번호 입력 후 비밀번호 맞을 시, 회원 탈퇴됨
	
	String adminUI(); //admin메뉴 출력하고 선택값 리턴
	Member changeInfoUI(); //유저정보 변경하고 변경된 값 리턴
	int chargeMoneyUI();//금액 충전 및 충전할 금액 리턴 
}
