const subtitle = 'Source: Medha Sandhan Examination - Garalgacha Science Club - Official Website';
$(document).ready(function() {
	beforeAjaxBlockUI('<h4>Preparing Analysis...</h4>');
	$('select').formSelect();
	drawSgb($('#analytics-year').val(), -1);
	drawCgb($('#analytics-year').val());
	drawTotalEnrollmentChart('enrollment-chart', callApi('/reports/enrollment?year='+$('#analytics-year').val(), 'POST', '{}'),'90%');
	$.unblockUI();
	$('#analytics-year').on('change', function() {
		beforeAjaxBlockUI('<h4>Preparing Analysis...</h4>');
		redoCharts($('#analytics-year').val());
		$.unblockUI();
	});

	$('#analytics-school-sgc').on('change', function() {
		beforeAjaxBlockUI('<h4>Preparing Analysis...</h4>');
		drawSgb($.isEmptyObject($('#analytics-year').val()) ? 0 : $('#analytics-year').val(), $('#analytics-school-sgc').val());
		$.unblockUI();
	});
	drawSchoolLeaderBoard(callApi('/reports/school-leaderboard?year=', 'POST', '{}'));
	drawRevenueChart(callApi('/reports/revenue', 'POST', '{}'));
	drawShiftAnalysis(callApi('/reports/shift-analysis', 'POST', '{}'));

});

function redoCharts(y) {
	drawSgb(y, $('#analytics-school-sgc').val());
	drawCgb(y);
	drawSchoolLeaderBoard(callApi('/reports/school-leaderboard?year=' + y, 'POST', '{}'));
	drawTotalEnrollmentChart('enrollment-chart', callApi('/reports/enrollment?year=' + y, 'POST', '{}'),'90%');
}
function drawSgb(y, z) {
	var response = callApi('/reports/sgc?year=' + y + '&schoolId=' + z, 'POST', '{}');	
	drawBar('school-gender-chart', response, 'Gender based participation of institutions',
		subtitle,
		'Schools', 'Head Count', 'MALE', 'FEMALE');
}
function drawCgb(y) {
	var response = callApi('/reports/cgs?year=' + y, 'POST', '{}');
	drawCgbStackedChart('class-gender-chart', response, 'Gender based participation',
		subtitle,
		'Class', 'Head Count', 'MALE', 'FEMALE');
}
function drawCgbStackedChart(selector, data, titleText, subtitle, xDesc, yTitle, bar1, bar2){
	//console.log(data);
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
			categories: data.school
		},
		yAxis: {
			min: 0,
			title: {
				text: 'Percent'
			}
		},
		tooltip: {
			pointFormat: '<span style="color:{series.color}">{series.name}</span>' +
				': <b>{point.y}</b> ({point.percentage:.0f}%)<br/>',
			shared: true
		},
		plotOptions: {
			column: {
				stacking: 'percent',
				dataLabels: {
					enabled: true,
					format: '{point.y}'
				}
			}
		},
		series: [{
			name: 'Male',
			data: data.male
		}, {
			name: 'Female',
			data: data.female
		}]
	});
	

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

function drawRevenueChart(data){
	console.log(data);
	Highcharts.chart('revenue-analysis', {

		title: {
			text: 'Revenue Growth',
			align: 'left'
		},
	
		subtitle: {
			text: subtitle,
			align: 'left'
		},
	
		yAxis: {
			title: {
				text: 'Revenue earned from Enrollment'
			},
			tickInterval: 500
		},
	
		xAxis: {
			accessibility: {
				//rangeDescription: 'Year: 2023 to 2022'
			},
			tickInterval: 1
			
		},
	
		legend: {
			layout: 'vertical',
			align: 'right',
			verticalAlign: 'middle'
		},
	
		plotOptions: {
			series: {
				label: {
					connectorAllowed: false
				},
				lineWidth: 3,
				pointStart: 2023
			}
		},
	
		series: data,
	
		responsive: {
			rules: [{
				condition: {
					maxWidth: 500
				},
				chartOptions: {
					legend: {
						layout: 'horizontal',
						align: 'center',
						verticalAlign: 'bottom'
					}
				}
			}]
		}
	
	});
	
}

function drawSchoolLeaderBoard(data){
	Highcharts.chart('school-leaderboard', {
		chart: {
			type: 'column'
		},
		title: {
			text: 'School Leaderboard - Top 10 Institutions',
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
				description: 'School Names'
			}
		},
		yAxis: {
			min: 0,
			title: {
				text: 'Count'
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
				name: 'Applications',
				data: data.application
			}
		]
	});
}	
function drawShiftAnalysis(data){

	Highcharts.chart('shift-analysis', {

		title: {
			text: 'Primary and Secondary Participation Trend',
			align: 'left'
		},
	
		subtitle: {
			text: subtitle,
			align: 'left'
		},
	
		yAxis: {
			title: {
				text: 'No. of Enrollment'
			},
			tickInterval: 100
		},
	
		xAxis: {
			accessibility: {
				//rangeDescription: 'Year: 2023 to 2022'
			},
			tickInterval: 1
			
		},
	
		legend: {
			layout: 'vertical',
			align: 'right',
			verticalAlign: 'middle'
		},
	
		plotOptions: {
			series: {
				label: {
					connectorAllowed: false
				},
				lineWidth: 3,
				pointStart: 2023
			}
		},
	
		series: data,
	
		responsive: {
			rules: [{
				condition: {
					maxWidth: 500
				},
				chartOptions: {
					legend: {
						layout: 'horizontal',
						align: 'center',
						verticalAlign: 'bottom'
					}
				}
			}]
		}
	
	});
}