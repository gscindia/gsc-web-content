<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="reports" tagdir="/WEB-INF/tags/reports"%>

<c:url value="/asset" var="assestRoot" />
<html>
<head>
<common:script />
<link rel="stylesheet" href="${assestRoot}/css/materialize.min.css">
<link href="${assestRoot}/font/icon.css" rel="stylesheet">
<%-- <link rel="stylesheet" href="${assestRoot}/css/style.css" /> --%>
<style type="text/css">
table, td, th {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 0px 0px;
}
</style>
<title>Form A - Part I - ${candidate[0].school.name}</title>
</head>
<body>
	<main>
		<div class="container">
		<c:forEach items="${pagedata.breakup }" var="dataList" varStatus="loop">		   	
			<reports:forma1header></reports:forma1header>			
			<reports:forma1table dataList="${dataList }"></reports:forma1table>
			<reports:forma1footer></reports:forma1footer>
			<reports:Copyright></reports:Copyright>
			<p class="right-align"> Page ${loop.index+1 } of ${fn:length(pagedata.breakup)}</p>
        </c:forEach>
		</div>

	</main>

</body>
</html>
