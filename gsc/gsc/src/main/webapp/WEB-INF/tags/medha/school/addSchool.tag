<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="venues" type="java.util.List"%>
<div id="add-school-modal" class="modal">
	<div class="modal-content">
		<h4>Register School</h4>
		<hr>
		<div class="row">
			<form class="col s12" id="add-school" action="/" method="post">
				<div class="row">
					<div class="input-field col s6">
						<input placeholder="Enter School Name" name="name" id="school-name" type="text"
							class="validate"> <label for="first_name"><strong>Name</strong></label>
					</div>

				</div>
				<div class="row">
					<div class="input-field col s6">
						<input placeholder="School Address" name="address" id="school-address" type="text"
							class="validate"> <label for="first_name"><strong>Address</strong></label>
					</div>

				</div>
				<div class="row">
				<div class="input-field col s6">
					<select id="school-venue" name="venue">
									<option value="" disabled selected><strong>Allot Venue</strong></option>
									<c:forEach items="${venues }" var="venue">
										<option value="${venue.id }">${venue.name }</option>
									</c:forEach>
								</select> <label>Venue</label>
					
				</div>
				</div>
				<a class="btn-floating btn-large waves-effect pulse red"
					onclick="addSchool();"><i class="material-icons">add</i></a>
			</form>
		</div>
	</div>
	<div class="modal-footer">
		<a href="#!" class="modal-close waves-effect cyan btn-flat"><i class="material-icons">clear</i></a>
	</div>
</div>