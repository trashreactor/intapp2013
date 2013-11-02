<%@include file='master/header.jsp'%>
    <div id="divContenedor">
        <div id="divTitulo">
            Articulos
        </div>
        <div id="divBusqueda">
            Buscador por Nombre o C�digo<br />
            <input id="Text7" type="text" value="" />
            <input id="Submit1" type="submit" value="Buscar" class="boton" /><br />
            <br />
        </div>
        <div id="divListado" runat="server">
            <div style="padding-bottom: 4px">
                <input id="btnNuevo" type="button" value="Nuevo" class="boton" />
            </div>
            <div id="divContenedorListado" >
                <table class="highLightRow" cellpadding="3" cellspacing="0" border="1" width="1000">
                    <tr style="background-color: #dfdfdf; height: 25px">
                        <th align="left" width="10px">
                            <input id="Checkbox1" type="checkbox" onclick="checkAllOrders(this)" />
                            <script>

                                function checkAllOrders(x) {
                                    for (var i = 0, l = x.form.length; i < l; i++)
                                        if (x.form[i].type == 'checkbox' && x.form[i].name != 'sAll')
                                            x.form[i].checked = x.form[i].checked ? false : true
                                        x.checked = x.checked ? false : true
                                    }
				
                            </script>
                        </th>
                        <th align="left" width="100px">
                            Codigo
                        </th>
                        <th align="left">
                            Nombre
                        </th>
                        <th align="left" width="150px">
                            Fecha Creaci&oacute;n
                        </th>
                        <th colspan="2">
                            &nbsp;
                        </th>
                    </tr>
                    <tr class="highlightRow">
                        <td>
                            <input id="Checkbox2" type="checkbox" />
                        </td>
                        <td>
                            D237UE
                        </td>
                        <td>
                            ProductoNombre
                        </td>
                        <td>
                            2012-01-02 09:28:35
                        </td>
                        <td style="width: 30px; text-align: center;">
                            <a href="?a=edit&id=">
                                <img id="Image1" src="img/edit.png" alt="Modificar" border="0" />
                            </a>
                        </td>
                        <td style="width: 30px; text-align: center;">
                            <a href="?a=delete&id=">
                                <img id="Image2" src="img/delete.png" alt="Eliminar" border="0" />
                            </a>
                        </td>
                    </tr>
                    <%	
							for (DiccionarioView d : diccionarios ){
								out.print("<tr>");
								out.print(
									"<td>"+d.getNombre()+"</td>"+
									"<td>"+d.getDescripcion()+"</td>"+
									"<td>"+d.getFechaCreacionView()+"</td>"+
									"<td>"+d.getFechaActualizacionView()+"</td>"+
									"<td>"+"<center>"+"<a href='DiccionarioItemList.jsp?id="+d.getIdDiccionario()+"'><img id='Image0' src='img/page_white_text.png' alt='Ver lista de items' border='0'/></a>"+"</td>"+						
									"<td>"+"<center>"+"<a   href='DiccionarioList.jsp?divEditar=1&idDicc="+d.getIdDiccionario()+"'><img id='Image1' src='img/edit.png' alt='Modificar' border='0' /></a>"+"</td>"+
									"<td>"+"<center><img id='Image2' src='img/delete.png' alt='Eliminar' border='0' /></td>"+"</tr>"
									);
							}
						%>
                </table>
            </div>
            <div style="padding: 4px; vertical-align: middle; background-color: #e9e9e9;">
                Cantidad de Stock multiple:
                <input id="Text9" type="text" />
                <input id="btnNuevo0" type="button" value="Modificar Todos" class="boton" /></div>
        </div>
        <div id="divForm" runat="server" style="margin-top: 20px">
            <table id="tablaListado" style="width: 500px; border: solid 1px #dfdfdf" visible="false">
                <tr>
                    <td colspan="2" style="background-color: #dfdfdf; font-weight: bold; height: 30px">
                        Edicion de Articulo
                    </td>
                </tr>
                <tr>
                    <td width="100px">
                        Codigo
                    </td>
                    <td>
                        <input id="Text8" type="text" value="D237UE" />
                    </td>
                </tr>
                <tr>
                    <td width="100px">
                        Nombre
                    </td>
                    <td>
                        <input id="Text1" type="text" value="Silla nro3" />
                    </td>
                </tr>
                <tr>
                    <td width="100px">
                        Stock
                    </td>
                    <td>
                        <input id="Text2" type="text" value="4000" />
                    </td>
                </tr>
                <tr>
                    <td width="100px">
                        desc
                    </td>
                    <td>
                        <input id="Text3" type="text" value="" />
                    </td>
                </tr>
                <tr>
                    <td width="100px">
                        tipo
                    </td>
                    <td>
                        <select id="Select1">
                            <option></option>
                            <option>tipo1</option>
                            <option selected="selected">tipo2</option>
                            <option>tipo3</option>
                            <option>tipo4</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        &nbsp;
                    </td>
                    <td>
                        <br />
                        <input type="button" id="btnSave" value="Guardar" class="boton" />
                        <br />
                    </td>
                </tr>
            </table>
        </div>
    </div>
<%@include file='master/footer.jsp'%>
