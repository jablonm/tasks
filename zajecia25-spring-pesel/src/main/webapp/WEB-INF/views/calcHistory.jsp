<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<div>
		<table>
			<tr>
				<td>Data</td>
				<td>Liczba pierwsza</td>
				<td>Liczba druga</td>
				<td>Liczba operator</td>
			</tr>
			<c:forEach var="h" items="${ history }">
				<tr>
					<td>${h.date}</td>
					<td>${h.l1}</td>
					<td>${h.l2}</td>
					<td>${h.operator}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>