<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Game Administration</title>
<link href="../includes/style.css" rel="stylesheet" type="text/css">
</head>

<body>
	<h1>
		Game Administration
	</h1>
	
	Now : ${model.now}
	

<table border="1">
<tr class="even">
<th>Home Team</th>
<th>Away Team</th>
<th>Result<br>Home : Away</th>
<th>Closing Time</th>
</tr>
</table>
	
	
</body>
</html>