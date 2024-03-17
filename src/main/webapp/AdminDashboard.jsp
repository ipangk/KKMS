<%-- 
    Document   : AdminDashboard
    Created on : 11 Jan 2024, 1:25:41 am
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

        <title>Admin Dashboard</title>
        <style><%@ include file="CSS/dashboardCSS.css"%></style>

    </head>

    <body>
        <div class="container">
            <div class="image-container">
                <img src="IMAGE/KK_LOGO_CROP.png" alt="KK UMT">
            </div>        
            <h1>Welcome Admin <c:out value='${adminUsername}' /> </h1>

            <div class="button-container">
                <button onclick="location.href = '<%=request.getContextPath()%>/listph'">Photographer Management</button>
                <button onclick="location.href = '<%=request.getContextPath()%>/SearchStudent.jsp'">Portfolio Management</button>
                <button onclick="location.href = '<%=request.getContextPath()%>/listVisitor'">Customer Management</button>
                <button onclick="location.href = '<%=request.getContextPath()%>/SearchVisitor.jsp'">Booking Management</button>
                <button onclick="location.href = '<%=request.getContextPath()%>/liststudent'">Feedback Management</button>
                <button onclick="location.href = '<%=request.getContextPath()%>/listadminfine'">Report</button>
                <button onclick="location.href = '<%=request.getContextPath()%>/LoginUser.jsp'">Log out</button>
            </div>
        </div>
    </body>
</html>
