$(document).ready(function() {
	$('select').formSelect();
	drawSgb(0, -1);
	drawCgb(0);
	drawTotalEnrollmentChart(callApi('/reports/enrollment?year=0', 'POST', '{}'));

	$('#analytics-year').on('change', function() {
		redoCharts($('#analytics-year').val());
	});

	$('#analytics-school-sgc').on('change', function() {
		drawSgb($.isEmptyObject($('#analytics-year').val()) ? -1 : $('#analytics-year').val(), $('#analytics-school-sgc').val());
	});
});

function redoCharts(y) {
	drawSgb(y, -1);
	drawCgb(y);
	drawTotalEnrollmentChart(callApi('/reports/enrollment?year=' + y, 'POST', '{}'));
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
function drawTotalEnrollmentChart(count) {
	Highcharts.chart('enrollment-chart', {
		chart: {
			type: 'gauge',
			plotBackgroundColor: null,
			plotBackgroundImage: null,
			plotBorderWidth: 0,
			plotShadow: true,
			height: '90%'
		},

		title: {
			text: 'Enrollment Statistics'
		},

		pane: {
			startAngle: -90,
			endAngle: 89.9,
			background: null,
			center: ['50%', '75%'],
			size: '110%'
		},

		// the value axis
		yAxis: {
			min: 0,
			max: 1400,
			tickPixelInterval: 72,
			tickPosition: 'inside',
			tickColor: Highcharts.defaultOptions.chart.backgroundColor || '#FFFFFF',
			tickLength: 20,
			tickWidth: 3,
			minorTickInterval: null,
			labels: {
				distance: 20,
				style: {
					fontSize: '14px'
				}
			},
			lineWidth: 0,
			plotBands: [{
				from: 0,
				to: 499,
				color: '#d50000 ', // red
				thickness: 20
			}, {
				from: 500,
				to: 799,
				color: '#ffea00 ', // yellow
				thickness: 20
			}, {
				from: 800,
				to: 1200,
				color: '#1b5e20 ', // green
				thickness: 20
			}, {
				from: 1201,
				to: 2000,
				color: '#d50000 ', // red
				thickness: 20
			}]
		},

		series: [{
			name: 'Enrollment Statistics',
			data: [count],
			tooltip: {
				valueSuffix: ' Student enrolled'
			},
			dataLabels: {
				format: 'Total {y} Applications',
				borderWidth: 0,
				color: (
					Highcharts.defaultOptions.title &&
					Highcharts.defaultOptions.title.style &&
					Highcharts.defaultOptions.title.style.color
				) || '#333333',
				style: {
					fontSize: '18px'
				}
			},
			dial: {
				radius: '80%',
				backgroundColor: '#212121',
				baseWidth: 12,
				baseLength: '0%',
				rearLength: '0%'
			},
			pivot: {
				backgroundColor: '#ff8f00 ',
				radius: 20
			}

		}]

	});



}
