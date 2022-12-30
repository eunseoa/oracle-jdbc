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

@WebServlet("/member/addMember")
public class AddMemberController extends HttpServlet {
	private MemberService memberService;
	// 회원가입 Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/addMember.jsp").forward(request, response);
	}

	// 회원가입 Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 로그인 정보 저장
		HttpSession session = request.getSession();
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		
		// 로그인시 접근금지
		if(loginMember != null) {
			response.sendRedirect(request.getContextPath() + "/board/boardList");
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
		
		// Model
		this.memberService = new MemberService();
		// 아이디 중복 검사
		if(memberService.getMemberIdCheck(member)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('사용할 수 없는 아이디입니다'); history.back(); </script>");
			out.flush();
			return;
		}
		
		// 아이디가 중복되지않으면
		memberService.getInsertMember(member);
		response.sendRedirect(request.getContextPath() + "/member/login");
	}

}
