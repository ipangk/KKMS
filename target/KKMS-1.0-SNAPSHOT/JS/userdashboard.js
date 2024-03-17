// Sample JavaScript functions for loading different sections
function loadDashboard() {
    document.getElementById("dashboard-section").innerHTML =
            "<h2>Dashboard</h2><p>Your personalized dashboard content goes here.</p>";
}

function loadBookings() {
    document.getElementById("dashboard-section").innerHTML =
            "<h2>Bookings</h2><p>Your order history and details will be displayed here.</p>";
}

function loadProfile() {
    document.getElementById("dashboard-section").innerHTML =
            "<h2>Profile</h2><p>Your profile information and settings go here.</p>";
}

function logout() {
    // Implement logout functionality as needed
    alert("Logout clicked. Implement your logout logic here.");
}

// Load the default dashboard content on page load
loadDashboard();