<%@page import="com.hrmanager.service.EmployeeService"%>
<%@page import="com.hrmanager.entities.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page isELIgnored="false"%>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <script href="<c:url value="/resources/js/validator.js" />"></script>
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
            <div class="col-lg-12 mb-2" style="background-image: linear-gradient(#AFAEFD, #efe8de);">
                <div class="col-lg-12">
                    <h1>
                    <a class="navbar-brand" style="color: darkblue; font-size: 30px;"
                        href="#">EMS</a>
                </h1>
                </div>                
                <div class="col-lg-12 d-flex justify-content-end">
                    <h3>
                        Welcome user ! <a href="logout"><i style="color: red; font-size: 30px;" class="fa fa-times-circle"></i></a>
                    </h3>
                </div>
            </div>
        </div>
    </div>
    <!-- Header -->
    
    <div class="container">
        <div class="row d-flex justify-content-center">
            <div class="col-lg-12">
                <div class="col-sm-12 col-lg-12 col-md-12 mt-3"    
                    style="border: 2px solid lightgray; border-radius: 5px;">        
                    <h5><span class="pr-2 pl-2">Employee Listings</span></h5>
                    <div class="col-lg-12 d-flex flex-row-reverse">                        
                        <input type="button" class="m-3" name="login" 
                            value="Download Employee Details">
                        <input type="button" class="m-3" name="login" 
                            value="Upload Employee Details">
                    </div>                                                                                                                                            
                  
                  <div class="col-lg-12 table-wrapper-scroll-y my-custom-scrollbar">
                      <table class="table table-bordered">
                        <thead>
                            <tr>
                                  <th scope="col">Employee Code</th>
                                  <th scope="col">Employee Name</th>
                                  <th scope="col">Location</th>
                                  <th scope="col">Email</th>
                                  <th scope="col">Date Of Birth</th>
                                  <th scope="col">Action</th>
                            </tr>
                                              
                          </thead>
                          <tbody>
                          <%! int count = 0; List<Employee> employeeList = null;%>
                            <%
                            employeeList = (List) request.getAttribute("employees");
                                if (!(employeeList.isEmpty())) {
                                    count = 0;
                                    for (Employee employee : employeeList) {
                            %>
                            <tr>                               
                                  <td><%=employee.getEmployeeCode() %></td>
                                  <td><%=employee.getEmployeeName() %></td>
                                  <td><%=employee.getLocation() %></td>
                                  <td><%=employee.getEmail() %></td>
                                  <td><%=EmployeeService.changeDate(employee.getDob()) %></td>
                                  <td>
                                      <div class="d-flex justify-content-center" style="background-color: lightgray;">
                                          <a href="edit?employeeCode=<%=employee.getEmployeeCode() %>" style="text-decoration: none;">Edit</a>
                                      </div>
                                  </td>
                            </tr>
                            <%
                                }
                            %>
                       </tbody>
                    </table>
                </div>
                                  <%
                                } else {
                            %>
                                 <div class="row d-flex justify-content-center fixed-top">
                                    <div class="col-lg-6 ">
                                        <div class="alert alert-primary alert-dismissible fade show d-flex justify-content-center">
                                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                                            <strong>Sorry :( </strong>&nbsp; Data Not Found
                                        </div>
                                    </div>       
                                </div>
                            <%
                                }
                            %>
                  </div>                 
            </div>
        </div>
    </div>
         
    <!-- Footer -->
    <div style="background-image: linear-gradient(#efe8de, #AFAEFD);" class="page-footer font-small blue mt-3">        
        <div class="footer-copyright text-center py-3" >
            <h6 style="color: darkblue;">Copyright 2020-2021 by Fresher Training</h6>            
        </div>
    </div>
    <!-- Footer -->
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
    <script    src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
   <script>
   <%@include file="js/validator.js"%> 
   </script>
</body>
</html>









