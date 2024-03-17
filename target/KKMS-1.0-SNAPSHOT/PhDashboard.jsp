<%-- 
    Document   : PhDashboard
    Created on : 20 Jan 2024, 5:58:50 am
    Author     : irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Cache-Control" content="no-store, no-cache, must-revalidate, max-age=0">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="0">

        <title>Photographer Dashboard</title>
        <style><%@ include file="CSS/phdashboard.css"%></style>
    </head>
    <body>
        <div class="background-images"></div>

        <div class="navbar">
            <a href="logoutUser">Logout</a>
        </div>

        <div class="dashboard-section" id="dashboard-section">
            <h1>WELCOME TO PHOTOGRAPHER <c:out value='${ph.phUsername}' /></h1>
        </div>

        <!-- Add this content to your detail-section in the HTML file -->
        <div class="container">
            <form id="signup" action="editphph" method="post">             
                <fieldset>
                    <h2>PHOTOGRAPHER DETAILS</h2>
                    <input type="hidden" name="phId" value="<c:out value='${ph.phId}' />" />

                    <label for="fullname" >Name:</label><br>
                    <label style="color: navy; font-weight: bolder;"><c:out value='${ph.phName}' /></label>
                    <br><br>
                    <label for="username">Username:</label><br>
                    <label style="color: navy;font-weight: bolder;"><c:out value='${ph.phUsername}' /></label>
                    <br><br>
                    <label for="email">Email:</label><br>
                    <label style="color: navy;font-weight: bolder;"><c:out value='${ph.phEmail}' /></label>
                    <br><br>
                    <label for="phone">Phone Number:</label><br>
                    <label style="color: navy;font-weight: bolder;"><c:out value='${ph.phContact}' /></label>
                    <br><br>
                    <input type="submit" value="Edit" style="margin-left: 420px;">
                </fieldset>
            </form>      
        </div>


        <div class="option-section" id="option-section">
            <img src="IMAGE/KK_USER_DASH.png" alt="KKP"/>
            <button onclick="location.href = '<%=request.getContextPath()%>/#'">PORTFOLIO</button>
            <button onclick="location.href = '<%=request.getContextPath()%>/#'">AVAILABLE BOOKING</button>
            <button onclick="location.href = '<%=request.getContextPath()%>/#'">CURRENT BOOKING</button>
            <button onclick="location.href = '<%=request.getContextPath()%>/#'">BOOKING HISTORY</button>
            <button onclick="location.href = '<%=request.getContextPath()%>/#'">SCHEDULE</button>
        </div>

    </body>
</html>
