<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Admin Main</title>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet" type="text/css">
</head>

<body>
	<h1>Admin Main</h1>
	<p>
		<a href="<c:url value="/admin/accounts/" />">Manage Account</a>
	<p>
		<a href="<c:url value="/admin/events/" />">Manage Events</a>
	<p>
</body>
</html>