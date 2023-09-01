<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="mediaUrl"%>
<%@ attribute name="index"%>
<%@ attribute name="venueItem" type="org.gsc.medha.dto.VenueDto"%>
<style>
.done {
	color: green
}

.pending {
	color: #d12e0d;
}
</style>
<div class="row venue-details ${index>0 ? 'hide':'show'}"
	id="venue-${index}">
	<!-- <div class="row"> -->
	<div class="col s12">
		<!-- Venue picture -->
		<img class="responsive-img" src="${mediaUrl}/${venueItem.picture}">
	</div>
	<!-- </div> -->

	<div class="col s12">
		<div class="row">
			<span>Name: ${venueItem.name}</span>
		</div>
		<div class="row">
			<span>Address: ${venueItem.address} </span>
		</div>
		<div class="row">
			<span>Centre Code: ${venueItem.code} </span>
		</div>
		<div class="row">
			<span>Convenor: ${venueItem.convenor} </span>
		</div>
		<div class="row">
			<span>Contact: ${venueItem.phone} </span>
		</div>
		<div class="row">
			<p>Recent examinations at this venue:</p>
			<c:forEach items="${venueItem.exam }" var="exam">
				<span class="blue-text">${exam.name}</span>
				<span class="${exam.status eq
						'OFF' ?'done':'pending'}"> <i class="material-icons tiny">${exam.status eq
						'OFF' ?'done_all':'pending_actions'}</i>
				</span>
				</br>

			</c:forEach>
		</div>
	</div>
</div>