package notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// �뵵 : �������� ���� �������� �� �� ���� �ؾ��� ����
// 		 ������ �ִ� ����� (������) �� �������� ���� �������� ���� �������� ���̵��� �ϰ� 
//		 ������ ���� ����� (�α����� ���� �ʾҰų�, �Ϲ� ����ڷ� �α���) �� �������� ���� ���� �������� ���̵��� �ϴ� ����

@WebServlet("/notice/form")
public class Form extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	
	try {
			HttpSession session = request.getSession();
			String userLevel = (String) session.getAttribute("userLevel");
					
			if (userLevel.equals("admin")) {
				// ������ �ִ� ����ڰ� �������� �� �������� ���� �������� ���̵���
				RequestDispatcher rd = request.getRequestDispatcher("/notice/form.html");
				rd.forward(request, response);
				
			} else {
				// ������ ���� ����ڰ� �������� �� ���� ���� �������� ���̵���
				response.sendRedirect("/web3/main");
				}
			} catch (NullPointerException e)  {
			// �α��� ���� ���� ����ڰ� �������� �� ���� �������� ���̵���
			response.sendRedirect("/web3/main");

			}	
	}
}

