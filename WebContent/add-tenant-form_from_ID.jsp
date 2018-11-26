<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>

<title>Lägg till Hyresgäst</title>
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
<h2>Lägg till hyresgäst</h2>

</div>
</div>

<div id="container">


<form action ="Servlet" method="GET">
<input type="hidden" name="command" value="ADD"/>
<input type="hidden" name="Empty_A_ID" value="${THE_APARTMENT}"/>
<input type="hidden" name="todays_date" value="${DATE}"/>

<table>
<tbody>
<tr>

<tr><td><label>Lägenhetsnummer</label></td>
<td><input type="text" name="apartmentNumber" value ="${THE_APARTMENT}"/></td></tr>
<tr><td><label>Förnamn</label></td>
<td><input type="text" name="firstName"></td></tr>
<tr><td><label>Efternamn</label></td>
<td><input type="text" name="lastName"></td></tr>
<tr><td><label>Personnummer</label></td>
<td><input type="text" name="ss_number"></td></tr>
<tr><td><label>Mobil</label></td>
<td><input type="text" name="mobile"></td></tr>
<tr><td><label>Email</label></td>
<td><input type="text" name="email"></td></tr>
<tr><td><label>Inflyttad</label></td>
<td><input type="text" name="_from" value = "${DATE}"></td></tr>
<tr><td><label>Noteringar</label></td>
<td><input type="text" name="notes"></td></tr>
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