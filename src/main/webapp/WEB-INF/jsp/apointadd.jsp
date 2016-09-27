<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/head.jsp"%>
<%@include file="common/tag.jsp"%>
<html>
<body>
	<form method="post" action="<%=basePath%>book/${book.bookId}/appoint">
	<table border="1">
		<tr>
			<td>名称</td>
			<td>${book.name}</td>
		</tr>
		<tr>
			<td>学生Id</td>
			<td><input type="text" name="studentId" /></td>
		</tr>
	</table>
	<input type="submit" value="现在预约"/>|<input type="button" value="返回列表" onclick="javascript: document.location.href='<%=basePath%>book/list';"/>
	</form>
</body>
</html>