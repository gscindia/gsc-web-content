<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/medha"%>
<html>
<head>
<meta charset="ISO-8859-1">
<common:script />
<common:style />
<common:dataTableScripts />
<script type="text/javascript" src="../../asset/js/student.js"></script>
<style>
select.form-control.input-sm {
	display: block;
}
</style>

<title>Enrollment - Medha Sandhan Pariksha</title>
</head>
<body>
	<common:header />
	<main>
		<div class="container">
			<div class="row">
				<div class="row"></div>
				<div class="col s12 m12 l5">
					<img class="responsive-img" src="../../asset/media/student-2.jpg">
				</div>

				<div class="col s12 m12 l5 offset-l2 ">
					<div class="row">
						<form id="enroll-form" class="col s10 m10 l10" method="POST" action="/medha/student/add">						
							<h4 class="header center">Enroll Student </h4>
							<h6 class="center"><c:if test="${not empty examName}">for ${examName}</c:if></h6>
							<div class="row">
								</br>
								<span>
									<label> <input name="gender" value="M" type="radio"
										class="with-gap" /> <span><strong>Male</strong> </span>
									</label>
								</span>
								<span>
									<label> <input name="gender" value="F" type="radio"
										class="with-gap" /> <span><strong>Female</strong></span>
									</label>
								</span>
								
							</div>
							<div class="row">
								<select id="student-class" name="cls">
									<option value="" disabled selected><strong>Choose your class</strong></option>
									<option value="1">I</option>
									<option value="2">II</option>
									<option value="3">III</option>
									<option value="4">IV</option>
									<option value="5">V</option>
									<option value="6">VI</option>
									<option value="7">VII</option>
									<option value="8">VIII</option>
									<option value="9">IX</option>
									<option value="10">X</option>
									<option value="11">XI</option>
									<option value="12">XII</option>
								</select> <label>Select class</label>
							</div>
							<div class="row">
								<select id="student-school" name="school">
									<option value="" disabled selected><strong>Choose your school</strong></option>
									<c:forEach items="${schools }" var="school">
										<option value="${school.id }">${school.name }</option>
									</c:forEach>
								</select> <label>Select School</label>
							</div>					
							<div class="row">
								<input value="" id="student-name" type="text" name="name" class="validate">
								<label class="active" for="student-name"><strong>Full Name</strong></label>
							</div>
							<div class="row">
								<button class="btn waves-effect waves-light btn-large red right"
									type="button" name="action" onclick="enroll();">
									Enroll <i class="material-icons right">send</i>
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</main>
	<common:footer/>
</body>

</html>