<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css">
<script src="static/js/jquery-3.2.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/canvasjs.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Komis samochodowy</title>
<script type="text/javascript">
function changeFieldValue(fieldId, newValue, formId){
	document.getElementById(fieldId).val=newValue;
	document.getElementById(formId).submit();
}
</script>
</head>
<body>

	<div class="container">

		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#home">Strona główna</a></li>
			<li><a data-toggle="tab" href="#clients">Klienci</a></li>
			<li><a data-toggle="tab" href="#vehicles">Pojazdy</a></li>
			<li><a data-toggle="tab" href="#transactions">Tranzakcje</a></li>
			<li><a data-toggle="tab" href="#raports">Raporty</a></li>
		</ul>

		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
			</div>
			<div id="clients" class="tab-pane fade">
				<jsp:include page="clients.jsp" />
			</div>
			<div id="vehicles" class="tab-pane fade">
				<jsp:include page="vehicles.jsp" />
			</div>
			<div id="transactions" class="tab-pane fade">
				<jsp:include page="transactions.jsp" />
			</div>
			<div id="raports" class="tab-pane fade">
				<jsp:include page="raports.jsp" />
			</div>
		</div>

	</div>

</body>
</html>