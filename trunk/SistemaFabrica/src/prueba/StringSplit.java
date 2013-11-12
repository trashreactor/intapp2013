package prueba;

import java.util.*;

import org.apache.commons.lang3.StringUtils;

public class StringSplit {

	public static void main(String[] args) {
		
		
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		String cadena = StringUtils.join(lista, ",");
		System.out.println(cadena);
		
		String[] cadenas = cadena.split(",");
		for(String caracter: cadenas)
			System.out.println(caracter);
	}

}
