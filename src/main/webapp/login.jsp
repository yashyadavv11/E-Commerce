<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Shopping Bazaar</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <a href="index.jsp"><img src="images/Logoo.png" alt="Shopping Bazaar Logo"></a>
    </header>
    <main>
        <h2>Login</h2>
        <form action="login" method="post">
            <input type="text" name="email" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit">Login</button>
        </form>
        <a href="register.jsp">Don't have an account? Register here</a>
    </main>
</body>
</html>