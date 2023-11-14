<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Free Bootstrap 4 Ecommerce Template</title>
<!-- CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/templates/admin/css/style.css"/>" rel="stylesheet" type="text/css">
<!-- <link href="/src/main/resources/static/admin/css/style.css" rel="stylesheet" type="text/css"> -->
</head>
<body>

	<table>
		<tr>
			<td rowspan="2"><%@ include file="/common/admin/left.jsp"%></td>
			<td style="vertical-align: top; width:100%; height:0px"><%@ include file="/common/admin/header.jsp"%></td>
		</tr>
		<tr>
			<td style="vertical-align: top;"><sitemesh:write property='body'></sitemesh:write> </td>
		</tr>
	</table>

	<!-- JS -->
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
		<script src="https://kit.fontawesome.com/6424ba951a.js" crossorigin="anonymous"></script>
</body>
</html>