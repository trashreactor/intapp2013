package controller;



import java.util.List;

import entity.vo.ArticuloVO;
import model.BusinessDelegate;

public class Prueba {

	public Prueba() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		BusinessDelegate b = new BusinessDelegate();
		List<ArticuloVO> arts = b.getArticulosALL();
		System.out.println(arts.get(0).getNombre());
		
		

	}

}
