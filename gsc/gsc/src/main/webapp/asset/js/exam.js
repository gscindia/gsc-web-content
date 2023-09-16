$(document).ready(function() {
	$("#slider").slider({
		values: [2, 12]
	});
	$(".dropdown-trigger").dropdown();
	$('.collapsible').collapsible();
	$('input#icon_prefix').characterCounter();
	$('.datepicker').datepicker({
		format: 'yyyy-mm-dd'

	});


	$('.carousel.carousel-slider').carousel({
		fullWidth: true,
		indicators: true
	});
	$('.sidenav').sidenav();





	$('.chips').chips();
	$('.chips-placeholder').chips({
		placeholder: 'Select a Venue',
		secondaryPlaceholder: 'add another'
	});

	try {

		$('.chips-autocomplete').chips({
			autocompleteOptions: {
				data: autocomplete,
				limit: Infinity,
				minLength: 1
			}
		});
	} catch (ex) {

	}



	$('.venue-list').click(function() {
		var row = $(this).data('row');
		$('.venue-details').removeClass('show');
		$('.venue-details').addClass('hide');
		$('#venue-' + row).removeClass('hide');
		$('#venue-' + row).addClass('show');
	});

	$('#exam-switch').find('#status-switch').click(function() {
		var currentStatus = $('#exam-switch').find('#status-switch').data('status');
		if (currentStatus == 'off' || currentStatus == "OFF") {
			$('#exam-switch').find('#status-switch').data('status', 'ACTIVE');
		} else {
			$('#exam-switch').find('#status-switch').data('status', 'OFF');
		}
	});
	$('.tabs').tabs();
	$('select').formSelect();

	
});

function addExam() {
	var name = $('#exam-name').val();;
	var date = $('.datepicker').datepicker('toString').val();
	var status = $('#exam-switch').find('#status-switch').data('status').toUpperCase();
	var venues = [];
	var chips = document.getElementsByClassName('chip');

	for (i = 0; i < chips.length; i++) {
		var html = chips[i].innerHTML;
		var index = html.indexOf("<");
		var value = html.slice(0, index);
		venues.push(value);

	}
	data = {
		"name": name,
		"date": date,
		"venue": venues,
		"status": status
	}
	if (!$.isEmptyObject(name) && !$.isEmptyObject(date) && !$.isEmptyObject(venues) && chips.length >= 1) {
		result = callApi("/medha/exam/add", 'POST', JSON.stringify(data));
		if ($.isEmptyObject(result)) {
			M.toast({ html: 'Something went wrong - at server. Try later' });

		} else {
			M.toast({ html: 'Hurray! Exam scheduled', completeCallback: function() { location.reload(); } });
		}
	} else {
		M.toast({ html: 'Please check your inputs' });
	}



}
function previewA() {
	if ($.isEmptyObject($('#forma-school').val()) || $.isEmptyObject($('#forma-exam-year').val())) {
		M.toast({ html: 'Please select mandatory fields' });
	} else {
		window.open("forma/2/" + $('#forma-school').val() + "/" + $('#forma-exam-year').val() + "?page=20");
		window.open("forma/1/" + $('#forma-school').val() + "/" + $('#forma-exam-year').val() + "?page=20");
	}
}
function previewB() {
	if ($.isEmptyObject($('#formb-student-class').val()) || $.isEmptyObject($('#formb-exam-year').val())) {
		M.toast({ html: 'Please select mandatory fields' });
	} else {
		window.open("formb/" + $('#formb-student-class').val() + "/" + $('#formb-exam-year').val() + "?page=20");
	}
}
function previewAdmitCards() {
	if ($.isEmptyObject($('#admit-student-class').val()) || $.isEmptyObject($('#admit-exam-year').val())) {
		M.toast({ html: 'Please select mandatory fields' });
	} else {
		window.open("admit-cards/" + $('#admit-student-class').val() + "/" + $('#admit-exam-year').val());
	}
}
function previewSchoolAdmit() {
	if ($.isEmptyObject($('#admit-school').val()) || $.isEmptyObject($('#admit-exam-year').val())) {
		M.toast({ html: 'Please select mandatory fields' });
	} else {
		window.open("school-admit-cards/" + $('#admit-school').val() + "/" + $('#admit-exam-year').val());
	}
}
