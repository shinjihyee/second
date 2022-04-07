package notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import etc.Database;


@WebServlet("/notice/write")
public class Write extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		// 공지사항 데이터들을 공지사항 정보로 뭉쳐줌
		NoticeInfo noticeInfo = new NoticeInfo (title, contents);
		
	
		// 공지사항 테이블에 공지사항 저장 
		Database.noticeInfoTable.add(noticeInfo);
		
		// 공지사항 목록 페이지로 이동
		response.sendRedirect("/web3/notice/list.html");
	}
}
