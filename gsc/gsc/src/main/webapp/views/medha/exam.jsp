<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="exam" tagdir="/WEB-INF/tags/exam"%>
<%@ taglib prefix="venue" tagdir="/WEB-INF/tags/venue"%>
<%@ taglib prefix="reports" tagdir="/WEB-INF/tags/reports"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/"%>
<html>
<head>
<common:script />
<script type="text/javascript" src="../../asset/js/exam.js"></script>
<common:style />
<meta charset="ISO-8859-1">
<script>
	autocomplete = ${autocompleteData};
</script>

<c:set var="imageUrl" value="../../asset/media" scope="request" />
<meta charset="ISO-8859-1">
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
							<li class="tab col s3"><a  href="#add-exam">ADD EXAM</a></li>
							<li class="tab col s3"><a class="" href="#forms">FORM 'A' & 'B'</a></li>
							<li class="tab col s3"><a href="#admit-card">Admit Cards</a></li>
							 
						</ul>
					</div>
					<div id="exam" class="col s8">
						<exam:listExam examList="${examList}" />
					</div>
					<div id="add-exam" class="col s7"><exam:addExam /></div>
					<div id="forms" class="col s12">
						<div class="col s6"><reports:formA></reports:formA></div>
						<div class="col s6"><reports:formB></reports:formB></div>
					</div>
					<div id="admit-card" class="col s12"><reports:admit></reports:admit></div>
				</div>
				<div class="col s12"><hr></div>
				<div class="col s12" id="left-pan">
					<venue:venueList mediaUrl="${imageUrl }" />
				</div>

			</div>
			
		</div>
	</main>
	<common:footer />
</body>
</html>