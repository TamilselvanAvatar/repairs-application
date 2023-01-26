<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
<link rel ="icon" type ="image/x-icon" href = "/resources/images/techIcon.jfif" >
<link rel="stylesheet" href="/resources/style/searchresults.css">
</head>
<body>
	<div id="container">
		<div id="content">
			<h1 id="tech-list">${alert}</h1>
			<table>
				<tr>

					<th>TechnicianName</th>
					<th>TechnicianRating</th>
					<th>Skill</th>
					<th>Location</th>
					<th>Rate</th>
				</tr>
				<!-- loop over and print our packages -->
				<c:forEach var="pack" items="${list}">
					<tr>

						<td>${pack.technicianName}</td>
						<td>${pack.technicianRating}</td>
						<td>${pack.technicianSkill}</td>
						<td>${pack.technicianLocation}</td>
						<td>${pack.technicianPay}</td>
						<td>
							<%
								String str = (String) session.getAttribute("select");
							if (str.equalsIgnoreCase("Select")) {
							%> 
							<a
							href="/request?technicianName=<c:out value="${pack.technicianName}"/> "
							class="s-btn">${select}</a>
							<%
 							}
 							if (str.equals("selected")) {
 							%>
							<p style="ackground: aliceblue;"></p> 
							<%
 							}
 							%>
						</td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div id="btn">
		<button type="button" onclick="location.href='/menu/sort'"
			id="SortbyRate">SortbyRate</button>
		<button type="button" onclick="location.href='/back'" id="Back">Home</button>
	</div>
</body>
</html>