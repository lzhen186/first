package org.student.service;

import java.util.List;

import org.student.entity.Student;

public interface IStudentService {
	//���ѧ��
		public boolean addStudent(Student student);
		//����ѧ��ɾ��
		public boolean deleteStudentBySno(int sno) ;
		//����ѧ���޸�
		public boolean updateStudentBySno(int sno, Student student);
		//����ѧ�Ų�ѯѧ��
		public Student queryStudentBySno(int sno);
		//��ѯȫ��ѧ��
		public List<Student> queryAllStudetns();
		//����ҳ����ѧ��
		public List<Student> queryStudentByPage(int currentPage, int pageSize);
		
		public int getTotalCount();
}
