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

/**
 * Servlet implementation class AddBoardActionController
 */
@WebServlet("/AddBoardActionController")
public class AddBoardActionController extends HttpServlet {
	private BoardService boardService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 로그인 정보 저장
		HttpSession session = request.getSession();
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		// 등록할 board 내용		
		String title = request.getParameter("title");
		String content = request.getParameter("title");
		
		// 바인딩
		Board board = new Board();
		board.setBoardTitle(title);
		board.setBoardContent(content);
		board.setMemberId(loginMember.getMemberId());
		
		this.boardService = new BoardService();
		int row = boardService.getInsertBoard(board);
		
		if(row == 1) {
			System.out.println("board 등록 성공");
			response.sendRedirect(request.getContextPath() + "/BoardListController");
		} else {
			System.out.println("board 등록 실패");
		}
	}

}