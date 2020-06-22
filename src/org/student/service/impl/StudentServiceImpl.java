package org.student.service.impl;

import java.util.List;

import org.student.dao.IStudentDao;
import org.student.dao.impl.StudentDaoImpl;
import org.student.entity.Student;
import org.student.service.IStudentService;

//业务逻辑层；逻辑性的增删改查（增：查+增），对dao层进行的组装；
public class StudentServiceImpl implements IStudentService {
	IStudentDao studentDao = new StudentDaoImpl();
	//添加学生
	public boolean addStudent(Student student) {
		
		if(!studentDao.isExist(student.getSno())) {
			studentDao.addStudent(student);
			return true;
		}else {
			System.out.println("此人已存在");
			return false;
		}
	}
	//根据学号删除
	public boolean deleteStudentBySno(int sno) {
			
		if(studentDao.isExist(sno)) {
			return studentDao.deleteStudentBySno(sno);
		}else{
			System.out.println("此人不存在");
			return false;
		}
	}
	//根据学号修改
	public boolean updateStudentBySno(int sno, Student student) { 
		if(studentDao.isExist(sno)) {
			return studentDao.updateStudentBySno(sno, student);
		}else {
			System.out.println("修改失败");
			return false;
		}
	}
	//根据学号查询学生
	public Student queryStudentBySno(int sno) {
		return studentDao.queryStudentBySNo(sno);
	}
	//查询全部学生
	public List<Student> queryAllStudetns(){
		return studentDao.queryAllstudetns();
	}
	
	//查询当前页的数据集合
	@Override
	public List<Student> queryStudentByPage(int currentPage, int pageSize) {
		return studentDao.queryStudentsByPage(currentPage, pageSize);
	}
	
	//查询数据总条数
	@Override
	public int getTotalCount() {
		return studentDao.getTotalCount();
	}
	
	
	
}
