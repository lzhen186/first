
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
		//获取待修改的人的学号
		int no = Integer.parseInt(request.getParameter("sno"));  
		//获取修改后的内容
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		//修改的数据 封装到实体类中
		Student student = new Student(name, age, address);
		
		IStudentService service = new StudentServiceImpl();
		boolean result = service.updateStudentBySno(no, student);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(!result) {
//			response.getWriter().println("修改成功!");
			request.setAttribute("error","Error");
		}else {
			request.setAttribute("error", "noupError");
//			response.getWriter().println("修改失败!");
		}	
		
		request.getRequestDispatcher("QueryStudentByPage").forward(request,response);	//修改完毕后，再次查询全部的学生 并显示
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
