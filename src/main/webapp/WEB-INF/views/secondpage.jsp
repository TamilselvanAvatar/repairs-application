<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Technician Page</title>
<link rel ="icon" type ="image/x-icon" href = "/resources/images/techIcon.jfif" >
<link rel="stylesheet" href="/resources/style/secondpage.css">
</head>
<body>
	<header>
		<nav>
			Welcome <span style="color: red; text-transform: capitalize;">${name}</span>
			<button class="nav1" type="button" onclick="location.href='/profile'"
				value="Profile">Profile</button>
			<button class="nav2" type="button" onclick="location.href='/logout'"
				value="Logout">Logout</button>
		</nav>
	</header>


	<form action="menu" method="post">
		<table id="tb3">
			<tr>
				<td><label>Required Service</label></td>
				<td><input type="text" id="service" name="techSkill"
					pattern="[a-zA-Z]{5,0}" required="required" /></td>
			</tr>
			<tr>
				<td><label>Rate</label></td>
				<td><input type="number" id="rate" name="techRate"
					pattern="[0-9]*" required="required" /></td>
			</tr>

			<tr>
				<td><button type="reset" id="res" class="f-btn">Clear</button></td>
				<td><button type="submit" id="sub" class="f-btn">Search</button></td>
			</tr>
		</table>
	</form>
	<footer>
		<p>Copyright &copy; 2020</p>
	</footer>
</body>
</html>