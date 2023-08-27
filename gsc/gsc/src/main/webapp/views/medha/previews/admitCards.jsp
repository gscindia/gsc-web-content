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
<link href="${assestRoot}/font/icon.css" rel="stylesheet">
<%-- <link rel="stylesheet" href="${assestRoot}/css/style.css" /> --%>
<style type="text/css">
.bold{
	font-weight: bold;
    font-family: sans-serif;
}
@media print {  
.print-small-admit {
    font-size: 10px;
}
}
</style>
<title>Admit Cards</title>
</head>
<body>
	<main>
		<div class="container">		
		<c:forEach items="${candidate }" var="entry" varStatus="loop">
		<div class="row" style="border: 2px solid #282626;">
				<reports:admitCard entry="${entry}"></reports:admitCard>		
		</div>
		<c:if test="${loop.index %2 == 0}">
			<div class="row"></div><div class="row"></div><div class="row"></div><div class="row"><hr></div><div class="row"></div><div class="row"></div><div class="row"></div>
		</c:if>
        </c:forEach>
</div>
	</main>

</body>
</html>
		