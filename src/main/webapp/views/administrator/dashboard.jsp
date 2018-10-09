<%--
 * action-1.jsp
 *
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<table>

<tr>
	<td><spring:message code="dashboard.numbershouts" /></td>
	<td id="numberShouts">${numberShouts}</td>
</tr>

<tr>
	<td><spring:message code="dashboard.numbershortshouts" /></td>
	<td id="numberShortShouts">${numberShortShouts}</td>
</tr>

<tr>
	<td><spring:message code="dashboard.numberlongshouts" /></td>
	<td id="numberLongShouts">${numberLongShouts}</td>
</tr>

</table>

<script>
window.onload = function () {
var ns = Number(document.getElementById("numberShouts").innerHTML);
var nss = Number(document.getElementById("numberShortShouts").innerHTML);
var nls = Number(document.getElementById("numberLongShouts").innerHTML);
var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	theme: "light2", // "light1", "light2", "dark1", "dark2"
	title:{
		text: ""
	},
	axisY: {
		title: "<spring:message code='dashboard.numbershouts'/>"
	},
	data: [{        
		type: "column",  
		showInLegend: true, 
		legendMarkerColor: "grey",
		legendText: "",
		dataPoints: [      
			{ y: ns, label: "<spring:message code='dashboard.numbershouts'/>" },
			{ y: nss,  label: "<spring:message code='dashboard.numbershortshouts'/>" },
			{ y: nls,  label: "<spring:message code='dashboard.numberlongshouts'/>" },
		]
	}]
});
chart.render();

};
</script>
<div id="chartContainer" style="height: 300px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>