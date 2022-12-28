package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/modifyMember")
public class ModifyMemberController extends HttpServlet {
	// 회원정보 수정 Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/modifymember.jsp").forward(request, response);
	}

	// 회원정보 수정 Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// member/memberOne?key값 컨트롤러 
	}

}
