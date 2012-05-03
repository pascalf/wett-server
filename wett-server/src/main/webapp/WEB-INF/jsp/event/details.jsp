<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Event Overview</title>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet"
	type="text/css">
</head>

<body>
	<h1>Event ${event.name}</h1>
	<p>User for Event:
	<h3>Users</h3>
	<table border="1">
		<tr class="even">
			<th>Name</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.name}</td>
			</tr>
		</c:forEach>
	</table>
	<p>Games for Event:
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
		<c:forEach items="${games}" var="game" varStatus="status">
			<!--  <tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">-->
			<tr align="center">
				<td>${game.id}</td>
				<td><a href="<c:url value="/game/${game.id}/" />">${game.homeTeam}
						: ${game.awayTeam}</a></td>
				<td><c:if test="${game.resultHome == null}">-</c:if>${game.resultHome}
					: <c:if test="${game.resultAway == null}">-</c:if>${game.resultAway}</td>
				<td>${game.closingTime}</td>
				<td align="center"><jsp:useBean id="now" class="java.util.Date" />
					<c:choose>
						<c:when test="${game.closingTime gt now}">
							<form id="tipButton" class="textform" action="<c:url value="/tip/" />" method="post">
								<input type="submit" value="Tip" />
							</form>
						</c:when>
						<c:when test="${game.closingTime le now}">
							<img src="<c:url value="/resources/img/error.png" />"
								align="middle">expired</c:when>
					</c:choose></td>
			</tr>
		</c:forEach>
	</table>

</body>

</html>