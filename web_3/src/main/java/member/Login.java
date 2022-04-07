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
		// Ŭ���̾�Ʈ�� ���� �Ķ���͸� ������.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// �α��� ó�� 
		boolean success = false;
		String loginUserName = null; 

		
		// Db ���� ���̵�� ��й�ȣ�� ����ؼ� ��ġ�ϴ� ����ڸ� ã�´�.
		for (MemberInfo nthMemberInfo : Database.memberInfoTable) {
			String nthMemberId = nthMemberInfo.getId();
			String nthMemberPw = nthMemberInfo.getPw();
			
			success = nthMemberId.equals(id) && nthMemberPw.equals(pw);
			
			if (success) {
				loginUserName = nthMemberInfo.getName();
			} else {
			}
			
			// ã������ �α��� ����
			// ã�� �������� �α��� ����
			// �α��� ���� ���� ���� ��� 
			if (success) {
				HttpSession session = request.getSession();
				session.setAttribute("isLogin", true);
				// �����ڰ� �α����� �ߴٸ� userLevle=admin
				// �����ڰ� �ƴ� ����ڰ� �α��� �ߴٸ� userLevel=user
				// ���� ���������� ����غ�����.
				
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