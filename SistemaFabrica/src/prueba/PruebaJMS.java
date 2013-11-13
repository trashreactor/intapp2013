package prueba;

import entities.RemitoCompra;
import jms.ConexionJMS;

public class PruebaJMS {

	public static void main(String[] args) {
		try {	
			ConexionJMS con = new ConexionJMS();
			con.setUrl("localhost:4447");
			con.setUsuario("user");
			con.setContraseña("user1234");
			con.setDestino("jms/queue/test");
			RemitoCompra remito = new RemitoCompra();
			remito.setNroRemitoCompra(1);
			con.enviarMensaje(remito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
