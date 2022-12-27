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
 * Servlet implementation class ModifyBoardFormController
 */
@WebServlet("/ModifyBoardFormController")
public class ModifyBoardFormController extends HttpServlet {
	private BoardService boardService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 로그인 유효성 검사
		HttpSession session = request.getSession();
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		
		// 로그인이 안되어있으면
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath() + "/LoginFormController");
			return;
		}
		
		// 로그인 되어있으면
		// no 값 유효성
		if(request.getParameter("boardNo") == null) {
			response.sendRedirect(request.getContextPath() + "/BoardListController");
			return;
		}
		
		// no 값 받아오기
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		this.boardService = new BoardService();
		Board resultBoard = boardService.getBoardOne(boardNo);
		
		request.setAttribute("boardOne", resultBoard);
		request.getRequestDispatcher("/WEB-INF/view/modifyBoardForm.jsp?boardNo=" + boardNo).forward(request, response);
	}

}
