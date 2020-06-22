package org.student.service;

import java.util.List;

import org.student.entity.Student;

public interface IStudentService {
	//添加学生
		public boolean addStudent(Student student);
		//根据学号删除
		public boolean deleteStudentBySno(int sno) ;
		//根据学号修改
		public boolean updateStudentBySno(int sno, Student student);
		//根据学号查询学生
		public Student queryStudentBySno(int sno);
		//查询全部学生
		public List<Student> queryAllStudetns();
		//根据页数查学生
		public List<Student> queryStudentByPage(int currentPage, int pageSize);
		
		public int getTotalCount();
}
