<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css">
<script src="static/js/jquery-3.2.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista osob</title>
</head>
<body>
	<div class="container">
		<form action="person" method="post">
			<input type="hidden" name="action" value="add" />
			<div class="form-group">
				<label for="name">Wpisz imie:</label> <input type="text" class="form-control" id="name" name="name" value="${param['name']}" />
			</div>
			<div class="form-group">
				<label for="secondname">Wpisz nazwisko:</label> <input type="text" class="form-control" id="secondname" name="secondname"
					value="${param['secondname']}" />
			</div>
			<div class="form-group">
				<label for="age">Wpisz wiek:</label> <input class="form-control" type="text" name="age" id="age" value="${param['age']}" />
			</div>
			<button type="submit" class="btn btn-default">Dodaj</button>
		</form>
		<c:if test="${onError!=null}">
			<div class="panel panel-danger">
				<div class="panel-heading">Podano nieprawidlowe wartosci</div>
				<div class="panel-body">${onError}</div>
			</div>
		</c:if>
		<table class="table">
			<thead>
				<tr>
					<th onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
						onclick="document.location.href='person?orderBy=imie'">Imie</th>
					<th onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
						onclick="document.location.href='person?orderBy=nazw'">Nazwisko</th>
					<th onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
						onclick="document.location.href='person?orderBy=wiek'">Wiek</th>
					<th>Akcja</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="person" items="${persons}">
					<tr>
						<td>${person.name}</td>
						<td>${person.secondname}</td>
						<td>${person.age}</td>
						<td>
							<form action="person" method="post">
								<input type="hidden" name="id" value="${person.id}" /> <input type="hidden" name="action" value="delete" />
								<button type="submit" class="btn btn-danger btn-sm">Usun</button>
								<button type="button" data-toggle="modal" data-target="#personEdit_${person.id}" class="btn btn-primary btn-sm">Edytuj</button>
							</form>
							<div id="personEdit_${person.id}" class="modal fade" role="dialog">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">Dane Osoby</h4>
										</div>
										<div class="modal-body">
											<form action="person" method="post">
												<input type="hidden" name="id" value="${person.id}" />
												<input type="hidden" name="action" value="edit" />
												<div class="form-group">
													<label for="name_edit">Wpisz imie:</label> <input type="text" class="form-control" id="name_edit" name="name"
														value="${person.name}" />
												</div>
												<div class="form-group">
													<label for="secondname_edit">Wpisz nazwisko:</label> <input type="text" class="form-control" id="secondname_edit"
														name="secondname" value="${person.secondname}" />
												</div>
												<div class="form-group">
													<label for="age_edit">Wpisz wiek:</label> <input class="form-control" type="text" name="age" id="age_edit"
														value="${person.age}" />
												</div>
												<button type="submit" class="btn btn-default btn-sm">Zapisz</button>
											</form>
										</div>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>