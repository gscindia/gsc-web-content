$(document).ready(function() {
	beforeAjaxBlockUI('<h4>Preparing Analysis...</h4>');
	$('select').formSelect();
	drawSgb(0, -1);
	drawCgb(0);
	drawTotalEnrollmentChart('enrollment-chart', callApi('/reports/enrollment?year=0', 'POST', '{}'),'90%');
	$.unblockUI();
	$('#analytics-year').on('change', function() {
		beforeAjaxBlockUI('<h4>Preparing Analysis...</h4>');
		redoCharts($('#analytics-year').val());
		$.unblockUI();
	});

	$('#analytics-school-sgc').on('change', function() {
		beforeAjaxBlockUI('<h4>Preparing Analysis...</h4>');
		drawSgb($.isEmptyObject($('#analytics-year').val()) ? -1 : $('#analytics-year').val(), $('#analytics-school-sgc').val());
		$.unblockUI();
	});

});

function redoCharts(y) {
	drawSgb(y, -1);
	drawCgb(y);
	drawTotalEnrollmentChart('enrollment-chart', callApi('/reports/enrollment?year=' + y, 'POST', '{}'),'90%');
}
function drawSgb(y, z) {
	var response = callApi('/reports/sgc?year=' + y + '&schoolId=' + z, 'POST', '{}');
	drawBar('school-gender-chart', response, 'Male vs Female participation',
		'Source: Medha Sandhan Examination - Garalgacha Science Club - Official Website',
		'Schools', 'Head Count', 'MALE', 'FEMALE');
}
function drawCgb(y) {
	var response = callApi('/reports/cgs?year=' + y, 'POST', '{}');
	drawBar('class-gender-chart', response, 'Male vs Female participation',
		'Source: Medha Sandhan Examination - Garalgacha Science Club - Official Website',
		'Class', 'Head Count', 'MALE', 'FEMALE');
}

function drawBar(selector, data, titleText, subtitle, xDesc, yTitle, bar1, bar2) {
	Highcharts.chart(selector, {
		chart: {
			type: 'column'
		},
		title: {
			text: titleText,
			align: 'left'
		},
		subtitle: {
			text: subtitle,
			align: 'left'
		},
		xAxis: {
			categories: data.school,
			crosshair: true,
			accessibility: {
				description: xDesc
			}
		},
		yAxis: {
			min: 0,
			title: {
				text: yTitle
			}
		},
		tooltip: {
		},
		plotOptions: {
			column: {
				pointPadding: 0.2,
				borderWidth: 0
			},
			series: {
				dataLabels: {
					enabled: true,
					allowOverlap: true
				}
			}
		},

		series: [
			{
				name: bar1,
				data: data.male
			},
			{
				name: bar2,
				data: data.female
			}
		]
	});
}

