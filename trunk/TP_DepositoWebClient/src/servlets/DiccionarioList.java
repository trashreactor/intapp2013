package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DiccionarioView;

import com.sun.xml.internal.txw2.Document;

import controller.Sistema;

/**
 * Servlet implementation class DiccionarioListSVL
 */

public class DiccionarioList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Sistema sistema = Sistema.getInstancia();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiccionarioList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = (String) request.getParameter("action");  
		if(action.equals("Nuevo")){
            	try {
					this.crearDiccionario(request,response);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
			}
		}
		if(action.equals("Guardar")){
           	try {
				this.guardarDiccionario(request,response);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(action.equals("Editar")){
           	try {
				this.editarDiccionario(request,response);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}


	private void guardarDiccionario(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
	HttpSession session = request.getSession(true);
	
	String nombre = request.getParameter("tNombre");
	String descripcion = request.getParameter("tDescripcion");
	
	session.setAttribute("divCrear", null);
	DiccionarioView diccionario;
	
	if(session.getAttribute("diccionario") == null)
    {
    	diccionario = new DiccionarioView();
    	session.setAttribute("diccionario", diccionario);
    }
    else 
    {
    	diccionario = (DiccionarioView) session.getAttribute("diccionario");
    }
	
	
	diccionario.setNombre(nombre);
	diccionario.setDescripcion(descripcion);
	
	session.setAttribute("diccionario", diccionario);
	
	sistema.altaDiccionario(diccionario);
	
	session.setAttribute("divCrear", null);

	
	
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/DiccionarioList.jsp");
    try {
            dispatcher.forward(request, response);
    } catch (ServletException e) {
            e.printStackTrace();
    } catch (IOException e) {
            e.printStackTrace();
    }
	
	
	}


	private void crearDiccionario(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		String divCrear = "1";
		session.setAttribute("divCrear", divCrear);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DiccionarioList.jsp");
	    try {
	            dispatcher.forward(request, response);
	    } catch (ServletException e) {
	            e.printStackTrace();
	    } catch (IOException e) {
	            e.printStackTrace();
	    }
		

		
	}
	
	private void editarDiccionario(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession(true);
		String nombre = request.getParameter("tNombre");
		String descripcion = request.getParameter("tDescripcion");
		Long id = Long.parseLong((String) session.getAttribute("idDicc"));

		DiccionarioView diccionario;
		
		if(session.getAttribute("diccionario") == null)
	    {
	    	diccionario = new DiccionarioView();
	    	session.setAttribute("diccionario", diccionario);
	    }
	    else 
	    {
	    	diccionario = (DiccionarioView) session.getAttribute("diccionario");
	    }
		
		diccionario.setIdDiccionario(id);
		diccionario.setNombre(nombre);
		diccionario.setDescripcion(descripcion);
		
		session.setAttribute("diccionario", diccionario);
		
		sistema.modificarDiccionario(diccionario);
		
		session.setAttribute("divCrear", null);
		session.setAttribute("divEditar", null);
		session.setAttribute("nombre", null);
		session.setAttribute("descripcion",null);
		session.setAttribute("id", null);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DiccionarioList.jsp");
	    try {
	            dispatcher.forward(request, response);
	    } catch (ServletException e) {
	            e.printStackTrace();
	    } catch (IOException e) {
	            e.printStackTrace();
	    }
		

		
	}

}
