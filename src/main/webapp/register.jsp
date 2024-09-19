<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - Shopping Bazaar</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <a href="index.jsp"><img src="images/Logoo.png" alt="Shopping Bazaar Logo"></a>
    </header>
    <main>
        <h2>Register</h2>
        <form action="register" method="post">
            <input type="hidden" name="action" value="register"/>
            <input type="text" name="customer_id" placeholder="Customer ID" required>
            <input type="text" name="name" placeholder="Name" required> <!-- Updated name -->
            <input type="password" name="password" placeholder="Password" required>
            <input type="email" name="email" placeholder="Email" required>
            <button type="submit">Register</button>
        </form>
        <a href="login.jsp">Already have an account? Login here</a>
    </main>
</body>
</html>
