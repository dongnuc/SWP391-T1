<%-- 
    Document   : ContactUs
    Created on : May 22, 2024, 2:31:45 AM
    Author     : Nguyen Hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/contactus.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <section class="contact-section">

            <div class="contact-info-box">
                <div class="background">
                    <img src="images/contactus.png" alt="">
                </div>
                <a href="Home.jsp" class="home-link">
                    <img src="images/logo3.png" alt="Logo" class="logo">
                </a>
                <p class="contact-subheading">Any question or remarks? Just write us a message!</p>
            </div>

            <div class="contact-container">
                <div class="contact-inner">
                    <div class="contact-info">
                        <h3 class="contact-info-title">Contact Information</h3>
                        <p class="contact-info-description">Say something to start a live chat!</p>
                        <div class="contact-info-details">
                            <div class="detail-item">
                                <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/16efcee12261d35860456522f48970b4da39ef461d25553ee37bea2a565d1633?apiKey=9802f090930545ed9e8e7106f2abf67d&" alt="Phone icon" />
                                <span>+1012 3456 789</span>
                            </div>
                            <div class="detail-item">
                                <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/f33a12af71453b99485ac9031fecc220eb9409e1999afd1ffbb8eef1e6b8f8f2?apiKey=9802f090930545ed9e8e7106f2abf67d&" alt="Email icon" />
                                <span>demo@gmail.com</span>
                            </div>
                            <div class="detail-item">
                                <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/0a95236edbb272ad63891b22868a195f09637d663fca1420ca3cc4475295718e?apiKey=9802f090930545ed9e8e7106f2abf67d&" alt="Location icon" />
                                <span>132 Dartmouth Street Boston, Massachusetts 02156 United States</span>
                            </div>
                        </div>
                        <div class="social-icons">
                            <div class="social-icons-inner">
                                <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/66ea2ff0f2515af5a51b7f233b1f409d364b5f0df83ffedf8c136b50bc3d9bb9?apiKey=9802f090930545ed9e8e7106f2abf67d&" alt="Social icon 1" />
                                <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/84bd54cc61c32ab35ff49f9a2f55e95c5923cd3a45cbff32064de123a6557787?apiKey=9802f090930545ed9e8e7106f2abf67d&" alt="Social icon 2" />
                                <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/bb81d9e3889282d2a223a859cf8071d4c31be8305c4258e539dca8a5efabc91c?apiKey=9802f090930545ed9e8e7106f2abf67d&" alt="Social icon 3" />
                            </div>
                        </div>
                    </div>
                    <form class="form-section" action="saveForm" method="POST">
                        <div class="form-title">
                            <div class="form-group">
<!--                                <div class="input-wrapper">
                                    <label for="clubId">Name Club</label>                                                                                              
                                    <select id="clubId" name="idClub" class="input-field">
                                        <option>Select club</option>
                                        <c:forEach items="${listClub}" var="listclub"> 
                                        <option value="${listclub.club}">${listclub.nameclub}</option>
                                        </c:forEach>                                  

                                                                           Thêm các tùy chọn khác nếu cần 
                                    </select>                                    
                                </div>-->
                            </div>
                            <div class="name-group">
                                <div class="input-wrapper">
                                    <label for="firstName">FullName</label>
                                    <input type="text" name="fullName" id="firstName" class="input-field" placeholder="Nguyen Duc Hau" />
                                </div>
                                <div class="input-wrapper">
                                    <label for="email">Email</label>
                                    <input type="email" name="email" id="email" class="input-field" placeholder="haundhe176911@fpt.edu.vn" />
                                </div>
                            </div>
                            <div class="input-container">
                                <div class="input-wrapper">
                                    <label for="lastName">Tittle</label>
                                    <input type="text" name="tittle" id="lastName" class="input-field" placeholder="Write here...." />
                                </div>
                            </div>
                            <label class="message-label" for="message"></label>
                            <textarea name="content" id="message" class="message-field" placeholder="Write your message.." rows="5" style="width: 100%"></textarea>

                            <button type="submit" class="send-button">Send Message</button>
                        </div>
                    </form>
                </div>
            </div>
        </section>

    </body>
</html>
