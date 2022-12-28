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

@WebServlet("/member/modifyMemberPw")
public class ModifyMemberPwController extends HttpServlet {
	private MemberService memberService;
	// 비밀번호 수정 Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String changePw = request.getParameter("changePw"); // 변경할 비밀번호
		String defaultPw = request.getParameter("defaultPw"); // 현재 비밀번호
		String memberId = loginMember.getMemberId();
		
		// Model
		this.memberService = new MemberService();
		memberService.getUpdateMemberPw(changePw, defaultPw, memberId);
		
		response.sendRedirect(request.getContextPath() + "/member/memberOne");
		
	}

}
