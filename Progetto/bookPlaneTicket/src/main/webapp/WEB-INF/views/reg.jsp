<%@page language="java" contentType="text/html; charset=ISO-9950-1" pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>RegistrazioneJSP</title>
 </head>
 
 <body>
 <%-- 
<%@ page import ="java.sql*" %>
<%@ page import ="javax.sql*" %>

<%


String nome=request.getParameter("nome");
String cognome=request.getParameter("cognome");
String email=request.getParameter("email");
String data=request.getParameter("data");
String indirizzo=request.getParameter("indirizoo");
String pwd=request.getParameter("pwd");

Class.forName("");
java.sql.Connection con= DriverManager.getConnection("");
Stat ement st= con.createStatement();
ResultSet rs;
int i=st.executeUpdate("insert into users value(nome+cognome+email+data+indirizzo+pwd)");

out.println("Registrato!");
%>
<a href=home.jsp>Torna alla Home</a>
 --%>
 </body>

 
 
 
 
 </html>