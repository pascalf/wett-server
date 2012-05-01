<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Admin Modify Event</title>
<link href="../includes/style.css" rel="stylesheet" type="text/css">
</head>

<body>
	<h1>Event</h1>
	<p>
	<table border="1">
		<tr class="even">
			<th>Event Name</th>
		</tr>
	</table>
	<p>
	<p>
	<input name="save" type="submit" value="Save">
	<input name="cancel" type="button" value="Cancel"
            onClick="javascript:window.location='eventoverview.htm'">
	<p>
		<c:if test="${event != null}">
	Player in Event:<br>
			<p>
			<table border="1">
				<tr class="even">
					<th>Player Name</th>
				</tr>

				<c:forEach items="${model.playersForEvent}" var="player">
					<tr>
						<td>${player.name}</td>
					</tr>
				</c:forEach>

				<tr>
					<td><br></td>
				</tr>
				<tr class="even">
					<td><a href="modifyeventplayer.htm?eid=${event.id}">Add/Remove
							Players</a></td>
				</tr>
			</table>
		</c:if>
</body>
</html>