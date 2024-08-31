<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="exam" tagdir="/WEB-INF/tags/medha/exam"%>
<%@ taglib prefix="venue" tagdir="/WEB-INF/tags/medha/venue"%>
<%@ taglib prefix="reports" tagdir="/WEB-INF/tags/medha/reports"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/medha"%>
<html>
<head>
<common:script />
<common:highchartsScripts></common:highchartsScripts>
<script type="text/javascript" src="../../asset/js/exam.js"></script>
<common:style />
<meta charset="UTF-8">
<script>
	autocomplete = ${autocompleteData};
</script>

<c:set var="imageUrl" value="../../asset/media" scope="request" />
<title>Exam Centre</title>


</head>
<body>
	<common:header />
	<main>
		<div class="container">
			<div class="row"></div>
			<div class="row ">
				<div class="col s12">
					<div class="col s12">
						<ul class="tabs bold">
							<li class="tab col s3"><a href="#exam">EXAMS</a></li>
							<li class="tab col s3"><a href="#add-exam">ADD EXAM</a></li>
							<li class="tab col s3"><a class="" href="#forms">FORM
									'A' & 'B'</a></li>
							<li class="tab col s3"><a href="#admit-card">Admit Cards</a></li>

						</ul>
					</div>
					<div id="exam" class="row">
						<div class="col s8">
							<exam:listExam examList="${examList}" />
						</div>
						<div class="col s12">
							<hr>
						</div>
						<div class="col s12" id="left-pan">
							<venue:venueList mediaUrl="${imageUrl }" />
						</div>
					</div>
					<div id="add-exam" class="col s7">
						<exam:addExam />
					</div>
					<div id="forms" class="col s12">
						<div class="col s6">
							<reports:formA></reports:formA>
						</div>
						<div class="col s6">
							<reports:formB></reports:formB>
						</div>
					</div>
					<div id="admit-card" class="col s12">
						<reports:admit></reports:admit>
					</div>
				</div>


			</div>

		</div>
	</main>
	<common:footer />
</body>
</html>