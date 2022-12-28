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

@WebServlet("/board/addBoard")
public class AddBoardController extends HttpServlet {
	private BoardService boardService;
	// 글쓰기 Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/board/addBoardForm.jsp").forward(request, response);
	}

	// 글쓰기 Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 로그인 정보 저장
		HttpSession session = request.getSession();
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		
		// 로그인이 안되어있으면
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath() + "/member/login");
			return;
		}
		
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
			response.sendRedirect(request.getContextPath() + "/board/boardList");
		} else {
			System.out.println("board 등록 실패");
		}
	}

}
