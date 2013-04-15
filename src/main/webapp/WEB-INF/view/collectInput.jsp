<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/liferay-portlet.tld" prefix="portlet" %>
<portlet:actionURL var="addInput">
	<portlet:param name="myaction" value="addInput"/>
</portlet:actionURL>
<form:form action="${addInput}" commandName="userInput" method="post">
	First name: 
		<font color="red"><form:errors path="firstName" /></font>
		<form:input path="firstName" />
		<br/>
	Last name: 
		<font color="red"><form:errors path="lastName" /></font>
		<form:input path="lastName"/>
		<br/>
	User name: 
		<font color="red"><form:errors path="userName" /></font>
		<form:input path="userName" />
		<br/>
	Age: 
		<font color="red"><form:errors path="age" /></font>
		<form:input path="age"/>
		<br/>
	Email: 
		<font color="red"><form:errors path="email" /></font>
		<form:input path="email" />
		<br/>
	Password: 
		<font color="red"><form:errors path="password" /></font>
		<form:input path="password"/>
		<br/>
	<input type="submit" value="Add Input">
</form:form>