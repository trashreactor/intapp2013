package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.vo.*;
import model.*;

/**
 * Servlet implementation class ArticuloListSVL
 */

public class ArticuloSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BusinessDelegate bd = new BusinessDelegate();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticuloSVL() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = (String) request.getParameter("action");
			if (action.equals("Nuevo")) {
				this.crearArticulo(request, response);
			}
			if (action.equals("Guardar")) {
				this.guardarArticulo(request, response);
			}
			if (action.equals("Editar")) {
				this.editarArticulo(request, response);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void guardarArticulo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(true);

		String nombre = request.getParameter("tNombre");
		String precio = request.getParameter("tPrecio");
		String descripcion = request.getParameter("tDescripcion");
		String tipo = request.getParameter("tTipo");

		switch(tipo){
		case "Moda":
			ArtModaVO Articulo= new ArtModaVO(nombre, descripcion, float precio,
					String foto, int stock, String color, String talle) ;
			bd.crearArticuloModa(Articulo);
		case "Ninos":
			
		case "Mueble":
			
		case "Electro":
			
		}
		
		
		
		
		session.setAttribute("divCrear", null);
		

		if (session.getAttribute("Articulo") == null) {
			Articulo = new ArticuloView();
			session.setAttribute("Articulo", Articulo);
		} else {
			Articulo = (ArticuloView) session.getAttribute("Articulo");
		}

		Articulo.setNombre(nombre);
		Articulo.setDescripcion(descripcion);

		session.setAttribute("Articulo", Articulo);

		
		bd.crearArticuloNinos(Articulo);
		bd.crearArticuloMueble(Articulo);
		bd.crearArticuloElectro(Articulo);

		session.setAttribute("divCrear", null);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/ArticuloList.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void crearArticulo(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		String divCrear = "1";
		session.setAttribute("divCrear", divCrear);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/ArticuloList.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void editarArticulo(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession(true);
		String nombre = request.getParameter("tNombre");
		String descripcion = request.getParameter("tDescripcion");
		Long id = Long.parseLong((String) session.getAttribute("idDicc"));

		ArticuloView Articulo;

		if (session.getAttribute("Articulo") == null) {
			Articulo = new ArticuloView();
			session.setAttribute("Articulo", Articulo);
		} else {
			Articulo = (ArticuloView) session.getAttribute("Articulo");
		}

		Articulo.setIdArticulo(id);
		Articulo.setNombre(nombre);
		Articulo.setDescripcion(descripcion);

		session.setAttribute("Articulo", Articulo);

		sistema.modificarArticulo(Articulo);

		session.setAttribute("divCrear", null);
		session.setAttribute("divEditar", null);
		session.setAttribute("nombre", null);
		session.setAttribute("descripcion", null);
		session.setAttribute("id", null);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/ArticuloList.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
