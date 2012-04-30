<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Game Tip Overview</title>
<link href="includes/style.css" rel="stylesheet" type="text/css">
</head>

<body>
	<h1>
		Tip Overview for Event: <br>${model.event.name}
	</h1>

	<p>
	<p>
	<h3>Event</h3>

	<table border="1">
		<tr class="even" align="center">
			<th>Game ID</th>
			<th>Match</th>
			<th>Result</th>
			<th>Time till Close</th>
			<th>Tips</th>

		</tr>

		<c:forEach items="${model.gameTips}" var="gametip">
			<tr align="center">
				<td>${gametip.game.id}</td>
				<td>${gametip.game.homeTeam} : ${gametip.game.awayTeam}</td>
				<td><c:if test="${gametip.game.resultHome == null}">-</c:if>${gametip.game.resultHome}
					: <c:if test="${gametip.game.resultAway == null}">-</c:if>${gametip.game.resultAway}</td>
				<td>${gametip.game.closingTime}</td>
				<td>
					<table border="1">
						<tr align="center" class="even">
							<c:forEach items="${gametip.playerTips}" var="pt">
								<th>${pt.player.name}</th>
							</c:forEach>
						</tr>
						<tr align="center">
							<c:forEach items="${gametip.playerTips}" var="pt2">
								<td><c:if test="${pt2.tip.tipHome == null}">-</c:if>${pt2.tip.tipHome}
									: <c:if test="${pt2.tip.tipAway == null}">-</c:if>${pt2.tip.tipAway}
								</td>
							</c:forEach>
						</tr>
					</table>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>

</html>