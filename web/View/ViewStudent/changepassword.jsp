<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            .form-container {
                background-color: #fff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                width: 300px;
                text-align: center;
            }
            .form-container h2 {
                margin-bottom: 20px;
                color: #333;
            }
            .form-container input[type="password"] {
                width: 100%;
                padding: 10px;
                margin: 10px 0;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-sizing: border-box;
            }
            .form-container input[type="submit"] {
                width: 100%;
                padding: 10px;
                background-color: #28a745;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px;
            }
            .form-container input[type="submit"]:hover {
                background-color: #218838;
            }
            .error-message {
                color: red;
                margin-top: 10px;
            }
        </style>
    </head>
    <body>
        <div class="form-container">
            <h2>Change Password</h2>
            <form action="<%= request.getContextPath() %>/newpassword" method="post">
                <input type="password" name="oldpassword" placeholder="Enter Old Password" required><br>
                <input type="password" name="newpassword" placeholder="Enter New Password" required><br>
                <input type="password" name="confirm" placeholder="Confirm Password" required><br>
                <div class="error-message">
                    ${error}
                </div>
                <input type="submit" value="Change">
            </form>
        </div>
    </body>
</html>
