<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="examList" type="java.util.List"%>
<h4>List of Exams</h4>
<!-- <a class="btn-floating btn-large cyan pulse right" href=""><i
	class="material-icons">add</i></a> -->
<ul class="collapsible">
	<c:forEach items="${examList}" varStatus="status" var="exam">
		<li>
			<div class="collapsible-header">
				<i class="material-icons">filter_drama</i>${exam.name}
			</div>
			<div class="collapsible-body">

				<p>Status: ${exam.status }</p>
				<p>Date of Examination: ${exam.date }</p>
				<c:if test="${exam.status eq 'POST'}">
				<form action="/medha/exam/upload-attendence" method="post" id='upload-attendance-form' enctype="multipart/form-data">
					<!-- <div class=" file-field input-field">
						<div class="btn right">
							<span>Select File</span> <input type="file">
						</div>
						<div class="file-path-wrapper">
							<input class="file-path validate" type="text">
						</div>
						
  
					</div> -->
					<!-- <label>Select a .json file</label> -->
					<input type="file" name="file"/>
					<a class="waves-effect waves-light btn" onclick="uploadAtt();"><i class="material-icons right">file_upload</i>Upload Attendance</a>
					
				</form>
				</c:if>
			</div>

		</li>

	</c:forEach>

</ul>