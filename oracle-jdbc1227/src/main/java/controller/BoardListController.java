package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import vo.Board;
import vo.Member;

@WebServlet("/board/boardList")
public class BoardListController extends HttpServlet {
	private BoardService boardService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");
				
		// 로그인 정보 저장
		HttpSession session = request.getSession();
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		
		// 로그인이 되어있지않으면
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath() + "/member/login");
			return;
		}
		
		// 로그인 되어있으면
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int rowPerPage = 10;
		if(request.getParameter("rowPerPage") != null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		
		// 검색
		// 검색을 하지 않았을때 모두 풀력하기 위해서 공백 대입
		String searchTitle = "";
		if(request.getParameter("searchTitle") != null) {
			searchTitle = request.getParameter("searchTitle");
		}
		System.out.println(searchTitle);
		
		this.boardService = new BoardService();
		ArrayList<Board> list = boardService.getBoardListByPage(currentPage, rowPerPage, searchTitle);
		// 마지막 페이지
		int cnt = boardService.getBoardListCount();
		int lastPage = cnt / rowPerPage;
		if(lastPage % rowPerPage != 0) {
			lastPage++;
		}
		
		request.setAttribute("boardList", list);
		request.setAttribute("currentPage", currentPage); // view에서 필요
		request.setAttribute("rowPerPage", rowPerPage); // view에서 필요
		request.setAttribute("lastPage", lastPage); // view에서 필요
		request.setAttribute("searchTitle", searchTitle); // view에서 필요
		
		// view
		request.getRequestDispatcher("/WEB-INF/view/board/boardList.jsp").forward(request, response);
	}

}
