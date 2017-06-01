<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista osob</title>
</head>
<body>

	<div>
		<form action="person" method="post">
			<table>
				<tr>
					<td>Wpisz imie:</td>
					<td><input type="text" name="name"
						value="${param['name']}" />
				</tr>
				<tr>
					<td>Wpisz nazwisko:</td>
					<td><input type="text" name="secondname"
						value="${param['secondname']}" />
				</tr>
				<tr>
					<td>Wpisz wiek:</td>
					<td><input type="text" name="age" value="${param['age']}" />
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Dodaj" /></td>
				</tr>
			</table>
		</form>
	</div>

	<div>
		<table>
			<tr bgcolor="silver">
				<td onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';" onclick="document.location.href='person?orderBy=imie'">Imie</td>
				<td>Nazwisko</td>
				<td>Wiek</td>
			</tr>
			<c:forEach var="person" items="${persons}">
				<tr>
					<td>${person.name}</td>
					<td>${person.secondname}</td>
					<td>${person.age}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>