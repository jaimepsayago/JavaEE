<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<<h1>Inicio Usuario</h1>
  
<%
 String usuario = request.getUserPrincipal().getName();
 out.println("<h2>Bienvenido(a) : " + usuario + "</h2>");
  
 if(request.isUserInRole("ADMIN")){
 out.println("<a href='../admin/'>Administrador</a>");
 }
if(request.isUserInRole("ESTUDIANTE")){
 out.println("<a href='../estudiante/'>Estudiante</a>");
 }
 
%>
</body>
</html>