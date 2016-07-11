<%@page import="com.landingpage.emailNotification"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
section{
height: 50%;
width: 50%;
margin: auto;
padding-top: 20%;
text-align: center;
font-weight: oblique;

}
</style>
</head>
<body>

<%
String email = request.getParameter("email_id");
String name = request.getParameter("name");
String phone = request.getParameter("number");
if(email == null){
	//nothing
	}
else{
//java class configured to send emails
emailNotification snd = new emailNotification();
snd.sending(email, name,phone);
}
%>
<section><b>Dear <%=name %>,</b><br><br>Thank you for registering with PROFESSIONAL PAINTERS!<br> 
A confirmation email will be sent to your email id 
with a PROMO CODE to redeem the offer of $150 OFF on your $3000 purchase.</section>

<div>

</div>
</body>
</html>