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

</div>
</div>
<div id="container">
<div id ="content">

<c:set var="infoA" value="${INFOAPARTMENT[0]}"/>

<h2> ${infoA.address}, ${infoA.postal_code}, ${infoA.city} </h2>

<c:choose> <c:when test = "${infoA.house_number==1}"><img src="Images/house01.png" align="middle"></c:when>
<c:otherwise> <img src="Images/house02.png" align="middle"> </c:otherwise></c:choose>

<p> Lägenhetsnummer: ${infoA.apartmentNumber} </p>
<br>
<p>Noteringar: ${infoA.a_notes} </p>
<br><br>
<h4>Specifikation</h4>
<table>
<tr>


<th>Hyra</th>
<th>Bofond</th>
<th>Storlek </th>
<th>Rum </th>
<th>Balkong </th>
<th>Förråd </th>
<th>Bastu </th>
<th>Gym </th>
<th>Hiss </th>
</tr>





<c:url var="tempLink" value="Servlet"> 
<c:param name="command" value="INFOAPARTMENT"/>
<c:param name="A_ID" value="${InfoA.id}"/>
</c:url> 


<tr>

<td>${infoA.rent}</td>
<td>${infoA.bofond}</td>
<td>${infoA.size}</td>
<td>${infoA.rooms}</td>
<td><c:choose> <c:when test = "${infoA.balcony}"> Ja</c:when>
<c:otherwise> Nej </c:otherwise></c:choose></td>
<td><c:choose> <c:when test = "${infoA.storage_room}"> Ja</c:when>
<c:otherwise> Nej </c:otherwise></c:choose></td>
<td><c:choose> <c:when test = "${infoA.sauna}"> Ja</c:when>
<c:otherwise> Nej </c:otherwise></c:choose></td>
<td><c:choose> <c:when test = "${infoA.gym}"> Ja</c:when>
<c:otherwise> Nej </c:otherwise></c:choose></td>
<td><c:choose> <c:when test = "${infoA.elevator}"> Ja</c:when>
<c:otherwise> Nej </c:otherwise></c:choose></td>


</tr>






</table>

<br>
<h4>Inventarie-byten</h4>
<table>
<tr>


<th>Kylskåp</th>
<th>Frys </th>
<th>Spis/Ugn </th>

</tr>
<tr>

<td>${infoA.fridge}</td>
<td>${infoA.freezer}</td>
<td>${infoA.stove}</td>



</tr>






</table>

<br>
<h4>Hyresgäster</h4>
<table>
<tr>


<th>Namn</th>
<th>Efternamn </th>
<th>Personnummer </th>
<th>Mobil </th>
<th>Flyttade in </th>
<th>Status </th>
</tr>



<c:forEach var="infoA" items="${INFOAPARTMENT}">

<c:url var="tempLink" value="Servlet"> 
<c:param name="command" value="INFOAPARTMENT"/>
<c:param name="A_ID" value="${InfoA.id}"/>
</c:url> 


<tr>

<td>${infoA.firstName}</td>
<td>${infoA.lastName}</td>
<td>${infoA.ss_number}</td>
<td>${infoA.mobile}</td>
<td>${infoA._from}</td>
<td><c:choose> <c:when test = "${infoA._until==null}">Nuvarande hyresgäst</c:when>
<c:otherwise> flyttade ut ${infoA._until} </c:otherwise></c:choose></td>


</tr>





</c:forEach>
</table>



















</div>



</div>

</body>


</html>