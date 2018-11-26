<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>

<title>Uppdatera Hyresgäst</title>
<link type="text/css" rel="stylesheet" href="css/form-style.css">

</head>


<body>
<div id ="wrapper">
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
<h2>Uppdatera hyresgäst</h2>

<form action ="Servlet" method="GET">

<input type="hidden" name="command" value="UPDATE"/>
<input type="hidden" name="tenantID" value="${THE_TENANT.id}"/>

<table>
<tbody>
<tr>
<td><label>Lägenhetsnummer</label></td>
<td><input type="text" name="apartmentNumber" value ="${THE_TENANT.apartmentNumber}"/></td></tr>
<tr><td><label>Förnamn</label></td>
<td><input type="text" name="firstName" value ="${THE_TENANT.firstName}"/></td></tr>
<tr><td><label>Efternamn</label></td>
<td><input type="text" name="lastName" value ="${THE_TENANT.lastName}"/></td></tr>
<tr><td><label>Personnummer</label></td>
<td><input type="text" name="ss_number" value ="${THE_TENANT.ss_number}"/></td></tr>

<tr><td><label>Mobil</label></td>
<td><input type="text" name="mobile" value ="${THE_TENANT.mobile}"/></td></tr>
<tr><td><label>Email</label>
<td><input type="text" name="email" value ="${THE_TENANT.email}"/></td></tr>
<tr><td><label>Inflytt</label></td>
<td><input type="text" name="_from" value ="${THE_TENANT._from}"/></td></tr>
<tr><td><label>T.o.m.</label></td>
<td><input type="text" name="_until" value ="${THE_TENANT._until}"/></td></tr>
<tr><td><label>Noteringar</label></td>
<td><input type="text" name="notes" value ="${THE_TENANT.notes}"/></td></tr>


<tr>
<td><label></label></td>
<td><input type="submit" value="Spara" /></td>
</tr>





</tbody>


</table>
</form>
<div style="clear: both;"></div>




</div>



</body>


</html>