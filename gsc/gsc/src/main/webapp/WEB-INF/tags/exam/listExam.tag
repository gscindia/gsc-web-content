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
				
				<p>${exam.status }</p>
				<p>${exam.date }</p>
			</div>
		</li>

	</c:forEach>

</ul>