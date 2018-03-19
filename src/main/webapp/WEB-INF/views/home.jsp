<%@ include file="taglib.jsp" %>
<<style>
.news-comments-icon {
    background: url(https://www.ua-football.com/imgs/comment.svg) no-repeat;
    padding-left: 15px;
    font-size: 11px;
    font-weight: 700;
    color: #bbc0c2;
}
</style>
 <div class="text-center ">       
 <div class="row firstRow ">
 <ul>
<c:forEach items="${list1}" var="oneLink">
${oneLink}

</c:forEach>

</ul> 
</div>
</div>