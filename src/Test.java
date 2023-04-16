package Tests;
import java.net.URI;
import java.sql.Date;

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
		 * RES16 = MENSAJES DE AMIGOS
		 * RES17 = MENSAJES AMIGOS CON FILTROS
		 * RES18 = USUARIOS CON FILTRO
		 * RES19 = MODO APP
		 * RES20 = AÑADIR EN PAGINA PRINCIPAL
		 * 
		 * */
		
		/*CREACION DE USUARIOS PARA PRUEBAS USUARIO*/
		
		
		User u1 = new User("Pepe","pepe@gmail.com", "JosePepe");
		User u2 = new User("Emil","email@gmail.com", "gabacha1");
		User u3 = new User("Rodri","rodri@gmail.com", "gito333");
		User u4 = new User("Dani","dani@gmail.com", "Elmejol");
		User u5 = new User("Paco","paco@gmail.com", "paquito");
		User u6 = new User("Adolfo","adolf@gmail.com", "not_h");
		User u7 = new User("Esther","esther@gmail.com", "AmoLunde");
		User u8 = new User("Benjamin","benjamin@gmail.com", "benji");
		User u9 = new User("Alejandro","alejandro@gmail.com", "Perli");
		User u10 = new User("Ignacio","asio@gmail.com", "ILoveAlmeria");
		User u11 = new User("Miki","miguelluis@gmail.com", "MariquitaMala");
		User u12 = new User("Guillelmo","guille@gmail.com", "Vigueras");
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA INICIAL PAR AVER SI LISTA VACIA*/

		String res1 = target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PruebaListaVaciaInicial: " + res1 + '\n');
		
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/* PRUEBA AÑADIR USUSARIOS */
		
		System.out.println("STATUS CRACIÓN DE USUARIO: \n"  );
		Response res2 = target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u1),Response.class);
		res2 = target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u2),Response.class);
		res2 = target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u3),Response.class);
		res2 = target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res2 = target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u5),Response.class);
		res2 = target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u6),Response.class);
		res2 = target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u7),Response.class);
		res2 = target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u8),Response.class);
		res2 = target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u9),Response.class);
		res2 = target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u10),Response.class);
		res2 = target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u11),Response.class);
		res2 = target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u12),Response.class);


		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA CONSEGUIR TODOS LOS USERS AÑADIDOS*/
		
		String res3 =target.path("api").path("users").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PruebaAñadirUsuarios: " + res3 + '\n');
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA CONSEGUIR TODOS LOS USERS AÑADIDOS CON FILTRO*/
		
		String res18=target.path("api").path("users").path("filter").queryParam("filtro", "A").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PruebaAñadirUsuarios: " + res18 + '\n');
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA PARA COMPROBAR LOS DATOS DE UN SOLO USUARIO*/
		
		String res4 = target.path("api").path("users").path("12").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PruebaInfoUsuario: " + res4 + '\n');
		
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA PARA MODIFICAR LOS DATOS DE UN USUARIO*/
		
		User uCambio = new User("Emilie", "email@gmail.com", "eemail");
		
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
		
		Message m1 = new Message(1,2,"hola_1", Date.valueOf("2018-3-31"));
		Message m2 = new Message(2,3,"hola_2", Date.valueOf("2019-3-31"));
		Message m3 = new Message(3,4,"hola_3", Date.valueOf("2020-3-31"));
		Message m4 = new Message(4,5,"hola_4", Date.valueOf("2018-2-31"));
		Message m5 = new Message(8,6,"hola_5", Date.valueOf("2014-3-12"));
		Message m6 = new Message(2,5,"hola_6", Date.valueOf("2012-5-10"));
		Message m7 = new Message(1,11,"hola_7", Date.valueOf("2002-5-10"));
		Message m8 = new Message(2,11,"hola_8", Date.valueOf("2002-8-1"));
		Message m9 = new Message(11,10,"hola_9", Date.valueOf("2002-1-9"));
		Message m10 = new Message(6,10,"hola_10", Date.valueOf("2002-3-19"));
		Message m11 = new Message(7,9,"hola_11", Date.valueOf("2002-11-10"));
		Message m12 = new Message(1,7,"hola_12", Date.valueOf("2002-4-2"));
		Message m13 = new Message(9,11,"hola_13", Date.valueOf("2002-6-23"));
		Message m14 = new Message(5,1,"hola_14", Date.valueOf("2002-9-8"));
		Message m15 = new Message(10,4,"hola_15", Date.valueOf("2002-9-24"));
		Message m16 = new Message(4,1,"hola_16", Date.valueOf("2001-7-20"));
		Message m17 = new Message(2,10,"hola_16", Date.valueOf("2000-9-19"));
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA AÑADIR UN POST EN PAGINA PRINCIPAL*/
		System.out.println("STATUS CRACIÓN DE USUARIO: \n" );
		Response res8 = target.path("api").path("users").path("1").path("2").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m1),Response.class);	
		res8 =  target.path("api").path("users").path("2").path("3").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m2),Response.class);		
		res8 =  target.path("api").path("users").path("2").path("1").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m3),Response.class);
		res8 =  target.path("api").path("users").path("10").path("4").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m4),Response.class);
		res8 =  target.path("api").path("users").path("1").path("2").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m5),Response.class);
		res8 =  target.path("api").path("users").path("4").path("2").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m6),Response.class);
		res8 =  target.path("api").path("users").path("10").path("1").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m7),Response.class);
		res8 =  target.path("api").path("users").path("9").path("2").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m8),Response.class);
		res8 =  target.path("api").path("users").path("8").path("3").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m9),Response.class);
		res8 =  target.path("api").path("users").path("7").path("4").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m10),Response.class);
		res8 =  target.path("api").path("users").path("6").path("5").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m11),Response.class);
		res8 =  target.path("api").path("users").path("5").path("6").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m12),Response.class);
		res8 =  target.path("api").path("users").path("4").path("7").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m13),Response.class);
		res8 =  target.path("api").path("users").path("3").path("8").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m14),Response.class);
		res8 =  target.path("api").path("users").path("2").path("9").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m15),Response.class);
		res8 =  target.path("api").path("users").path("1").path("10").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m16),Response.class);
		res8 =  target.path("api").path("users").path("10").path("2").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(m17),Response.class);
		

		
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
		
		Message mCambio = new Message(1,2,"ups", Date.valueOf("2018-3-31"));
		
		Response res11 =  target.path("api").path("users").path("1").path("messages").path("1").request().put(Entity.json(mCambio),Response.class);
		
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*COMPROBACION PREUBA DE MODIFICACION*/
		
		String res12 = target.path("api").path("users").path("2").path("inbox").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PruebaModificaciónMensajes: " + res12 + '\n');
		 
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/

		/*AÑADIR UN AMIGO*/
		
		Response res13 = target.path("api").path("users").path("1").path("friends").queryParam("friend", "4").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("2").path("friends").queryParam("friend", "11").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("3").path("friends").queryParam("friend", "10").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("1").path("friends").queryParam("friend", "9").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("1").path("friends").queryParam("friend", "8").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("2").path("friends").queryParam("friend", "7").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("3").path("friends").queryParam("friend", "6").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("4").path("friends").queryParam("friend", "7").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("5").path("friends").queryParam("friend", "6").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("6").path("friends").queryParam("friend", "5").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("7").path("friends").queryParam("friend", "4").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("8").path("friends").queryParam("friend", "3").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("9").path("friends").queryParam("friend", "2").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("10").path("friends").queryParam("friend", "1").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("11").path("friends").queryParam("friend", "1").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("10").path("friends").queryParam("friend", "2").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("9").path("friends").queryParam("friend", "3").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("8").path("friends").queryParam("friend", "4").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("7").path("friends").queryParam("friend", "5").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("6").path("friends").queryParam("friend", "6").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("5").path("friends").queryParam("friend", "7").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("4").path("friends").queryParam("friend", "8").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("3").path("friends").queryParam("friend", "9").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("2").path("friends").queryParam("friend", "10").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		res13 = target.path("api").path("users").path("1").path("friends").queryParam("friend", "11").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u4),Response.class);
		
		
		
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/

		/*LISTA AMIGOS*/
		
		String res14 = target.path("api").path("users").path("1").path("friends").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PRUEBA AMIGOS: " + res14 + "\n");
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/

		/*ELIMINAR AMIGOS AMIGOS*/
		
		Response res15 = target.path("api").path("users").path("2").path("friends").queryParam("friend", "4").request().delete();
	
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/

		/*CONSEGUIR MENSAJES DE AMIGOS*/
		
		String res16 = target.path("api").path("users").path("2").path("friends").path("messages").queryParam("nMessages", "10").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PRUEBA CONSEGUIR MENSAJES DE AMIGOS: "+ res16 + "\n");
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/

		/*CONSEGUIR MENSAJES DE AMIGOS CON FILTRO*/
		
		String res17 = target.path("api").path("users").path("2").path("friends").path("messages").path("filter").queryParam("nMessages", "2").queryParam("filtro", "8").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println("PRUEBA CONSEGUIR MENSAJES DE AMIGOS: "+ res17 + "\n");
		
		
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/
		
		/*PRUEBA AÑADIR UN POST EN PAGINA PRINCIPAL*/
		
		Message mPagPrinc1 = new Message(1,0,"Ay amiga me encata mi pelo", Date.valueOf("2018-4-12"));
		Message mPagPrinc2 = new Message(1,0,"Bon dia", Date.valueOf("2018-6-1"));
		Message mPagPrinc3 = new Message(1,0,"Je m'appelle", Date.valueOf("2018-2-10"));
		
		Response res20 = target.path("api").path("users").path("2").path("messages").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(mPagPrinc1),Response.class);
		res20 = target.path("api").path("users").path("2").path("messages").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(mPagPrinc2),Response.class);
		res20 = target.path("api").path("users").path("2").path("messages").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(mPagPrinc3),Response.class);
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/

		/*MODO APP*/
		
		String res19 =  target.path("api").path("users").path("2").path("description").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println("PRUEBA FORMATO APLICACIÓN : " + res19 + "\n");
		
		/*----------------------------------------------------------------------------------------------------------------------------------------------*/

		/*MENSAJES pUBLICADOS POR UN USUARIO EN LA PAG PERSONAL*/
		
		String res21 = target.path("api").path("users").path("2").path("messages").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println("PRUEBA MENSAJES PAGINA PRINCIPAL: " + res21);
		
	}
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/facebook/").build();
	}
}
