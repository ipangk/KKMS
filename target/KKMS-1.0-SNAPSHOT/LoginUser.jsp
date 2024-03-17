<%-- 
    Document   : LoginUser
    Created on : 3 Jan 2024, 10:19:58 am
    Author     : irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title> 
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Cache-Control" content="no-store, no-cache, must-revalidate, max-age=0">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="0">

        <style>
            <%@ include file="CSS/GeneralCSS.css"%>
        </style>
        <script>
            // Use pushState to add a new state to the browser history
            history.pushState(null, null, document.URL);

            // Disable the back button
            window.addEventListener('popstate', function () {
                history.pushState(null, null, document.URL);
            });

            // Now, if you want to navigate to a certain page when the user clicks back
            function navigateToPage() {
                window.location.href = 'LoginUser.jsp';
            }

        </script>
    </head>
    <body>
        <div class="container">
            <form id="login" action="loginUser" method="post">
                <fieldset>                   
                    <img src="IMAGE/KK_OFFICIAL_LOGO.png" alt="KKMS">
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" placeholder="Enter Username" required>

                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" placeholder="Enter Password" required>
                    <input type="checkbox" id="togglePassword"> Show Password<br>
                    <c:if test="${errorMsg != null}">
                        <label style="color: red;"><c:out value='${errorMsg}' /></label>
                    </c:if><br>
                    Admin
                    <input type="radio" id="admin" name="usertype" value="admin" required>|
                    Photographer
                    <input type="radio" id="ph" name="usertype" value="ph" required>|

                    User
                    <input type="radio" id="cust" name="usertype" value="cust" required><br><br>

                    <a class="button-add" href="#">Forgot Password?</a><br><br>
                    <a class="button-add" href="<%=request.getContextPath()%>/SignUp.jsp">New User Sign Up</a>                 
                    <input type="submit" value="Login" style="margin-left: 350px;">
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

