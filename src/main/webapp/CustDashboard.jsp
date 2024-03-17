<%-- 
    Document   : PhDashboard
    Created on : 20 Jan 2024, 5:58:50 am
    Author     : irfan
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Cache-Control" content="no-store, no-cache, must-revalidate, max-age=0">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="0">

        <title>Customer Dashboard</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <style>
            <%@ include file="CSS/userdashboard.css"%>
        </style>
    </head>
    <body>

        <div class="background-images"></div>

        <div class="navbar">
            <a href="profilecust?custId=${custId}">Profile</a>
            <a href="logoutUser">Logout</a>
        </div>

        <div class="dashboard-section" id="dashboard-section">
            <h1>WELCOME TO KANTA KAMARIA <c:out value='${custUsername}' /></h1>
            <p>At Kanta Kamaria Photography, we believe in capturing moments that matter.</p>
            <p>Our platform serves as a hub connecting talented photographers, discerning customers, and efficient administrators to create a seamless photography experience.</p>
        </div>

        <!-- Add this content to your detail-section in the HTML file -->
        <div class="detail-section" id="detail-section">
            <h2>WHY CHOOSE KANTA KAMARIA PHOTOGRAPHY?</h2>
            <table>
                <tr>
                    <td><strong>DIVERSE PHOTOGRAPHY SERVICES</strong></td>
                    <td>From weddings to sports events, graduations to special occasions, our photographers specialize in various categories, ensuring a perfect match for your needs.</td>
                </tr>
                <tr>
                    <td><strong>EASY RESERVATION</strong></td>
                    <td>Our user-friendly system allows customers to easily manage reservations, view, confirm, or cancel bookings hassle-free. Administrators ensure the smooth operation of the platform.</td>
                </tr>
                <tr>
                    <td><strong>PHOTOGRAPHER PORTFOLIO</strong></td>
                    <td>Explore our photographers' portfolios, showcasing their skills and previous work. We prioritize transparency, enabling you to make an informed choice for your special moments.</td>
                </tr>
                <tr>
                    <td><strong>FEEDBACK AND REVIEWS</strong></td>
                    <td>We value your feedback! Share your experiences and thoughts on our platform. Our photographers, along with our dedicated admin team, actively engage with your feedback to enhance our services continually.</td>
                </tr>
                <tr>
                    <td><strong>SECURE AND EFFICIENT</strong></td>
                    <td>Your data security is our priority. Our robust system ensures the safety of your personal information, making your interactions with us secure and efficient.</td>
                </tr>
            </table>
        </div>


        <div class="option-section" id="option-section">
            <img src="IMAGE/KK_USER_DASH.png" alt="KKP"/>
            <button onclick="location.href = '<%=request.getContextPath()%>/#'">START BOOKING</button>
            <button onclick="location.href = '<%=request.getContextPath()%>/#'">DIVE INTO OUR SERVICES</button>
            <button onclick="location.href = '<%=request.getContextPath()%>/#'">CURRENT BOOKING</button>
            <button onclick="location.href = '<%=request.getContextPath()%>/#'">BOOKING HISTORY</button>
            <button onclick="location.href = '<%=request.getContextPath()%>/#'">FEEDBACK</button>
        </div>

    </body>
</html>
