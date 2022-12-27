package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDao;
import util.DBUtil;
import vo.Member;

public class MemberService {
	private MemberDao memberDao;
	// memberDao insertMember
	public int getInsertMember(Member member) {
		int row = 0;
		Connection conn = null;
		try {
			this.memberDao = new MemberDao();
			conn = DBUtil.getConnection();
			row = memberDao.insertMember(conn, member);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return row;
	}
	
	
	// memberDao loginMember
	public Member getLoginMember(Member member) {
		Member resultMember = null;
		Connection conn = null;
		try {
			this.memberDao = new MemberDao();
			conn = DBUtil.getConnection();
			resultMember = memberDao.loginMember(conn, member);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultMember;
	}
}
