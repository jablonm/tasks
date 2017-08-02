<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Psi spis</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.1.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

<script type="text/javascript">
	function changeFieldValue(fieldId, newValue, formId) {
		document.getElementById(fieldId).value = newValue;
		document.getElementById(formId).submit();
	}
</script>

</head>
<body>

	<c:set var="orderByUrl">
		<c:url value="/dogs/" />
	</c:set>


	<div class="container">
		<h2>Wprowadz nowego piesa:</h2>
		<c:set var="addActionUrl">
			<c:url value="/dogs/create" />
		</c:set>
		<form:form cssClass="form-horizontal" action="${addActionUrl}" method="post" commandName="dogForm">
			<div class="form-group">
				<label class="control-label col-sm-2" for="breed">Breed:</label>
				<div class="col-sm-10">
					<form:input path="breed" cssClass="form-control" id="breed" />
					<form:errors path="breed" cssStyle="color: red;" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="age">Age:</label>
				<div class="col-sm-10">
					<form:input path="age" cssClass="form-control" id="age" />
					<form:errors path="age" cssStyle="color: red;" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="color">Color:</label>
				<div class="col-sm-10">
					<form:input path="color" cssClass="form-control" id="color" />
					<form:errors path="color" cssStyle="color: red;" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Name:</label>
				<div class="col-sm-10">
					<form:input path="name" cssClass="form-control" id="name" />
					<form:errors path="name" cssStyle="color: red;" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="gender">Gender:</label>
				<div class="col-sm-10">
					<form:select path="gender" cssClass="form-control" id="gender">
						<form:option value="M">MALE</form:option>
						<form:option value="F">FEMALE</form:option>
					</form:select>
					<form:errors path="gender" cssStyle="color: red;" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Add</button>
				</div>
			</div>
		</form:form>
	</div>

	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
						onclick="changeFieldValue('field_sort_by','breed','sortForm')">Breed</th>
					<th onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
						onclick="changeFieldValue('field_sort_by','age','sortForm')">Age</th>
					<th onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
						onclick="changeFieldValue('field_sort_by','color','sortForm')">Color</th>
					<th onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
						onclick="changeFieldValue('field_sort_by','name','sortForm')">Name</th>
					<th onmouseover="this.style.cursor='pointer';" onmouseout="this.style.cursor='default';"
						onclick="changeFieldValue('field_sort_by','gender','sortForm')">Gender</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="d" items="${dogs}">
					<tr>
						<td>${d.breed}</td>
						<td>${d.age}</td>
						<td>${d.color}</td>
						<td>${d.name}</td>
						<td>${d.gender}</td>
						<td>
							<button type="button" data-toggle="modal" data-target="#update_${d.id}" class="btn btn-primary btn-sm">Edit</button>
							<div id="update_${d.id}" class="modal fade" role="dialog">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
										</div>
										<div class="modal-body">

											<form action="<c:url value="/dogs/update/${d.id}"/>" method="post">

												<input type="hidden" name="id" value="${d.id}" />
												<div class="form-group">
													<label for="updateBreed">Breed:</label> <input type="text" class="form-control" id="updateBreed" name="breed"
														value="${d.breed}" />
												</div>
												<div class="form-group">
													<label for="updateAge">Age:</label> <input type="text" class="form-control" id="updateAge" name="age" value="${d.age}" />
												</div>
												<div class="form-group">
													<label for="updateColor">Color:</label> <input type="text" class="form-control" id="updateColor" name="color"
														value="${d.color}" />
												</div>
												<div class="form-group">
													<label for="updateName">Name:</label> <input type="text" class="form-control" id="updateName" name="name" value=" ${d.name}" />
												</div>
												<div class="form-group">
													<label for="updateGender">Gender:</label> <input type="text" class="form-control" id="updateGender" name="gender"
														value="${d.gender}" />
												</div>
												<button type="submit" class="btn btn-default btn-sm">Save</button>
											</form>
										</div>
									</div>
								</div>
							</div>
						</td>
						<td>
							<form action="<c:url value="/dogs/delete"/>" method="post">
								<input type="hidden" name="id" value="${d.id}" />
								<button type="submit" class="btn btn-danger btn-sm">Delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form action="${orderByUrl}" method="get" id="sortForm">
			<input type="hidden" name="orderBy" id="field_sort_by" value="orderBy" />
		</form>
	</div>

</body>
</html>