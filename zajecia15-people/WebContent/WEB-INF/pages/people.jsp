<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
			<input type="hidden" name="action" value="add" />
			<table>
				<tr>
					<td>Wpisz imie:</td>
					<td><input type="text" name="name" value="${param['name']}" /></td>
				</tr>
				<tr>
					<td>Wpisz nazwisko:</td>
					<td><input type="text" name="secondname" value="${param['secondname']}" /></td>
				</tr>
				<tr>
					<td>Wpisz wiek:</td>
					<td><c:if test="${onError!=null}">
							<input style="border: 1px solid; border-color: red;" type="text" name="age" value="${param['age']}" />
							${onError}
						</c:if> <c:if test="${onError==null}">
							<input type="text" name="age" value="${param['age']}" />
						</c:if></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Dodaj" /></td>
				</tr>
			</table>
		</form>
	</div>

	<div>
		<table>
			<tr bgcolor="silver">
				<td onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
					onclick="document.location.href='person?orderBy=imie'">Imie</td>
				<td onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
					onclick="document.location.href='person?orderBy=nazw'">Nazwisko</td>
				<td onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
					onclick="document.location.href='person?orderBy=wiek'">Wiek</td>
				<td>Akcja</td>
			</tr>
			<c:forEach var="person" items="${persons}">
				<tr>
					<td>${person.name}</td>
					<td>${person.secondname}</td>
					<td>${person.age}</td>
					<td>
						<form action="person" method="post">
							<input type="hidden" name="id" value="${person.id}" /> 
							<input type="hidden" name="action" value="delete" /> 
							<input type="submit" value="usun" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>