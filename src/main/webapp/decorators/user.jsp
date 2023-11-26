<%--
  Created by IntelliJ IDEA.
  User: trong
  Date: 11/16/2023
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
    <link href="<c:url value="/templates/user/css/header.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/templates/user/css/style.css"/>" rel="stylesheet" type="text/css">

</head>
<body>
    <%@ include file="../common/user/header.jsp"%>

    <sitemesh:write property="body"> </sitemesh:write>

    <%@ include file="../common/user/footer.jsp"%>
</body>

<script src= "<c:url value="/templates/user/js/header.js"/>" type="text/javascript"></script>
<script src="//code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>

</html>