package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import etc.Database;
import vo.MemberInfo;

@WebServlet("/member/join")
public class Join extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		

		MemberInfo memberInfo = new MemberInfo(id, pw, name);
		

		Database.memberInfoTable.add(memberInfo);
		

		response.sendRedirect("/web3/member/joinSuccess.html");
	}

}





