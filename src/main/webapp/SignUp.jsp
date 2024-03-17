<%-- 
    Document   : SignUp
    Created on : 9 Jan 2024, 8:28:51 pm
    Author     : irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Sign Up</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <style>
            <%@ include file="CSS/GeneralCSS.css"%>
        </style>        
        <script>
            // Disable the browser's back button
            history.pushState(null, null, location.href);
            window.onpopstate = function () {
                history.go(100);
            };
        </script>
    </head>    
    <body>
        <div class="container">
            <form id="signup" action="signupCust" method="post">             
                <fieldset>
                    <img src="IMAGE/KK_LOGO_CROP.png" alt="KKMS"><br>
                    <h2>NEW USER DETAILS</h2>

                    <label for="fullname">Name:</label>
                    <input type="text" id="fullname" name="fullname" value="<c:out value='${details.custName}' />" placeholder="Enter Full Name" required >

                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" value="<c:out value='${details.custUsername}' />" placeholder="Enter Username" required>
                    <c:if test="${errorUsername != null}">
                        <label style="color: red;"><c:out value='${errorUsername}' /></label>
                    </c:if>
                    <label for="email">Email:</label>
                    <input type="text" id="email" name="email" value="<c:out value='${details.custEmail}' />" pattern="[a-zA-Z0-9._%+-]@[a-zA-Z0-9.-].[a-zA-Z]{2,}" required title="Enter a valid email address" placeholder="Enter Email">

                    <label for="phone">Phone Number:</label>
                    <input type="text" id="phone" name="contact" value="<c:out value='${details.custContact}' />" pattern="\d{3}-\d{7,8}" required title="Enter a valid phone number in the format XXX-XXXXXXX or XXX-XXXXXXXX" placeholder="Enter Phone No.">

                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" pattern="^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$" required title="Password must have number, special character, and least 8 characters long" placeholder="Enter Password">
                    <input type="checkbox" id="togglePassword"> Show Password<br><br>

                    <label for="confirmPassword">Confirm Password:</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" required>
                    <c:if test="${errorPass != null}">
                        <label style="color: red;"><c:out value='${errorPass}' /></label>
                    </c:if>
                    <a href="<%=request.getContextPath()%>/LoginUser.jsp">Already have an account? Login here</a>

                    <input type="submit" value="Sign Up">
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

