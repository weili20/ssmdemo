<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/head.jsp"%>
<%@include file="common/tag.jsp"%>
<html>
<body>
	<table border="1">
		<tr>
			<td>图书ID</td><td>${book.bookId}</td>
		</tr>
		<tr>
			<td>图书名称</td><td>${book.name}</td>
		</tr>
		<tr>
			<td>馆藏数量</td><td>${book.number}</td>
		</tr>
	</table>
	<br>
	<a href="<%=basePath%>book/list">返回列表</a>
</body>
</html>