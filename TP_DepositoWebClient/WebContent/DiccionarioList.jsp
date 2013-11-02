<%@page import="beans.*"%>
<%@page import="controller.*"%>
<%@page import="java.util.List"%>
<%@page import="model.*"%>
<%@ page import="java.io.*,java.util.*"%>

<%@include file='master/header.jsp'%>

<%
	String divCrear = (String) session.getAttribute("divCrear");
%>
<%
	String divEditar = (request.getParameter("divEditar") == null) ? "0"
			: (String) request.getParameter("divEditar");
%>
<%
	String id = (String) request.getParameter("id");
%>
<%
	String eliminar = (request.getParameter("eliminar") == null) ? "0"
			: (String) request.getParameter("eliminar");
%>
<%
	Sistema s = Sistema.getInstancia();
%>
<%
	String idDicc = (request.getParameter("idDicc") == null) ? (String) session
			.getAttribute("idDicc") : (String) request
			.getParameter("idDicc");
%>
<%
	session.setAttribute("idDicc", idDicc);
%>
<%
	if (eliminar.equals("1")) {
		DiccionarioView dView = s.buscarDiccionarioViewByID(Long
				.parseLong(id));
		List<ItemDiccionario> items = s.buscarDiccionarioByID(
				dView.getIdDiccionario()).getItemsDiccionario();
		if (items.isEmpty()) {
			s.bajaDiccionario(dView);
			session.setAttribute("id", null);
			session.setAttribute("eliminar", "0");
		} else {
%>
<script type="text/javascript">
	alert("El Diccionario no se puede eliminar porque posee items asociados.");
</script>
<%
	}

	}
%>
<%
	List<DiccionarioView> diccionarios = s.getDiccionarios();
%>

<head>
<script type="text/javascript">
	function borrar() {
		return confirm('¿Eliminar Diccionario seleccionado?');
	}

	function ValidaCreacion(DiccionarioList) {
		if (DiccionarioList.tNombre.value != null
				&& DiccionarioList.tDescripcion.value != null) {
			return true
		} else {
			return false
		}
	}
</script>
</head>




<div id="divContenedor">

	<div id="divTitulo">Diccionarios</div>
	<div id="divBusqueda">
		<div id="divFiltros">
			<table style="width: 100%;">
				<tr>
					<td><input name="tBuscar" type="text"
						value="nombre diccionario" /> <input name="action" type="submit"
						value="Buscar" onclick="alert('Funcionalidad no implementada');" />
					</td>
				</tr>
			</table>
		</div>
	</div>
	<form action="DiccionarioList" method="post">
		<div id="divListado">
			<div style="padding-bottom: 4px">
				<input type="submit" value="Nuevo" name="action">

			</div>
			<div style="width: 816px; height: 300px; overflow: auto;">
				<table class="highLightRow" cellpadding="3" cellspacing="0"
					border="1" width="800">
					<tr style="background-color: #dfdfdf;">
						<th style="width: 300px" align="left">Nombre</th>
						<th style="width: 300px" align="left" width="50px">Descripción</th>
						<th align="left" width="150px">Fecha Creación</th>
						<th align="left" width="150px">Fecha Actualización</th>
						<th>Items</th>
						<th>Editar</th>
						<th>Eliminar</th>
					</tr>
					<%
						for (DiccionarioView d : diccionarios) {

							out.print("<tr>");

							out.print(

							"<td>"
									+ d.getNombre()
									+ "</td>"
									+ "<td>"
									+ d.getDescripcion()
									+ "</td>"
									+ "<td>"
									+ d.getFechaCreacionView()
									+ "</td>"
									+ "<td>"
									+ d.getFechaActualizacionView()
									+ "</td>"
									+ "<td>"
									+ "<center>"
									+ "<a href='DiccionarioItemList.jsp?id="
									+ d.getIdDiccionario()
									+ "'><img id='Image0' src='img/page_white_text.png' alt='Ver lista de items' border='0'/></a>"
									+ "</td>"
									+ "<td>"
									+ "<center>"
									+ "<a   href='DiccionarioList.jsp?divEditar=1&idDicc="
									+ d.getIdDiccionario()
									+ "'><img id='Image1' src='img/edit.png' alt='Modificar' border='0' /></a>"
									+ "</td>"
									+ "<td>"
									+ "<center>"
									+ "<a href='DiccionarioList.jsp?eliminar=1&id="
									+ d.getIdDiccionario()
									+ "'onclick='return borrar()'"
									+ ">"
									+ "<img id='Image2' src='img/delete.png' alt='Eliminar' border='0' />"
									+ "</a>" + "</td>" + "</tr>");
						}
					%>
				</table>
			</div>



			<%
				if (divCrear == "1") {
			%>
			<div id="divForm" style="margin-top: 20px">

				<table id="Table1" style="width: 500px; border: solid 1px #dfdfdf">
					<tr>
						<td colspan="2"
							style="background-color: #dfdfdf; font-weight: bold; height: 30px">
							Crear de Diccionario</td>
					</tr>
					<tr>
						<td width="100px">Nombre</td>
						<td><input name="tNombre" type="text" value=""
							style="width: 302px;" /></td>
					</tr>
					<tr>
						<td width="100px">Descripci&oacute;n</td>
						<td><input name="tDescripcion" type="text" value=""
							style="width: 302px;" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type=submit value="Guardar" name="action"
							onclick="return ValidaCreacion('DiccionarioList');" /> <br /></td>
					</tr>
				</table>

				<%
					}
				%>



				<%
					if (divEditar.equals("1")) {
				%>
				<%
					Sistema sist = Sistema.getInstancia();
				%>
				<%
					Long idDiccionario = Long.parseLong(idDicc);
				%>
				<%
					DiccionarioView dicView = sist
								.buscarDiccionarioViewByID(idDiccionario);
				%>
				<div id="divForm" style="margin-top: 20px">
					<table id="Table1" style="width: 500px; border: solid 1px #dfdfdf">
						<tr>
							<td colspan="2"
								style="background-color: #dfdfdf; font-weight: bold; height: 30px">
								Editar Diccionario</td>
						</tr>
						<tr>
							<td width="300px">Nombre:</td>
							<td><input name="tNombre" type="text"
								value="<%=dicView.getNombre()%>" style="width: 302px;">
							</td>
						</tr>
						<tr>
							<td width="100px">Descripción:</td>
							<td><input name="tDescripcion" type="text"
								value="<%=dicView.getDescripcion()%>" style="width: 302px;">
							</td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Editar" name="action">
								<br></td>
						</tr>
					</table>
				</div>
				<%
					}
				%>
			
	</form>

</div>
<%@include file='master/footer.jsp'%>
