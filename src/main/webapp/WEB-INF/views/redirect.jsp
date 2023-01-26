<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login message</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<link rel ="icon" type ="image/x-icon" href = "/resources/images/cross.png" >

<style>

.container{
margin-top : 10% 

}
.alert{
text-align: center;
}

</style>

</head>
<body>
	<div class = "container">
		<div class="alert alert-danger" style="font-style: italic; color: blue;">${name}<a
				href="/redierctfirst" style="text-decoration: none; color: red;">${msg}</a>
		</div>	
	</div>
</body>
</html>