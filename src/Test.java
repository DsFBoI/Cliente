import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response; 

import org.glassfish.jersey.client.ClientConfig;

import model.User;


public class Test {

	public static void main(String[] args) {
		
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());
		
		/* Para conseguir todos los usuarios*/

		String res1 =target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("Prueba1: "+res1);
		
		/* Anadir user*/
		User prueba1 = new User("pepe",1);
		
		Response res2 = target.path("api").path("users").path(prueba1.getName()).path(""+prueba1.getId()).request().accept(MediaType.APPLICATION_JSON).post(Entity.json(prueba1),Response.class);
		System.out.println(res2.getStatus());
		
		Response res3 = target.path("api").path("users").path("emiliepajera").path("2").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(prueba1),Response.class);
		System.out.println(res3.getStatus());
		
		Response res6 = target.path("api").path("users").path("bababunga").path("3").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(prueba1),Response.class);
		System.out.println(res3.getStatus());
		
		String res4 =target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("Prueba2: " +res4);
		
		String res5 = target.path("api").path("users").path("2").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("Prueba3: " +res5);
		
		/* DELETE */ 
		
		Response res7 =  target.path("api").path("users").path("1").request().delete();
		//System.out.println("Prueba4: " +res7);
		
		 String res17 =target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("Prueba4: "+res17);
		
		/*  */
	
			
	

	}
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/REST1bHolaMundo/").build();
	}
}


