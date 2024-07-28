<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            * {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  font-family: 'Poppins', sans-serif;
}

html,
body {
  height: 100%;
  display: grid;
  place-items: center;
  background-color: #EAF5F6;
}

.container {
  width: 400px;
  padding: 50px;
  background-color: #ffffff;
  border-radius: 25px;
}

h3.title {
  font-size: 28px;
  font-weight: 700;
  color: #093030;
  margin-bottom: 25px;
}

p.sub-title {
  color: #B5BAB8;
  font-size: 14px;
  margin-bottom: 25px;
}

p span.phone-number {
  display: block;
  color: #093030;
  font-weight: 600;
}

.wrapper {
  width: 100%;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  justify-items: space-between;
}

.wrapper input.field {
  width: 50px;
  line-height: 75px;
  font-size: 32px;
  border: none;
  background-color: #EAF5F6;
  border-radius: 5px;
  text-align: center;
  text-transform: uppercase;
  color: #093030;
  margin-bottom: 25px;
}

.wrapper input.field:focus {
  outline: none;
}

button.resend {
  background-color: transparent;
  border: none;
  font-weight: 600;
  color: #3DAFE1;
  cursor: pointer;
}

button.resend i {
  margin-left: 5px;
}
.hinhanh{
                margin-left: 1200px;
            }
            

        </style>
    </head>
    <body>
        <div class="hinhanh">
<a href="<%= request.getContextPath() %>/home" >
    <img src="images/homeh.png" alt="Home Icon" width="50" height="50" style="margin-left:  20%;">
</a>     </div>
        <form action="<%= request.getContextPath() %>/checkotp1" method="post">
        <div class="container">
            <h3 class="title">OTP Verification</h3>
            <p class="sub-title">
                Enter the OTP you received to
                <span class="phone-number">+20 102 2233 444</span>
            </p>
            <div class="wrapper">
                <input type="text" class="field 1" maxlength="1" name="otp1" value="${otp1}">
                <input type="text" class="field 2" maxlength="1" name="otp2" value="${otp2}">
                <input type="text" class="field 3" maxlength="1" name="otp3" value="${otp3}">
                <input type="text" class="field 4" maxlength="1" name="otp4" value="${otp4}">
            </div>
            <div style="color: red;">
    ${error}
</div>
            <button class="resend">
                confirm
                <i class="fa fa-caret-right"></i>
            </button>
        </div>
            </form>

    </body>
</html>
