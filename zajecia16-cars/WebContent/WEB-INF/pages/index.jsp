<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css">
<script src="static/js/jquery-3.2.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista pojazdów.</title>
</head>
<body>

	<div class="container">
		<form action="addCar" method="post">
			<input type="hidden" name="action" value="add" />
			<div class="form-group">
				<label for="marka">Wpisz markę:</label> <input type="text" class="form-control" id="mark" name="mark" value="${param['mark']}" />
			</div>
			<div class="form-group">
				<label for="model">Wpisz model:</label> <input type="text" class="form-control" id="model" name="model"
					value="${param['model']}" />
			</div>
						<div class="form-group">
				<label for="paliwo">Wpisz rodzaj paliwa:</label> <input type="text" class="form-control" id="fuel" name="fuel" value="${param['fuel']}" />
			</div>
			<div class="form-group">
				<label for="age">Wpisz moc:</label> <input class="form-control" type="text" name="power" id="power" value="${param['power']}" />
			</div>
			<div class="form-group">
				<label for="age">Wpisz przebieg:</label> <input class="form-control" type="text" name="mileage" id="mileage" value="${param['mileage']}" />
			</div>
			<button type="submit" class="btn btn-default">Dodaj</button>
		</form>
	</div>

</body>
</html>