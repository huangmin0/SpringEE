<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>修改试题</center>
	<hr />
	<center>
		<form action="/SpringmvcSpringMybatis/content/updateAll" method="post">
			<input id="id" type="hidden" name="id" value="${cot.getId()}">
			<table>
				<tr>
					<td><span>test：</span></td>
					<td><input id="test" name="test" type="text"
						value="${cot.getTest()}" /></td>
				</tr>
				<tr>
					<td><span>A：</span></td>
					<td><input id="A" name="A" type="text"
						value="${cot.getA()}" /></td>
				</tr>
				<tr>
					<td><span>B：</span></td>
					<td><input id="B" name="B" type="text"
						value="${cot.getB()}" /></td>
				</tr>
				<tr>
					<td><span>C：</span></td>
					<td><input id="C" name="C" type="text"
						value="${cot.getC()}" /></td>
				</tr>
				<tr>
					<td><span>D：</span></td>
					<td><input id="D" name="D" type="text"
						value="${cot.getD()}" /></td>
				</tr>
				<tr>
					<td><span>Answer：</span></td>
					<td><input id="Answer" name="Answer" type="text"
						value="${cot.getAnswer()}" /></td>
				</tr>
			
				<tr>
					<td colspan="2"><input type="submit" value="保存" /> <input
						type="reset" value="取消" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>