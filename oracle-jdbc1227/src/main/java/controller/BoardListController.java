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
		
		// 검색
		// 검색을 하지 않았을때 모두 풀력하기 위해서 공백 대입
		String searchTitle = "";
		if(request.getParameter("searchTitle") != null) {
			searchTitle = request.getParameter("searchTitle");
		}
		System.out.println(searchTitle);
		
		// 페이징
		// 한 페이지당 보여줄 board 개수
		int rowPerPage = 10;
		if(request.getParameter("rowPerPage") != null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		
		// 페이지 이동 버튼 알고리즘
		this.boardService = new BoardService();
		ArrayList<Board> list = boardService.getBoardListByPage(currentPage, rowPerPage, searchTitle);
		int cnt = boardService.getBoardListCount(searchTitle); // board 총 개수
		int lastPage = cnt / rowPerPage; // 마지막페이지 + 페이지 개수
		if(lastPage % rowPerPage != 0) {
			lastPage++;
		}
		int showPage = 10; // 버튼에 표시할 페이지 개수
		int startPage = ((currentPage - 1) / showPage) * showPage + 1; // 시작 페이지
		int endPage = (((currentPage - 1) / showPage) + 1) * showPage; // 현제 페이지의 마지막 페이지 번호
		// lastPage가 endPage보다 작을 경우 lastPage로 바꿔줌
		if(lastPage < endPage) {
			endPage = lastPage;
		}
		
		// 이전 버튼 활성화 여부
		boolean prev = (startPage == 1) ? false : true;
		// 다음 버튼 활성화 여부
		boolean next = (endPage == lastPage) ? false : true;
		
		
		// view에서 필요
		request.setAttribute("boardList", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("rowPerPage", rowPerPage);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		
		// view
		request.getRequestDispatcher("/WEB-INF/view/board/boardList.jsp").forward(request, response);
	}

}
