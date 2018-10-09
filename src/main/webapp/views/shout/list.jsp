<%--
 * action-2.jsp
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

<display:table id="shout" pagesize="5" requestURI="shout/list.do" name="shouts"  >
	  
	<spring:message code="shout.username" var="usernameTitle" />
	<display:column property="username" title="${usernameTitle}" sortable="true" />
	
	<spring:message code="shout.text" var="textTitle" />
	<display:column property="text" title="${textTitle}" sortable="true" />
	
	<spring:message code="shout.link" var="linkTitle" />
	<display:column title="${linkTitle}" >
		<a href="${shout.link}">${shout.link}</a>
	</display:column>

</display:table>

<button onclick="window.location = 'shout/create.do';"><spring:message code="shout.create" /></button>
