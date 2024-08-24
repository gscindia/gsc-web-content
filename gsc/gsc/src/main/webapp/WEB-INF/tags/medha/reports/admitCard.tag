<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="reports" tagdir="/WEB-INF/tags/medha/reports"%>
<%@ attribute name="entry" type="org.gsc.medha.dto.CandidateDto"%>
<script src="/asset/js/jquery-3.6.0-min.js"></script>
<script src="/asset/js/qrcode.min.js"></script>

<div class="row">
<div class="col s10 offset-s2 header-image">
	<img alt="" class="responsive-img" src="/asset/media/admit-header.png"/>	
</div>
</div>
<div class="row">
<div class="col s8 offset-s1">
		
		<p class="bold">Name: ${fn:toUpperCase(entry.name)}</p>
		<p class="bold">School: ${entry.school.name }</p>
		<span class="bold">Class: ${entry.cls }</span>&nbsp;&nbsp;&nbsp;&nbsp;<span class="bold">Code No. ${entry.school.venue.code }</span><span class="bold">&nbsp;&nbsp;&nbsp; Roll No. <c:if test="${entry.gender eq 'F'}">${entry.gender}</c:if>${entry.roll }</span>
		<p class="bold">Venue: ${entry.school.venue.name }</p>
		<p class="bold">Date of Examination: ${entry.exam.date } at ${entry.schedule }</p>
		<hr>
		<span>For Class II to IV &#x20B9;50 and Class V to X &#x20B9;60 has been paid</span>
		<reports:Copyright></reports:Copyright>
		
</div>
<div class="col s3 center-align">
		<c:url var="encodedUrl" value ='/qrcode'>
			<c:param name="data" value="${entry.maskedRollid}" />
		</c:url>
		<img class='responsive-img' src="${encodedUrl }">
		<hr>
		<span class='qr-id'>App#:&nbsp;${entry.exam.id}/${entry.rollId}</span>
</div>
</div>