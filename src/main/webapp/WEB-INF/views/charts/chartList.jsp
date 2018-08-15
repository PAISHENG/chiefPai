<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<c:url value='/resources/js/jquery-3.3.1.min.js' />"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
</head>
<body>
	<h1>test</h1>

	<div id="chartResult"></div>
	<script>
		var data = {
			chart : {
				type : "bar"
			},
			series : [ {
				name : "Jane",
				data : [ 3, 1, 4, 1, 5, 9 ]
			} ]
		}
		
		$("#chartResult").highcharts(data);
	</script>
</body>
</html>