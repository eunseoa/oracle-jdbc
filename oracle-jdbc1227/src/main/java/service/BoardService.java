package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BoardDao;
import util.DBUtil;
import vo.Board;

public class BoardService {
	private BoardDao boardDao;
	// boardDao selectBoardListByPage
	public ArrayList<Board> getBoardListByPage(int currentPage, int rowPerPage, String searchTitle) {
		/*
			1) connection 생성 <- DBUtil.class
			2) beginRow, endRow 생성 <- currentPage, rowPerPage를 가공
		 */
		ArrayList<Board> list = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			// 페이징
			int beginRow = ((currentPage - 1) * rowPerPage) + 1;
			int endRow = beginRow + rowPerPage - 1;
			
			this.boardDao = new BoardDao();
			list = boardDao.selectBoardListByPage(conn, beginRow, endRow, searchTitle);
			conn.commit(); // DBUtil에서 setAutoCommit(false)했음
		} catch (Exception e) {
			try {
				conn.rollback(); // DBUtil에서 setAutoCommit(false)했음
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
		
		return list;
	}
	
	// boardDao selectHomeBoardList
	public ArrayList<Board> getHemoBoardList() {
		ArrayList<Board> list = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			this.boardDao = new BoardDao();
			list = boardDao.selectHomeBoardList(conn);
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
		
		return list;
	}
	
	// 데이터 총 개수 count
	public int getBoardListCount() {
		int cnt = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			this.boardDao = new BoardDao();
			cnt = boardDao.boardListCount(conn);
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
		
		return cnt;
	}
	
	// boardDao selectBoardOne
	public Board getBoardOne(int boardNo) {
		Board board = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			this.boardDao = new BoardDao();
			board = boardDao.selectBoardOne(conn, boardNo);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.commit();
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
		
		return board;
	}
	
	// boardDao insertBoard
	public int getInsertBoard(Board board) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			this.boardDao = new BoardDao();
			row = boardDao.insertBoard(conn, board);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return row;
	}
	
	// boardDao updateBoard
	public int getUpdateBoard(Board board) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			this.boardDao = new BoardDao();
			row = boardDao.updateBoard(conn, board);
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
	
	// boardDao deleteBoard
	public int getDeleteBoard(Board board) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			this.boardDao = new BoardDao();
			row = boardDao.deleteBoard(conn, board);
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
