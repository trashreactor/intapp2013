//#####·########################################################################			
//funcion que desloguea al usuario luego de 15min=900segs
var contador = 0;         // contador de tiempo inactivo
// llamo a la función de Actualización 1 segundo después de su primera carga
ID=window.setTimeout("actualizar();",1000);		
						
function actualizar(){
		contador ++;
		if(contador == 900){//15 minutos = 900segs			                
			window.location.href ='logout.aspx';//'index.htm';
		}               							 
		window.status="tiempo Inactivo : " + contador //+ " / " + elemento ;
		//document.form1.title.value="El contador esta ahora en " + contador + " segundos " + user ;
		// poné otro timeout para el siguiente contador
		ID=window.setTimeout("actualizar();",1000);
}
//#####·########################################################################	