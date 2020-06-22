package org.student.serlvet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;


public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int no = Integer.parseInt(request.getParameter("sno")); 
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		Student student = new Student(no,name,age,address);
		
		//�ӿ� X = new ʵ����();
		IStudentService studentService = new StudentServiceImpl();
		boolean result = studentService.addStudent(student);
		
		/**
		 * out request response session application
		 * out: PrintWriter out = response.getWriter();
		 * session: request.getSession();
		 * application: request.getServletContext();
		 */
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
//		PrintWriter out = response.getWriter();
		
//		if(result) {	
//			out.println("���ӳɹ�!");
//			
//		}else {
//			//out.println("����ʧ��!");
//		}
		if(!result) {//�������ʧ�ܣ���request����һ������error
			request.setAttribute("error", "Error");
		}else {
			request.setAttribute("error","noaddError");
		}
		request.getRequestDispatcher("QueryStudentByPage").forward(request, response);;
//		response.sendRedirect("QueryAllStudentsServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
