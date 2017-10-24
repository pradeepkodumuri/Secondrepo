<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tek.com.demo.model.Items,com.tek.com.demo.service.shopservice"%>
           <%@ page session="false"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Shopping App</title>
<body>
     <h1>Available Items List</h1>
     <table border="1" >
     <tr><th>Item No</th><th>Item Name</th><th>Price</th><th>Description</th> </tr>
     <%
     List<Items> ls=(List<Items>) request.getAttribute("itemslist");
     int count=1;
     for(Items i:ls)
     {
    	%> 
    	 <tr> 
    	 <td><%=count %> </td>
    	 <td><%=i.getName()%> </td>
    	 <td><%=i.getPrice()%> </td>  
    	 <td><%=i.getDescription()%> </td>    
    	 
    	   </tr>
    	 
    <% count++; }
     
     %>
     
     
     </table>
     
     <form action="select">
     <table>
     <tr>
     <td> Item No:<td>
					<td><input type="text" name="itemno" /><td>
      </tr>
      
        <tr>
     <td> Quantity:<td>
					<td><input type="text" name="quantity" /><td>
					<td><input type="submit" value="AddtoCart" name="method" /></td>
      </tr>
     </table>  
     </form>
     
    <br>
    <h4>Cart</h4>
      <table border="1" >
     <tr><th>Item Name</th><th>Price</th><th>Quantity</th> </tr>
     <%
     List<Items> mp=(List<Items>) request.getSession().getAttribute("itemsAdded");
     if(mp!=null)
     {     
 
     for(Items i:mp)
     {
    	%> 
    	 <tr> 
    	 <td><%=i.getName()%> </td>
    	 <td><%=i.getPrice()%> </td>
    	 <td><%=i.getQuantity()%> </td>  
    	   </tr>
    	      
    <% }}
     
     %>
       </table>
     <form action="select" >
     <input type="submit" value="Checkout" name="method" />
     </form>
    
    
</body>

</html>