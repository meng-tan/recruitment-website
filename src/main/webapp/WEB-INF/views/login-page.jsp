<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log In</title>
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 	<link href="<c:url value="/resources/css/floating-labels.css"/>" rel="stylesheet">
</head>
<body>
 	<form class="form-signin" action="${cp}/login" method="post">
      <div class="text-center mb-4">
        <h1 class="h3 mb-3 font-weight-normal">Welcome</h1>
      </div>
      <div class="form-label-group">
        <input name="username" type="text" id="inputUsername" class="form-control" placeholder="Username" required="required" autofocus="autofocus"/>
        <label for="inputUsername" >Username</label>
      </div>
      <div class="form-label-group">
        <input type="password" name="password"  id="inputPassword" class="form-control" placeholder="Password" required="required"/>
        <label for="inputPassword" >Password</label>
      </div>
      <button class="btn btn-lg btn-success btn-block" type="submit">Log In</button>
      <p class="mt-5 mb-3 text-muted text-center">&copy; 2017-2018</p>
    </form>
</body>
</html>