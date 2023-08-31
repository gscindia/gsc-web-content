<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="reports" tagdir="/WEB-INF/tags/medha/reports"%>
<c:url value="/asset" var="assetRoot" />
<html>
<head>
<link rel="stylesheet" href="${assetRoot}/css/materialize.min.css">
<link href="${assetRoot}/font/icon.css" rel="stylesheet">
<style type="text/css">
table, td, th {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 0px 0px;
}
.hide-here{
display:none;
}
@media print {
.print-small {
    font-size: 14px;
}
}
</style>
<title>Form A - Part II - ${candidate[0].school.name}</title>
</head>
<body>
	<main>
		<div class="container">
		<c:forEach items="${pagedata.breakup }" var="dataList" varStatus="loop">		   	
			<div class="row">
			<div class="col s6">
			<reports:forma2header address=""></reports:forma2header>
			<reports:forma2table dataList="${dataList }"></reports:forma2table>
			<reports:forma2ConvenorFooter></reports:forma2ConvenorFooter>
			<reports:Copyright></reports:Copyright>
			</div>
			<div class="col s6">
			<reports:forma2header address="hidden"></reports:forma2header>
			<reports:forma2table dataList="${dataList }"></reports:forma2table>
			<reports:forma2SocietyFooter></reports:forma2SocietyFooter>
			<reports:Copyright></reports:Copyright>
			<div class="row" style="padding-top:57px;">
				<p class="right-align"> Page ${loop.index+1 } of ${fn:length(pagedata.breakup)}</p>
			</div>
			</div>	
						
					
			
			</div>
        </c:forEach>
		</div>

	</main>

</body>
</html>
