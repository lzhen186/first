package org.student.serlvet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;


public class QueryStudentBySnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int no = Integer.parseInt(request.getParameter("sno"));
		
		IStudentService service = new StudentServiceImpl();
		Student student = service.queryStudentBySno(no);
		System.out.print(student);
		//将此人的数据 通过前台jsp显示：studentInfo.jsp
		request.setAttribute("student",student);
		request.getRequestDispatcher("studentInfo.jsp").forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
