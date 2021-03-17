<%@page import="com.hrmanager.entities.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.hrmanager.service.EmployeeService"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Form</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<!-- Font Awesome CSS -->
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
   <%@include file="css/design.css"%> 
   </style>
</head>



<body>
<% 
   request.getSession();
   String userName=(String)session.getAttribute("user");
   if(userName!=null)
   {
%>
    <!-- Header -->
    <div class="container-fliud">
        <div class="row">
            <div class="col-lg-12 mb-2"
                style="background-image: linear-gradient(#AFAEFD, #efe8de);">
                <div class="col-lg-12">
                    <h1>
                        <a class="navbar-brand" style="color: darkblue; font-size: 30px;"
                            href="#">EMS</a>
                    </h1>
                </div>
                <div class="col-lg-12 d-flex justify-content-end">
                    <h3>
                        Welcome user ! <a href="logout"><i
                            style="color: red; font-size: 30px;" class="fa fa-times-circle"></i></a>
                    </h3>
                </div>
            </div>
        </div>
    </div>
    <!-- Header -->
<% int id=Integer.parseInt(request.getParameter("employeeCode"));
   Employee emp=EmployeeService.getEmployeeById(id);
%>
<div class="container">
        <div class="row d-flex justify-content-center">
            <div class="col-lg-12">
                <div class="col-sm-12 col-lg-12 col-md-12 mt-3"
                    style="border: 2px solid lightgray; border-radius: 5px;">
                    <h5>
                        <span class="pr-2 pl-2">Employee Listings</span>
                    </h5>
                    <form action="updateEmployee" class="col-lg-8 mx-auto" method="post">
                        <div class="form-group row mt-4 d-flex justify-content-center">
                            <label for="Name" class="col-sm-3 col-lg-3 col-form-label">Employee Code:</label>
                            <div class="col-sm-6 col-md-8 col-lg-7">
                                <input type="text" value="<%=emp.getEmployeeCode() %>" readonly class="form-control" name="code">
                            </div>
                        </div>
                        <div class="form-group row d-flex justify-content-center">
                            <label for="Email" class="col-sm-3 col-lg-3 col-form-label">Employee Name:</label>
                            <div class="col-sm-6 col-md-8 col-lg-7">
                                <input type="text" value="<%=emp.getEmployeeName()%>" required class="form-control" name="name" id="name" onblur="checkName()">
                            </div>
                        </div>
                        
                        <div class="form-group row mt-4 d-flex justify-content-center">
                            <label for="Name" class="col-sm-3 col-lg-3 col-form-label">Location:</label>
                            <div class="col-sm-6 col-md-8 col-lg-7">
                                <textarea required class="form-control" name="location" id="location" onblur="checkLocation()"><%=emp.getLocation() %></textarea>
                            </div>
                        </div>
                        <div class="form-group row d-flex justify-content-center">
                            <label for="Email" class="col-sm-3 col-lg-3 col-form-label">Email:</label>
                            <div class="col-sm-6 col-md-8 col-lg-7">
                                <input type="email" value="<%=emp.getEmail() %>" required class="form-control" name="email" id="email" onblur="checkEmail()">
                            </div>
                        </div>
                        
                        <div class="form-group row d-flex justify-content-center">
                          <label for="example-date-input" class="col-sm-3 col-lg-3 col-form-label">Date Of Birth:</label>
                          <div class="col-sm-6 col-md-8 col-lg-7">
                            <input class="form-control" value="<%=EmployeeService.changeDate(emp.getDob())%>" type="text" name="date" id="date" onblur="checkDate()" required>
                          </div>
                        </div>
                        
                        <div class="form-group row d-flex justify-content-center">
                        <label id="button" for="Email" class="col-sm-3 col-lg-3 col-form-label">
                            <input type="submit" name="submit" value="Submit">
                        </label>                            
                            <div class="col-sm-6 col-md-8 col-lg-7 pl-0">
                                <label for="Email" class="col-sm-3 col-lg-3 col-form-label">
                            <input type="button" onclick="document.location.href='back'" name="cancel" value="Cancel">
                        </label>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

 

    <div class="row d-flex justify-content-center fixed-top">
        <div class="col-lg-6 ">
            <div id="alert">                
            </div>
        </div>
    </div>


      

    <!-- Footer -->
    <div style="background-image: linear-gradient(#efe8de, #AFAEFD);"
        class="page-footer font-small blue mt-3">
        <div class="footer-copyright text-center py-3">
            <h6 style="color: darkblue;">Copyright 2020-2021 by Fresher
                Training</h6>
        </div>
    </div>

<%
   }
   else
   {
	   %>
	   <div class="row d-flex justify-content-center fixed-top">
       <div class="col-lg-6 ">
           <div
               class="alert alert-primary alert-dismissible fade show d-flex justify-content-center">
               <button type="button" class="close" onclick="document.location.href='login'" data-dismiss="alert">&times;</button>
               <strong>Logged Out :( </strong>&nbsp; Please Login
           </div>
       </div>
   </div>
 <%  
   }
%>


    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <!-- Bootstrap Core javascript -->
    <script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
         <script>
   <%@include file="js/validator.js"%> 
   </script>
</body>
</html>














