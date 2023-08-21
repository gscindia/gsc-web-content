<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<common:script />
<common:style />
<script type="text/javascript" src="../../asset/js/highcharts.js"></script>
<script type="text/javascript" src="../../asset/js/analytics.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<style>
select.form-control.input-sm {
	display: block;
}
</style>

<title>Analysis of Medha Sandhan Examination</title>
</head>
<body>
	<common:header />
	<main>
		<div class="container">
			<div class="row">
					<div class="col s4 left-align">
					<select id="analytics-year" name="cls">
						<option value="" disabled selected>Choose Year</option>
							<c:forEach items="${examList}" varStatus="status" var="exam">
								<option value="${exam.id }">${exam.name }</option>
							</c:forEach>
				</select> <label>Examination</label>
				</div>			

				<div class="col s12" id="school-gender-chart">
					
				</div>
				<div class="col s6" id="class-gender-chart">
					
				</div>
			</div>
		</div>
	</main>
	<common:footer />
</body>
</html>