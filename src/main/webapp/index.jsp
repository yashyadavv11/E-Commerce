<!DOCTYPE html>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Bazaar</title>
    <link rel="stylesheet" href="style.css">
    <script src="script.js" defer></script>
</head>
<body>
    <!-- Header -->
    <header>
        <div class="logo">
            <img src="images/Logoo.png" alt="Shopping Bazaar Logo">
        </div>
        <div class="search-bar">
            <input type="text" id="searchInput" placeholder="Search for products...">
            <button onclick="searchProducts()">Search</button>
        </div>
        <div class="nav-links">
            <button class="dropbtn" onclick="toggleDropdown()">Account</button>
            <div class="dropdown-content" id="accountDropdown">
                <a href="login.jsp">Login</a>
                <a href="register.jsp">Register</a>
            </div>
            <a href="cart.jsp" onclick="showCartModal()">Cart</a>
        </div>
    </header>

    <!-- Advertisements -->
    <section class="advertisements">
        <div class="slideshow-container">
            <div class="slide"><img src="images/slides.jpg" alt="Advertisement 1"></div>
            <div class="slide"><img src="images/slides.jpg" alt="Advertisement 2"></div>
            <!-- Add more slides as needed -->
        </div>
    </section>

    <!-- Main Content -->
    <main>
        <nav>
            <ul>
                <li><a href="#" onclick="showProducts('electronics')">Electronics</a></li>
                <li><a href="#" onclick="showProducts('fashion')">Fashion</a></li>
                <li><a href="#" onclick="showProducts('home')">Home</a></li>
                <li><a href="#" onclick="showProducts('appliances')">Appliances</a></li>
            </ul>
        </nav>

        <section class="products" id="productList">
            <!-- Product list will be dynamically inserted here -->
        </section>
    </main>

    <!-- Login Modal -->
    <div id="loginModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal('loginModal')">×</span>
            <h2>Login</h2>
            <form action="login.jsp" method="post">
                <input type="text" name="username" placeholder="Username" required>
                <input type="password" name="password" placeholder="Password" required>
                <button type="submit">Login</button>
            </form>
        </div>
    </div>

    <!-- Register Modal -->
    <div id="Customers" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal('registerModal')">×</span>
            <h2>Register</h2>
            <form action="register.jsp" method="post">
            	<input type="text" name="customer_id" placeholder="Customer_id" required>
                <input type="text" name="username" placeholder="Username" required>
                <input type="password" name="password" placeholder="Password" required>
                <input type="email" name="email" placeholder="Email" required>
                <button type="submit">Register</button>
            </form>
        </div>
    </div>

    <!-- Cart Modal -->
    <div id="cartModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal('cartModal')">×</span>
            <h2>Your Cart</h2>
            <div id="cartItems">
                <!-- Cart items will be displayed here -->
                <p>Your cart is empty.</p>
            </div>
            <button onclick="showLoginModal()">Login</button>
        </div>
    </div>

    <!-- Product Details Modal -->
    <div id="productModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal('productModal')">×</span>
            <h2 id="productName">Product Name</h2>
            <img id="productImage" src="" alt="Product Image">
            <p id="productPrice">$0.00</p>
            <button onclick="addToCart()">Add to Cart</button>
        </div>
    </div>
</body>
</html>