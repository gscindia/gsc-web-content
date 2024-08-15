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
			<div class="row valign-wrapper">
				<div class="col l5 hide-on-med-and-down enrollment-banner">
					<img class="responsive-img" src="../../asset/media/student-2.jpg">
				</div>

				<div class="col s12 m12 l5 offset-l2">
					<div class="row">
						<c:choose>
							<c:when test="${not empty examName}">
								<h4 class="header center">Application Form</h4>
								<h6 class="center  darken-1 green-text bold">${examName}</h6>
							</c:when>
							<c:otherwise>
								<blockquote>Enrollment is yet to start for upcoming	session. 
									Please check back few days later.
								</blockquote>
							</c:otherwise>
						</c:choose>
						<form id="enroll-form" class="col s12 m12 l12" method="POST"
							action="/medha/student/add">
							<div class="row">
								</br> <span> <label> <input name="gender" value="M"
										type="radio" class="with-gap" /> <span><strong>Male</strong>
									</span>
								</label>
								</span> <span> <label> <input name="gender" value="F"
										type="radio" class="with-gap" /> <span><strong>Female</strong></span>
								</label>

								</span><span class="red-text">*</span>
							</div>
							<div class="row input-field">
								<select id="student-class" name="cls">
									<option value="" disabled selected>Choose your class</option>
									<option value="2">Class - II</option>
									<option value="3">Class - III</option>
									<option value="4">Class - IV</option>
									<option value="5">Class - V</option>
									<option value="6">Class - VI</option>
									<option value="7">Class - VII</option>
									<option value="8">Class - VIII</option>
									<option value="9">Class - IX</option>
									<option value="10">Class - X</option>
								</select> <label>Select class<span class="red-text">*</span></label>
							</div>
							<div class="row input-field">
								<select id="student-school" name="school">
									<option value="" disabled selected>Choose your school</option>
									<c:forEach items="${schools }" var="school">
										<option value="${school.id }">${school.name }</option>
									</c:forEach>
								</select> <label>Select School<span class="red-text">*</span></label>
							</div>
							<div class="row">
								<input value="" id="student-name" type="text" name="name"
									class="validate"> <label class="active"
									for="student-name"><strong>Full Name<span
										class="red-text">*</span></strong></label>
							</div>
							<div class="row">
								<button class="btn waves-effect waves-light btn-large green darken-1"
									type="button" name="action" onclick="enroll();">
									Apply <i class="material-icons right">send</i>
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</main>
	<common:footer />
</body>

</html>