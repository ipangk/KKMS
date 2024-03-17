<%-- 
    Document   : AdminPhList
    Created on : 11 Jan 2024, 4:15:15 am
    Author     : irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Photographer List</title>
        <style><%@ include file="CSS/listCSS.css"%></style>
        <script>
            const sidebar = document.querySelector(".sidebar");
            const sidebarClose = document.querySelector("#sidebar-close");
            const menu = document.querySelector(".menu-content");
            const menuItems = document.querySelectorAll(".submenu-item");
            const subMenuTitles = document.querySelectorAll(".submenu .menu-title");

            sidebarClose.addEventListener("click", () => sidebar.classList.toggle("close"));

            menuItems.forEach((item, index) => {
                item.addEventListener("click", () => {
                    menu.classList.add("submenu-active");
                    item.classList.add("show-submenu");
                    menuItems.forEach((item2, index2) => {
                        if (index !== index2) {
                            item2.classList.remove("show-submenu");
                        }
                    });
                });
            });

            subMenuTitles.forEach((title) => {
                title.addEventListener("click", () => {
                    menu.classList.remove("submenu-active");
                });
            });
        </script>
    </head>
    <body>
        <nav class="sidebar">
            <h2>KANTA KAMARIA</h2>

            <div class="menu-content">
                <ul class="menu-items">
                    <div class="menu-title"></div>
                    <li class="item"><a href="<%=request.getContextPath()%>/AdminDashboard.jsp">DASHBOARD</a></li>
                    <li class="item"><a href="#">PHOTOGRAPHER</a></li>
                    <li class="item"><a href="#">PORTFOLIO</a></li>                    
                    <li class="item"><a href="#">CUSTOMER</a></li>
                    <li class="item"><a href="#">BOOKING</a></li>
                    <li class="item"><a href="#">FEEDBACK</a></li>
                    <li class="item"><a href="#">REPORT</a></li>
                </ul>
            </div>
        </nav>
        <nav class="navbar">
            <i class="fa-solid fa-bars" id="sidebar-close"></i>
            <h1>PHOTOGRAPHER LIST </h1>
        </nav>

        <main class="main">
            <br>
            <a class="button-add" href="addph">ADD PHOTOGRAPHER</a>
            <br>
            <br>
            <table border="1">
                <thead>
                    <tr>
                        <th>NO</th>
                        <th>NAME</th>
                        <th>CONTACT</th>
                        <th>EMAIL</th>
                        <th>USERNAME</th>
                        <th>ACTION</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listph}" var="ph" varStatus="status">
                        <tr>
                            <td>${status.index +1}</td>
                            <td><c:out value="${ph.phName}"/></td>
                            <td><c:out value="${ph.phContact}"/></td>
                            <td><c:out value="${ph.phEmail}"/></td>
                            <td><c:out value="${ph.phUsername}"/></td>
                            <td>
                                <div class="button-container">
                                    <a  class="button" href="editph?phId=${ph.phId}">UPDATE</a>
                                    <a class="button" href="#" onclick="confirmDelete('${ph.phId}'); return false;">DELETE</a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </main>
    </body>
    <script>function confirmDelete(phId) {
            // First confirmation
            if (confirm("Are you sure you want to delete this item?")) {
                // Second confirmation
                var userResponse = confirm("This action cannot be undone. Are you really sure?");

                if (userResponse) {
                    // User confirmed both times, proceed with the deletion logic
                    window.location.href = "deleteph?phId=" + phId;
                } else {
                    // User canceled the second confirmation
                    alert("Deletion canceled.");
                }
            } else {
                // User canceled the first confirmation
                alert("Deletion canceled.");
            }
        }</script>
</html>
