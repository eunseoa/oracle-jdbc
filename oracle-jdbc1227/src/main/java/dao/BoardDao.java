package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Board;

public class BoardDao {
	// 검색 추가
	// home에서 보여줄 board 리스트
	public ArrayList<Board> selectHomeBoardList(Connection conn) throws Exception {
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "SELECT board_no boardNo, board_title boardTitle, member_id memberId, SUBSTR(createdate, 1, 9) createdate "
					+" FROM (SELECT rownum rnum, board_no, board_title, member_id, createdate "
					+"		FROM (SELECT board_no, board_title, member_id, createdate "
					+"				FROM board ORDER BY TO_NUMBER(board_no) DESC)) "
					+" WHERE rnum BETWEEN 1 AND 10";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Board b = new Board();
			b.setBoardNo(rs.getInt("boardNo"));
			b.setBoardTitle(rs.getString("boardTitle"));
			b.setMemberId(rs.getString("memberId"));
			b.setCreatedate(rs.getString("createdate"));
			list.add(b);
		}
		
		return list;
	}
	
	// board 리스트 출력
	public ArrayList<Board> selectBoardListByPage(Connection conn, int beginRow, int endRow, String searchTitle) throws Exception {
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "SELECT board_no boardNo, board_title boardTitle, member_id memberId, SUBSTR(createdate, 1, 9) createdate "
					+" FROM (SELECT rownum rnum, board_no, board_title, member_id, createdate "
					+"		FROM (SELECT board_no, board_title, member_id, createdate "
					+"				FROM board "
					+"				WHERE board_title LIKE ? "
					+"				ORDER BY TO_NUMBER(board_no) DESC)) "
					+" WHERE rnum BETWEEN ? AND ?"; // WHERE rnum >=? AND rnum <=?;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%" + searchTitle + "%");
		stmt.setInt(2, beginRow);
		stmt.setInt(3, endRow);
		
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Board b = new Board();
			b.setBoardNo(rs.getInt("boardNo"));
			b.setBoardTitle(rs.getString("boardTitle"));
			b.setMemberId(rs.getString("memberId"));
			b.setCreatedate(rs.getString("createdate"));
			list.add(b);
		}
		
		return list;
	}
	
	// list 페이징을 위한 데이터 총 갯수
	public int boardListCount(Connection conn, String searchTitle) throws Exception {
		int cnt = 0;
		String sql = "SELECT COUNT(*) cnt FROM board WHERE board_title LIKE ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%" + searchTitle + "%");
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			cnt = Integer.parseInt(rs.getString("cnt"));
		}
		
		return cnt;
	}
	
	// board 상세보기
	public Board selectBoardOne(Connection conn, int boardNo) throws Exception {
		Board board = null;
		String sql = "SELECT board_no boardNo, board_title boardTitle, board_content boardContent, member_id memberId, updatedate, createdate FROM board WHERE board_no = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, boardNo);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			board = new Board();
			board.setBoardNo(rs.getInt("boardNo"));
			board.setBoardTitle(rs.getString("boardTitle"));
			board.setBoardContent(rs.getString("boardContent"));
			board.setMemberId(rs.getString("memberId"));
			board.setUpdatedate(rs.getString("updatedate"));
			board.setCreatedate(rs.getString("createdate"));
		}
		
		return board;
	}
	
	// board 추가
	public int insertBoard(Connection conn, Board board) throws Exception{
		int row = 0;
		String sql = "INSERT INTO board(board_no, board_title, board_content, member_id, updatedate, createdate) VALUES(board_seq.nextval, ?, ?, ?, sysdate, sysdate)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, board.getBoardTitle());
		stmt.setString(2, board.getBoardContent());
		stmt.setString(3, board.getMemberId());
		
		row = stmt.executeUpdate();
		
		return row;
	}
	
	// board 수정
	public int updateBoard(Connection conn, Board board) throws Exception {
		int row = 0;
		String sql = "UPDATE board SET board_title = ?, board_content = ?, updatedate = sysdate WHERE board_no = ? AND member_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, board.getBoardTitle());
		stmt.setString(2, board.getBoardContent());
		stmt.setInt(3, board.getBoardNo());
		stmt.setString(4, board.getMemberId());
		
		row = stmt.executeUpdate();
		
		return row;
	}
	
	// board 삭제
	public int deleteBoard(Connection conn, Board board) throws Exception {
		int row = 0;
		String sql = "DELETE FROM board WHERE board_no = ? AND member_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, board.getBoardNo());
		stmt.setString(2, board.getMemberId());
		
		row = stmt.executeUpdate();
		
		return row;
	}
}
