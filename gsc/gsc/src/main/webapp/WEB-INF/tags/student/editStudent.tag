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
							class="validate"> <label for="first_name"><strong>Student Name</strong></label>
					</div>

				</div>
				<div class="row">
				<div class="input-field col s5">
					<select id="student-school" name="school">
									<option value="" disabled selected><strong>Choose your school</strong></option>
									<c:forEach items="${schools }" var="school">
										<option value="${school.id }">${school.name }</option>
									</c:forEach>
					</select> <label>Select School</label>
					
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
