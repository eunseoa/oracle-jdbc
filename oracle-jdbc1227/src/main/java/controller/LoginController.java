package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;

@WebServlet("/member/login")
public class LoginController extends HttpServlet {
	private MemberService memberService;
	
	// 로그인 Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
	}

	// 로그인 Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		System.out.println("post");
		request.setCharacterEncoding("UTF-8");
		
		// 로그인 정보 저장
		HttpSession session = request.getSession();
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		
		// 로그인 되어있으면
		if(loginMember != null) {
			response.sendRedirect(request.getContextPath() + "/board/boardList");
			return;
		}
		
		// 로그인 되어있지않으면
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPw(pw);
		
		// Model
		this.memberService = new MemberService();
		Member resultMember = memberService.getLoginMember(member);
		
		// 로그인 실패
		if(resultMember == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('아이디나 비밀번호를 확인해주세요'); history.back(); </script>");
			out.flush();
			return;
		}
		
		// 로그인 성공
		session.setAttribute("loginMember", resultMember);
		response.sendRedirect(request.getContextPath() + "/home");
	}

}
