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
<title>Upload Marks</title>
</head>
<body>
	<common:header />
	<main>
		<div class="container">
			<div class="row">
				<h3 class="center-align red-text ">Upload Marks</h3>
				<div class="col s5 ">
					<div class="row">
						<div class="col s12">
							<h4 class="">Select a file</h4>
						</div>
					</div>
					<form action="/medha/exam/upload-marks-file" method="post"
						enctype="multipart/form-data" id="form-preview-marks"
						class="col s12">
						<div class="file-field input-field">
							<div class="btn deep-purple accent-4">
								<span>File</span> <input name="file" type="file">
							</div>
							<div class="file-path-wrapper">
								<input class="file-path validate" type="text">
							</div>
						</div>
						<a href="../../resources/templates/MarksUploadTemplate.xlsx"
								data-position="bottom" data-tooltip='Sample Template' class='tooltipped red-text'><i
								class="material-icons green-text left">file_download</i>Download Sample</a> 
						<a class="waves-effect amber btn right" id="btn-preview-marks"><i
							class="material-icons left">preview</i>Preview</a>
					</form>
					
					
					<div class="row">
					<h3 class="center grey-text">Or</h3>
						<div class="col s12">

						<form action="/medhasandhan/pre-filled-template" method="get">
							<div class="row">
								<div class="col s12 input-field">
									<select id="ms-exam-year" name="examId">
										<option value="" disabled selected>Choose Examination</option>
										<c:forEach items="${examList}" varStatus="status" var="exam">
											<option value="${exam.id }">${exam.formattedName }</option>
										</c:forEach>
									</select> <label>Examination<span class="red-text">*</span></label>
								</div>


							</div>
							<div class="row">
								<div class="col s12 input-field">
									<select id="ms-school" name="schoolId">
										<option value="" disabled selected>Choose your school</option>
										<c:forEach items="${schools }" var="school">
											<option value="${school.id }">${school.name }</option>
										</c:forEach>
									</select> <label>Select School<span class="red-text">*</span></label>
								</div>


								<button class="btn waves-effect amber btn right"
									 type="submit" 
									>
									<i class="material-icons right ">print</i>Download Filled Template
								</button>
							</div>
						</form>

						</div>
					</div>
					
					
					
					
					
				</div>
				<div class="col s7">
					<div class="row">
						<div class="col s6">
							<h4 class="">Preview</h4>
						</div>

						<div class="col s6">
								<a
								class="valign-btn waves-effect deep-purple accent-4 btn right"
								id="btn-save-marks"><i class="material-icons left">save</i>Confirm
								& Save</a>
						</div>
					</div>
					<div class="row">
						<div class="col s12">
							<table id="preview-marks-table"
								class="mdl-data-table collection striped responsive-table">
								<thead>
									<tr>
										<th>Roll</th>
										<th>Name</th>
										<th>Class</th>
										<th>Marks Obtained</th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<common:footer />
</body>
</html>