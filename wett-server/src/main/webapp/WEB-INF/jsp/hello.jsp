<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<style type="text/css">
.even {
	background-color: silver;
}
</style>

<html>
  <head><title>Hello :: Spring Application</title></head>
  <body>
    <h1>Hello - Spring Application</h1>
    <p>Greetings, it is now <c:out value="${model.now}"/></p>
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