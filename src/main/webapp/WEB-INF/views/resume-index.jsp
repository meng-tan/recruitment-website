<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Resume Index</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="<c:url value="/resources/css/album.css"/>" rel="stylesheet">
  </head>

  <body>

    <header>
      <div class="collapse bg-dark" id="navbarHeader">
        <div class="container">
          <div class="row">
            <div class="col-sm-8 col-md-7 py-4">
              <h4 class="text-white">About</h4>
              <p class="text-muted">This page lists all resumes.</p>
            </div>
            <div class="col-sm-4 offset-md-1 py-4">
              <ul class="list-unstyled">
                <li><a href="${cp}/register" class="text-white">Register</a></li>
                <li><a href="${cp}/login" class="text-white">Login</a></li>
                <li><a href="${cp}/logout" class="text-white">Logout</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div class="navbar navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
          <a href="#" class="navbar-brand d-flex align-items-center">
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mr-2"><path d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z"></path><circle cx="12" cy="13" r="4"></circle></svg>
            <strong>Album</strong>
          </a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
        </div>
      </div>
    </header>

    <main role="main">

      <section class="jumbotron text-center">
        <div class="container">
          <h1 class="jumbotron-heading">Seek Talents</h1>
          <p class="lead text-muted">Hire the right people.</p>
          <p class="lead text-muted">Find them here.</p>
          <p>
            <a href="#" class="btn btn-primary my-2">filter by target school</a>
            <a href="#" class="btn btn-primary my-2">filter by target major</a>
          </p>
        </div>
      </section>
      
<c:if test="${not empty resumes}">
      <div class="album py-5 bg-light">
        <div class="container">

          <div class="row">
<c:forEach items="${resumes}" var="resume">
            <div class="col-md-4">
              <div class="card mb-4 box-shadow">
                <div class="card-body">
                  <p class="card-text">Objective: ${resume.objective}</p>
                  <p class="card-text">${resume.firstName} ${resume.lastName}</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                      <form action="${contextPath}/hr/viewResume" method="POST">
                        <button class="btn btn-secondary" type="submit" name="Resume_ID" value="${resume.id}">View details &raquo;</button>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
</c:forEach>            
           </div>
           
           
          </div>
		</div>
</c:if>		
    </main>

    <footer class="text-muted">
      <div class="container">
        <p class="float-right">
          <a href="#">Back to top</a>
        </p>
      </div>
    </footer>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
  </body>
</html>
