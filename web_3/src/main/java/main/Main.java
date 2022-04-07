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
			// -> 로그인 성공 상태라면 ~님 환영합니다가 보이는 메인 페이지로 이동
			boolean isLogin = (boolean) session.getAttribute("isLogin");
			String loginUserName = (String) session.getAttribute("loginUserName");
			
			String userLevel = (String) session.getAttribute("userLevel");
			String writeNoticeBtnTag = ""; 
			if (userLevel.equals("admin")) {
				// 공지사항 쓰기 버튼 태그를 문자열로 구성
				writeNoticeBtnTag = "<button type=\"button\" id=\"admin_notice_write\"> 공지사항 쓰기 </button>";
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
					+ "		<div id=\"login_area\"> " + loginUserName + "님 환영합니다~ "
					+ "		</div> "
					+ "		 "
					+ "		<div id=\"join_area\"> "
					+ 			writeNoticeBtnTag
					+ "			<button type=\"button\" id=\"logout\">로그아웃</button> "
					+ "		</div> "
					+ "	</header> "
					+ "	 "
					+ "	<main> "
					+ "		<h2>공지사항</h2> "
					+ "		<div id=\"notice_list\">공지사항이 없습니다.</div> "
					+ "	</main> "
					+ "	 "
					+ "	<footer>메가스터디 IT 아카데미 웹개발 취업반 Servlet 프로젝트</footer> "
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
			// -> 로그인 실패 또는 로그인 화면이 보이는 메인 페이지로 이동
			RequestDispatcher rd = request.getRequestDispatcher("/main/index.html");
			rd.forward(request, response);
		}			
		}
}
