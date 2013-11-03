package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DiccionarioView;
import beans.ItemDiccionarioView;

import com.sun.xml.internal.txw2.Document;

import controller.Sistema;

/**
 * Servlet implementation class DiccionarioListSVL
 */

public class DiccionarioItemList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Sistema sistema = Sistema.getInstancia();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiccionarioItemList() {
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
					this.crearItemDiccionario(request,response);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
			}
		}
		if(action.equals("Guardar")){
           	try {
				this.guardarItemDiccionario(request,response);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(action.equals("Editar")){
           	try {
				this.editarItemDiccionario(request,response);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void guardarItemDiccionario(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
	HttpSession session = request.getSession(true);
	
	String id = (String) session.getAttribute("idDiccionario");
	session.setAttribute("idDiccionario", id);
	Long idDicc = Long.parseLong(id);
	String nombre = request.getParameter("tNombre");
	
//	StringBuffer text = new StringBuffer(request.getParameter("tCondicion")); 
//	int loc = (new String(text)).indexOf('\n');
//	while(loc > 0){
//		text.replace(loc, loc+1, "");
//		loc = (new String(text)).indexOf('\n');
//	}
	String condicion = request.getParameter("tCondicion");
	
	String reemplazo = request.getParameter("tReemplazo");
	ItemDiccionarioView item;
	if(session.getAttribute("itemDiccionario") == null)
    {
    	item = new ItemDiccionarioView();
    	
    	session.setAttribute("itemDiccionario", item);
    }
    else
    {
    	item = (ItemDiccionarioView) session.getAttribute("itemDiccionario");
    }
	
	item.setNombre(nombre);
	item.setCondicion(condicion);
	//agrego el span para resaltar el reemplazo.
	item.setReemplazo("<SPAN STYLE='background-color: #FFFF00'>"+reemplazo+"</span>");
	session.setAttribute("itemDiccionario", item);
		
	sistema.altaItemDiccionario(idDicc, item.getNombre(), item.getCondicion(), item.getReemplazo());
	
	session.setAttribute("divCrear", null);
	String idNuevo = (String) session.getAttribute("idDiccionario");
	session.setAttribute("idDiccionario", id);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/DiccionarioItemList.jsp?id="+idNuevo);
    try {
            dispatcher.forward(request, response);
    } catch (ServletException e) {
            e.printStackTrace();
    } catch (IOException e) {
            e.printStackTrace();
    }
	
	
	}


	private void crearItemDiccionario(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession(true);
		String divCrear = "1";
		session.setAttribute("divCrear", divCrear);
		
		session.setAttribute("divEditar", null);
		
		
		
		String id = (String) session.getAttribute("idDiccionario");
		session.setAttribute("idDiccionario", id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DiccionarioItemList.jsp?id="+id);
	
		try {
                dispatcher.forward(request, response);
        } catch (ServletException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }
		
	}
	
	private void editarItemDiccionario(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession(true);
			
		
		String id = (String) session.getAttribute("idDiccionario");
		session.setAttribute("idDiccionario", id);
		Long idDicc = Long.parseLong(id);
		String nombre = request.getParameter("tNombre");
		
//		StringBuffer text = new StringBuffer(request.getParameter("tCondicion")); 
//		
//		int loc = (new String(text)).indexOf('\n');
//		while(loc > 0){
//			text.replace(loc, loc+1, "");
//			loc = (new String(text)).indexOf('\n');
//		}
		String condicion = request.getParameter("tCondicion");
		String reemplazo = request.getParameter("tReemplazo");
		
		ItemDiccionarioView item;
		if(session.getAttribute("itemDiccionario") == null)
	    {
	    	item = new ItemDiccionarioView();
	    	
	    	session.setAttribute("itemDiccionario", item);
	    }
	    else
	    {
	    	item = (ItemDiccionarioView) session.getAttribute("itemDiccionario");
	    }
		
		item.setNombre(nombre);
		item.setCondicion(condicion);
		//agrego el span para resaltar el reemplazo.
		item.setReemplazo("<SPAN STYLE='background-color: #FFFF00'>"+reemplazo+"</span>");
		session.setAttribute("itemDiccionario", item);
			
		sistema.modificarItemDiccionario(idDicc, item.getIdItemDiccionario(), item.getCondicion(), item.getReemplazo());
		session.setAttribute("divEditar", null);
		
		String idNuevo = (String) session.getAttribute("idDiccionario");
		session.setAttribute("idDiccionario", id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DiccionarioItemList.jsp?id="+idNuevo);
	    try {
	            dispatcher.forward(request, response);
	    } catch (ServletException e) {
	            e.printStackTrace();
	    } catch (IOException e) {
	            e.printStackTrace();
	    }
				
       
		
	}

}
