package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.Board;

/**
 * Servlet implementation class BoardOneController
 */
@WebServlet("/BoardOneController")
public class BoardOneController extends HttpServlet {
	BoardService boardService = new BoardService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");
				
		if (request.getParameter("boardNo") == null) {
			response.sendRedirect(request.getContextPath() + "/BoardListController");
		}
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		this.boardService = new BoardService();
		Board boardOne = boardService.getBoardOne(boardNo);
		request.setAttribute("boardOne", boardOne);
		
		request.getRequestDispatcher("/WEB-INF/view/boardOne.jsp?boardNo=" + boardNo).forward(request, response);
	}

}
