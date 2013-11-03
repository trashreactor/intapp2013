



//
/***************************************************************************/


//function sumarImportesFondo(){

//    var total = parseFloat(document.getElementById("HiddenTotalA_fijo").value.replace(",","."))
//    
//    total += parseFloat(document.getElementById("TextBoxItemA3").value.replace(",","."))
//    total = Math.round( (total)*100)/100
//    
//    document.getElementById("TextBoxTotalA").value = total;
//    document.getElementById("HiddenTotalA").value = total;
//}

function _get(nombre) {
    return document.getElementById("ctl00_ContentPlaceHolderMain_" + nombre);
}

function _set(nombre, valor) {
    document.getElementById("ctl00_ContentPlaceHolderMain_" + nombre).value = (isNaN(valor) ? "0" : valor);
}

function funcNoHabilitada() {
	return confirm('Funcionabilidad no habilitada');
}
	 


///setea en cero los inputs que estan vacios en un onblur
function siVacioCero(elem){
	if (elem.value=='') elem.value='0.00';
	if (elem.value=='0') elem.value='0.00';	
}

///Usado en planilla de aportes, lanza un popupjava para que el usuario confirme la eliminacion del usuairo
function confirmaBajaUsuario(id,periodo,aporte){
    
	if ( confirm("¿Esta seguro que quiere eliminar\n el empleado de este periodo y tipo de aporte?") ){									
		window.location="?a=darBajaId&id="+id+"&periodo=" + periodo + "&tipoAporte=" + aporte;
	}
}

//uso vaciaInput(this,'aaaa/mm/dd') vacia lo 
//ingresado y se vacia si es igual a  con 'aaaa/mm/dd'
function vaciaInput(elem,formato){
	if (elem.value == formato) elem.value=''	;	
}

//uso llenaInput(this,'aaaa/mm/dd') llena el input si esta vacio con el formato ingresado
function llenaInput(elem,formato){
	if (elem.value == "") elem.value = formato;		
}


//#####·##validaciones##########################################################






//valida email
function validaEmail(elem){
	var s = elem.value;
	var filter=/^[A-Za-z][A-Za-z0-9_.]*@[A-Za-z0-9_]+\.[A-Za-z0-9_.]+[A-za-z]$/;
	
	if (s.length == 0 ) {		
		elem.style.backgroundColor = "ffffff";
	}else if (filter.test(s))
		elem.style.backgroundColor = "#D7EADA";
	else
		elem.style.backgroundColor = "#FFCCCC";
	return false;
}

//valida cantidad 
function validaCantidad(elem){
	var s = elem.value;
	var filter=/^[0-9]*$/;

	if (s.length == 0 ) {
	}else if (filter.test(s))
		elem.style.backgroundColor = "#D7EADA";
	else{
		elem.style.backgroundColor = "#FFCCCC";
		alert("debe ser solo NUMERICO");
	}
	return false;
}
//valida cantidad 
function validaCantidadMax(elem,max) {
    var s = elem.value;
    var filter = /^[0-9]*$/;

    if (s.length == 0) {
    } else if (filter.test(s))
        if (parseInt(s) <= max)
            elem.style.backgroundColor = "#D7EADA";
        else {
            elem.style.backgroundColor = "#FFCCCC";
            alert("Ingrese una cantidad");
        }

    else {
        elem.style.backgroundColor = "#FFCCCC";
        alert("debe ser solo NUMERICO");
    }
    return false;
}
//valida importes
function validaImporte(elem){
        elem.value = elem.value.replace(",", ".");
		var s = elem.value;
		var filter=/^([-]?[0-9]*|[0-9]*[.]*[0-9]*)$/; //acepta decimales solo con punto

		if (s.length == 0 ) {
		    elem.style.backgroundColor = "";
		}else if (filter.test(s))
			elem.style.backgroundColor = "#D7EADA";	
		else{
			elem.style.backgroundColor = "#FFCCCC";
		    alert("El importe debe ser solo NUMERICO");
		}
		return false;
}


//valida fechas en formato dd/mm/aaaa
function validaFecha(elem){
		var s = elem.value;
		
		//completo con barras si no las tiene
		s = completaFecha(s); 
		elem.value = s;
		
		var filter=/^\d{1,2}\/\d{1,2}\/\d{4}$/; //acepta decimales solo con punto

		if (s.length == 0 ) {
		}else if (filter.test(s))
			elem.style.backgroundColor = "#D7EADA";			
		else{
			elem.style.backgroundColor = "#FFCCCC";
			alert("La fecha debe ser en formato dd/mm/aaaa");
		}
		return false;
}

function completaFecha(elem){
    var data = elem;
    var rta="";
    if ( (data.charAt(2)!='/')&&(data.charAt(4)!='/') ){
         rta= data.charAt(0)+data.charAt(1)+"/"+data.charAt(2)+data.charAt(3)+"/"+data.charAt(4)+data.charAt(5)+data.charAt(6)+data.charAt(7);      
         return rta;
    }     
    return data;    
}

//onkeydown
function completaPeriodo(elem){
    var data = elem.value;
    if (elem.value.charAt(1)=='/') elem.value= '0'+data;      
}

//onblur
function validaperiodo(elem){	
    if (elem.value.charAt(2)!='/') elem.value= elem.value.charAt(0)+elem.value.charAt(1)+'/'+ elem.value.charAt(2)+elem.value.charAt(3)+elem.value.charAt(4)+elem.value.charAt(5);  
    
    var longitud = elem.value.length;    
    var mes=elem.value.charAt(0)+elem.value.charAt(1);      
    
    if ((longitud==1)||(longitud==0)){
        elem.value="";
        elem.style.backgroundColor = "#ffffff";
    }else if ( (elem.value.charAt(2)=='/') && (longitud==7) && (mes <=12) && (mes >=1) ){
	    elem.style.backgroundColor = "#D7EADA";//verde=OK
	}else{
	    elem.style.backgroundColor = "#FFCCCC";//rojo=error
	    if ((mes>12)||(mes==0)) alert('Error en el MES ingresado');	    
	    else alert('Debe ingresar el PERIODO en formato mm/aaaa');
	}
}

//#####·##validaciones##########################################################

