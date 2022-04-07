package etc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import vo.MemberInfo;

// 이 서블릿을 직접 등록하고 등록할 때 load-on-startup 태그를 사용해서
// 서버가 시작되면서 서블릿이 만들어지도록 하세요.
// 서블릿이 만들어질 때 우리에게 필요한 계정을 생성해서
// DB에 저장하도록 하세요

public class StartupProcessor extends HttpServlet {


	@Override
	public void init() throws ServletException {
		
		System.out.println("<< StartupProcessor 동작 >> ");
		
		MemberInfo memberInfo = new MemberInfo ("id1", "id2", "id3");
		MemberInfo adminInfo = new MemberInfo ("admin", "admin123", "관리자");
		
		
		Database.memberInfoTable.add(memberInfo);
		Database.memberInfoTable.add(adminInfo);
	}
}
