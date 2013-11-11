package prueba;

import java.io.*;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.*;

public class AppCliente {

	public static void main(String[] args) {
		 try {
			 	Client client = Client.create();

		        WebResource webResource = client.resource("http://localhost:8080/SistemaFabrica/enviarSolicitud");

		        String input = leerXML("SolicitudPrueba.json");

		        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
		           .post(ClientResponse.class, input);
		      
		     
		        if (response.getStatus() != 201 && response.getStatus() != 200) {
		            throw new RuntimeException("Failed : HTTP error code : "
		                 + response.getStatus());
		        }

		        System.out.println("Output from Server .... \n");
		        String output = response.getEntity(String.class);
		        System.out.println(output);

		      } catch (Exception e) {

		        e.printStackTrace();

		      }

	}
	
	private static String leerXML(String rutaArchivo){
		String archivo = new String();
		try{
			// Open the file that is the first 
			// command line parameter
			FileInputStream fstream = new FileInputStream(rutaArchivo);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
				archivo = archivo.concat(strLine);
			}
			
			  //Close the input stream
			in.close();
		}
		catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		return archivo;
	}
}
