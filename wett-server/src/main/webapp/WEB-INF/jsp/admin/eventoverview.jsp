<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Admin Event Overview</title>
<link href="../includes/style.css" rel="stylesheet" type="text/css">
</head>

<body>
	<h1>Events</h1>
	<p>
	All existing Events in Database.<br>
	To add a new Event click on "Create new Event" at the bottom of the table. 
	<p>
	<table border="1">
		<tr class="even" align="center">
			<th>Event</th>
		</tr>
		<c:forEach items="${model.events}" var="event">
			<tr align="center">
				<td><a href="modifyevent.htm?eid=${event.id}">${event.name}</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td><br></td>
		</tr>
		<tr align="center" class="even">
			<td><a href="modifyevent.htm">Create new Event</a></td>
		</tr>
	</table>