<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="reports" tagdir="/WEB-INF/tags/medha/reports"%>
<%@ attribute name="entry" type="org.gsc.medha.dto.CandidateDto"%>
<script src="/asset/js/jquery-3.6.0-min.js"></script>
<script src="/asset/js/qrcode.min.js"></script>

<div class="row">
	<div class="col s10 offset-s2">
		<img alt="" class="responsive-img" src="/asset/media/marksheet-header.png" />
	</div>
</div>
<div class="row">

	<div class="col s8 offset-s1">
		<span class="bold">${fn:toUpperCase(entry.name)}</span> bearing Roll
		No. <span class="bold"><c:if test="${entry.gender eq 'F'}">${entry.gender}</c:if>${entry.roll }</span>
		of Class <span class="bold">${entry.cls }</span> from <span class="bold">${entry.school.name }</span>
		appeared in the Medha Sandhan Pariksha held on <span class="bold">${entry.exam.date }</span>
		at <span class="bold">${entry.school.venue.name }</span> has secured <span
			class="bold">${entry.marks }</span> marks.<br><br>
			
	  	<span>Date: 10 January, 2024</span><span class="right"> Convener, ASCPS</span>

		<%--  <reports:Copyright></reports:Copyright>   --%>

	</div>
	 <div class="col s2" style="border: 2px solid #282626;">
		<h2 class="center bold"> ${entry.grade }</h2>
	</div> 
</div>
