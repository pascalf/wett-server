<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Account Overview</title>
<link href="includes/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>Hello - Spring Application</h1>
	<p>
		Greetings, it is now
		<c:out value="${model.now}" />
	</p>
	<h3>Accounts</h3>
	<table>
		<tr class="even">
			<th>ID</th>
			<th>Name</th>
		</tr>
		<c:forEach items="${model.accounts}" var="account" varStatus="status">
			<tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">
				<td>${account.id}</td>
				<td>${account.name}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>