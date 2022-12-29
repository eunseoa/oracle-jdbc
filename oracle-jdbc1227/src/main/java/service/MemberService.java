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
	
	// memberDao memberIdCheck
	public boolean getMemberIdCheck(Member member) {
		boolean check = false;
		Connection conn = null;
		try {
			this.memberDao = new MemberDao();
			conn = DBUtil.getConnection();
			check = memberDao.memberIdCheck(conn, member);
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
		
		return check;
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
	
	// memberDao memberOne
	public Member getMemberOne(Member member) {
		Member resultMember = null;
		Connection conn = null;
		try {
			this.memberDao = new MemberDao();
			conn = DBUtil.getConnection();
			resultMember = memberDao.memberOne(conn, member);
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
	
	// memberDao updateMember
	public int getUpdateMember(Member member) {
		int row = 0;
		Connection conn = null;
		try {
			this.memberDao = new MemberDao();
			conn = DBUtil.getConnection();
			row = memberDao.updateMember(conn, member);
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
	
	// memberDao updateMemberPw
	public int getUpdateMemberPw(String changePw, String defaultPw, String memberId) {
		int row = 0;
		Connection conn = null;
		try {
			this.memberDao = new MemberDao();
			conn = DBUtil.getConnection();
			row = memberDao.updateMemberPw(conn, changePw, defaultPw, memberId);
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
	
	// memberDao deleteMember
	public int getDeleteMember(Member member) {
		int row = 0;
		Connection conn = null;
		try {
			this.memberDao = new MemberDao();
			conn = DBUtil.getConnection();
			row = memberDao.deleteMember(conn, member);
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
}
