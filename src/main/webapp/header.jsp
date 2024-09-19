<header>
    <div class="logo">
        <img src="images/Logoo.png" alt="Amazon Logo">
    </div>
    <div class="search-bar">
        <input type="text" id="searchInput" placeholder="Search for products, brands and more">
        <button onclick="searchProducts()">Search</button>
    </div>
    <div class="nav-links">
        <div class="dropdown">
            <button class="dropbtn" onclick="toggleDropdown()">Account</button>
            <div class="dropdown-content" id="accountDropdown">
                <a href="login.jsp">Login</a>
                <a href="register.jsp">Register</a>
            </div>
        </div>
        <a href="cart.jsp" onclick="showCart()">Cart</a>
    </div>
</header>