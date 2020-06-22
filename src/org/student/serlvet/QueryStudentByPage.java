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
		int count = studentService.getTotalCount();	//��������
		//����ҳ�����5���ֶΣ�������1���Զ����㣬���ʵ��ֻ��Ҫ��װ4�����ɣ�����װ��page������
		Page page = new Page();
		
		String cPage = request.getParameter("currentPage");
		if(cPage == null) {
			cPage = "0";
		}
		
		int currentPage = Integer.parseInt(cPage);//��ǰҳ
		page.setCurrentPage(currentPage);
		
		//ע�� ˳��
		int totalCount = studentService.getTotalCount();//��������
		page.setTotalCount(totalCount);
		
		
		/**
		 * currentPage ��ǰҳ��ҳ�룩
		 * studtents ��ǰҳ�����ݼ��ϣ���ǰҳ������ѧ����
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
