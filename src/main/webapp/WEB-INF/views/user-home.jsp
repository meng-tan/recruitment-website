<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${user.role.role} HOME</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="<c:url value="/resources/css/jumbotron.css"/>" rel="stylesheet">
  </head>
  <body>
	
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${contextPath}/register">Register</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${contextPath}/login">Login</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${contextPath}/logout">Logout</a>
          </li>
        </ul>
      </div>
    </nav>

    <main role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <div class="container">
          <h1 class="display-3">Hello, ${user.username}!</h1>
          <p>
            <a class="btn btn-primary btn-lg" href="${contextPath}/user/addResume"  role="button">Add A Resume &raquo;</a>
            <a class="btn btn-primary btn-lg" href="${contextPath}/user/jobIndex"  role="button">Seek Jobs &raquo;</a>
            <a class="btn btn-primary btn-lg" href="${contextPath}/user/viewApplications"  role="button">View My Applications &raquo;</a>
          </p>
        </div>
      </div>

<c:if test="${not empty user.resumes}">
      <div class="container">
        <!-- Example row of columns -->
        <div class="row">

        <c:forEach items="${user.resumes}" var="resume">
          <div class="col-md-4">
            <h2>${resume.resumeTitle}</h2>
            <p>Objective: ${resume.objective}</p>
            <p>
            <form action="${contextPath}/user/viewResume" method="POST">
            	<button class="btn btn-secondary" type="submit" name="Resume_ID" value="${resume.id}">View details &raquo;</button>
          	</form>
            </p>
          </div>
        </c:forEach>
         
        </div>
        <hr>
      </div> 
</c:if>
      
    </main>

    <footer class="container">
      <p>&copy; Company 2017-2018</p>
    </footer>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
  </body>
</html>