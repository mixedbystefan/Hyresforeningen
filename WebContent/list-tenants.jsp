<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>

<head>
	<title>Hyresgast_app</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
	
	
	
</head>

<body>

<div id="wrapper">
<div id ="header">
<c:url var="list_empty_apartments" value="Servlet"> 
<c:param name="command" value="LIST_EMPTY_A"/>
</c:url>
<c:url var="list_all_apartments" value="Servlet"> 
<c:param name="command" value="LIST_A"/>
</c:url>
<div style="clear: both;"></div>
<p><a href="${list_empty_apartments}"> Lediga Lägenheter </a>|<a href="${list_all_apartments}"> Alla lägenheter </a></p>
<h2>Hyresgäster</h2>
</div>
</div>
<div id="container">
<div id ="content">

<table>
<tr>

<th>Förnamn </th>
<th>Efternamn  </th>
<th>Adress </th>
<th>Postnummer  </th>
<th>Stad  </th>
<th>Mobilnummer </th>
<th>Modifiera</th>
</tr>

<c:forEach var="tempTenant" items="${TENANT_LIST}">

<c:url var="tempLink" value="Servlet"> 
<c:param name="command" value="LOAD"/>
<c:param name="tenantID" value="${tempTenant.id}"/>
</c:url> 

<c:url var="deleteLink" value="Servlet"> 
<c:param name="command" value="DELETE"/>
<c:param name="tenantID" value="${tempTenant.id}"/>


</c:url> 

<tr>

<td>${tempTenant.firstName}</td>
<td>${tempTenant.lastName}</td>
<td>${tempTenant.address}</td>
<td>${tempTenant.postal_code}</td>
<td>${tempTenant.city}</td>

<td>${tempTenant.mobile}</td>





<td> <a href="${tempLink}"> Uppdatera</a> | <a href="${deleteLink}" 
onclick="if (!(confirm('Är du säker på att du vill radera hyresgästen?'))) return false"> Radera</a></td>


</tr>

</c:forEach>


</table>



</div>


</div>

</body>


</html>