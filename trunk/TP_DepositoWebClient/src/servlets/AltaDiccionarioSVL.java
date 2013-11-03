package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DiccionarioView;

import controller.Sistema;

/**
 * Servlet implementation class AltaDiccionarioSVL
 */

public class AltaDiccionarioSVL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Sistema sistema = Sistema.getInstancia();

    /**
     * Default constructor. 
     */
    public AltaDiccionarioSVL() {
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
		
	}
		
	
	
	
	
	
	
	
	
	

}
