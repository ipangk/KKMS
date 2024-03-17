<%-- 
    Document   : PhProfileForm
    Created on : 20 Jan 2024, 7:22:14 am
    Author     : irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Profile</title>
        <style><%@ include file="CSS/formCSS.css"%></style>
    </head>
    <body>
        <h1>EDIT PROFILE</h1>

        <br>
        <a class="button-list" href="phdashboard?phId=${ph.phId}">DASHBOARD</a>

        <div class="form-container">
            <form action="updatephph" method="post">
                <input type="hidden" name="phId" value="<c:out value='${ph.phId}' />" />
                <table border="0">
                    <tbody>
                        <tr>
                            <td>NAME</td>
                            <td><input type="text" value="<c:out value='${ph.phName}' />" name="phName" size="100" required></td>   
                        </tr>
                        <tr>
                            <td>CONTACT</td>
                            <td><input type="text" name="phContact" value="<c:out value='${ph.phContact}' />" size="100" required></td>
                        </tr>
                        <tr>
                            <td>EMAIL</td>
                            <td><input type="text" name="phEmail" value="<c:out value='${ph.phEmail}' />" size="100" required></td>
                        </tr>
                        <tr>
                            <td>USERNAME</td>
                            <td><input type="text" name="phUsername" value="<c:out value='${ph.phUsername}' />" size="100" required></td>
                        </tr>
                        <tr>
                            <td>PASSWORD</td>
                            <td><input type="password" name="phPass" id="password" value="<c:out value='${ph.phPass}' />" placeholder="Enter Password" size="100" required>
                                <br>
                                <input type="checkbox" id="togglePassword"> Show Password
                            </td>
                        </tr>
                        <tr>
                            <td>CONFIRM PASSWORD</td>
                            <td><input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" size="100" required>
                                <br>
                                <c:if test="${errorPass != null}">
                                    <label style="color: red;"><c:out value='${errorPass}' /></label>
                                </c:if>
                            </td>                                
                        </tr>
                        <tr>
                            <td colspan="2">
                                <div class="button-container">
                                    <input class="button" type="submit" value="SUBMIT"/>
                                    <input class="button" type="reset" value="CANCEL"/>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <script>
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
