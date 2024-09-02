<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/medha"%>
<%@ taglib prefix="school" tagdir="/WEB-INF/tags/medha/school"%>
<%@ taglib prefix="student" tagdir="/WEB-INF/tags/medha/student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<common:script />
<common:style />
<common:dataTableScripts />
<script type="text/javascript" src="../../asset/js/school.js"></script>
<script type="text/javascript" src="../../asset/js/student.js"></script>
<style>
select.form-control.input-sm {
	display: block;
}
</style>

<title>Schools - Medha Sandhan Pariksha</title>
</head>
<body>
	<common:header />
	<main>
		<div class="container">
		<h3 class="center-align red-text ">Manage Schools Details</h3>
			<div class="row">

					<div class="row">
						<div class="col s2">
							<blockquote>Register New School</blockquote>
						</div>
						<div class="col s1">
							<a class="btn-floating btn-large cyan pulse modal-trigger" href="#add-school-modal"><i class="material-icons">add</i></a>
							
						</div>		
						<div class="col s4 offset-s5 right-align input-field right">
							<select id="school-list" name="school">
								<option value="-1" disabled selected>Select School</option>
								<c:forEach items="${schoolList}" varStatus="status" var="school">
									<option value="${school.id }">${school.name }</option>
								</c:forEach>
							</select> <label>Filter by School</label>
						</div>
					</div>					

				<div class="col s12">
					<common:studentListOfSchool></common:studentListOfSchool>
				</div>

			</div>
			<school:addSchool venues="${venues }"></school:addSchool>
			<student:editStudent schools='${schoolList }'></student:editStudent>
		</div>
	</main>
	<common:footer />
</body>
</html>