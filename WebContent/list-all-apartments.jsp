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
<c:url var="list_tenant" value="Servlet"> 
<c:param name="command" value="LIST"/>
</c:url>
<c:url var="list_empty_apartments" value="Servlet"> 
<c:param name="command" value="LIST_EMPTY_A"/>
</c:url>
<div style="clear: both;"></div>
<p><a href="${list_tenant}"> Visa hyresgäster </a>|<a href="${list_empty_apartments}"> Lediga lägenheter </a></p>
<h2>Alla Lägenheter</h2>
</div>
</div>
<div id="container">
<div id ="content">

 
<table>
<tr>

<th>Stad</th>
<th>Adress </th>
<th>Postnummer </th>
<th>Storlek </th>
<th>Rum  </th>
<th>Våning  </th>
<th>Hyra </th>
<th>ID_NR </th>
<th>Modifiera</th>
</tr>



<c:forEach var="tempA" items="${A_LIST}">

<c:url var="tempLink" value="Servlet"> 
<c:param name="command" value="LOAD_A"/>
<c:param name="A_ID" value="${tempA.id}"/>
<c:param name="from" value="all_a"/></c:url> 

<c:url var="details" value="Servlet"> 
<c:param name="command" value="INFO_APARTMENT"/>
<c:param name="A_ID" value="${tempA.id}"/>
</c:url> 

<tr>

<td>${tempA.city}</td>
<td>${tempA.address}</td>
<td>${tempA.postal_code}</td>
<td>${tempA.size}</td>
<td>${tempA.rooms}</td>
<td>${tempA.floor}</td>
<td>${tempA.rent}</td>
<td>${tempA.id}</td>

<td> <a href="${tempLink}"> Ändra</a> | <a href="${details}"> Info </a> </td>
</tr>



</c:forEach>


</table>


</div>


</div>



</body>


</html>