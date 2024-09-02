<%@ tag language="java" pageEncoding="ISO-8859-1" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ attribute name="venues" type="java.util.List" %>
			<div id="add-school-modal" class="modal">
				<div class="modal-content">
					<h4>Register School</h4>
					<hr>
					<div class="row">
						<form class="col s12" id="add-school" action="/" method="post">
							<div class="row">
								<div class="input-field col s6">
									<input placeholder="Enter School Name" name="name" id="school-name" type="text"
										class="validate"> <label for="school-name" class="bold">Name</label>
								</div>

							</div>
							<div class="row">
								<div class="input-field col s6">
									<input placeholder="School Address" name="address" id="school-address" type="text"
										class="validate"> <label for="school-address" class="bold">Address</label>
								</div>

							</div>
							<div class="row">
								<div class="input-field col s6">
									<select id="school-venue" name="venue">
										<option value="" disabled selected class="bold">Allot Venue</option>
										<c:forEach items="${venues }" var="venue">
											<option value="${venue.id }" class="bold">${venue.name }</option>
										</c:forEach>
									</select> <label class="bold">Venue</label>

								</div>
								<a class="btn-floating btn-large waves-effect pulse red" onclick="addSchool();"><i
									class="material-icons">add</i></a>
							</div>
							
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<a href="#!" class="modal-close waves-effect cyan btn-flat"><i class="material-icons">clear</i></a>
				</div>
			</div>