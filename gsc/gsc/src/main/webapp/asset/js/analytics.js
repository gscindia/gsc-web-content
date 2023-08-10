$(document).ready(function(){
	
	drawSgb();
});

function drawSgb() {
	var response = callApi('/reports/sgc','POST','{}');
	Highcharts.chart('sgc', {
		chart: {
			type: 'column'
		},
		title: {
			text: 'Male vs Female participation',
			align: 'left'
		},
		subtitle: {
			text:'Source: Medha Sandhan Examination - Garalgacha Science Club - Official Website',
			align: 'left'
		},
		xAxis: {
			categories: response.school,
			crosshair: true,
			accessibility: {
				description: 'Schools'
			}
		},
		yAxis: {
			min: 0,
			title: {
				text: 'Head Count'
			}
		},
		tooltip: {
		},
		plotOptions: {
			column: {
				pointPadding: 0.2,
				borderWidth: 0
			}
		},
		series: [
			{
				name: 'MALE',
				data: response.male
			},
			{
				name: 'FEMALE',
				data: response.female
			}
		]
	});
}
