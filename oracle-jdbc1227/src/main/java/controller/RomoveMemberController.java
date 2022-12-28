package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RomoveMemberController
 */
@WebServlet("/member/removeMember")
public class RomoveMemberController extends HttpServlet {
	// 회원탈퇴 Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/removeMember.jsp").forward(request, response);
	}

	// 회원탈퇴 Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// member/logout
	}

}
