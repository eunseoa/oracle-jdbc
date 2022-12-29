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

/**
 * Servlet implementation class RomoveMemberController
 */
@WebServlet("/member/removeMember")
public class RomoveMemberController extends HttpServlet {
	private MemberService memberService;
	// 비밀번호를 model로 받기때문에 from이 없어도됨

	// 회원탈퇴 Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");
		System.out.println("모달");
		
		// 로그인 정보 저장
		HttpSession session = request.getSession();
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		
		// 로그인이 안되어있으면
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath() + "/member/login");
			return;
		}
		
		// 값 받기
		String memberId = loginMember.getMemberId();
		String memberPw = request.getParameter("memberPw");
		
		// 바인딩
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		// Model
		this.memberService = new MemberService();
		memberService.getDeleteMember(member);
		
		response.sendRedirect(request.getContextPath() + "/member/login");
	}

}
