package etc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import vo.MemberInfo;

// �� ������ ���� ����ϰ� ����� �� load-on-startup �±׸� ����ؼ�
// ������ ���۵Ǹ鼭 ������ ����������� �ϼ���.
// ������ ������� �� �츮���� �ʿ��� ������ �����ؼ�
// DB�� �����ϵ��� �ϼ���

public class StartupProcessor extends HttpServlet {


	@Override
	public void init() throws ServletException {
		
		System.out.println("<< StartupProcessor ���� >> ");
		
		MemberInfo memberInfo = new MemberInfo ("id1", "id2", "id3");
		MemberInfo adminInfo = new MemberInfo ("admin", "admin123", "������");
		
		
		Database.memberInfoTable.add(memberInfo);
		Database.memberInfoTable.add(adminInfo);
	}
}
