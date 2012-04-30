<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Event Overview</title>
<link href="includes/style.css" rel="stylesheet" type="text/css">
</head>

<body>
<h1>Events</h1>

<p>

Games for Event ${model.event.name} :

<p>

<h3>Games</h3>

<table border="1">
<tr class="even" align="center">
			<th>Game ID</th>
			<th>Match</th>
			<th>Result</th>
			<th>Time till Close</th>
			<th>Tip</th>
			
		</tr>
		<c:forEach items="${model.games}" var="game" varStatus="status">
			<!--  <tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">-->
			<tr align="center">
				<td>${game.id}</td>
				<td>${game.homeTeam} : ${game.awayTeam}</td>
				<td><c:if test="${game.resultHome == null}">-</c:if>${game.resultHome} : <c:if test="${game.resultAway == null}">-</c:if>${game.resultAway}</td>
				<td>${game.closingTime}</td>
				<jsp:useBean id="now" class="java.util.Date"/>
				<c:if test="${game.closingTime gt now}"><td>Tip</td></c:if>
			</tr>
		</c:forEach>
</table>

</body>

</html>