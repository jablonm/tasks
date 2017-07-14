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
				<label class="control-label col-sm-2" for="name">Nazwa produktu:</label>
				<div class="col-sm-10">
					<form:input path="name" cssClass="form-control" id="name" />
					<form:errors path="name" cssStyle="color: red;" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="price">cena:</label>
				<div class="col-sm-10">
					<form:input path="price" cssClass="form-control" id="price" />
					<form:errors path="price" cssStyle="color: red;" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="category">Wybierz kategorie:</label>
				<div class="col-sm-10">
					<form:select path="category" items="${categories}" cssClass="form-control"></form:select>
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
					<th>Nazwa</th>
					<th>Cena</th>
					<th>Kategoria</th>
					<th>Edytuj</th>
					<th>Usun</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${products}">
					<tr>
						<td>${p.name}</td>
						<td>${p.price}</td>
						<td>${p.category}</td>
						<td>
							<form action="editProduct/${p.id}" method="post">
								<input type="hidden" name="id" value="${p.id}" />
							</form>
							<button type="button" data-toggle="modal" data-target="#editProduct_${p.id}" class="btn btn-primary btn-sm">Edytuj</button>
							<div id="editProduct_${p.id}" class="modal fade" role="dialog">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
										</div>
										<div class="modal-body">
											<form action="editProduct/${p.id}" method="post">
												<input type="hidden" name="id" value="${p.id}" />
												<div class="form-group">
													<label for="editProduct_name">Nazwa:</label> <input type="text" class="form-control" id="editProduct_name"
														name="editProduct_name" value="${p.name}" />
												</div>
												<div class="form-group">
													<label for="editProduct_price">Cena:</label> <input type="text" class="form-control" id="editProduct_price"
														name="editProduct_price" value="${p.price}" />
												</div>
												<div class="form-group">
													<label for="editProduct_category">Kategoria:</label> <select class="form-control" name="editProduct_category"
														id="editProduct_category">
														<c:forEach var="c" items="${categories}">
															<option>${c}</option>
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
							<form action="deleteProduct" method="post">
								<input type="hidden" name="id" value="${p.id}" />
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