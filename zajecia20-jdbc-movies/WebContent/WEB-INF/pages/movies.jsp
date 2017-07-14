<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Baza filmów</title>
</head>
<body>
	<div>
		<form action="movies" method="post">
			<input type="hidden" name="action" value="add" />
			<table>
				<tr>
					<td>Podaj tytuł:</td>
					<td><input type="text" name="title" /></td>
				</tr>
				<tr>
					<td>Podaj rok produkcji:</td>
					<td><input type="text" name="year" /></td>
				</tr>
				<tr>
					<td>Podaj gatunek:</td>
					<td><input type="text" name="genre" /></td>
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
				<td>Tytuk</td>
				<td>Rok produkcji</td>
				<td>Gatunek</td>
			</tr>
			<c:forEach var="movie" items="${movies}">
				<tr>
					<td>${movie.title}</td>
					<td>${movie.year}</td>
					<td>${movie.genre}</td>
				</tr>
			</c:forEach>
		</table>
	</div>	
	
</body>
</html>