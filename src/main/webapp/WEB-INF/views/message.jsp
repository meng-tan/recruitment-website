<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Message Page</title>
</head>
<body>
<h1>Message</h1>
<p>${message}</p>
<sec:authorize access="hasRole('USER')">
<a href="${cp}/user/user-home">Back To Home</a>
</sec:authorize>
<sec:authorize access="hasRole('ADMIN')">
<a href="${cp}/admin/admin-home">Back To Home</a>
</sec:authorize>   
</body>
</html>