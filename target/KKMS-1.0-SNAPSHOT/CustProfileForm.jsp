<%-- 
    Document   : CustProfileForm
    Created on : 20 Jan 2024, 3:38:46 am
    Author     : irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <a class="button-list" href="custdashboard?custId=${cust.custId}">DASHBOARD</a>

        <div class="form-container">
            <form action="updatecust" method="post">
                <input type="hidden" name="custId" value="<c:out value='${cust.custId}' />" />
                <table border="0">
                    <tbody>
                        <tr>
                            <td>NAME</td>
                            <td><input type="text" value="<c:out value='${cust.custName}' />" name="custName" size="100" required></td>   
                        </tr>
                        <tr>
                            <td>CONTACT</td>
                            <td><input type="text" name="custContact" value="<c:out value='${cust.custContact}' />" size="100" required></td>
                        </tr>
                        <tr>
                            <td>EMAIL</td>
                            <td><input type="text" name="custEmail" value="<c:out value='${cust.custEmail}' />" size="100" required></td>
                        </tr>
                        <tr>
                            <td>USERNAME</td>
                            <td><input type="text" name="custUsername" value="<c:out value='${cust.custUsername}' />" size="100" required>
                                <input type="hidden" name="custOriUsername" value="<c:out value='${cust.custUsername}' />" size="100" >
                                <br>
                                <c:if test="${errorUsername != null}">
                                    <label style="color: red;"><c:out value='${errorUsername}' /></label>
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td>PASSWORD</td>
                            <td><input type="password" name="custPass" id="password" value="<c:out value='${cust.custPass}' />" placeholder="Enter Password" size="100" required>
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
