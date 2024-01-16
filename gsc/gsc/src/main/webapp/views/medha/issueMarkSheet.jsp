<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/medha"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<common:script />
<common:style />
<common:dataTableScripts />
<script type="text/javascript" src="../../asset/js/marksheet.js"></script>
<title>Issue Mark Sheet</title>
</head>
<body>
	<common:header />
	<main>
		<div class="container">
			<div class="row">
				<div class="col s6 offset-s3">
					<div class="row">
						<div class="col s12">


							<div class="row">
								<div class="col s12 input-field">
									<select id="ms-exam-year" name="cls">
										<option value="" disabled selected>Choose Examination</option>
										<c:forEach items="${examList}" varStatus="status" var="exam">
											<option value="${exam.id }">${exam.formattedName }</option>
										</c:forEach>
									</select> <label>Examination<span class="red-text">*</span></label>
								</div>


							</div>
							<div class="row">
								<div class="col s12 input-field">
									<select id="ms-school" name="school">
										<option value="" disabled selected>Choose your school</option>
										<c:forEach items="${schools }" var="school">
											<option value="${school.id }">${school.name }</option>
										</c:forEach>
									</select> <label>Select School<span class="red-text">*</span></label>
								</div>


								<button class="btn waves-effect waves-light btn-large red right"
									target="_blank" type="button" name="action"
									onclick="printMarksheet();">
									<i class="material-icons right ">print</i>Print Preview
								</button>
							</div>


						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<common:footer />
</body>
</html>