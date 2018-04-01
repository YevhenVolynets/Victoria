<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp" %>

<style>
.site-heading h3{
    font-size : 40px;
    margin-bottom: 15px;
    text-transform: uppercase;
    font-weight: 600;
}
.border {
    background: #d1360e;
    height: 2px;
    width: 165px;
    margin-left: auto;
    margin-right: auto;
    margin-bottom: 25px;
}
/* Blog-CSS */
.blog-box {
    padding: 0 0px;
    transition: .5s;
    border: 1px solid #e2e2e2;
    margin-bottom: 30px;
}
.blog-box-content h4 a {
    font-size: 20px;
    padding: 0px 0 0px;
    text-transform: uppercase;
    color:#2b2b2b;
     text-decoration:none;
    
}
.blog-box-content h4:hover {
    color:#000;
     text-decoration:none;
    
}

.blog-box-content {
padding: 0 20px 20px;
}
.blog-box-text h4 a {
    color: #333;
}
</style>

<div class="site-heading text-center text-white">
						<h3>Новини</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt <br> ut labore et dolore magna aliqua. Ut enim ad minim </p>
						<div class="border"></div>
					</div>
<div class="row text-center">
<c:forEach items="${allNews}" var="post">
  <div class="col-sm-6 col-md-4">
							<div class="blog-box">
								<div class="blog-box-image">
									<img src="data:img/png; base64, ${post.pathToFoto}" class="img-responsive" alt="">
								</div>
								<div class="blog-box-content">
									<h4 ><a href="#" style="color:white">${post.title}</a></h4>
									<a href="${rootURL}/news/${post.id}" class="btn btn-default site-btn">Read More</a>
								</div>
							</div>
						</div>



</c:forEach>
</div>