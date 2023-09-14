var studentDataTable;
$(document).ready(function() {
	studentTable = $('#student-list');
	$('select').formSelect();
	studentDataTable = studentTable.DataTable({
		ajax: { url: "/medha/school/forma/datatable/" + $($('.school-list')[0]).data('id'), type: 'POST' },
		/*"pageLength" : 25,*/
		columnDefs: [
			{
				targets: ['_all'],
				className: 'mdc-data-table__cell',
			}
		]
	});

	$('.dataTables_length').addClass('col s4');

	$('.school-list').click(function() {
		//console.log($(this).data('id'));
		refreshStudentDataTable('/medha/school/forma/datatable/' + $(this).data('id'));
	});

});

function refreshStudentDataTable(url) {
	studentDataTable.destroy();
	studentDataTable = studentTable.DataTable({
		autoWidth: false,
		ajax: { url: url, type: 'POST' },
		/*"pageLength" : 25,*/
		columnDefs: [
			{
				targets: ['_all'],
				className: 'mdc-data-table__cell',
			},
		]
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


