<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="static/canvasjs.min.js"></script>
<script type="text/javascript">
function drawChar(citiesMap){
// 	console.log(citiesMap);
// 	var json = JSON.stringify(eval("(" + citiesMap + ")"));
// 	console.log(json)
	var chart = new CanvasJS.Chart("chartContainer", {
		title:{
			text: "Miasta"              
		},
		data: [              
		{
			// Change type to "doughnut", "line", "splineArea", etc.
			type: "column",
			dataPoints: [
				<c:forEach var="row" items="${citiesMap}">
				{ label: "${row.key}",  y: ${row.value}  },
				</c:forEach>		             
// 				
// 				{ label: "grape",  y: 28  }
			]
		}
		]
	});
	chart.render();
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Miasta</title>
</head>

<body onload="drawChar('${citiesMap}')">
	<div id="chartContainer" style="height: 500px; width: 100%;"></div>
</body>



</html>