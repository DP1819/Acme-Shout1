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

<label for="usernamecheck" ><spring:message code="shout.usernamecheck" /></label>
<input id="usernamecheck" type="checkbox" onclick="usernamecheckFunction('${username}')" checked />	

<form:form action="shout/edit.do" modelAttribute="shout" >
	
	<form:label path="username" >
		<spring:message code="shout.username" />
	</form:label>
	<form:input path="username" onload="usernamecheckFunction('${username}')" />
	<form:errors path="username" cssClass="error" />
	
	<br>
	
	<form:label path="text">
		<spring:message code="shout.text" />
	</form:label>
	<form:input path="text" />
	<form:errors path="text" cssClass="error" />
	
	<br>
	
	<form:label path="link" >
		<spring:message code="shout.link" />
	</form:label>
	<form:input path="link" />
	<form:errors path="link" cssClass="error" />
	
	<br>
	
	<button type="submit" name="save" onclick="document.getElementById('username').disabled = false" ><spring:message code="shout.save" /></button>
	
</form:form>

<button type="button" onclick="window.location = 'shout/list.do';" ><spring:message code="shout.cancel" /></button>