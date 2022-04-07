package notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import etc.Database;


@WebServlet("/notice/list")
public class List extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//공지사항 목록을 불러와 전달해주는 서블릿
		
		response.setContentType("application/json;charset=UTF-8");

		PrintWriter out = response.getWriter();
		
		String data = "";
		for (NoticeInfo noticeInfo : Database.noticeInfoTable) {
			data = data + "{\"title\":\"" + noticeInfo.getTitle() + "\",\"contents\":\"" + noticeInfo.getContexts();
					
		}
		
		data = data.substring(0, data.length()-1);
		
		out.print(data);
		
		out.print("]}");
		out.close();
	}

}
