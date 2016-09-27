<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/head.jsp"%>
<%@include file="common/tag.jsp"%>
<html>
<body>
	<table border="1">
		<tr>
			<td>图书ID</td>
			<td>图书名称</td>
			<td>馆藏数量</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="book">
			<tr>
				<td>${book.bookId}</td>
				<td>${book.name}</td>
				<td>${book.number}</td>
				<td><a href="<%=basePath%>book/${book.bookId}/detail">查看明细</a>|<a href="<%=basePath%>book/${book.bookId}/appoint/add">预约此书</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>