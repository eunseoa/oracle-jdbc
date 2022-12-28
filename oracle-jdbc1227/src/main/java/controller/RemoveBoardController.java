package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import vo.Board;
import vo.Member;

@WebServlet("/board/removeBoard")
public class RemoveBoardController extends HttpServlet {
	private BoardService boardService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 정보 저장
		HttpSession session = request.getSession();
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		
		// 값 받아오기
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String memberId = loginMember.getMemberId();
		
		// 바인딩
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setMemberId(memberId);
		
		this.boardService = new BoardService();
		boardService.getDeleteBoard(board);
		
		response.sendRedirect(request.getContextPath() + "/board/boardList");
	}

}
