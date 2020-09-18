<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Hello App Engine</title>
</head>

<body>
<h1>Inicio Usuario</h1>
  
<%
 String usuario = request.getUserPrincipal().getName();
 out.println("<h2>Bienvenido(a) : " + usuario + "</h2>");
  
 if(request.isUserInRole("ADMIN")){
 out.println("<a href='../EX-WEB/admin/admin.jsf'>Administrador</a>");
 }
if(request.isUserInRole("ESTUDIANTE")){
 out.println("<a href='../EX-WEB/estudiante/admin.jsf'>Estudiante</a>");
 }
 
%>
	<%-- <% response.sendRedirect("listaPost.jsf"); %> --%>
</body>
</html>
