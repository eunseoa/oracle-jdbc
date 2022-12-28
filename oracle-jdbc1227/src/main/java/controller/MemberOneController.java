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

@WebServlet("/member/memberOne")
public class MemberOneController extends HttpServlet {
	private MemberService memberService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 정보 저장
		HttpSession session = request.getSession();
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		// 로그인이 안되어있으면
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath() + "/home");
		}
		
		// 로그인되어있으면
		String memberId = loginMember.getMemberId();
		
		// 바인딩
		Member member = new Member();
		member.setMemberId(memberId);
		
		this.memberService = new MemberService();
		Member resultMember = memberService.getMemberOne(member);
		
		// 값 저장
		request.setAttribute("loginMember", resultMember);
		
		request.getRequestDispatcher("/WEB-INF/view/member/memberOne.jsp").forward(request, response);
		// 회원정보 수정, 회원탈퇴
	}

}
