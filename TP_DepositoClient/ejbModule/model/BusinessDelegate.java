package model;
import java.util.Hashtable;
import java.util.List;

import javax.naming.InitialContext;

import facade.DepositoFacade;
import entity.vo.*;

public class BusinessDelegate {

	private DepositoFacade depositoFacade;
	private InitialContext initialContext;
	private String naming = "TP_Deposito/facade/bean/DepositoFacadeBean/remote";
	
	
	public BusinessDelegate() {
		inicializarContexto();
	}
	
	private DepositoFacade getDepositoFacade(){
		try{
			if(depositoFacade == null){
				depositoFacade = (DepositoFacade)initialContext.lookup(naming);
				
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return depositoFacade;
	}
	

	
	private void inicializarContexto() {
		try{
			Hashtable props = new Hashtable();
			props.put(InitialContext.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			//Url completa de ubicacion del servidor de aplicaciones
			props.put(InitialContext.PROVIDER_URL,"jnp://127.0.0.1:1099");
			//Objeto del tipo InitialContext
			initialContext = new InitialContext(props);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public List<ArticuloVO> getArticulosALL(){
		return getDepositoFacade().getAllArticulos();
	}
	
	
	

}
