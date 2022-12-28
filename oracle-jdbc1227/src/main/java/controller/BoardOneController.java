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
 * Servlet implementation class BoardOneController
 */
@WebServlet("/board/boardOne")
public class BoardOneController extends HttpServlet {
	BoardService boardService = new BoardService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 로그인 정보 저장
		HttpSession session = request.getSession();
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		
		// 로그인되어있지않으면
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath() + "/LoginFormController");
			return;
		}
		
		// 로그인되어있으면
		if (request.getParameter("boardNo") == null || request.getParameter("boardNo").equals("")) {
			response.sendRedirect(request.getContextPath() + "/BoardListController");
		}
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		this.boardService = new BoardService();
		Board boardOne = boardService.getBoardOne(boardNo);
		request.setAttribute("boardOne", boardOne);
		request.setAttribute("loginMemberId", loginMember.getMemberId());
		System.out.println(loginMember.getMemberId());
		
		request.getRequestDispatcher("/WEB-INF/view/board/boardOne.jsp?boardNo=" + boardNo).forward(request, response);
	}

}
