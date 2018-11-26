<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>

<title>Uppdatera Lägenhet</title>
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
<h2>Uppdatera Lägenhet - ${THE_E_APARTMENT.address}, ${THE_E_APARTMENT.postal_code} ${THE_E_APARTMENT.city}</h2>


<form action ="Servlet" method="GET">

<input type="hidden" name="command" value="UPDATE_APARTMENT"/>
<input type="hidden" name="A_ID" value="${THE_E_APARTMENT.id}"/>
<input type="hidden" name="from" value="${FROM}"/>




<table>
<tbody>

<tr><td><label>Hyra</label></td>
<td><input type="text" name="rent" value ="${THE_E_APARTMENT.rent}"/></td></tr>
<tr><td><label>Bofond</label></td>
<td><input type="text" name="bofond" value ="${THE_E_APARTMENT.bofond}"/></td></tr>
<tr><td><label>Kylbyte datum</label></td>
<td><input type="text" name="fridge" value ="${THE_E_APARTMENT.fridge}"/></td></tr>
<tr><td><label>Frysbyte datum</label></td>
<td><input type="text" name="freezer" value ="${THE_E_APARTMENT.freezer}"/></td></tr>
<tr><td><label>Spisbyte datum</label></td>
<td><input type="text" name="stove" value ="${THE_E_APARTMENT.stove}"/></td></tr>
<tr><td><label>Noteringar</label></td>
<td><input type="text" name="notes" value ="${THE_E_APARTMENT.a_notes}"/></td></tr>





<tr>
<td><label></label></td>
<td><input type="submit" value="Spara" /></td>
</tr>





</tbody>


</table>
</form>
<div style="clear: both;"></div>

<h3>${ERROR_MESS}</h3>

</div>



</body>


</html>