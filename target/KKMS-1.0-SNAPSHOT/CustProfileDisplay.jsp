<%-- 
    Document   : CustProfileDisplay
    Created on : 20 Jan 2024, 3:46:27 am
    Author     : irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Profile</title>
        <style><%@ include file="CSS/GeneralCSS.css"%></style>
    </head>
    <body>
        <div class="container">
            <form id="signup" action="editcust" method="post">             
                <fieldset>
                    <img src="IMAGE/KK_OFFICIAL_LOGO.png" alt="KKMS"><br>
                    <h2>USER DETAILS</h2>
                    
                    <input type="hidden" name="custId" value="<c:out value='${cust.custId}' />" />
                    
                    <label for="fullname" >Name:</label>
                    <label style="color: navy; font-weight: bolder;"><c:out value='${cust.custName}' /></label>
                    <br>
                    <label for="username">Username:</label>
                    <label style="color: navy;font-weight: bolder;"><c:out value='${cust.custUsername}' /></label>
                    <br>
                    <label for="email">Email:</label>
                    <label style="color: navy;font-weight: bolder;"><c:out value='${cust.custEmail}' /></label>
                    <br>
                    <label for="phone">Phone Number:</label>
                    <label style="color: navy;font-weight: bolder;"><c:out value='${cust.custContact}' /></label>
                    <br>
                    <a href="custdashboard?custId=${cust.custId}">Dashboard</a>

                    <input type="submit" value="Edit" style="margin-left: 400px">
                </fieldset>
            </form>      
        </div>
        <script>
            // Disable the browser's back button
            history.pushState(null, null, location.href);
            window.onpopstate = function () {
                history.go(10);
            };

            document.addEventListener('DOMContentLoaded', function () {
                var togglePassword = document.getElementById('togglePassword');
                var passwordField = document.getElementById('password');
                togglePassword.addEventListener('change', function () {
                    passwordField.type = this.checked ? 'text' : 'password';
                });
            });
        </script>
    </body>
</html>
