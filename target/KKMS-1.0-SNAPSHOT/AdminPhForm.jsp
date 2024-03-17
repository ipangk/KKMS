<%-- 
    Document   : AdminPhForm
    Created on : 11 Jan 2024, 6:19:22 am
    Author     : irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Photographer Form</title>
        <style><%@ include file="CSS/formCSS.css"%></style>
    </head>
    <body>
        <c:if test="${ph == null}">
            <h1>NEW PHOTOGRAPHER</h1>
        </c:if>
        <c:if test="${ph != null}">
            <h1>EDIT PHOTOGRAPHER</h1>
        </c:if>
        <br>
        <a class="button-list" href="<%=request.getContextPath()%>/AdminPhList.jsp">PHOTOGRAPHER LIST</a>

        <div class="form-container">
            <c:if test="${ph != null}">
                <form action="updateph" method="post">
                </c:if>
                <c:if test="${ph == null}">
                    <form action="insertph" method="post">
                    </c:if>
                    <c:if test="${ph != null}">
                        <input type="hidden" name="phId" value="<c:out value='${ph.phId}' />" />
                    </c:if>
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
    </body>
</html>
