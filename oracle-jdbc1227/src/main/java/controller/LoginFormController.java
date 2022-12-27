package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Member;

@WebServlet("/LoginFormController")
public class LoginFormController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 전에만 접근가능
		HttpSession session = request.getSession();
		// 로그인 정보 저장
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		
		// 로그인 되어 있으면
		if(loginMember != null) {
			response.sendRedirect(request.getContextPath() + "/BoardListController");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/loginForm.jsp").forward(request, response);
	}

}
