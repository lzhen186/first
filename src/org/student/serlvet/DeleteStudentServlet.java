package org.student.serlvet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;


public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//删除
		request.setCharacterEncoding("UTF-8");
		//接收前端传来的学号
		int no = Integer.parseInt(request.getParameter("sno"));
		
		IStudentService service = new StudentServiceImpl();
		boolean result = service.deleteStudentBySno(no);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(!result) {
			request.setAttribute("error", "Error");
		}else {
			request.setAttribute("error", "nodelError");
		}
		
		request.getRequestDispatcher("QueryStudentByPage").forward(request,response);//重新查询 所有学生
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
