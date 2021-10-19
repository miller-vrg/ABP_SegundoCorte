
package datos;

import java.sql.*;

/**
 *
 * @authores
 * saray lopez tobinson
 * Miler vargas mola
 * 
 */

public class Conector {
   
private static String url = "jdbc:mariadb://localhost:3306/test?";
private static String user = "anonimous";
private static String password = "";
    

public static Connection getConexion() throws SQLException{
    
return DriverManager.getConnection(url+user+password);

}

public static void close(ResultSet argumento) throws SQLException{

try{ 
    argumento.close();
 }catch(SQLException ex){
    ex.printStackTrace(System.out);
}
}

public static void close(Statement argumento) throws SQLException{
    
try{
    argumento.close();
 }catch(SQLException ex){
    ex.printStackTrace(System.out);
}
}


}
