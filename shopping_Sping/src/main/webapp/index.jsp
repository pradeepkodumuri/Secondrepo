<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="com.tek.com.demo.model.Items,com.tek.com.demo.service.shopservice"%>
       <%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Shopping App</title>
<body>
     <h1>Shopping APPlication</h1>
     <br>
   	<h2>Select a option </h2>
	<a href="http://localhost:8080/shoppingApplication/select?option=1">Show Available Items</a>
	<br>
		<a href="http://localhost:8080/shoppingApplication/select?option=2">Checkout</a>
    <br>
    	<a href="http://localhost:8080/shoppingApplication/select?option=3">viewOrders</a>
    <br>	
</body>

</html>