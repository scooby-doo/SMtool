<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
You have entered: <br/>
First Name <core:out value="${userInput.firstName}" /> <br/>
Last Name <core:out value="${userInput.lastName}" /> <br/>
User Name <core:out value="${userInput.userName}" /> <br/>
Age: <core:out value="${userInput.age}" /> <br/>
Password <core:out value="${userInput.password}" /> <br/> 
Email: <core:out value="${userInput.email}" /> <br/>
</body>
</html>