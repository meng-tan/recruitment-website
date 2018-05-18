<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!doctype html>
<html lang="en">
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Resume Form</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
   <link  href="<c:url value="/resources/css/form-validation.css"/>" rel="stylesheet">
  </head>
  <body class="bg-light">

    <div class="container">
      <div class="py-5 text-center">
        <h2>Resume Form</h2>
      </div>

      <div class="row justify-content-md-center">
        <div class="col-md-8 order-md-1">
          <h4 class="mb-3">Contact Information</h4>
          <hr class="mb-4">
          <form:form modelAttribute="resume" class="needs-validation" action="${cp}/user/addResume" method="post">
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="firstName">First name</label>
                <form:input path="firstName" name="firstName" type="text" class="form-control" id="firstName" placeholder="" value="Meng" required="required" />
              </div>
              
              <div class="col-md-6 mb-3">
                <label for="lastName">Last name</label>
                <form:input type="text" path="lastName" name="lastName" class="form-control" id="lastName" placeholder="" value="Tan"  required="required"/>
              </div>
            </div>

            <div class="mb-3">
              <label for="tel">Tel</label>
              <div class="input-group">
                <form:input type="tel" name="tel" path="tel" class="form-control" id="tel" placeholder="" value="1111111111" required="required"/>
              </div>
            </div>

            <div class="mb-3">
              <label for="email">Email</label>
              <form:input type="email" path="email" name="email" class="form-control" id="email" value="tanmeng@qq.com" placeholder="you@example.com"/>
            </div>

            <h4 class="mb-3">General Information</h4>
            <hr class="mb-4">
            
            <div class="mb-3">
              <label for="resumeTitle">Resume Title</label>
              <form:input type="text" class="form-control" path="resumeTitle" name="resumeTitle" id="resumeTitle" value="My Resume"  required="required"/>
            </div>

            <div class="mb-3">
              <label for="objective">Objective</label>
              <form:input type="text" class="form-control" path="objective" name="objective" id="objective" value="Web Developer"  required="required"/>
            </div>

            <h4 class="mb-3">Education Background <button class="btn btn-primary add" style="float: right;">Add</button></h4>
            <div class="addlist edus">
            <hr class="mb-4">
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="from">Year From</label>
                <input type="month" class="form-control eduYearFrom" name="eduFrom" id="from" placeholder="" value=""  required="required"/>
              </div>
              <div class="col-md-6 mb-3">
                <label for="to">Year To</label>
                <input type="month"class="form-control eduYearTo" id="to" name="eduTo" placeholder="" value=""  required="required"/>
              </div>
            </div>

            <div class="row">
              <div class="col-md-5 mb-3">
                <label for="university">University</label>
                <input type="text" class="form-control university" id="" name="university" placeholder="" value="NEU"  required="required"/>
              </div>
              
              <div class="col-md-3 mb-3">
                <label for="degree">Degree</label>
                <input type="text" class="form-control degree" name="degree" id="degree" value="Master" required="required"/>
              </div>
              
              <div class="col-md-4 mb-3">
                <label for="major">Major</label>
                <input type="text" class="form-control major" id="" name="major" placeholder="" value="CSYE"  required="required"/>
              </div>
            </div>
			</div>
			
            <h4 class="mb-3">Experience<button class="btn btn-primary add" style="float: right;">Add</button></h4>
            <div class="addlist exps">
            <hr class="mb-4">
              <div class="row">
                <div class="col-md-6 mb-3">
                  <label for="from">Year From</label>
                  <input type="month" class="form-control expYearFrom" name="expFrom" id="from" placeholder="" value=""  required="required"/>
                </div>
                <div class="col-md-6 mb-3">
                  <label for="to">Year To</label>
                  <input type="month" class="form-control expYearTo"  name="expTo" id="to" placeholder="" value="" required="required"/>
                </div>
              </div>

              <div class="row">
                <div class="col-md-6 mb-3">
                  <label for="company">Company</label>
                  <input type="text" class="form-control company"  name="company" id="company" value="GeekGroup" required="required"/>
                </div>
                <div class="col-md-6 mb-3">
                  <label for="title">Title</label>
                   <input type="text" class="form-control title"  name="title" id="title" value="Web Developer Intern" required="required"/>
                </div>
            </div>

            <div class="mb-3">
              <label for="responsibility">Responsibility</label>
              <textarea name="responsibility" class="form-control" id="responsibility"></textarea>
            </div>
			</div>
			
			<h4 class="mb-3">Skill<button class="btn btn-primary add" style="float: right;">Add</button></h4>
            <div class="addlist skills">
              <div class="row">
                <div class="col-md-6 mb-3">
                  <label for="skill">Skill</label>
                  <input type="text" class="form-control skill" name="skill" id="skill" placeholder="" value="SpringMVC"  required="required"/>
                </div>
              </div>
			</div>
			
            <hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" id="save" type="submit" >Save Resume</button>
          </form:form>
        </div>
      </div>

      <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2017-2018 Company Name</p>
        <ul class="list-inline">
          <li class="list-inline-item"><a href="#">Privacy</a></li>
          <li class="list-inline-item"><a href="#">Terms</a></li>
          <li class="list-inline-item"><a href="#">Support</a></li>
        </ul>
      </footer>
    </div>
<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-1.9.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
    <script>
    $(document).ready(function () {
        $(document).on('click', '.add', function (event) {
            var $clone=$(this).parent().next().clone();
            $clone.find("input").val("");
            $clone.find("textarea").val("");
            $clone.insertBefore($(this).parent().next());
        });
    });
    </script>
  </body>
</html>
