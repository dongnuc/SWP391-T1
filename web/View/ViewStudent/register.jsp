<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        form {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
            text-align: center;
        }

        h4 {
            color: red;
        }

        label {
            text-align: left;
            display: block;
            margin-bottom: 5px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <form action="<%= request.getContextPath()%>/register">
        <h4>${error}</h4>
        <label for="taikhoan">Tài Khoản:</label>
        <input type="text" name="taikhoan" required=""><br>
        <label for="matkhau">Mật khẩu:</label>
        <input type="text" name="matkhau" required=""><br>
        <label for="confirm">Confirm:</label>
        <input type="text" name="confirm" required=""><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
