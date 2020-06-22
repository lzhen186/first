package org.student.service.impl;

import java.util.List;

import org.student.dao.IStudentDao;
import org.student.dao.impl.StudentDaoImpl;
import org.student.entity.Student;
import org.student.service.IStudentService;

//ҵ���߼��㣻�߼��Ե���ɾ�Ĳ飨������+��������dao����е���װ��
public class StudentServiceImpl implements IStudentService {
	IStudentDao studentDao = new StudentDaoImpl();
	//���ѧ��
	public boolean addStudent(Student student) {
		
		if(!studentDao.isExist(student.getSno())) {
			studentDao.addStudent(student);
			return true;
		}else {
			System.out.println("�����Ѵ���");
			return false;
		}
	}
	//����ѧ��ɾ��
	public boolean deleteStudentBySno(int sno) {
			
		if(studentDao.isExist(sno)) {
			return studentDao.deleteStudentBySno(sno);
		}else{
			System.out.println("���˲�����");
			return false;
		}
	}
	//����ѧ���޸�
	public boolean updateStudentBySno(int sno, Student student) { 
		if(studentDao.isExist(sno)) {
			return studentDao.updateStudentBySno(sno, student);
		}else {
			System.out.println("�޸�ʧ��");
			return false;
		}
	}
	//����ѧ�Ų�ѯѧ��
	public Student queryStudentBySno(int sno) {
		return studentDao.queryStudentBySNo(sno);
	}
	//��ѯȫ��ѧ��
	public List<Student> queryAllStudetns(){
		return studentDao.queryAllstudetns();
	}
	
	//��ѯ��ǰҳ�����ݼ���
	@Override
	public List<Student> queryStudentByPage(int currentPage, int pageSize) {
		return studentDao.queryStudentsByPage(currentPage, pageSize);
	}
	
	//��ѯ����������
	@Override
	public int getTotalCount() {
		return studentDao.getTotalCount();
	}
	
	
	
}
