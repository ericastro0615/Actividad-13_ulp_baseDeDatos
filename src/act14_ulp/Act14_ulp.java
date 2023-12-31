
package act14_ulp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;


public class Act14_ulp {

 
    public static void main(String[] args) {
       try {
            
            Class.forName("org.mariadb.jdbc.Driver");
            //1. Cargar el driver MariaDB. 
            //2. Establecer la conexión a la base de datos previamente creada.


            String url = "jdbc:mariadb://127.0.0.1:3306/ulp";
            String usuario= "root";
            String contrasenia = "";
            Connection conexion=  DriverManager.getConnection(url, usuario, contrasenia);
           // System.out.println("correcta conexion");
            
  /*          
            //3. Insertar 3 alumnos 
            String sqlAlumno = "INSERT INTO alumno  (dni, apellido, nombre, fechaNacimiento, estado ) "
                    //+ "VALUES (3581575 , 'Gonzales', 'Juana', '2001-04-30', true)";
                    + "VALUES (34785426 , 'Marin', 'Juan Ignacio', '2002-01-30', true), " 
                    + "(3985427, 'Suarez', 'Maria', '2001-03-11', true) " ;
                     
                    
            //inserta en tabla alumno
            PreparedStatement psAlumno=  conexion.prepareStatement( sqlAlumno );
            //Envia datos a la tabla, se agrega con if para saber si se agrego una fila - camppo        
            int filas = psAlumno.executeUpdate();
            if (filas >0) {
                JOptionPane.showMessageDialog(null, "Alumno agregado");
            }
            
           //4. Insertar 4 materias
             String sqlMateria= "INSERT INTO materia  (nombre, anio, estado ) "
                     + "VALUES ('Programación 1' , '1',  true), " 
                    + "( 'Ingles Técnico', 2, true), " 
                    + "('Matemática', 1, true), " 
                    + "('Practicas profesionales', 3, true)";
            
             PreparedStatement psMateria=  conexion.prepareStatement(sqlMateria );
            //Envia datos a la tabla, se agrega con if para saber si se agrego una fila - camppo        
            int filasMateria = psMateria.executeUpdate();
            if (filasMateria >0) {
                JOptionPane.showMessageDialog(null, "Datos agregados");
            
  */
  
  /*
  //5.Inscribir a los 3 alumnos en 2 materias cada uno.
    String sqlInscripcion = "INSERT INTO inscripción (nota, idAlumno, idMateria) VALUES "
                   + "(8, 1, 4), "
                   + "(9, 1, 3), "
                   + "(10, 6, 3), "
                   + "(7, 6, 1), "
                   + "(9, 7, 2), "
                   + "(6, 7, 4)";
            
             PreparedStatement psInscripcion=  conexion.prepareStatement(sqlInscripcion );
            //Envia datos a la tabla, se agrega con if para saber si se agrego una fila - camppo        
            int filasInscripcion = psInscripcion.executeUpdate();
            if (filasInscripcion >0) {
                JOptionPane.showMessageDialog(null, "Inscripcion agregada");
*/
  
  /*
  //6.Listar los datos de los alumnos con calificaciones superiores a 8.
           String sqlCalificacion = "SELECT a.idAlumno, a.nombre, a.apellido, a.dni, a.fechaNacimiento,m.nombre, i.nota \n"
                   + "FROM alumno a, inscripción i, materia m\n"
                   + "WHERE i.idAlumno = a.idAlumno AND i.nota >=8;";
           PreparedStatement psCalificacion = conexion.prepareStatement(sqlCalificacion);
           ResultSet rsCalificacion = psCalificacion.executeQuery();
            //devuelve tru, mientras haya datos0filas para mostrar  rsCalificacion.next();
            while(rsCalificacion.next() ) {
                int idAlumno= rsCalificacion.getInt("a.idAlumno");
                String nombre= rsCalificacion.getString("a.nombre");
                String apellido= rsCalificacion.getString("a.apellido");
                int dni= rsCalificacion.getInt("dni");
                String materia= rsCalificacion.getString("m.nombre");
                int nota= rsCalificacion.getInt("i.nota");
                
                LocalDate fechaNac = rsCalificacion.getDate("a.fechaNacimiento").toLocalDate();
                System.out.println("\n");
                System.out.println("id alumno " + idAlumno);
                System.out.println("nombre " + nombre);
                System.out.println("apellido " + apellido);
                System.out.println("dni " + dni);
                System.out.println("fecha de nacimiento " + fechaNac.toString());
                System.out.println("materia: " + materia);
                System.out.println("nota "+ nota);
                System.out.println("___________ \n");

            }
*/
  
  //7. Desinscribir un alumno de una de la materias.
           String sqlDesinscripcion = "DELETE FROM inscripción "
                   + "WHERE idAlumno = 7 AND idMateria= 1 ";
           PreparedStatement psDesinscripcion = conexion.prepareStatement(sqlDesinscripcion);
           int deleteInscripcion = psDesinscripcion.executeUpdate();

           if (deleteInscripcion > 0) {
               JOptionPane.showMessageDialog(null, "Inscripción eliminada ");
           }

           
           
           
           
           
       } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null, "Error al cargar driver" + ex.getMessage());

       } catch (SQLException ex) {

            //imprime cola de errores ex.printStackTrace
           
             int error= ex.getErrorCode() ;
              if (error ==1062) {
                   JOptionPane.showMessageDialog(null, "Entrada duplicada");
                  
              if (error==0) {
                   JOptionPane.showMessageDialog(null, "error al ingresar a la base de datos, verifique la URL");
                
              }
              if (error==1049 ) {
                   JOptionPane.showMessageDialog(null, "Error al intentar ingresar a la base de datos, verifique el nombre de la base de datos");
             
              }
              if (error==1045) {
                   JOptionPane.showMessageDialog(null, "Acceso denegado, verifique la contraseña ");
               
              }
              if (error ==1146) {
                   JOptionPane.showMessageDialog(null, "Error al intentar conectarse a a tabla de la base de datos, verifique el nombre");

              }
              else {
                  JOptionPane.showMessageDialog(null, "error SQL");
                    ex.printStackTrace();
              }
            }
          
        } 
    }
}
