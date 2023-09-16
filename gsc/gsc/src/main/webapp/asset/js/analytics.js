$(document).ready(function() {
	$('select').formSelect();
	drawSgb(0);
	drawCgb(0);

	$('#analytics-year').on('change', function() {
		redoCharts($('#analytics-year').val());
	});
});

function redoCharts(y) {
	drawSgb(y);
	drawCgb(y);
}
function drawSgb(y) {
	var response = callApi('/reports/sgc?year=' + y, 'POST', '{}');
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
