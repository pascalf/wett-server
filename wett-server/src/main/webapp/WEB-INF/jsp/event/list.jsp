<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Event List</title>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet" type="text/css">
</head>

<body>
<h1>Events</h1>

<p>

All available Events:

<p>

<h3>Events</h3>

<table border="1">
<tr class="even">
			<th>Name</th>
			
		</tr>
		<c:forEach items="${events}" var="event" varStatus="status">
			<!--  <tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">-->
			<tr>
				<td><a href="<c:url value="/event/${event.id}/"  />">${event.name}</a></td>
				
			</tr>
		</c:forEach>
</table>

</body>

</html>