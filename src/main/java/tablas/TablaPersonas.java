
package tablas;

import datos.Conector;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author 
 * Saray Lopez tobinson
 * Miler Vargas Mola
 */

public class TablaPersonas extends JTable{
     
DefaultTableModel modelo = new DefaultTableModel(){
 @Override
 public boolean isCellEditable(int row, int column){

 return false;
 }
 
 };

    public TablaPersonas() {
       
    }
    
public TablaPersonas(String consulta){
  
 PreparedStatement prepared = null; 
 ResultSet resul = null;
 
 Conector conet = new Conector();
 Connection conec  = null;
 
try {
    

conec = conet.getConexion();
 
 prepared = conec.prepareStatement(consulta);
 resul = prepared.executeQuery();
 
 ResultSetMetaData resultData = resul.getMetaData();
 var cantidad = resultData.getColumnCount();

 modelo.addColumn("N° Cuenta");
 modelo.addColumn("Nombre1");
 modelo.addColumn("Nombre2");
 modelo.addColumn("Apellido1");
 modelo.addColumn("Apellido2");
 modelo.addColumn("CC");
 modelo.addColumn("Dirección");
 modelo.addColumn("Nacimiento");
 modelo.addColumn("Sexo");
 modelo.addColumn("Tipo cuenta");
 modelo.addColumn("codigo oficina");
 modelo.addColumn("Codigo");
 modelo.addColumn("Fondo");
 this.setModel(modelo);
   
int[] anchos = {90,100,100,100,100,120,120,100,100,100,120,70,100};

for(int x = 0; x < 13; x++){
    
getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);

}

 while(resul.next()){
 
 Object[] filas = new Object[cantidad];
     
 for(int i = 0; i < cantidad; i++){
 
 filas[i] = resul.getObject( i + 1);
     
 }

modelo.addRow(filas);
this.setBackground(new Color(27,38,49));
this.setForeground(Color.white);
this.setGridColor(new Color(0,164,255));

 }

 for(int i = 0; i < 30; i++){

  Object[] filas = {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,};
  modelo.addRow(filas);
 }

    } catch (SQLException ex) {
    System.err.println(ex.toString());
    }
}

public void modelo(Object[] fila){

this.modelo.addRow(fila);
}

public JTable verRegistroPersonas(){
   
    return this;
}
  
}
