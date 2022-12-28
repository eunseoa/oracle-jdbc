package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		String sql = "SELECT member_id memberId, member_name memberName, updatedate, createdate FROM member WHERE member_id = ?";
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
}
