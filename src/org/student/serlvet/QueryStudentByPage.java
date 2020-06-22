package org.student.serlvet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Page;
import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;


public class QueryStudentByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService studentService = new StudentServiceImpl();
		int count = studentService.getTotalCount();	//数据总数
		//将分页所需的5个字段（其中有1个自动计算，因此实际只需要组装4个即可），组装到page对象中
		Page page = new Page();
		
		String cPage = request.getParameter("currentPage");
		if(cPage == null) {
			cPage = "0";
		}
		
		int currentPage = Integer.parseInt(cPage);//当前页
		page.setCurrentPage(currentPage);
		
		//注意 顺序
		int totalCount = studentService.getTotalCount();//总数据数
		page.setTotalCount(totalCount);
		
		
		/**
		 * currentPage 当前页（页码）
		 * studtents 当前页的数据集合（当前页的所有学生）
		 */
		
		int pageSize = 5;
				
		page.setPageSize(pageSize);
		List<Student> students = studentService.queryStudentByPage(currentPage,pageSize);
		
		page.setStudents(students);
	
		
		request.setAttribute("p",page);
		request.getRequestDispatcher("index.jsp").forward(request, response);;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
