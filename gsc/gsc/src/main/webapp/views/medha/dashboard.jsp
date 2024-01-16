<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/medha"%>

<html>
<head>
<common:script />
<common:style />
<title>Dashboard - Medha Sandhan Pariksha</title>
</head>
<body>
	<common:header />
	<main>
		<div class="container">
			<!-- exam creation -->
			<div class="row">
				<div class="col s12 m6 l4">
					<div class="card medium">
						<div class="card-image">
							<img src="../../asset/media/exam.jpg"> <span
								class="card-title">Manage Examination</span>
						</div>
						<div class="card-content">
							<p>Manage you examination with ease. Create and modify your
								exam. Generate FORAM 'C'. Prepare schedule and modify them and
								many more useful tools.</p>
						</div>
						<div class="card-action">
							<a href="<c:url value = "/medhasandhan/exam"/>">Click here</a>
						</div>
					</div>
				</div>


				<!-- School -->

				<div class="col s12 m6 l4">
					<div class="card medium">
						<div class="card-image">
							<img src="../../asset/media/school.jpg"> <span
								class="card-title">Manage Schools</span>
						</div>
						<div class="card-content">
							<p>Enroll and manage all the participating schools. Modify
								their details. Generate FORM 'A', Admit cards</p>
						</div>
						<div class="card-action">
							<a href="<c:url value = "/medhasandhan/school"/>">Click here</a>
						</div>
					</div>
				</div>

				<!-- Candidate Profile -->
				<div class="col s12 m6 l4">
					<div class="card medium">
						<div class="card-image">
							<img src="../../asset/media/student.jpg"> <span
								class="card-title">Enrollment</span>
						</div>
						<div class="card-content">
							<p>Create and enroll a candidate. Manage all his/her details.
								Print their admit card and Marksheet</p>
						</div>
						<div class="card-action">
							<a href="<c:url value = "/medhasandhan/candidate"/>">Click here</a>
						</div>
					</div>
				</div>

				<!-- Marksheet -->
				<div class="col s12 m6 l4">
					<div class="card medium">
						<div class="card-image">
							<img src="../../asset/media/marksheet.jpg"> <span
								class="card-title">Mark sheet</span>
						</div>
						<div class="card-content">
							<p>Upload mark sheets for exams. Print them for and publish
								them online as well.</p>
						</div>
						<div class="card-action">
							<a href="<c:url value = "/medhasandhan/upload-result"/>">click here</a>
						</div>
					</div>
				</div>

				<!-- analytics -->

				<div class="col s12 m6 l4">
					<div class="card medium">
						<div class="card-image">
							<img src="../../asset/media/analytics.jpg"> <span
								class="card-title">View Insights</span>
						</div>
						<div class="card-content">
							<p>Data is god, so it's important to keep an eye on the
								performance. Compare and visualize the recent activities around
								the programs.</p>
						</div>
						<div class="card-action">
							<a href="<c:url value = "/medhasandhan/analytics"/>">View insights</a>
						</div>
					</div>
				</div>

			</div>

		</div>
	</main>
	<common:footer />
</body>
</html>