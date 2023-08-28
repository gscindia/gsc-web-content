<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="reports" tagdir="/WEB-INF/tags/reports"%>

<c:url value="/asset" var="assestRoot" />
<html>
<head>
<link rel="stylesheet" href="${assestRoot}/css/materialize.min.css">

<style type="text/css">
table, td, th {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 0px 0px;
	white-space: nowrap;
}
tr{
line-height: 35px;
white-space: nowrap;
}

</style>
<title>Form B - Class - ${candidate[0].cls}</title>
</head>
<body>
	<main>
		<div class="container">
		<c:forEach items="${pagedata.breakup }" var="dataList" varStatus="loop">		   	
			<reports:formBHeader></reports:formBHeader>	
			<reports:formBTable dataList="${dataList }"></reports:formBTable>
			<reports:Copyright></reports:Copyright>
			<p class="right-align"> Page ${loop.index+1 } of ${fn:length(pagedata.breakup)}</p>
        </c:forEach>
		</div>

	</main>

</body>
</html>
