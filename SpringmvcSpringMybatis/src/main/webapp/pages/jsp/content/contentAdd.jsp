<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>增加试题</center>
	<hr />
	<center>
		<form action="<%=request.getContextPath()%>/content/add" method="post">
			<table>
				<tr>
					<td>test:<input id="test" name="test" type="text" />
					</td>
				</tr>
				<tr>
					<td>A:<input id="A" name="A" type="text" />
					</td>
				</tr>
				<tr>
					<td>B:<input id="B" name="B" type="text" />
					</td>
				</tr>
				<tr>
					<td>C:<input id="C" name="C" type="text" />
					</td>
				</tr>
				<tr>
					<td>D:<input id="D" name="D" type="text" />
					</td>
				</tr>
				<tr>
					<td>Answer:<input id="Answer" name="Answer" type="text" />
					</td>
				</tr>
				<tr>
					<td><input id="submit" name="submit" type="submit" value="增加" /><input
						id="reset" name="reset" type="reset" value="取消" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>