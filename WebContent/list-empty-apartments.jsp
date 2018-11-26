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
<c:url var="list_all_apartments" value="Servlet"> 
<c:param name="command" value="LIST_A"/>
</c:url>
<div style="clear: both;"></div>
<p><a href="${list_tenant}"> Visa hyresgäster </a>|<a href="${list_all_apartments}"> Alla lägenheter </a></p>
<h2>Lediga Lägenheter</h2>
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



<c:forEach var="tempEmptyA" items="${EMPTY_A_LIST}">

<c:url var="tempLink" value="Servlet"> 
<c:param name="command" value="LOAD_A"/>
<c:param name="A_ID" value="${tempEmptyA.id}"/>
<c:param name="from" value="empty_a"/>



</c:url> 

<c:url var="details" value="Servlet"> 
<c:param name="command" value="INFO_APARTMENT"/>
<c:param name="A_ID" value="${tempEmptyA.id}"/>

</c:url> 
<c:url var="add_tenant" value="Servlet"> 
<c:param name="command" value="ADD_FROM_ID"/>
<c:param name="emptyA_ID" value="${tempEmptyA.id}"/>
</c:url> 




<tr>

<td>${tempEmptyA.city}</td>
<td>${tempEmptyA.address}</td>
<td>${tempEmptyA.postal_code}</td>
<td>${tempEmptyA.size}</td>
<td>${tempEmptyA.rooms}</td>
<td>${tempEmptyA.floor}</td>
<td>${tempEmptyA.rent}</td>
<td>${tempEmptyA.id}</td>
<td> <a href="${tempLink}"> Ändra</a> | <a href="${details}"> Info </a>| <a href="${add_tenant}"> Hyr ut </a></td>
</tr>



</c:forEach>


</table>


</div>


</div>



</body>


</html>