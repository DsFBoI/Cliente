package Tests;
import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response; 

import org.glassfish.jersey.client.ClientConfig;



import models.facebook.*;

public class Test {
	
	public static void main(String[] args) {
		
		
		
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());
		
		/*INDEX RES:
		 * 
		 * RES1 = COMPROBAR USUARIOS
		 * RES2 = AÑADIR USUARIO
		 * RES3 = COMPROBAR AÑADIR USUARIO UN USUARIO
		 * RES4 = COMPROBAR DATOS DE UN USUARIO
		 * RES5 = MODIFICAR DATOS DE UN USARIO
		 * RES6 = BORRAR USUARIO
		 * RES7 = COMPROBACION BORRADO DE USUARIO
		 * RES8 = AÑADIR POST
		 * RES9 = INBOX DE UN USAURIO
		 * RES10 = BORRAR MENSAJE
		 * RES11 = MODIFICAR MENSAJE
		 * RES12 = COMPRPBACION MODIFICACION
		 * RES13 = AÑADIR UN AMIGO
		 * RES14 = LISTA DE AMIGOS
		 * RES15 = BORRAR AMIGOS 
		 *  
		 * */
		
		/*CREACION DE USUARIOS PARA PRUEBAS USUARIO*/
		
		
		User u1 = new User("Pepe");
		User u2 = new User("Emil");
		User u3 = new User("Rodri");
		User u4 = new User("Dani");
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA INICIAL PAR AVER SI LISTA VACIA*/

		String res1 = target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PruebaListaVaciaInicial: " + res1 + '\n');
		
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/* PRUEBA AÑADIR USUSARIOS COMPROBAR CON EL NUEVO RODRI */
		System.out.println("STATUS CRACIÓN DE USUARIO: \n"  );
		Response res2 = target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u1),Response.class);
		System.out.println("STATUS U1 = " + res2.getStatus());
		
		res2 = target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u2),Response.class);
		System.out.println("STATUS U2 = " + res2.getStatus());
		
		res2 = target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u3),Response.class);
		System.out.println("STATUS U3 = " + res2.getStatus());
		
		res2 = target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		System.out.println("STATUS U4 = " + res2.getStatus());
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA CONSEGUIR TODOS LOS USERS AÑADIDOS*/
		
		String res3 =target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PruebaAñadirUsuarios: " + res3 + '\n');
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA PARA COMPROBAR LOS DATOS DE UN SOLO USUARIO*/
		
		String res4 = target.path("api").path("users").path("3").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PruebaInfoUsuario: " + res4 + '\n');
		
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA PARA MODIFICAR LOS DATOS DE UN USUARIO*/
		
		User uCambio = new User("gABACHA");
		
		Response res5 = target.path("api").path("users").path("2").request().accept(MediaType.APPLICATION_JSON).put(Entity.json(uCambio),Response.class);
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/* PRUEBA DE DELETE DE UN USUSARIO */
		
		Response res6 =  target.path("api").path("users").path("3").request().delete();
		System.out.println("STATUS DELETE: " + res6.getStatus() + "\n");
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*COMPROBACION SI SE HA BORRADO EL USUARIO*/
		
		String res7 =target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PruebaBorrarUsuario: " + res7 + '\n');
		
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*MENSAJES PAR A LA PRUEBA DE USUARIOS*/
		
		Message m1 = new Message(1,2,"y Je m'appelle");
		Message m2 = new Message(2,3,"Inshalla");
		Message m3 = new Message(2,1,"no hablo frances");
		Message m4 = new Message(1,2,"y Je m'appelle Barbara");
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA AÑADIR UN POST EN PAGINA PRINCIPAL*/
		System.out.println("STATUS CRACIÓN DE USUARIO: \n" );
		Response res8 = target.path("api").path("users").path("1").path("2").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m1),Response.class);
		System.out.println("STATUS M1=" + res8.getStatus());
		
		res8 =  target.path("api").path("users").path("2").path("3").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m2),Response.class);
		System.out.println("STATUS M2=" + res8.getStatus());
		
		res8 =  target.path("api").path("users").path("2").path("1").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m3),Response.class);
		System.out.println("STATUS M3=" + res8.getStatus());
		
		res5 =  target.path("api").path("users").path("1").path("2").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m4),Response.class);
		System.out.println("STATUS M4=" + res8.getStatus() + "\n");
		

		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA TODOS LOS MENSAJES EN LA PAGINA DEL USUARIO*/
		
		String res9 = target.path("api").path("users").path("2").path("inbox").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PruebaMostrarMensajes: " + res9 + '\n');
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA DELETE DE UN MENSAJE*/
		
		Response res10 = target.path("api").path("users").path("2").path("messages").path("2").request().delete();
		
		res9 = target.path("api").path("users").path("3").path("inbox").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PruebaBorrarMensajes: " + res9 + '\n');
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA MODIFICACIÓN DE MENSAJES*/
		
		Message mCambio = new Message(1,2,"ups");
		
		Response res11 =  target.path("api").path("users").path("1").path("messages").path("1").request().put(Entity.json(mCambio),Response.class);
		
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*COMPROBACION PREUBA DE MODIFICACION*/
		
		String res12 = target.path("api").path("users").path("2").path("inbox").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PruebaModificaciónMensajes: " + res12 + '\n');
		 
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/

		/*AÑADIR UN AMIGO*/
		
		Response res13 = target.path("api").path("users").path("1").path("friends").queryParam("friend", "4").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("2").path("friends").queryParam("friend", "4").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("3").path("friends").queryParam("friend", "1").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("1").path("friends").queryParam("friend", "2").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);

		
		
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/

		/*LISTA AMIGOS*/
		
		String res14 = target.path("api").path("users").path("1").path("friends").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PRUEBA AMIGOS: " + res14);
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/

		/*ELIMINAR AMIGOS AMIGOS*/
		
		Response res15 = target.path("api").path("users").path("2").path("friends").queryParam("friend", "4").request().delete();
		System.out.println(res15);
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/

		/*ELIMINAR AMIGOS AMIGOS*/
		
	}
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/facebook/").build();
	}
}
