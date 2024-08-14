/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import modelo.Estudiante;

/**
 *
 * @author Alejandro
 */
public class EstudianteControlador {
    
    public Estudiante estudiante;
    
    ConexionBDD conexion=new ConexionBDD();
    Connection connection=(Connection) conexion.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;
    
    public void crearEstudiante(int idPersona){
        try {
            String consulta = "INSERT INTO estudiantes(per_id) "
                    + "VALUES (?);";
            
            ejecutar =(PreparedStatement) connection.prepareCall(consulta);
            ejecutar.setInt(1, idPersona);
            
            int res = ejecutar.executeUpdate();
            
            if(res > 0){
                ejecutar.close();
            }else{
                System.out.println("¡ERROR, CONTACTESE CON EL ADMINISTADOR!");
                ejecutar.close();
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}
