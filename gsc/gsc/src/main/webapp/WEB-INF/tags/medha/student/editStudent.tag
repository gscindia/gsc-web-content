<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="schools" type="java.util.List"%>
<%@ attribute name="id"%>
<div id="edit-student-modal" class="modal">
	<div class="modal-content">
		<h4>Edit Student</h4>
		<hr>
		<div class="row">
			<form class="col s12" id="edit-student" action="/" type="post">
			<input type="hidden" name="id" id ="roll-id" value="" />			
				<div class="row">
					<div class="input-field col s6">
						<input placeholder="Enter Name" name="name" id="edit-student-name" type="text"
							class="validate"> <label for="edit-student-name" class="bold">Student Name</label>
					</div>
				</div>
				<div class="row">	
					<div class="input-field col s5">							
								<span>
									<label> <input name="gender" id="Male" value="M" type="radio"
										class="with-gap" /> <span class="bold">Male </span>
									</label>
								</span>
								<span>
									<label> <input name="gender" value="F" id="Female" type="radio"
										class="with-gap" /> <span class="bold">Female</span>
									</label>
								</span>	
					</div>							
				</div>
				<div class="row">
					<div class="input-field col s5">
						<select id="edit-student-school" name="school">
										<option value="" disabled selected class="bold">Choose your school</option>
										<c:forEach items="${schools }" var="school">
											<option value="${school.id }">${school.name }</option>
										</c:forEach>
						</select> <label>Select School</label>
						
					</div>
				</div>
				<div class="row">					
						<div class="input-field col s6">							
								<input value="" placeholder="Enter Mobile" id="edit-student-contact" type="text" name="mobile" 
									data-length="10" maxlength="10" pattern="^(\d{10})?$"
									class="validate"> <label class="active"
									for="edit-student-contact"><strong>Mobile No.<span
										class="red-text">(Optional)</span></strong></label>
						</div>
					
				<a class="btn-floating btn-large waves-effect pulse red center"
					onclick="editStrudent(event);"><i class="material-icons">save</i></a>
				</div>
				
			</form>
		</div>
	</div>
	<div class="modal-footer">
		<a href="#!" class="modal-close waves-effect cyan btn-flat"><i class="material-icons">clear</i></a>
	</div>
</div>
