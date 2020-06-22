<%@page import="org.student.entity.Page"%>
<%@page import="org.student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("tr:odd").css("background-color","lightgray");
		});
	</script>
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息列表</title>
</head>
<body>

	<center>
		<h2>学生信息管理</h2>	
	
		<%
			/*
				在分页显示的前提下：显示数据jsp需要哪些数据：
						当前页  currentPage
						页面大小 pageSize
						当前页的数据集合  students
						总数据 totalCount
						总页数   totalPage
								-->新建Page类，用于封装以上5个字段
			*/
		
		
			//error:adderror 失败
			//否则：1 确实执行了增加    2直接访问查询全部页面
			String error = (String)request.getAttribute("error") ;//addError
			if(error!=null){
				if(error.equals("Error")){
					out.print("操作失败！");
				}else if(error.equals("noaddError")){
					out.print("增加成功！");
				}else if(error.equals("nodelError")){
					out.print("删除成功！");
				}else if(error.equals("noupError")){
					out.print("更新成功！");
				}//根本没有执行增加
			}	
		%>
	
	
		<table border="1px">
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>操作</th>
			</tr>
			
			<%
				//获取request域中的数据
				Page p  = (Page)request.getAttribute("p") ;			
			
				for(Student student:p.getStudents()){
			%>
			<tr>
				<td><%=student.getSno() %></td>
				
				
				<td><%=student.getSname() %></td>
				<td><%=student.getSage() %></td>
				<td><a href="QueryStudentBySnoServlet?sno=<%=student.getSno() %>">编辑</a> <a onClick="return confirm('删除后将无法恢复,确定要删除?')"  href="DeleteStudentServlet?sno=<%=student.getSno() %>" >删除</a> </td>
				
			</tr>
			<%
				}			
			%>
		
		</table>
			<a href="add.jsp">新增</a><br>
		<%
			if(p.getCurrentPage() ==p.getTotalPage()-1){ //尾页
		%>		
			<a href="QueryStudentByPage?currentPage=0">首页</a>
			<a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()-1%>">上一页</a>
		<% 
			}
			
			else if(p.getCurrentPage() ==0){//首页
				
		%>	
			<a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()+1%>">下一页</a>
			<a href="QueryStudentByPage?currentPage=<%=p.getTotalPage()-1%>">尾页</a>
		<%		
			}else{//中间
		%>		
			<a href="QueryStudentByPage?currentPage=0">首页</a>
			<a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()-1%>    ">上一页</a>
			<a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()+1%> ">下一页</a>
			<a href="QueryStudentByPage?currentPage=<%=p.getTotalPage()-1%>">尾页</a>
		
		<%			
			}
		
		%>
	
		<p>共<%=p.getTotalCount()%>条记录 当前<%=p.getCurrentPage()+1%>/<%=p.getTotalPage()%>页</p>
	</center>
</body>
</html>
		
			
