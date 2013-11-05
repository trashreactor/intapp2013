package jms;

import java.io.Serializable;
import java.util.Properties;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

public class ConexionJMS {
	private String url;
	private String usuario;
	private String contraseña;
	private String destino;
	
	public ConexionJMS(){}
	
	public void enviarMensaje(Serializable mensaje) throws Exception{

		// Set up the context for the JNDI lookup
        final Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, "remote://"+url));
        env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", usuario));
        env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", contraseña));
        Context context = new InitialContext(env);

        // Perform the JNDI lookups
        String connectionFactoryString = System.getProperty("connection.factory", "jms/RemoteConnectionFactory");
        ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(connectionFactoryString);

        String destinationString = System.getProperty("destination", destino);
        Destination destination = (Destination) context.lookup(destinationString);

        // Create the JMS connection, session, producer, and consumer
        Connection connection = connectionFactory.createConnection(System.getProperty("username", usuario), System.getProperty("password", contraseña));
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        connection.start();
    	
        MessageProducer producer = session.createProducer(destination);
        ObjectMessage mensajeAEnviar = session.createObjectMessage(mensaje);
        producer.send(mensajeAEnviar);
		
		connection.close();
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	
}
