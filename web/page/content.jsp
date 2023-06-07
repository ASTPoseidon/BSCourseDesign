<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("utf-8");%>

<!-- 设置页面的内容类型为HTML，字符编码为UTF-8 -->
<!-- 使用Java语言进行JSP页面处理 -->

<jsp:include page="include/htmlHead.jsp">
    <jsp:param name="title" value="选课系统"></jsp:param>
</jsp:include>

<!-- 包含htmlHead.jsp页面，并传递title参数值为"选课系统" -->

<c:if test="${!empty userinfo}">
    <!-- 如果userinfo不为空 -->

    <c:if test='${userinfo.type=="student"}'>
        <!-- 如果用户类型为学生 -->

        <jsp:include page="include/studentheader.jsp">
            <jsp:param name="sname" value="${userinfo.sname}"></jsp:param>
        </jsp:include>

        <!-- 包含studentheader.jsp页面（学生主页顶部），并传递sname（学生姓名）参数值为userinfo.sname -->

        <div class="container padding-150">
            <div class="row">
                <%@include file="include/stuleft.jsp" %>
                <%@include file="include/sturight.jsp" %>
            </div>
        </div>

        <!-- 包含stuleft.jsp（学生主页左部）和sturight.jsp（学生主页右部）页面 -->

    </c:if>

    <c:if test='${userinfo.type=="teacher"}'>
        <!-- 如果用户类型为教师 -->

        <jsp:include page="include/teacherheader.jsp">
            <jsp:param name="tname" value="${userinfo.tname}"></jsp:param>
        </jsp:include>

        <!-- 包含teacherheader.jsp（教师主页顶部）页面，并传递tname（教师姓名）参数值为userinfo.tname -->

        <div class="container padding-150">
            <div class="row">
                <%@include file="include/teacherleft.jsp" %>
                <%@include file="include/teacherright.jsp" %>
            </div>
        </div>

        <!-- 包含teacherleft.jsp（教师主页左部）和teacherright.jsp（教师主页右部）页面 -->

    </c:if>

    <c:if test='${userinfo.type=="root"}'>
        <!-- 如果用户类型为管理员 -->

        <jsp:include page="include/rootheader.jsp">
            <jsp:param name="tname" value="${userinfo.tname}"></jsp:param>
        </jsp:include>

        <!-- 包含rootheader.jsp（管理员界面顶部）页面，并传递tname（管理员姓名）参数值为userinfo.tname -->

        <div class="container padding-150">
            <div class="row">
                <%@include file="include/rootleft.jsp" %>
                <%@include file="include/rootright.jsp" %>
            </div>
        </div>

        <!-- 包含rootleft.jsp（管理员界面左部）和rootright.jsp（管理员界面右部）页面 -->

    </c:if>

</c:if>

<c:if test="${empty userinfo}">
    <!-- 如果userinfo为空 -->

    <script type="text/javascript">
        window.location.href = "../index.jsp";
    </script>

    <!-- 使用JavaScript进行页面重定向到../index.jsp -->

</c:if>

<%@include file="include/htmlFooter.jsp" %>

<!-- 包含htmlFooter.jsp页面 -->
