package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;

@WebServlet("/member/modifyMember")
public class ModifyMemberController extends HttpServlet {
	private MemberService memberService;
	// 회원정보 수정 Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 정보 저장
		HttpSession session = request.getSession();
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		
		// 로그인이 되어있지않으면
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath() + "/member/login");
			return;
		}
		
		// 수정 실패시
		String msg = request.getParameter("msg");
		request.setAttribute("msg", msg);
		
		// 로그인되어있으면
		request.getRequestDispatcher("/WEB-INF/view/member/modifymember.jsp").forward(request, response);
	}

	// 회원정보 수정 Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		// 로그인되어있으면
		// 수정할 값 받아오기
		String memberName = request.getParameter("memberName");
		String memberPw = request.getParameter("memberPw");
		String memberId = loginMember.getMemberId();
		
		// 바인딩
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberName(memberName);
		member.setMemberPw(memberPw);
		
		// Model
		this.memberService = new MemberService();
		int row = memberService.getUpdateMember(member);
		
		// view에서 현재 이름을 보여줌
		request.setAttribute("loginMember", loginMember);
		
		if(row == 1) {
			System.out.println("수정 성공");
			response.sendRedirect(request.getContextPath() + "/member/memberOne");
		} else {
			System.out.println("수정 실패");
			String msg = URLEncoder.encode("틀린비밀번호 입니다", "utf-8");
			response.sendRedirect(request.getContextPath() + "/member/modifyMember?msg=" + msg);
		}
	}

}
