<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kalkulator</title>
</head>
<body>
	<div>
		<form action="calc" method="get">
			<table>
				<tr>
					<td>Wpisz liczbe</td>
					<td><input type="text" name="n1" value="${param['n1']}"/></td>
				</tr>
				<tr>
					<td>Wpisz liczbe</td>
					<td><input type="text" name="n2" value="${param['n2']}"/></td>
				</tr>
				<tr>
					<td>Wybierz operator</td>
					<td><select name="operator">
							<option>+</option>
							<option>-</option>
							<option>*</option>
							<option>/</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Oblicz" /></td>
				</tr>
			</table>
		</form>
		<c:if test="${result!=null}">
			<font color="green">${result}</font>
		</c:if>
		<c:if test="${hasError}">
			<font color="red">${errorMessage}</font>
		</c:if>
	</div>
</body>
</html>