
package org.student.serlvet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;


public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//��ȡ���޸ĵ��˵�ѧ��
		int no = Integer.parseInt(request.getParameter("sno"));  
		//��ȡ�޸ĺ������
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		//�޸ĵ����� ��װ��ʵ������
		Student student = new Student(name, age, address);
		
		IStudentService service = new StudentServiceImpl();
		boolean result = service.updateStudentBySno(no, student);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(!result) {
//			response.getWriter().println("�޸ĳɹ�!");
			request.setAttribute("error","Error");
		}else {
			request.setAttribute("error", "noupError");
//			response.getWriter().println("�޸�ʧ��!");
		}	
		
		request.getRequestDispatcher("QueryStudentByPage").forward(request,response);	//�޸���Ϻ��ٴβ�ѯȫ����ѧ�� ����ʾ
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
