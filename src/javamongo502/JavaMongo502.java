/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javamongo502;

/**
 *
 * @author medin
 */
public class JavaMongo502
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
         System.out.println("Esperando conexión...");
        Connection con = new Connection();
            System.out.println("Mostrar los datos de la colección");
        con.mostrar();
        con.insertar("Salto");
        System.out.println("OTRO");
        con.mostrar();
        System.out.println("Actualizamos Salto a Correr");
        con.actualizar("Salto", "Correr");
        con.mostrar();
        System.out.println("Eliminamos Correr");
        con.eliminar("Correr");
        con.mostrar();
    }
    
}
