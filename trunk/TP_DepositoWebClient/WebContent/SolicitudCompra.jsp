<%@include file='master/header.jsp'%>
<div id="divContenedor">
	<div id="divTitulo">Solicitud de Compra</div>
	<div id="divListado" runat="server">
		<div
			style="padding-bottom: 10px; padding-top: 20px; font-size: 12px; font-weight: bold">
			&nbsp;Solicitud de productos pendientes</div>
		<div style="width: 1016px; height: 300px; overflow: auto;">
			<table class="highLightRow" cellpadding="3" cellspacing="0"
				border="1" width="1000">
				<tr style="background-color: #dfdfdf; height: 25px">
					<th align="left" width="10px"><input id="Checkbox1"
						type="checkbox" /></th>
					<th align="left" width="100px">Codigo</th>
					<th align="left" width="">Nombre</th>
					<th align="left" width="100px">Stock Actual</th>
					<th align="left" width="100px">Stock Solicitado</th>
					<th align="left" width="150px">Stock Sugerido</th>
				</tr>
				<tr>
					<td><input id="Checkbox2" type="checkbox" /></td>
					<td>D237UE</td>
					<td>ProductoNombre</td>
					<td>400</td>
					<td>150</td>
					<td><input id="Text10" type="text" value="300" /></td>
				</tr>
				<tr>
					<td><input id="Checkbox3" type="checkbox" /></td>
					<td>11155561</td>
					<td>ProductoNombre</td>
					<td>201</td>
					<td>0</td>
					<td><input id="Text11" type="text" value="0" /></td>
				</tr>
				<tr>
					<td><input id="Checkbox4" type="checkbox" /></td>
					<td>11155561</td>
					<td>ProductoNombre</td>
					<td>123</td>
					<td>30</td>
					<td><input id="Text12" type="text" value="60" /></td>
				</tr>
				<tr>
					<td class="style1"><input id="Checkbox5" type="checkbox" /></td>
					<td class="style1">11155561</td>
					<td class="style1">ProductoNombre</td>
					<td class="style1">155</td>
					<td class="style1">100</td>
					<td class="style1"><input id="Text13" type="text" value="200" />
					</td>
				</tr>
				<tr>
					<td><input id="Checkbox6" type="checkbox" /></td>
					<td>11155561</td>
					<td>ProductoNombre</td>
					<td>5002</td>
					<td>1000</td>
					<td><input id="Text14" type="text" value="2000" /></td>
				</tr>
				<tr>
					<td><input id="Checkbox7" type="checkbox" /></td>
					<td>11155561</td>
					<td>ProductoNombre</td>
					<td>5202</td>
					<td>1500</td>
					<td><input id="Text16" type="text" value="3000" /></td>
				</tr>
				<tr>
					<td><input id="Checkbox8" type="checkbox" /></td>
					<td>11155561</td>
					<td>ProductoNombre</td>
					<td>235</td>
					<td>0</td>
					<td><input id="Text15" type="text" value="0" /></td>
				</tr>
				<tr>
					<td><input id="Checkbox9" type="checkbox" /></td>
					<td>11155561</td>
					<td>ProductoNombre</td>
					<td>656</td>
					<td>100</td>
					<td><input id="Text17" type="text" value="200" /></td>
				</tr>
				<tr>
					<td><input id="Checkbox10" type="checkbox" /></td>
					<td>11155561</td>
					<td>ProductoNombre</td>
					<td>653</td>
					<td>200</td>
					<td><input id="Text18" type="text" value="400" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>11155561</td>
					<td>ProductoNombre0</td>
					<td>6663</td>
					<td>1000</td>
					<td><input id="Text5" type="text" value="400" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>Nombre</td>
					<td>ProductoNombre</td>
					<td></td>
					<td></td>
					<td><input id="Text6" type="text" value="400" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>Nombre</td>
					<td>ProductoNombre</td>
					<td>&nbsp;</td>
					<td></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>Nombre</td>
					<td>ProductoNombre</td>
					<td>&nbsp;</td>
					<td></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>Nombre</td>
					<td>Apellido</td>
					<td>&nbsp;</td>
					<td></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>Nombre</td>
					<td>Apellido</td>
					<td>&nbsp;</td>
					<td></td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</div>
	</div>
	<div id="divForm" runat="server" style="margin-top: 20px">
		<table id="tablaListado"
			style="width: 500px; border: solid 1px #dfdfdf" visible="false">
			<tr>
				<td colspan="2"
					style="background-color: #dfdfdf; font-weight: bold; height: 30px">
					Informacion de la solicitud de compra</td>
			</tr>
			<tr>
				<td width="100px"><br /> Nombre del Operador</td>
				<td><br /> <select id="Select1" name="D1">
						<option></option>
						<option>Operador</option>
						<option selected="selected">Operador</option>
						<option>Operador</option>
						<option>Operador</option>
				</select></td>
			</tr>
			<tr>
				<td width="100px">Legajo</td>
				<td><input id="Text1" type="text" value="1014930" /></td>
			</tr>
			<tr>
				<td width="100px">Email</td>
				<td><input id="tEmail" type="text" value="asdasdasd@asdasd.com"
					style="width: 200px" /></td>
			</tr>
			<tr>
				<td width="100px" style="vertical-align: top">Descripción</td>
				<td><input id="Text4" type="text"
					value="La solicitud debe ser aceptada antes del lunes 20/2" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><br /> <input type="button" id="btnSave"
					value="Enviar Solicitud de Compra" class="boton"
					style="width: 164px" /> <br /></td>
			</tr>
		</table>
	</div>
</div>
<%@include file='master/footer.jsp'%>
