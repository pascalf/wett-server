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
		Tip Overview for Game: <br>${model.game.homeTeam} -
		${model.game.awayTeam}
	</h1>

	<p>
	<p>
	<h3>Game</h3>

	<table border="1">
		<tr class="even" align="center">
			<th>Game ID</th>
			<th>Match</th>
			<th>Result</th>
			<th>Time till Close</th>
			<th>Tips</th>

		</tr>
		<!--  <tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">-->
		<tr align="center">
			<td>${model.game.id}</td>
			<td>${model.game.homeTeam} : ${model.game.awayTeam}</td>
			<td><c:if test="${model.game.resultHome == null}">-</c:if>${model.game.resultHome}
				: <c:if test="${model.game.resultAway == null}">-</c:if>${model.game.resultAway}</td>
			<td>${model.game.closingTime}</td>
			<td>
				<table border="1">
					<tr align="center" class="even">
						<c:forEach items="${model.playerTips}" var="pt">
							<th>${pt.player.name}</th>
						</c:forEach>
					</tr>
					<tr align="center">
						<c:forEach items="${model.playerTips}" var="pt2">
							<td><c:if test="${pt2.tip.tipHome == null}">-</c:if>${pt2.tip.tipHome}
								: <c:if test="${pt2.tip.tipAway == null}">-</c:if>${pt2.tip.tipAway}
							</td>
						</c:forEach>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</body>

</html>