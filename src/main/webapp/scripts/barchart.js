function chartShouts(nShouts, nLongShouts, nShortShouts) {
	var ns = Number(nShouts);
	var nss = Number(nShortShouts);
	var nls = Number(nLongShouts);
	var chart = new CanvasJS.Chart("chartContainer", {
		animationEnabled : true,
		theme : "light2", // "light1", "light2", "dark1", "dark2"
		title : {
			text : ""
		},
		axisY : {
			title : "<spring:message code='dashboard.numbershouts'/>"
		},
		data : [
			{
				type : "column",
				showInLegend : true,
				legendMarkerColor : "grey",
				legendText : "",
				dataPoints : [
						{
							y : ns,
							label : "<spring:message code='dashboard.numbershouts'/>"
						}, {
							y : nss,
							label : "<spring:message code='dashboard.numbershortshouts'/>"
						}, {
							y : nls,
							label : "<spring:message code='dashboard.numberlongshouts'/>"
						},
				]
			}
		]
	});
	chart.render();

};