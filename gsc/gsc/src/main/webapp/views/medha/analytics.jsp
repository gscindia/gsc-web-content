<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/medha"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<common:script />
<common:style />
<common:highchartsScripts></common:highchartsScripts>
<script type="text/javascript"
	src="../../asset/js/charts/enrollmentGuage.js"></script>
<script type="text/javascript" src="../../asset/js/analytics.js"></script>

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
				<div class="col s4 left-align input-field">
					<select id="analytics-year" name="cls">						
						<option value="0">All</option>
						<c:forEach items="${examList}" varStatus="status" var="exam">
							<option value="${exam.id }" <c:if test="${exam.status eq 'ACTIVE'}">selected</c:if>>${exam.name }</option>
						</c:forEach>
					</select> <label>Examination</label>
				</div>
			</div>	
			<div class="row">
				<div class="col s12" id="school-statistics">
					<div class="row">
						<h3>Statistics of Schools</h3>
						<div class="col s4 right input-field ">
							<select id="analytics-school-sgc" name="school">
								<option value="0" selected>Select School</option>
								<c:forEach items="${schools}" varStatus="status" var="school">
									<option value="${school.id }">${school.name }</option>
								</c:forEach>
							</select> <label>School</label>
						</div>
					</div>
					<div class="row" id="school-gender-chart"></div>
					<div class="row">
						<div id="school-leaderboard" class="col s12">
							
						</div>
					</div>

				</div>
			</div>
			<div class="row" id="exam-statistics">
				<h3>Statistics of every Examination</h3>
				<div class="col s6" id="class-gender-chart"></div>
				<div class="col s6" id="enrollment-chart"></div>	
				<div class="col s12 m12 l12" id="shift-analysis"></div>			
			</div>
			<div class="row">
				<h3>Reveue Analysis</h3>
				<div class="col s12 m12 l12" id="revenue-analysis"></div>
			</div>
		</div>
	</main>
	<common:footer />
</body>
</html>