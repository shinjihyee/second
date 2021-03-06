package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import etc.Database;
import vo.MemberInfo;

@WebServlet("/member/login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 보낸 파라미터를 꺼낸다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 로그인 처리 
		boolean success = false;
		String loginUserName = null; 

		
		// Db 에서 아이디와 비밀번호를 사용해서 일치하는 사용자를 찾는다.
		for (MemberInfo nthMemberInfo : Database.memberInfoTable) {
			String nthMemberId = nthMemberInfo.getId();
			String nthMemberPw = nthMemberInfo.getPw();
			
			success = nthMemberId.equals(id) && nthMemberPw.equals(pw);
			
			if (success) {
				loginUserName = nthMemberInfo.getName();
			} else {
			}
			
			// 찾았으면 로그인 성공
			// 찾지 못했으면 로그인 실패
			// 로그인 성공 상태 정보 기록 
			if (success) {
				HttpSession session = request.getSession();
				session.setAttribute("isLogin", true);
				// 관리자가 로그인을 했다면 userLevle=admin
				// 관리자가 아닌 사용자가 로그인 했다면 userLevel=user
				// 으로 상태정보를 기록해보세요.
				
				if (id.equals("admin")) {
					session.setAttribute("userLevel", "admin" );

				} else { 
					session.setAttribute("userLevel", "user");
				}
				
				session.setAttribute("loginUserName", loginUserName);
				
				response.setContentType("text/plain;charset=UTF-8");
				
				PrintWriter out = response.getWriter();
				
				out.print(loginUserName);
				out.close();
			} else {
				response.setStatus(400);
			}

		}}
	}