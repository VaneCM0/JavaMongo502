/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javamongo502;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author medin
 */
public class Connection
{
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();
    
    
    public Connection() {
        try {
            MongoClient mongo = new MongoClient("localhost", 27017);
            BaseDatos = mongo.getDB("Actividades502");
            coleccion = BaseDatos.getCollection("Actividades502");
            System.out.println("Conexion  establecida");
        } catch (MongoException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR AL CONECTAR" +ex);
        }
    }

    public boolean insertar(String accion) {
        document.put("accion", accion);
        coleccion.insert(document);
        return true;
    }

    public void mostrar() {
        DBCursor cursor = coleccion.find();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

    public boolean actualizar(String accionVieja, String accionNueva) {
        document.put("accion", accionVieja);
        BasicDBObject documentNuevo = new BasicDBObject();
        documentNuevo.put("accion", accionNueva);
        coleccion.findAndModify(document, documentNuevo);
        return true;
    }
    
    public boolean eliminar(String accion){
        document.put("accion",accion);
        coleccion.remove(document);      
        return true;
    }
}
