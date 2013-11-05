
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="entity.vo.*"%>
<%@include file='master/header.jsp'%>

<%
	String divCrear = (request.getParameter("divCrear") == null) ? "0"
	: (String) request.getParameter("divCrear");

	String divAltaStock = (request.getParameter("divAltaStock") == null) ? "0"
	: (String) request.getParameter("divAltaStock");

	String id = (request.getParameter("id") == null) ? "0"
	: (String) request.getParameter("id");

	BusinessDelegate bd = new BusinessDelegate();
%>

<script type="text/javascript">
	function funcNoHabilitada() {
		return confirm('Funcionabilidad no habilitada');
	}
	function checkAll(x) {
		for ( var i = 0, l = x.form.length; i < l; i++)
			if (x.form[i].type == 'checkbox' && x.form[i].name != 'sAll')
				x.form[i].checked = x.form[i].checked ? false : true
		x.checked = x.checked ? false : true
	}
</script>

<div id="divContenedor">
	<div id="divTitulo">Articulos</div>
	<div id="divBusqueda">
		Buscador por Nombre o Código<br /> <input id="Text7" type="text"
			name="stringBusqueda" value="" /> <input id="Submit1" type="submit"
			value="Buscar" name="action" class="boton" /><br /> <br />
	</div>
	<div id="divListado" runat="server">
		<div style="padding-bottom: 4px">
			<input type="submit" value="Nuevo" name="action" class="boton" />
		</div>
		<div id="divContenedorListado">
			<table class="highLightRow" cellpadding="3" cellspacing="0"
				border="1" width="1000">
				<tr style="background-color: #dfdfdf; height: 25px">
					<th align="left" width="10px"><input id="Checkbox1"
						type="checkbox" onclick="checkAll(this)" /> <script>
							
						</script></th>
					<th align="left" width="100px">Codigo</th>
					<th align="left">Nombre</th>
					<th align="left">Tipo</th>
					<th align="left" width="150px">Fecha Creaci&oacute;n</th>
					<th colspan="2">&nbsp;</th>
				</tr>
				<tr class="highlightRow">
					<td><input id="Checkbox2" type="checkbox" /></td>
					<td>D237UE</td>
					<td>ProductoNombre</td>
					<td>Ninios</td>
					<td>2012-01-02 09:28:35</td>
					<td style="width: 30px; text-align: center;"><a
						href="?a=agregarStock&id="> <img id="Image1"
							src="img/edit.png" alt="Modificar" border="0" />
					</a></td>
					<td style="width: 30px; text-align: center;"><a href="#"
						onclick="funcNoHabilitada()"> <img id="Image2"
							src="img/delete.png" alt="Eliminar" border="0" />
					</a></td>
				</tr>
				<%
					String stringBusqueda = (String) request.getParameter("stringBusqueda");

					List<ArticuloVO> articulos = new ArrayList<ArticuloVO>();
					
					if (stringBusqueda.equalsIgnoreCase("")){
						articulos = bd.getArticulosALL();
					}else{
						articulos= bd.buscarArticulo(stringBusqueda);
					}
									
									
									
						for (ArticuloVO a : articulos) {
							out.print("<tr>");
							out.print("<td><input id='Checkbox"
									+ a.getId()
									+ "' type='checkbox' /></td>"
									+ "<td>"
									+ a.getId()
									+ "</td>"
									+ "<td>"
									+ a.getNombre()
									+ "</td>"
									+ "<td>"
									+ a.getTipo()
									+ "</td>"
									+ "<td></td>"
									+ "<td>"
									+ "<center>"
									+ "<a href='?divEditar=1&id="
									+ a.getId()
									+ "' title='editar stock'><img id='Image1' src='img/edit.png' alt='Modificar' border='0' /></a>"
									+ "</td>"
									+ "<td>"
									+ "<center><img id='Image2' src='img/delete.png' alt='Eliminar' border='0' /></td>"
									+ "</tr>");
						}
				%>
			</table>
		</div>
		<div
			style="padding: 4px; vertical-align: middle; background-color: #e9e9e9;">
			Cantidad de Stock multiple: <input id="Text9" type="text" /> <input
				name="action" id="btnNuevo0" type="submit" value="Modificar Todos"
				class="boton" />
		</div>
	</div>

	<%
		if (divCrear == "1") {
	%>
	<div id="divForm" runat="server" style="margin-top: 20px">
		<table id="tablaListado"
			style="width: 500px; border: solid 1px #dfdfdf" visible="false">
			<tr>
				<td colspan="2"
					style="background-color: #dfdfdf; font-weight: bold; height: 30px">
					Alta de Articulo</td>
			</tr>
			<tr>
				<td width="100px">Codigo</td>
				<td><input id="tCodigo" type="text" value="" /></td>
			</tr>
			<tr>
				<td width="100px">Nombre</td>
				<td><input id="tNombre" type="text" value="" /></td>
			</tr>
			<tr>
				<td width="100px">Precio</td>
				<td><input id="tPrecio" type="text" value="" /></td>
			</tr>
			<tr>
				<td width="100px">Stock</td>
				<td><input id="tStock" type="text" value="0"
					onblur="validaCantidad(this)" /></td>
			</tr>
			<tr>
				<td width="100px">Precio</td>
				<td><input id="tPrecio" type="text" value="0"
					onblur="validaImporte(this)" /></td>
			</tr>
			<tr>
				<td width="100px">Descripcion</td>
				<td><input id="tDescripcion" type="text" value="" /></td>
			</tr>
			<tr>
				<td width="100px">Tipo</td>
				<td><select id="ddl">
						<option value="0"></option>
						<option value="1">Moda</option>
						<option value="2">Ninos</option>
						<option value="3">Mueble</option>
						<option value="4">Electro</option>
				</select></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><br /> <input type="button" id="bDarAlta" value="Guardar"
					name="action" class="boton" /> <br /></td>
			</tr>
		</table>
	</div>
	<%
		} else if (divAltaStock == "1") {

			ArticuloVO a = bd.getArticulo(Integer.parseInt(id));
	%>
	<div id="divFormEditarStock" runat="server" style="margin-top: 20px">
		<table id="tablaListado"
			style="width: 500px; border: solid 1px #dfdfdf" visible="false">
			<tr>
				<td colspan="2"
					style="background-color: #dfdfdf; font-weight: bold; height: 30px">
					Articulo: Alta de stock</td>
			</tr>
			<tr>
				<td width="100px">Codigo</td>
				<td><input type="hidden" name="hddnId" value="<%=a.getId()%>" />
					<%=a.getId()%></td>
			</tr>
			<tr>
				<td width="100px">Nombre</td>
				<td><%=a.getNombre()%></td>
			</tr>

			<tr>
				<td width="100px">Cantidad a agregar Stock</td>
				<td><input id="tStock" type="text" value="0"
					onblur="validaCantidad(this)" /></td>
			</tr>

			<tr>
				<td>&nbsp;</td>
				<td><br /> <input type="button" id="bAumentarStock"
					value="Agregar Stock" class="boton" name="action" /> <br /></td>
			</tr>
		</table>
	</div>
	<%
		}
	%>


</div>
<%@include file='master/footer.jsp'%>
