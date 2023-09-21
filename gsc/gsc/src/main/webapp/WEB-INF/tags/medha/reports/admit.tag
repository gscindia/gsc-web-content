<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col s12">
	    
		<div class="row valign-wrapper">
			<div class="col s7 input-field">
				<select id="admit-school" name="school">
					<option value="" disabled selected>Choose your school</option>
					<c:forEach items="${schools }" var="school">
						<option value="${school.id }">${school.name }</option>
					</c:forEach>
				</select> <label>Select School<span class="red-text">*</span></label>
			</div>
			
		<!-- </div> -->
		<div class='col s1 '><span>OR</span></div>
		<!-- <div class="row"> -->
			<div class="col s4 input-field">
				<select id="admit-student-class" name="cls">
					<option value="" disabled selected>Choose your class</option>
					<option value="1">I</option>
					<option value="2">II</option>
					<option value="3">III</option>
					<option value="4">IV</option>
					<option value="5">V</option>
					<option value="6">VI</option>
					<option value="7">VII</option>
					<option value="8">VIII</option>
					<option value="9">IX</option>
					<option value="10">X</option>
					<option value="11">XI</option>
					<option value="12">XII</option>
				</select> <label>Select Class<span class="red-text">*</span></label>
			</div>
			
		</div>
		<div class="row">
			<div class="col s6 input-field">
				<select id="admit-exam-year" name="cls">
					<option value="" disabled selected>Choose Examination</option>
					<c:forEach items="${examList}" varStatus="status" var="exam">
						<option value="${exam.id }">${exam.formattedName }</option>
					</c:forEach>
				</select> <label>Examination<span class="red-text">*</span></label>
			</div>
			<button class="btn waves-effect waves-light btn-large red"
				type="button" name="action" onclick="previewAdmitCards();">
				<i class="material-icons right ">print</i>Admit Card
			</button>
			<button class="btn waves-effect waves-light btn-large green " target="_blank"
				type="button" name="action" onclick="previewSchoolAdmit();">
				<i class="material-icons right ">print</i>Admit for School 
			</button>
		</div>
		
		
		<div class='row'>
			
		</div>

		
	</div>
	<div class="col s4"></div>
</div>