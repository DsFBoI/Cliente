import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response; 

import model.User;

import org.glassfish.jersey.client.ClientConfig;

//import com.sun.research.ws.wadl.Response;

import model.User;
import model.message;


public class Test {

	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());
		
		/*
		 * RES1 = COMPROBAR USUARIOS
		 * RES2 = AÑADIR USUARIO
		 * RES3 = COMPROBAR UN USUARIO
		 * RES4 = BORRAR USUSARIO 
		 * RES5 = AÑADIR POST
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
		
		/* PRUEBA ALADIR USUSARIOS COMPROBAR CON EL NUEVO RODRI*/
		
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
		
		res1 =target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PruebaAñadirUsuarios: " + res1 + '\n');
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA PARA COMPROBAR LOS DATOS DE UN SOLO USUARIO*/
		
		String res3 = target.path("api").path("users").path("2").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PruebaInfoUsuario: " + res3 + '\n');
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA PARA MODIFICAR LOS DATOS DE UN USUARIO*/
		
		User uCambio = new User("Jose");
		
		Response res8 = target.path("api").path("users").path("1").request().accept(MediaType.APPLICATION_JSON).put(Entity.json(uCambio),Response.class);
		System.out.println(res8.getStatus() + "\n");
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/* PRUEBA DE DELETE DE UN USUSARIO*/ 
		
		Response res4 =  target.path("api").path("users").path("1").request().delete();
		System.out.println(res4.getStatus());
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*COMPROBACION SI SE HA BORRADO EL USUARIO*/
		
		 res1 =target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PruebaBorrarUsuario: " + res1 + '\n');
		
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*MENSAJES PAR A LA PRUEBA DE USUARIOS*/
		
		message m1 = new message(1,2,"y Je m'appelle");
		message m2 = new message(2,3,"Inshalla");
		message m3 = new message(2,1,"no hablo frances");
		message m4 = new message(1,2,"y Je m'appelle Barbara");
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA AÑADIR UN POST EN PAGINA PRINCIPAL*/
		
		Response res5 = target.path("api").path("users").path("1").path("2").request().post(Entity.json(m1),Response.class);
		System.out.println("STATUS M1=" + res5.getStatus());
		
		res5 =  target.path("api").path("users").path("2").path("3").request().post(Entity.json(m2),Response.class);
		System.out.println("STATUS M2=" + res5.getStatus());
		
		res5 =  target.path("api").path("users").path("2").path("1").request().post(Entity.json(m3),Response.class);
		System.out.println("STATUS M3=" + res5.getStatus());
		
		res5 =  target.path("api").path("users").path("1").path("2").request().post(Entity.json(m4),Response.class);
		System.out.println("STATUS M4=" + res5.getStatus());
		
		System.out.println(res5.getStatus());
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA TODOS LOS MENSAJES EN LA PAGINA DEL USUARIO*/
		
		String res6 = target.path("api").path("users").path("2").path("pag_personal").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PruebaMostrarMensajes: " + res6 + '\n');
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA DELETE DE UN MENSAJE*/
		
		Response res7 = target.path("api").path("users").path("2").path("pag_personal").path("1").request().delete();
		
		res6 = target.path("api").path("users").path("2").path("pag_personal").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PruebaBorrarMensajes: " + res6 + '\n');
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA MODIFICACIÓN DE MENSAJES*/
		
		message mCambio = new message(1,2,"ups");
		
		res5 =  target.path("api").path("users").path("2").path("pag_personal").path("1").request().put(Entity.json(mCambio),Response.class);
		
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*COMPROBACION PREUBA DE MODIFICACION*/
		
		res6 = target.path("api").path("users").path("2").path("pag_personal").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PruebaModificaciónMensajes: " + res6 + '\n');
		 
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/

		
		
		
		
		
		
	}
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/facebook/api/").build();
	}
}


