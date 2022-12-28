 package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.Board;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	private BoardService boardService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
			비로그인시 볼 수 있음
			메뉴 구성 (로그인 전/후 따라 분기)
			로그인 전
			1) 회원가입
			2) 로그인
			로그인 후
			1) 로그아웃
			2) 회원정보
			3) 게시판리스트
		 */
		this.boardService = new BoardService();
		ArrayList<Board> list = boardService.getHemoBoardList();
		
		// list 저장
		request.setAttribute("boardList", list);
		
		request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
	}

}
