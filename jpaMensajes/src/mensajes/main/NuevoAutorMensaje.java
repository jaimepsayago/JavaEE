package mensajes.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mensajes.entities.Autor;
import mensajes.entities.Mensaje;

public class NuevoAutorMensaje {
   public static void main(String[] args) {
      Autor autor;

      // Creamos la factor�a de entity managers y un entity manager
      EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("mensajes");
      EntityManager em = emf.createEntityManager();

      // Marcamos el comienzo de la transacci�n
      em.getTransaction().begin();

      // Pedimos datos del autor
      String email = leerTexto("Introduce el correo electr�nico: ");
      String nombre = leerTexto("Introduce nombre: ");
      autor = new Autor(nombre, email);

      // Lo a�adimos a la BD
      em.persist(autor);
      System.out.println("Identificador del autor: " + autor.getId());

      // Creamos el mensaje
      String mensajeStr = leerTexto("Introduce mensaje: ");
      Mensaje mens = new Mensaje(mensajeStr, autor);
      // Establecemos los campos
      mens.setFecha(new Date());
      // Y lo guardamos en la BD
      em.persist(mens);

      Long idMensaje = mens.getId();
      System.out.println("Identificador del mensaje: " + idMensaje);

      // Cerramos la transacci�n y el entity manager
      em.getTransaction().commit();
      em.close();
      emf.close();
   }

   static private String leerTexto(String mensaje) {
      String texto;
      try {
         BufferedReader in = new BufferedReader(new InputStreamReader(
               System.in));
         System.out.print(mensaje);
         texto = in.readLine();
      } catch (IOException e) {
         texto = "Error";
      }
      return texto;
   }
}
