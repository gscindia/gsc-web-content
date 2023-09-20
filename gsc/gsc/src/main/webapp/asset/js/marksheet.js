var marksDataTable;
$(document).ready(function() {
	marksDataTable = $('#preview-marks-table').dataTable();
	$('.dataTables_length').addClass('col s4');
	$('select').formSelect();
	$('#btn-preview-marks').on('click', function() {
		beforeAjaxBlockUI('<h4 class="red-text">Upload in progress...</h4>');
		$('#btn-save-marks').removeAttr('disabled');
		var form = new FormData($('#form-preview-marks')[0]);

		response = uploadAttachment(form, $('#form-preview-marks').attr('action'));
		if (response == 'File Uploaded. Please Check Preview') {
			marksDataTable = $('#preview-marks-table').DataTable();
			marksDataTable.destroy();
			var marksTable = $('#preview-marks-table');
			marksDataTable = marksTable.DataTable({
				ajax: { url: "/medha/exam/preview-marks", type: 'POST' },

				columnDefs: [
					{
						targets: ['_all'],
						className: 'mdc-data-table__cell'
					},

				],
				initComplete: function(settings, json) { validateTable(); }
			});

			$('.dataTables_length').addClass('col s4');
			$('select').formSelect();
		}
		else {
			$('#btn-save-marks').attr('disabled', 'disabled');
			marksDataTable = $('#preview-marks-table').DataTable();
			marksDataTable.clear()
				.draw();
			$.unblockUI();
		}
		M.toast({ html: response });


	});

	$('#btn-save-marks').click(function() {
		response = callApi('/medha/exam/save-marks', 'GET', "");

	});
});

function validateTable() {
	$('#preview-marks-table tr').each(function() {
		if ($(this).text().toUpperCase().indexOf('STUDENT NOT FOUND') !== -1) {
			$(this).addClass('red');
			$(this).find('td').addClass('white-text');
			$('#btn-save-marks').attr('disabled', 'disabled');
		}
	});
	$.unblockUI();
}
