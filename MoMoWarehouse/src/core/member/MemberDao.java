package core.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	//멤버다오의 회원정보를 멤버db에 저장
	
	//절대값
		final String DRIVER = "oracle.jdbc.OracleDriver";
		final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		final String USER = "whadmin";
		final String PW = "whadmin";
		
		private Connection conn;
		private PreparedStatement pstmt;
		private ResultSet rs;
		
		public MemberDao() {
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		//Insert
		public int insert(Member member) {
			int result = 0;
			
			try {
				conn = DriverManager.getConnection(URL, USER, PW);
				
				StringBuilder sql = new StringBuilder();
				sql.append("INSERT INTO MEMBER(MEMBER_ID, PW, NAME, PHONE, EMAIL, SPOT_ID) ");
				sql.append("VALUES (?, ?, ?, ?, ?, ?)");
				
				pstmt = conn.prepareStatement(sql.toString());
				
				pstmt.setString(1, member.getMemberId());
				pstmt.setString(2, member.getPw()); 
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getPhone());
				pstmt.setString(5, member.getEmail());
				pstmt.setInt(6, member.getSpot_id());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(conn,pstmt);
			}
			
			return result;
		}
		
		
		//Select - ID, PW
		public Member selecte(String[] userInfo) {
			Member member = null;
			
			String id = userInfo[0];
			String pw = userInfo[1];
			
			try {
				conn = DriverManager.getConnection(URL, USER, PW);
				
				String sql = "SELECT MEMBER_ID, PW, NAME, PHONE, EMAIL, SPOT_ID, GRADE, CASH "
							+"  FROM MEMBER "
							+"  WHERE MEMBER_ID = ? AND PW = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id); 
				pstmt.setString(2, pw); 
				rs = pstmt.executeQuery(); 
				
				if(rs.next()) {
					member = new Member();
					member.setMemberId(rs.getString("MEMBER_ID"));
					member.setPw(rs.getString("PW"));
					member.setName(rs.getString("NAME"));
					member.setPhone(rs.getString("PHONE"));
					member.setEmail(rs.getString("EMAIL"));
					member.setSpot_id(rs.getInt("SPOT_ID"));
					member.setGrade(rs.getString("GRADE"));
					member.setCash(rs.getInt("CASH"));
				}else if(!rs.next()) {
					System.out.println("아이디가 존재하지 않거나 비밀번호가 틀렸습니다. 다시 입력 해 주세요.");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(conn, pstmt, rs);
			}
			
			return member;
		}
		
		//Select - 중복 ID 체크
		public String checkId(String id) {
			Member member = null;
			String checkid = null;
			
			try {
				conn = DriverManager.getConnection(URL, USER, PW);
				
				String sql = "SELECT MEMBER_ID  "
							+"  FROM MEMBER "
							+"  WHERE MEMBER_ID = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id); 
				rs = pstmt.executeQuery(); 
				
				if(rs.next()) {
					member = new Member();
					member.setMemberId(rs.getString("MEMBER_ID"));
					checkid = member.getMemberId();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(conn, pstmt, rs);
			}
			
			return checkid;
		}
		
		
		//Update - 회원정보수정(CRUD)
		public int update(Member member, String userInfoUpTxt, String id) {
			int result = 0;
			
			try {
				conn = DriverManager.getConnection(URL, USER, PW);
				
				StringBuilder sql = new StringBuilder();
				sql.append("UPDATE MEMBER ");
				sql.append("  SET " + userInfoUpTxt + " = ? ");
				sql.append("  WHERE MEMBER_ID = ? ");
				
				pstmt = conn.prepareStatement(sql.toString());
				
				if(userInfoUpTxt.trim().equals("PW")) {
					pstmt.setString(1, member.getPw()); 
				}else if(userInfoUpTxt.trim().equals("NAME")) {
					pstmt.setString(1, member.getName()); 
				}else if(userInfoUpTxt.trim().equals("PHONE")) {
					pstmt.setString(1, member.getPhone()); 
				}else if(userInfoUpTxt.trim().equals("EMAIL")) {
					pstmt.setString(1, member.getEmail()); 
				}
				
				pstmt.setString(2, id);
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(conn,pstmt);
			}
			
			return result;
		}
		
		//Update - 충전금액 변경
		public int updatingCash(Member member) {
			int result = 0;
			
			try {
				conn = DriverManager.getConnection(URL, USER, PW);
				
				StringBuilder sql = new StringBuilder();
				sql.append("UPDATE MEMBER ");
				sql.append("  SET CASH = ? ");
				sql.append("  WHERE MEMBER_ID = ? ");
				
				pstmt = conn.prepareStatement(sql.toString());
				
				pstmt.setInt(1, member.getCash()); 
				pstmt.setString(2, member.getMemberId());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(conn,pstmt);
			}
			
			return result;
		}
		
		//Delete
		public int delete(String id) {
			int result = 0;
			
			try {
				conn = DriverManager.getConnection(URL, USER, PW);
				
				StringBuilder sql = new StringBuilder();
				sql.append("DELETE FROM MEMBER WHERE MEMBER_ID = ?");
				
				pstmt = conn.prepareStatement(sql.toString());
				
				pstmt.setString(1, id);
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(conn,pstmt);
			}
			
			return result;
		}
		
		
		//클로즈 메서드
		public void close(Connection conn, PreparedStatement pstmt) {
			try {
				//null이 아닐때 닫아주는게 더 좋은 방법 (조건문 달아서..)
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
			try {
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				//null이 아닐때 닫아주는게 더 좋은 방법 (조건문 달아서..)
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}	
}
