<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理试题</title>
</head>
<body>
	<center>
		<table>
			<tr>
				<td><input id="conAddBtn" type="button" value="增加试题" /></td>

				<td><input id="conUpdateBtn" type="button" value="更新试题" /></td>

				<td><input id="conDeleteBtn" type="button" value="删除试题" /></td>

				<td><input id="conSelectBtn" type="button" value="查询试题" /></td>
			</tr>
		</table>
	</center>
	<hr />
	<form action="<%=request.getContextPath() %>/content/delete" method="post">
		<a
			href="<%=request.getContextPath()%>/pages/jsp/content/contentAdd.jsp">增加试题</a>

			
		<a href="<%=request.getContextPath()%>/content/selectall">获取所有</a>
		<input type="submit" value="批量刪除" />
		<hr />
		<center>

			<table>
				<tr>
					<td>勾选项</td>
					<td>试题序号</td>
					<td>试题内容</td>
					<td>选项A</td>
					<td>选项B</td>
					<td>选项C</td>
		 			<td>选项D</td>
					<td>正确答案</td>
				</tr>
				<c:forEach var="cot" items="${list}">
					<tr>
						<td><input type="checkbox" name="ids" value="${cot.getId()}" /></td>
						<td><a
							href="<%= request.getContextPath()%>/content/select/${cot.getId()}">${cot.getId()}</a></td>
						<td>${cot.getTest()}</td>
						<td>${cot.getA()}</td>
						<td>${cot.getB()}</td>
						<td>${cot.getC()}</td>
						<td>${cot.getD()}</td>
						<td>${cot.getAnswer()}</td>
						<td><a
							href="<%= request.getContextPath()%>/content/delete/${cot.getId()}">删除</a>
							<a href="<%=request.getContextPath()%>/content/update/${cot.getId()}">更新试题</a>
							</td>
					</tr>
				</c:forEach>
			</table>
		</center>
	</form>
</body>
</html>