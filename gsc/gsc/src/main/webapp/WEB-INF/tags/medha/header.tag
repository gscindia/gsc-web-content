<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="blue darken-4">
	<div class="nav-wrapper">
		<a href="/medhasandhan" class="brand-logo">Medha Sandhan Pariksha</a>
		<a href="#!" data-target="mobile-nav"
			class="sidenav-trigger"><i class="material-icons">menu</i></a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li><a href="<c:url value = "/medhasandhan/candidate"/>">Enrollment</a></li>
			<li><a href="<c:url value = "/medhasandhan/exam"/>">Exams</a></li>
			<li><a href="<c:url value = "/medhasandhan/school"/>">Schools</a></li>
			<li><a href="<c:url value="/medhasandhan/mark-sheet" />">Marks</a></li>
			<li><a href="<c:url value="/medhasandhan/analytics" />">Analytics</a></li>
		</ul>
	</div>
</nav>

<ul class="sidenav" id="mobile-nav">
	<li><a href="<c:url value = "/medhasandhan/candidate"/>">Enrollment</a></li>
	<li><a href="<c:url value = "/medhasandhan/exam"/>">Exams</a></li>
	<li><a href="<c:url value = "/medhasandhan/school"/>">Schools</a></li>
	<li><a href="<c:url value="/medhasandhan/mark-sheet" />">Marks</a></li>
	<li><a href="<c:url value="/medhasandhan/analytics" />">Analytics</a></li>
</ul>