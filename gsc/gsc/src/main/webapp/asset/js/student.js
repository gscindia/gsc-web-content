$(document).ready(function() {
	$('#student-school,#student-class').formSelect();
});

function enroll() {
	if (validateEnrollData()) {
		var formData = JSON.stringify(prepareFormData(document.getElementById('enroll-form')));
		var form = $('#enroll-form');
		var response = callApi(form.attr('action'), form.attr('method'), formData);
		if ($.isEmptyObject(response)) {
			M.toast({ html: "<span class='material-icons red-text'>bug_report</span>&nbsp;Something went wrong. &nbsp; <span class='material-icons blue-text'>call</span> &nbsp;Contact administrator" });

		} else if(response.roll > 0) {
			$('#student-name').focus();
			$('#student-name').val('');
			M.toast({ html: "<span class='material-icons green-text'>verified</span>&nbsp; Roll Number as realised " + response.roll, completeCallback: function() { } });
		}else{
			M.toast({ html: "<span class='material-icons red-text'>error</span>&nbsp;Enrollment is yet to start"});
		}
	} else {
		M.toast({ html: 'Please fill all details' });
	}

}
function validateEnrollData() {
	var isValid = true;

	var json = prepareFormData(document.getElementById('enroll-form'));
	try {
		if ($.isEmptyObject(json.name) || $.isEmptyObject(json.school) || $.isEmptyObject(json.cls) || $.isEmptyObject(json.gender)) {
			isValid = false;
		}
	} catch (ex) {
		isValid = false;
	}
	return isValid;
}

function popModal(studentId) {
	$('#edit-student-modal').modal('open');
	$('#roll-id').val(studentId);

}

function editStrudent(event) {

	const obj = prepareFormData(document.getElementById('edit-student'));
	var formData = JSON.stringify(obj);

	if ($.isEmptyObject(obj.name) || $.isEmptyObject(obj.school) || $.isEmptyObject(obj.gender)) {
		M.toast({ html: 'Please fill all details' });
	} else {
		var response = callApi('/medha/student/edit', 'POST', formData);
		if ($.isEmptyObject(response)) {
			M.toast({ html: "<span class='material-icons red-text'>bug_report</span>&nbsp;Something went wrong. &nbsp; <span class='material-icons blue-text'>call</span> &nbsp;Contact administrator" });

		}else if(response.editStatus!='Done'){
			
			M.toast({ html: "<span class='material-icons red-text'>error</span>&nbsp; Could not update at this moment." });
		} 
		else {
			M.toast({ html: "<span class='material-icons green-text'>done_all</span>&nbsp; Details Updated!"});
		}
	}
}
function removeStudent(id) {
	if (confirm('Are you sure? It can not be undone') == true) {
		$.post("/medha/student/remove/" + id,
			function(data, textStatus) {
				if (textStatus == 'success') {

					M.toast({ html: 'Student Removed ', completeCallback: function() { location.reload() } });
				} else {
					M.toast({ html: 'Something went wrong with server. Try later' });

				}
			});
	}
}
