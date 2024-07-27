<%-- 
    Document   : Footer
    Created on : May 24, 2024, 1:25:08 PM
    Author     : Nguyen Hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<footer>
    <div class="footer-top">
        <div class="pt-exebar">
            <div class="container">
                <div class="d-flex align-items-stretch">
                    <div class="pt-logo mr-auto">
                        <a href="index.html"><img src="images/logo3.png" alt="" style="width: 250px;height: 60px"/></a>
                    </div>
                   
                    <div class="pt-btn-join">
                        <a href="loginf" class="btn ">Join Now</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-12 col-sm-12 footer-col-4">
                    <div class="widget">
                        <h5 class="footer-title">FPT University Ha Noi</h5>
                        <p class="text-capitalize m-b20">FPT University, established in 2006, is a leading private university in Vietnam, focusing on technology and innovation.</p>
                        
                    </div>
                </div>
                
                <div class="col-12 col-lg-5 col-md-7 col-sm-12">
                    <div class="row">
                        <div class="col-4 col-lg-4 col-md-4 col-sm-4">
                            <div class="widget footer_widget">
                                <h5 class="footer-title">Service</h5>
                                <ul>
                                    <li><a >Help manage clubs and facilitate access to students.</a></li>
                                    
                                </ul>
                            </div>
                        </div>
                        <div class="col-4 col-lg-4 col-md-4 col-sm-4" style="width: 70%;">
                            <div class="widget footer_widget">
                                <h5 class="footer-title">Information</h5>
                                <ul>
                                    <li><a href="https://www.facebook.com/DaihocFPTHaNoi" target="_blank">Fanpage Facebook</a></li>
                                    <li><a href="#">Phone Number: 024 7300 5588</a></li>
                                    <li><a href="portfolio.html">Email: dichvusinhvien@fe.edu.vn </a></li>
                                </ul>
                            </div>
                        </div>
                        
                    </div>
                </div>
                <div class="col-12 col-lg-3 col-md-5 col-sm-12 footer-col-4">
                        <h5 class="footer-title">Address</h5>
                        <div class="footer-map">
                            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3131.934472255101!2d105.52448699952647!3d21.01191941511224!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135abc60e7d3f19%3A0x2be9d7d0b5abcbf4!2sFPT%20University!5e0!3m2!1sen!2s!4v1720818847772!5m2!1sen!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                        </div>
                    
                </div>
            </div>
        </div>
    </div>
    
</footer>
<style>
    .widget_gallery {
    padding: 20px;
    
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}



.footer-map {
    position: relative;
    padding-bottom: 56.25%; /* 16:9 aspect ratio */
    height: 0;
    overflow: hidden;
    border-radius: 10px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.footer-map iframe {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    border: 0;
}
</style>