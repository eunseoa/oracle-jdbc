package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;

@WebServlet("/LoginActionCotroller")
public class LoginActionCotroller extends HttpServlet {
	private MemberService memberService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 로그인 정보 저징
		HttpSession session = request.getSession();
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		
		// 로그인 되어있으면
		if(loginMember != null) {
			response.sendRedirect(request.getContextPath() + "/BoardListController");
			return;
		}
		
		// 로그인 되어있지않으면
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPw(pw);
		
		this.memberService = new MemberService();
		Member resultMember = memberService.getLoginMember(member);
		
		// 로그인 실패
		if(resultMember == null) {
			response.sendRedirect(request.getContextPath() + "/LoginFormController");
			return;
		}
		
		// null이 아니면
		session.setAttribute("loginMember", resultMember);
		response.sendRedirect(request.getContextPath() + "/BoardListController");
	}

}
