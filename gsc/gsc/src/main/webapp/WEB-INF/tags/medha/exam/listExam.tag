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
				<span class="bold">Status is </span><span class="green-text bold">${exam.status}</span>
				<hr>
					<analytics:countGuage year="${exam.id }" size="50%"></analytics:countGuage>
			</div>
		</li>

	</c:forEach>

</ul>