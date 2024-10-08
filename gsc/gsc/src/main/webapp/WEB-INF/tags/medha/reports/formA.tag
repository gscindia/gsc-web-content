<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col s12">
	
		
		<div class="row">
			<div class="col s12 input-field">
				<select id="forma-exam-year" name="cls">
					<option value="" disabled selected>Choose Examination</option>
					<c:forEach items="${examList}" varStatus="status" var="exam">
						<option value="${exam.id }">${exam.formattedName }</option>
					</c:forEach>
				</select> <label>Examination<span class="red-text">*</span></label>
			</div>

			
		</div>
		 <div class="row">
			<div class="col s7 input-field">
				<select id="forma-school" name="school">
					<option value="" disabled selected>Choose your school</option>
					<c:forEach items="${schools }" var="school">
						<option value="${school.id }">${school.name }</option>
					</c:forEach>
				</select> <label>Select School<span class="red-text">*</span></label>
			</div>
		
			
				<button class="btn waves-effect waves-light btn-large red" target="_blank"
				type="button" name="action" onclick="previewA();">
				<i class="material-icons right ">print</i>Form 'A' 
			</button>		
		</div>


	</div>
</div>

