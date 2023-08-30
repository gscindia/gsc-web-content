<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="school" tagdir="/WEB-INF/tags/school"%>
<%@ taglib prefix="student" tagdir="/WEB-INF/tags/student"%>
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
			<div class="row">

				<div class="col s4" id="left-pan">
					<!-- Grey navigation panel -->
					<ul class="collection with-header">
						<li class="collection-header"><h4>Schools</h4></li>
						<c:forEach items="${schoolList }" var="school" varStatus="status">
							<li class="collection-item school-list" data-id="${school.id }"><div class='valign-wrapper'>${school.name }<a
										href="#!" class="secondary-content"><span
										class="collection-icon"><i class="material-icons">navigate_next</i></span></a>
								</div></li>
						</c:forEach>



					</ul>
					<a class="btn-floating btn-large cyan pulse modal-trigger" href="#add-school-modal"><i class="material-icons">add</i></a>
				</div>

				<div class="col s8">
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