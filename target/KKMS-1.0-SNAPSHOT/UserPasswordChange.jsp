<%-- 
    Document   : UserPasswordChange
    Created on : 22 Jan 2024, 12:10:37 am
    Author     : irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
        <style><%@ include file="CSS/GeneralCSS.css"%></style>
    </head>
    <body>
        <div class="container">
            <form id="login" action="loginUser" method="post">
                <fieldset>                   
                    <img src="IMAGE/KK_OFFICIAL_LOGO.png" alt="KKMS"><br>
                    <label for="oldpass" style="font-weight: bold;">Current Password:</label>
                    <input type="password" id="oldppass" name="oldppass" placeholder="Enter Current Password" required>
                    <input type="checkbox" id="toggleOldPass"> Show Password<br><br>

                    <label for="newpass" style="font-weight: bold;">New Password:</label>
                    <input type="password" id="newpass" name="newpassword" placeholder="Enter New Password" required>
                    <input type="checkbox" id="toggleNewPass"> Show Password<br><br>

                    <label for="confirmpassword" style="font-weight: bold;">Confirm Password:</label>
                    <input type="password" id="confirmpassword" name="confirmpass" placeholder="Enter New Password" required>
                    <c:if test="${errorMsg != null}">
                        <label style="color: red;"><c:out value='${errorMsg}' /></label>
                    </c:if><br><br>

                    <input type="submit" value="Submit" style="margin-left: 450px;">
                </fieldset>
            </form>      
        </div>
        <script>
            document.addEventListener('DOMContentLoaded', function () {
                var toggleOldPass = document.getElementById('toggleOldPass');
                var oldPassField = document.getElementById('oldppass');
                toggleOldPass.addEventListener('change', function () {
                    oldPassField.type = this.checked ? 'text' : 'password';
                });

                var toggleNewPass = document.getElementById('toggleNewPass');
                var newPassField = document.getElementById('newpass');
                toggleNewPass.addEventListener('change', function () {
                    newPassField.type = this.checked ? 'text' : 'password';
                });

                var toggleConfirmPass = document.getElementById('toggleConfirmPass');
                var confirmPassField = document.getElementById('newpassword');
                toggleConfirmPass.addEventListener('change', function () {
                    confirmPassField.type = this.checked ? 'text' : 'password';
                });
            });
        </script>

    </body>
</html>
