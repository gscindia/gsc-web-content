<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
							<form class="col s12" id="add-exam-form">
								<h4>Start a new exam</h4>
								<div class="row">
									<div class="input-field col s12">
										<i class="material-icons prefix tiny">quiz</i> <input
											id="exam-name" name="name" type="text" class="validate"
											data-length="30"> <label for="exam-name">Exam
											Name</label>
									</div>
									<div class="input-field col s12">
										<i class="material-icons prefix tiny">calendar_month</i> <input
											type="text" name="date" class="datepicker"> <label>Date</label>
									</div>
																		
									<div class=" col s12">
										<div class="chips chips-placeholder chips-autocomplete">
											<input class="custom-class">
										</div>
									</div>
									<div class="col s12">
										<div class="switch" id="exam-switch"> <!-- -->
											<label> Closed <input id="status-switch"
												type="checkbox" data-status="off"> <span
												class="lever"></span> Active
											</label>
										</div>
									</div>
								</div>
								<a class="btn-floating btn-large waves-effect pulse right red" onclick='addExam();'><i
									class="material-icons">add</i></a>
							</form>
						</div>