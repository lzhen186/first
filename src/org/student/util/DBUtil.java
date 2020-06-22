package org.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.student.entity.Student;

//ͨ�õ����ݿ��������
public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/student";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "111111";
	public static Connection connection = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return  DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
	
	public static PreparedStatement createPreparedStatement(String sql, Object[] params) throws ClassNotFoundException, SQLException {
		pstmt = getConnection().prepareStatement(sql); //��ȡ����getConnection
		if(params!=null) {
			for(int i=0;i<params.length;i++) {
				pstmt.setObject(i+1, params[i]);
			}
		}
		return pstmt;
	}
	
	
	//��ѯ����
		public static int getTotalCount(String sql) //select count(1) from student
		{
			int count = -1;
			try {
				pstmt = createPreparedStatement(sql, null);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					count = rs.getInt(1);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll(rs,pstmt,connection);
			}
			
			return count;
		}

	//��ɾ��
		public static boolean executeUpdate(String sql,Object[] params) {
			try {
				//Object[] obs = {name,age,...};
//				String sql = "delete from student where sno = ?";
				
				
//				pstmt.setInt(1, sno);
				//setXxx()�����ĸ��� ������ �� �ĸ����� �� �� �ĸ����ֺ�����params�ĸ���һ��
				//setXxx()�����ĸ��� -�� ����params�ĸ���һ��
				pstmt = createPreparedStatement(sql,params);
				
				int count = pstmt.executeUpdate();
				if(count>0) {
					return true;
				}else {
					return false;
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return false;
			} catch(SQLException e) {
				e.printStackTrace();
				return false;
			} catch(Exception e) {
				e.printStackTrace();
				return false;
			} finally {
				closeAll(null,pstmt,connection);	
			}
		}
		
	
	//��
		//ͨ�õĲ�
		public static ResultSet executeQuery(String sql, Object[] params) {
			Student student = null;
			
			List<Student> students = new ArrayList<>();
			try {
								
//				String sql = "select * from student  where....";
			
				pstmt = createPreparedStatement(sql, params);
				
				rs = pstmt.executeQuery();
				
				return rs;			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			} catch(SQLException e) {
				e.printStackTrace();
				return null;
			} catch(Exception e) {
				e.printStackTrace();
				return null;
			} 
		}
		
		
		public static void closeAll(ResultSet rs, Statement stmt, Connection connection) 
		{
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(DBUtil.connection!=null)  DBUtil.connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	
}
