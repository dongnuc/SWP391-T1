<%-- 
    Document   : test
    Created on : May 16, 2024, 10:54:33 AM
    Author     : 84358
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #4e54c8, #8f94fb);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .form-container {
            background: #fff;
            padding: 20px 40px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 400px;
        }
        .form-container h2 {
            margin-bottom: 20px;
            text-align: center;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input,
        .form-group select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .form-group input[type="radio"] {
            width: auto;
            margin-right: 5px;
        }
        .form-group .radio-group {
            display: flex;
            align-items: center;
        }
        .form-group .radio-group label {
            margin-right: 10px;
        }
        .form-group .radio-group input {
            margin-right: 5px;
        }
        .form-group button {
            width: 100%;
            padding: 10px;
            background-color: #f44336;
            border: none;
            border-radius: 4px;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }
        .form-group button:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Event Registration Form</h2>
        <form>
            <div class="form-group">
                <label for="first-name">Name</label>
                <input type="text" id="first-name" name="first-name" placeholder="First Name">
            </div>
            <div class="form-group">
                <input type="text" id="last-name" name="last-name" placeholder="Last Name">
            </div>
            <div class="form-group">
                <label for="company">Company</label>
                <input type="text" id="company" name="company">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="example@email.com">
            </div>
            <div class="form-group">
                <label for="phone">Phone</label>
                <input type="text" id="phone" name="phone" placeholder="Area Code - Phone Number">
            </div>
            <div class="form-group">
                <label for="subject">Subject</label>
                <select id="subject" name="subject">
                    <option value="">Choose Option</option>
                    <!-- Add your options here -->
                </select>
            </div>
            <div class="form-group">
                <label>Are you an existing customer?</label>
                <div class="radio-group">
                    <input type="radio" id="yes" name="existing-customer" value="yes">
                    <label for="yes">Yes</label>
                    <input type="radio" id="no" name="existing-customer" value="no">
                    <label for="no">No</label>
                </div>
            </div>
            <div class="form-group">
                <button type="submit">Register</button>
            </div>
        </form>
    </div>
</body>
</html>

