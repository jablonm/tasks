<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista wycieczek:</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>


	<div class="container">
		<h2>Podaj dane wycieczki:</h2>
		<form:form cssClass="form-horizontal" action="add" method="post" commandName="tripForm">
			<div class="form-group">
				<label class="control-label col-sm-2" for="country">Kraj:</label>
				<div class="col-sm-10">
					<form:input path="country" cssClass="form-control" id="country" />
					<form:errors path="country" cssStyle="color: red;" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="destination">Miejsce:</label>
				<div class="col-sm-10">
					<form:input path="destination" cssClass="form-control" id="destination" />
					<form:errors path="destination" cssStyle="color: red;" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="departureDate">Data wylotu:</label>
				<div class="col-sm-10">
					<form:input path="departureDate" cssClass="form-control" id="departureDate" />
					<form:errors path="departureDate" cssStyle="color: red;" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="returnDate">Data przylotu:</label>
				<div class="col-sm-10">
					<form:input path="returnDate" cssClass="form-control" id="returnDate" />
					<form:errors path="returnDate" cssStyle="color: red;" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="region">Region:</label>
				<div class="col-sm-10">
					<form:input path="region" cssClass="form-control" id="region" />
					<form:errors path="region" cssStyle="color: red;" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="price">Cena:</label>
				<div class="col-sm-10">
					<form:input path="price" cssClass="form-control" id="price" />
					<form:errors path="price" cssStyle="color: red;" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Dodaj</button>
				</div>
			</div>
		</form:form>
	</div>

</body>
</html>