var studentDataTable;
$(document).ready(function() {
	beforeAjaxBlockUI('<h4 class="">Hang on! Fetching data</h4>');
	studentTable = $('#student-list');
	$('select').formSelect();
	studentDataTable = studentTable.DataTable({
		ajax: { url: "/medha/school/forma/datatable/-1", type: 'POST' },
		"pageLength" : 50,
		order: [[1, 'asc']],
		columnDefs: [
			{
				targets: ['_all'],
				className: 'mdc-data-table__cell'
			}
		],
		initComplete: function(settings, json) { $('.tooltipped').tooltip();$.unblockUI(); }
	});

	$('.dataTables_length').addClass('col s4');

	$('.school-list').click(function() {
		beforeAjaxBlockUI('<h4 class="">Hang on! Fetching data</h4>');
		refreshStudentDataTable('/medha/school/forma/datatable/' + $(this).data('id'),$(this).data('name'));
	});
	
});

function refreshStudentDataTable(url,schoolName) {
	$('#selected-school').html(schoolName);
	studentDataTable.destroy();
	studentDataTable = studentTable.DataTable({
		ajax: { url: url, type: 'POST' },
		"pageLength" : 25,
		columnDefs: [
			{
				targets: ['_all'],
				className: 'mdc-data-table__cell'
			}
		],
		initComplete: function(settings, json) { $('.tooltipped').tooltip(); $.unblockUI(); window.scrollTo(0, 0);}
	});
	$('.dataTables_length').addClass('col s4');
}
function addSchool() {

	const obj = prepareFormData(document.getElementById('add-school'));
	var formData = JSON.stringify(obj);
	if (!$.isEmptyObject(obj.name) && !$.isEmptyObject(obj.venue)) {
		var response = callApi('/medha/school/add', 'POST', formData);
		if ($.isEmptyObject(response)) {
			M.toast({ html: 'Something went wrong with server. Try later' });

		} else {
			M.toast({ html: 'School Added!', completeCallback: function() { location.reload(); } });
		}
	} else {
		M.toast({ html: 'Please fill all details' });
	}
}


