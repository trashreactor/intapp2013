<%@page import="beans.*"%>
<%@page import="controller.*"%>
<%@page import="java.util.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%
// 	Cookie[] cookielist = request.getCookies();
// 	String usuarioNombre = "";
// 	if(cookielist != null){ 
	   
// 		usuarioNombre = cookielist[1].getValue();		
// 	}else{
// 		response.sendRedirect( "login.jsp?a=logout" ) ;
// 	}
 %>
    
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Sistema Gestor de Conocimiento</title>
    <link href="scripts/StyleSheet.css" rel="stylesheet" type="text/css" />
   <script src="scripts/jquery.min.js" type="text/javascript"></script>
   <script src="scripts/JScript.js" type="text/javascript"></script>
    <script type="text/javascript" src="scripts/miniMCE/jscripts/tiny_mce/tiny_mce.js"></script>
    <script type="text/javascript">
        tinyMCE.init({
            // General options
            mode: "textareas",
            theme: "advanced",
            plugins: "safari,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,wordcount",

            // Theme options
            //save,newdocument,|,styleselect,formatselect,fontsizeselect
            theme_advanced_buttons1: "print,|,bold,italic,underline,|,justifyleft,justifycenter,justifyright,justifyfull,cut,copy,paste,pastetext,pasteword,",
            theme_advanced_buttons2: "search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
            theme_advanced_buttons3: "tablecontrols,|,hr,removeformat,visualaid,|,charmap,|,fullscreen",
            //theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak",
            theme_advanced_toolbar_location: "top",
            theme_advanced_toolbar_align: "left",
            theme_advanced_statusbar_location: "bottom",
            theme_advanced_resizing: true,

            // Example content CSS (should be your site CSS)
            content_css: "css/content.css",

            // Drop lists for link/image/media/template dialogs
            template_external_list_url: "lists/template_list.js",
            external_link_list_url: "lists/link_list.js",
            external_image_list_url: "lists/image_list.js",
            media_external_list_url: "lists/media_list.js",

            // Replace values for the template plugin
            template_replace_values: {
                username: "Some User",
                staffid: "991234"
            }
        });
     

    </script>
</head>
<body>
    <div id="divMenu">        
		<img src="img/logo.gif" /><br /><br />
		<b><div style="font-size:20px">Sistema Gestor de Conocimiento</div></b>
		<br />
        <div style="float:right">
        [<% //out.print(usuarioNombre); %>] - <a href="Login.jsp?a=logout">Cerrar Usuario</a> </div>
        
        <a href="TemaList.jsp">Temas</a> | <a href="Usuarios.jsp">Usuarios</a>
        | <a href="DiccionarioList.jsp">Diccionarios</a> | <a href="CategoriaList.jsp">Categoria </a>
		
    </div>
		
	<%
// 	out.print(usuario);
// 	out.print("Sucursal_" +sucursal);
	%>