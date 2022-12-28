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

@WebServlet("/member/modifyMemberPw")
public class ModifyMemberPwController extends HttpServlet {
	private MemberService memberService;
	// 비밀번호 수정 Form
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
		
		// 수정 실패시
		String msg = request.getParameter("msg");
		request.setAttribute("msg", msg);
		
		// 로그인되어있으면
		request.getRequestDispatcher("/WEB-INF/view/member/modifyMemberPw.jsp").forward(request, response);
	}

	// 비밀번호 수정 Action
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
		
		// 로그인 되어있으면
		// 값이 안넘어올경우
		if(request.getParameter("changePw") == null || request.getParameter("changePw").equals("")
			|| request.getParameter("defaultPw") == null || request.getParameter("defaultPw").equals("")) {
			System.out.println("값이 넘어오지않음");
			response.sendRedirect(request.getContextPath() + "/member/modifyMemberPw");
			return;
		}
		
		String changePw = request.getParameter("changePw"); // 변경할 비밀번호
		String defaultPw = request.getParameter("defaultPw"); // 현재 비밀번호
		String memberId = loginMember.getMemberId();
		
		// Model
		this.memberService = new MemberService();
		int row = memberService.getUpdateMemberPw(changePw, defaultPw, memberId);
		
		if(row == 1) {
			System.out.println("수정 성공");
			response.sendRedirect(request.getContextPath() + "/member/memberOne");
		} else {
			System.out.println("수정 실패");
			String msg = URLEncoder.encode("틀린비밀번호 입니다", "utf-8");
			response.sendRedirect(request.getContextPath() + "/WEB-INF/view/member/modifyMemberPw.jsp?msg=" + msg);
		}
		
	}

}
