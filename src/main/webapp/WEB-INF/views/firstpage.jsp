<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FixApps</title>

<link rel="icon" type="image/x-icon"
	href="/resources/images/techIcon.png">

<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 -->

<link rel="stylesheet" href="/resources/style/firstpage.css">
<script src="/resources/js/firstpage.js"></script>
</head>
<body>
	<header>
		<nav>
			Welcome to FixApps
			<button class="nav1" onclick="return show('tb1','tb2')">Register</button>
			<button class="nav2" onclick="return show('tb2','tb1')">Login</button>
		</nav>
	</header>
	<div class="container">
		<div class="content">
			<table id="tb1">
				<f:form action="register" modelAttribute="customerModel">
					<tr>
						<td><label>Name</label></td>
						<td><f:input id="name" type="text" path="customerName" /></td>
						<td><div>${nam}</div></td>
					</tr>
					<tr>
						<td><label>Phone Number</label></td>
						<td><f:input id="number" type="text" path="customerPhone" /></td>
						<td><div>${num}</div></td>
					</tr>

					<tr>
						<td><label>Location</label></td>
						<td><f:input id="location" type="text"
								path="customerLocation" /></td>
						<td><div>${loc}</div></td>
					</tr>
					<tr>
						<td><label>Gender</label></td>
						<td><f:radiobutton name="gender" value="Male"
								path="customerGender"  /> Male <f:radiobutton name="gender"
								value="Female" path="customerGender" />Female</td>
						<td><div>${gender}</div></td>
					</tr>
					<tr>
						<td><button type="reset" id="reset" class="f-btn">Clear</button></td>
						<td><button type="submit" id="submit" class="f-btn">Register</button></td>
					</tr>
					<tr>
						<td><div>${msg}</div></td>
						<td><div></div></td>
					</tr>
				</f:form>

			</table>

		</div>
	</div>
	<div class="container">
		<div class="content">
			<form action="login" method="POST">
				<table id="tb2" style="display: none;">
					<tr>
						<td><label>User Name</label></td>
						<td><input type="text" id="customername" name="customerName"
							pattern="[a-zA-Z\s]{3,}" required="required" /></td>
					</tr>
					<tr>
						<td><label>Password</label></td>
						<td><input type="password" id="customerphone"
							name="customerPhone" pattern="[6-9]{1}[0-9]{9}"
							required="required" /></td>
					</tr>
					<tr>
						<td><button type="reset" id="res" class="f-btn">Clear</button></td>
						<td><button type="submit" id="sub" class="f-btn">Login</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<footer>
		<p>Copyright &copy; 2021</p>
	</footer>
</body>
</html>