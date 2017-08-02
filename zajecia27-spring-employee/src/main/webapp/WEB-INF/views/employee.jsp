<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista produktow</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>


	<div class="container">
		<h2>Podaj dane:</h2>
		<form:form cssClass="form-horizontal" action="addProduct" method="post" commandName="productForm">
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Imie:</label>
				<div class="col-sm-10">
					<form:input path="name" cssClass="form-control" id="name" />
					<form:errors path="name" cssStyle="color: red;" />
				</div>
			</div>
						<div class="form-group">
				<label class="control-label col-sm-2" for="price">Stanowisko:</label>
				<div class="col-sm-10">
					<form:input path="position" cssClass="form-control" id="position" />
					<form:errors path="position" cssStyle="color: red;" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="salary">Pensja:</label>
				<div class="col-sm-10">
					<form:input path="salary" cssClass="form-control" id="salary" />
					<form:errors path="salary" cssStyle="color: red;" />
				</div>
			</div>
						<div class="form-group">
				<label class="control-label col-sm-2" for="pesel">PESEL:</label>
				<div class="col-sm-10">
					<form:input path="pesel" cssClass="form-control" id="pesel" />
					<form:errors path="pesel" cssStyle="color: red;" />
				</div>
			</div>
						<div class="form-group">
				<label class="control-label col-sm-2" for="address">Adres:</label>
				<div class="col-sm-10">
					<form:input path="address" cssClass="form-control" id="address" />
					<form:errors path="address" cssStyle="color: red;" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="departments">Wybierz wydzial:</label>
				<div class="col-sm-10">
					<form:select path="departments" items="${departments}" cssClass="form-control"></form:select>
					<form:errors path="category" cssStyle="color: red;" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Dodaj</button>
				</div>
			</div>
		</form:form>
	</div>

	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Imie</th>
					<th>Stanowisko</th>
					<th>Wypłata</th>
					<th>Pesel</th>
					<th>Adres</th>
					<th>Departament</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${employees}">
					<tr>
						<td>${e.name}</td>
						<td>${e.position}</td>
						<td>${e.salary}</td>
						<td>${e.pesel}</td>
						<td>${e.address}</td>
						<td>${e.department}</td>
						<td>
							<form action="edit/${p.id}" method="post">
								<input type="hidden" name="id" value="${e.id}" />
							</form>
							<button type="button" data-toggle="modal" data-target="#edit_${p.id}" class="btn btn-primary btn-sm">Edytuj</button>
							<div id="editProduct_${p.id}" class="modal fade" role="dialog">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
										</div>
										<div class="modal-body">
											<form action="edit/${e.id}" method="post">
												<input type="hidden" name="id" value="${e.id}" />
												<div class="form-group">
													<label for="edit_name">Nazwa:</label> <input type="text" class="form-control" id="edit_name"
														name="edit_name" value="${e.name}" />
												</div>
												<div class="form-group">
													<label for="edit_price">Stanowisko:</label> <input type="text" class="form-control" id="edit_price"
														name="edit_price" value="${e.position}" />
												</div>
																								<div class="form-group">
													<label for="edit_salary">Wyplata:</label> <input type="text" class="form-control" id="edit_salary"
														name="edit_salary" value="${e.salary}" />
												</div>
																								<div class="form-group">
													<label for="edit_pesel">PESEL:</label> <input type="text" class="form-control" id="edit_pesel"
														name="edit_pesel value="${e.pesel}" />
												</div>
																								<div class="form-group">
													<label for="edit_address">Adres:</label> <input type="text" class="form-control" id="edit_address"
														name="edit_address" value="${e.address}" />
												</div>
												<div class="form-group">
													<label for="edit_department">Departament:</label> <select class="form-control" name="edit_department"
														id="edit_department">
														<c:forEach var="d" items="${departments}">
															<option>${d}</option>
														</c:forEach>
													</select>
												</div>
												<button type="submit" class="btn btn-default btn-sm">Zapisz</button>
											</form>
										</div>
									</div>
								</div>
							</div>
						</td>
						<td>
							<form action="delete method="post">
								<input type="hidden" name="id" value="${e.id}" />
								<button type="submit" class="btn btn-danger btn-sm">Usun</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>