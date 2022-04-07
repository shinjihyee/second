package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		try {
			// -> �α��� ���� ���¶�� ~�� ȯ���մϴٰ� ���̴� ���� �������� �̵�
			boolean isLogin = (boolean) session.getAttribute("isLogin");
			String loginUserName = (String) session.getAttribute("loginUserName");
			
			String userLevel = (String) session.getAttribute("userLevel");
			String writeNoticeBtnTag = ""; 
			if (userLevel.equals("admin")) {
				// �������� ���� ��ư �±׸� ���ڿ��� ����
				writeNoticeBtnTag = "<button type=\"button\" id=\"admin_notice_write\"> �������� ���� </button>";
			}
			

			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.print("<!DOCTYPE html> "
					+ "<html> "
					+ "<head> "
					+ "<meta charset=\"UTF-8\"> "
					+ "<title>Servlet Project</title> "
					+ "<link rel=\"stylesheet\" href=\"/web3/css/header.css\"> "
					+ "<link rel=\"stylesheet\" href=\"/web3/css/footer.css\"> "
					+ "<link rel=\"stylesheet\" href=\"/web3/css/main_index.css\"> "
					+ "</head> "
					+ "<body> "
					+ "	<header> "
					+ "		<div id=\"login_area\"> " + loginUserName + "�� ȯ���մϴ�~ "
					+ "		</div> "
					+ "		 "
					+ "		<div id=\"join_area\"> "
					+ 			writeNoticeBtnTag
					+ "			<button type=\"button\" id=\"logout\">�α׾ƿ�</button> "
					+ "		</div> "
					+ "	</header> "
					+ "	 "
					+ "	<main> "
					+ "		<h2>��������</h2> "
					+ "		<div id=\"notice_list\">���������� �����ϴ�.</div> "
					+ "	</main> "
					+ "	 "
					+ "	<footer>�ް����͵� IT ��ī���� ������ ����� Servlet ������Ʈ</footer> "
					+ "	 "
					+ "	 "
					+ "	<script src=\"/web3/js/jquery-3.6.0.min.js\"></script> "
					+ "	<script type=\"text/javascript\"> "
					+ "	$(\"#join_area > button\").on(\"click\", function() { "
					+ "		location.href = \"/web3/member/logout\"; "
					+ "	}); "
					+ " $(\"#admin_notice_write\").on(\"click\", function () {"
					+ " location.href= \"/web3/notice/form.html\";"
					+ "});"
					+ "	</script> "
					+ "	 "
					+ "</body> "
					+ "</html>");
		} catch (NullPointerException e) {
			// -> �α��� ���� �Ǵ� �α��� ȭ���� ���̴� ���� �������� �̵�
			RequestDispatcher rd = request.getRequestDispatcher("/main/index.html");
			rd.forward(request, response);
		}			
		}
}
