

<!DOCTYPE HTML>
<html>
<head>

<title>Login</title>
<link type="text/css" rel="stylesheet" href="css/form-style.css">
<head>



</head>

</head>

<body onload="myFunction()">
<div id ="wrapper">
<div id ="header">
<h1>Hyresföreningen</h1>

</div>
</div>

<div id="container">
<br>





<form action="Servlet" method="post">  
<input type="hidden" name="Validation_txt" value="${VALID}"/>
Användarnamn:<br/><input type="text" name="_username"/><br/><br/>  
Lösenord:<br/><input type="password" name="_password"/><br/><br/> 
<br> <br> 
<input type="submit" value="login"/>  
</form>  


<div style="clear: both;"></div>


<p>${VALID}</p>
<p>

</p>



</div>



</body>


</html>