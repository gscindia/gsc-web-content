function drawTotalEnrollmentChart(selector,count,height) {
	Highcharts.chart(selector, {
		title: {
			text: 'Total Number of Applications',
			align: 'left'
		},
		subtitle: {
			text: 'Source: Medha Sandhan Examination - Garalgacha Science Club - Official Website',
			align: 'left'
		},
		chart: {
			type: 'gauge',
			plotBackgroundColor: null,
			plotBackgroundImage: null,
			plotBorderWidth: 0,
			plotShadow: true,
			height: height
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