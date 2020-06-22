package org.student.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.student.dao.IStudentDao;
import org.student.entity.Student;
import org.student.util.DBUtil;



//���ݷ��ʲ㣬ԭ���Ե���ɾ�Ĳ�
public class StudentDaoImpl implements IStudentDao {
	private final String URL  ="jdbc:mysql://localhost:3306/student" ;
	private final String USERNAME  ="root" ;
	private final String PASSWORD  ="111111" ;
	//���
	public boolean addStudent(Student student) {//zs 23 xa
		String sql = "insert into student values(?,?,?,?)";
		Object[] params = {student.getSno(),student.getSname(),student.getSage(),student.getSaddress()};
		return DBUtil.executeUpdate(sql, params);
	}
	//����ѧ���޸�ѧ��������sno֪�����޸ĵ��ˣ���������޸ĳ�student	
	public boolean updateStudentBySno(int sno,Student student) {//3 -> zs,23,bj
		String sql = "update student set sname =?,sage=?,saddress=? where sno=?" ;
		Object[] params = {student.getSname(),student.getSage(),student.getSaddress(),sno};
		return DBUtil.executeUpdate(sql, params) ;
	}
	//����ѧ��ɾ��ѧ��
	public boolean deleteStudentBySno(int sno) {
		String sql = "delete from student where sno = ?";
		Object[] params = {sno};
		return DBUtil.executeUpdate(sql, params);
	}
	
	
	//��ѯȫ��ѧ��(�ܶ�ѧ��) ����
	public List<Student> queryAllstudetns() {
		PreparedStatement pstmt = null ;
		Student student = null;
		ResultSet rs = null;
		List<Student> students = new ArrayList<>();
		
		try {
			String sql = "select * from student";
			rs = DBUtil.executeQuery(sql, null);
			while(rs.next()) {
				  int no =   rs.getInt("sno") ;
				  String name =   rs.getString("sname") ;
				  int age =   rs.getInt("sage");
				  String address = rs.getString("saddress") ;
				  student = new Student(no,name,age,address);
				  students.add(student) ;
			}
			return students;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
		
	}
	
	
	
	//���������ѯ
	
	//����������ѯ
	
	
	//��ѯ�����Ƿ����
	public boolean isExist(int sno) {	//ture ���˴��� 
		return queryStudentBySNo(sno)==null? false:true;
	}
//	//����ѧ�� ��ѯѧ��
	
	public Student queryStudentBySNo(int sno) {//3
		Student student = null;
		Connection connection = null ;
		 PreparedStatement pstmt = null ;
		  ResultSet rs = null ; 
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			 connection = DriverManager.getConnection( URL,USERNAME,PASSWORD ) ;
			 String sql = "select * from student where sno =? " ;
			  pstmt = connection.prepareStatement( sql) ;
			  pstmt.setInt(1, sno);
			   rs = pstmt.executeQuery() ;
			  if(rs.next()) {
				  int no =   rs.getInt("sno") ;
				  String name =   rs.getString("sname") ;
				  int age =   rs.getInt("sage");
				  String address = rs.getString("saddress") ;
				  student = new Student(no,name,age,address);
			  }
			  return student ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null ; 
		} catch (SQLException e) {
			e.printStackTrace();
			return null ; 
		}catch (Exception e) {
			e.printStackTrace();
			return null ; 
		}
		finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(connection!=null)connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
		}
	}
	
	@Override
	//��ѯ��������
	public int getTotalCount() {
		String sql = "select count(1) from student";
		return DBUtil.getTotalCount(sql);
	}
	
	
	@Override
	public List<Student> queryStudentsByPage(int currentPage, int pageSize) {
		String sql = "select * from student limit ?,?";
		Object[] params = {currentPage*pageSize,pageSize};
		
		ResultSet rs = DBUtil.executeQuery(sql, params);
		
		List<Student> students = new ArrayList<>();
		
		try{
			while(rs.next()) {
				Student student = new Student(rs.getInt("sno"),rs.getString("sname"),rs.getInt("sage"),rs.getString("saddress"));
				students.add(student);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return students;
	}


	
	

	
}
