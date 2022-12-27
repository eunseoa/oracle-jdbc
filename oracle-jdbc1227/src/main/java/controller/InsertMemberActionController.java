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

@WebServlet("/InsertMemberActionController")
public class InsertMemberActionController extends HttpServlet {
	private MemberService memberService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 로그인 정보 저장
		HttpSession session = request.getSession();
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		
		// 로그인시 접근금지
		if(loginMember != null) {
			response.sendRedirect(request.getContextPath() + "/BoardListController");
			return;
		}
		
		// 로그인안되어있으면 진행
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		
		// 바인딩
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setMemberName(memberName);
		
		this.memberService = new MemberService();
		int row = memberService.getInsertMember(member);
		
		// 회원가입 성공하면
		if(row == 1) {
			response.sendRedirect(request.getContextPath() + "/LoginFormController");
		} else { // 실패하면
			response.sendRedirect(request.getContextPath() + "/InsertMemberFormController");
		}
	}

}
