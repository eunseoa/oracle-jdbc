package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.jdbc.proxy.annotation.Pre;
import vo.Member;

public class MemberDao {
	// 회원가입
	public int insertMember(Connection conn, Member member) throws Exception {
		int row = 0;
		String sql = "INSERT INTO member(member_id, member_pw, member_name, updatedate, createdate) VALUES(?, ?, ?, sysdate, sysdate)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		stmt.setString(3, member.getMemberName());
		
		row = stmt.executeUpdate();
		
		return row;
	}
	
	// 아이디 중복 확인
	public boolean memberIdCheck(Connection conn, Member member) throws Exception {
		boolean check = false;
		String sql = "SELECT member_id FROM member WHERE member_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			check = true;
		}
		
		return check;
	}
	
	// 로그인
	public Member loginMember(Connection conn, Member member) throws Exception {
		Member resultMember = null;
		String sql = "SELECT member_id memberId, member_name memberName FROM member WHERE member_id = ? AND member_pw = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			resultMember = new Member();
			resultMember.setMemberId(rs.getString("memberId"));
			resultMember.setMemberName(rs.getString("memberName"));
		}
		
		return resultMember;
	}
	
	// 회원정보
	public Member memberOne(Connection conn, Member member) throws Exception {
		Member resultMember = null;
		String sql = "SELECT member_id memberId, member_name memberName, updatedate, SUBSTR(createdate, 1, 9) createdate FROM member WHERE member_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			resultMember = new Member();
			resultMember.setMemberId(rs.getString("memberId"));
			resultMember.setMemberName(rs.getString("memberName"));
			resultMember.setUpdatedate(rs.getString("updatedate"));
			resultMember.setCreatedate(rs.getString("createdate"));
		}
		
		return resultMember;
	}
	
	// 정보 수정
	public int updateMember(Connection conn, Member member) throws Exception {
		int row = 0;
		String sql = "UPDATE member SET member_name = ? WHERE member_id = ? AND member_pw = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberName());
		stmt.setString(2, member.getMemberId());
		stmt.setString(3, member.getMemberPw());
		
		row = stmt.executeUpdate();
		
		return row;
	}
	
	// 비밀번호 수정
	public int updateMemberPw(Connection conn, String chasngePw, String defalutPw, String memberId) throws Exception {
		int row = 0;
		String sql = "UPDATE member SET member_pw = ? WHERE member_id = ? AND member_pw = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, chasngePw);
		stmt.setString(2, memberId);
		stmt.setString(3, defalutPw);
		
		row = stmt.executeUpdate();
		
		return row;
	}
	
	// 회원 탈퇴
	public int deleteMember(Connection conn, Member member) throws Exception {
		int row = 0;
		String sql = "DELETE FROM member WHERE member_id = ? AND member_pw = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		
		row = stmt.executeUpdate();
		
		return row;
	}
}
