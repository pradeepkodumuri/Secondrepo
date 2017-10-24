<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tek.com.demo.model.finalorder,com.tek.com.demo.model.Items,org.hibernate.Session,org.hibernate.SessionFactory,com.tek.com.demo.service.shopservice,org.hibernate.cfg.Configuration,org.hibernate.boot.registry.StandardServiceRegistryBuilder"%>
           
           
           
      <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Shopping App</title>
<body>     
           
            <h1 >Orders List</h1>
            
<%
final Configuration configuration = new Configuration().configure();
final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
final SessionFactory factory = configuration.buildSessionFactory(builder.build());
final Session ses = factory.openSession();
ses.beginTransaction();
List<finalorder> orders = ses.createQuery("from finalorder").list();
for(finalorder or:orders)
{
	
	int id=or.getOrderId();
	String user=or.getUserOredred();
	List<Items> it=or.getItem();%>
	<br>
<table>
<tr><td>OrderId</td><td><%=id+"" %></td></tr>
<tr><td>UserName</td><td><%=user %></td></tr>
</table>
	 </table>
  <table border="1" >
     <tr><th>Item Name</th><th>Price</th><th>Quantity</th> </tr>
     <%for(Items t:it)
     { %>
	 <tr> 
	 <%System.out.println(t.getName()) ;%>
    	 <td><%=t.getName()%> </td>
    	 <td><%=t.getPrice()%> </td>
    	 <td><%=t.getQuantity()%> </td>  
    	   </tr>
    	   </table>
	<%}%>
<% 
}	
%>
</html>