<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="analytics" tagdir="/WEB-INF/tags/medha/analytics"%>
<%@ attribute name="examList" type="java.util.List"%>
<h4>List of Exams</h4>
<ul class="collapsible">
	<c:forEach items="${examList}" varStatus="status" var="exam">
		<li>
			<div class="collapsible-header bold deep-purple-text accent-4">
				<i class="material-icons black-text ">quiz</i>${exam.name}
			</div>
			<div class="collapsible-body">
				<span class="bold">Date of Examination </span><span class=" bold blue-text">${exam.date }</span>&nbsp;&nbsp;
				<span class="bold">Status: </span>
				<c:choose>
					<c:when test="${exam.status eq 'ACTIVE'}">
						<span class=" green-text bold">In progress</span>
						<i class="material-icons green-text tiny">call_received</i>
					</c:when>
					<c:when test="${exam.status eq 'POST'}">
						<span class="orange-text bold">Evalution in progress</span>
						<i class="material-icons green-text tiny">hourglass_empty</i>
					</c:when>
					<c:otherwise>
						<span class=" red-text bold">Concluded</span>
						<i class="material-icons tiny">offline_pin</i>
					</c:otherwise>
				</c:choose>
				
				<c:if test="${exam.status eq 'POST'}">
				<hr>
				<form action="/medha/exam/upload-attendence" method="post" id='upload-attendance-form' enctype="multipart/form-data">
					<input type="file" name="file"/>
					<a class="waves-effect deep-purple accent-4 btn" onclick="uploadAtt();"><i class="material-icons right">file_upload</i>Upload Attendance</a>
				</form>
				</c:if>
				<hr>
					<analytics:countGuage year="${exam.id }" size="50%"></analytics:countGuage>
			</div>

		</li>

	</c:forEach>

</ul>