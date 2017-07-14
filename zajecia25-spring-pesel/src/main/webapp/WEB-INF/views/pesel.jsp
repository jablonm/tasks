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
		<form action="execute" method="get">
			<table>
				<tr>
					<td>Podaj pesel:</td>
					<td><input type="text" name="l1" value="${param['pesel']}" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Sprawdz" /></td>
				</tr>
			</table>
		</form>
		<c:if test="${pesel!=null}">
			<font color="green">${pesel}</font>
		</c:if>
	</div>
</body>
</html>