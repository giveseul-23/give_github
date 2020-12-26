package core.member;

public class Member {
	private String memberId;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private int spot_id;
	private String grade;
	private int cash;
		
	public Member() {
	}
	
	public Member(String memberId, String pw, String name, String phone, String email, int spot_id) {
		this.memberId = memberId;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.spot_id = spot_id;
	}
	

	public Member(String memberId, String pw, String name, String phone, String email, int spot_id, String grade,
			int cash) {
		this.memberId = memberId;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.spot_id = spot_id;
		this.grade = grade;
		this.cash = cash;
	}
	

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public void setSpot_id(int spot_id) {
		this.spot_id = spot_id;
	}

	public int getSpot_id() {
		return spot_id;
	}
	

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public boolean checkPassword(String pw) {
		return this.pw == pw;
	}

	@Override
	public String toString() {
		return memberId + " 회원님의 정보 | 이름 = " + name + ", 전화번호 = " + phone + ", 이메일 = "
				+ email + ", 보관소ID = " + spot_id + ", 등급 = " + grade + ", 충전금액 = " + cash ;
	}
	
	
	
	
	
}
