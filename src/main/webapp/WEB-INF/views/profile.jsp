<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
<link rel ="icon" type ="image/x-icon" href = "/resources/images/techIcon.jfif" >
<link rel="stylesheet" href="/resources/style/profile.css">
<script type="text/javascript">
	function show(shown, hidden) {
		document.getElementById(shown).style.visibility = 'visible';
		document.getElementById(hidden).style.visibility = 'hidden';
		return false;
	}
	function checkingdelete() {
		if (confirm("Are you sure want to delete ?")) {
			location.href = '/delete';
		} else {
			location.href = '/profile';
		}
	}
</script>
</head>
<body>
	<h4>
		Profile of <span>${name}</span>
	</h4>

	<table id="tb">
		<tr>
			<td>
				<table id="tb1">
					<tr>
						<td><label class="label">Name</label></td>
						<td>: ${name}</td>
					</tr>
					<tr>
						<td><label class="label">Gender</label></td>
						<td>: ${gender}</td>
					</tr>
					<tr>
						<td><label class="label">Contact Number</label></td>
						<td>: ${phoneNumber}</td>
					</tr>
					<tr>
						<td><label class="label">Current Location</label></td>
						<td>: ${location}</td>
						<td id="edit">${edit}</td>
					</tr>
					<tr>
						<td><button type="button" class="btn" id="delete"
								onclick="return checkingdelete()">Delete account</button></td>
						<td><button type="button" class="btn" id="edited"
								onclick="return show('tb2','edit')">Edit</button></td>
					</tr>
				</table>
			</td>
			<td><img src="/resources/images/img.png"
				alt="Nothing to display"></td>
		</tr>
	</table>
	<table id="tb2" style="visibility: hidden;">
		<tr>
			<td><form action="edit" method="post">
					<%-- <%
						String custName = request.getParameter("name");
						String custPhone = request.getParameter("phoneNumber");
						session.setAttribute("custName", custName);
						session.setAttribute("custPhone", custPhone);
					%> --%>
					<label class="label">Location:</label> <input type="text"
						name="editLocation" pattern="[a-zA-Z]{3,}" required="required"
						title="Please enter valid Location">
					<button type="submit" value="submit" class="btn">Submit</button>
				</form></td>
		</tr>
	</table>

</body>
</html>