package org.student.dao;


import java.util.List;

import org.student.entity.Student;

public interface IStudentDao {
	//���
		public boolean addStudent(Student student);
			
		//����ѧ���޸�ѧ��������sno֪�����޸ĵ��ˣ���������޸ĳ�student
		public boolean updateStudentBySno(int sno, Student student);
		
		//����ѧ��ɾ��ѧ��
		public boolean deleteStudentBySno(int sno) ;
			
		//��ѯ��������
		public int getTotalCount();
		
		//��ѯȫ��ѧ��(�ܶ�ѧ��) ����
		public List<Student> queryAllstudetns() ;
		
		//currentPage:��ǰҳ��ҳ�룩 pageSize��ҳ���С��ÿҳ��ʾ������������
		public List<Student> queryStudentsByPage(int currentPage, int pageSize);
			
		
		//���������ѯ
		
		//����������ѯ
		
		
		//��ѯ�����Ƿ����
		public boolean isExist(int sno) ;
		//����ѧ�� ��ѯѧ��
		public Student queryStudentBySNo(int sno) ;
}
