
package tablas;

import datos.Conector;
import java.awt.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author 
 * 
 * Saray lopez tobinson
 * Miler vargas Mola
 */

public class TablaAmortizacion extends JTable{

    private String nombres;
    private String apellidos;
    private String encargado;
    private String cc;
    private String numCuenta;
    private String direccion;
    private String NoEmpleado;


    DefaultTableModel modelo = new DefaultTableModel(){
@Override
public boolean isCellEditable(int row, int column){

return false;
}  
};

    int tiempo;
    double renta;
    DecimalFormat cortar = new DecimalFormat("####.##");

public TablaAmortizacion(String buscar,String tipo){

    var consulta = "SELECT * FROM";

    if("persona".equals(tipo)) {

        consulta += " persona WHERE numCuenta='" + buscar + "' AND tipoCuenta='Ahorro'";

    }

    if("organizacion".equals(tipo)){
        consulta +=  " organizacion WHERE numCuenta='" + buscar + "' AND tipoCuenta='Ahorro'";
    }

System.out.println(consulta);

try {

Conector objConect = new Conector();
Connection conec = objConect.getConexion();
PreparedStatement prepared = conec.prepareStatement(consulta);
ResultSet resul = prepared.executeQuery();

ResultSetMetaData can = resul.getMetaData();
var cantidad = can.getColumnCount();

if("persona".equals(tipo)){
    
    while(resul.next()) {
        nombres = resul.getString("nombre1") + " " + resul.getString("nombre2");
        setApellidos(resul.getString("apellido1") + " " + resul.getString("apellido2"));
        cc = "" + resul.getInt("cc");
        numCuenta = "" + resul.getInt("numCuenta");

        renta = resul.getInt("fondo");
        tiempo = resul.getInt("tiempo");

        modelo.addColumn("Mes");
        modelo.addColumn("Pago/Cuota");
        modelo.addColumn("Interes");
        modelo.addColumn("Capital");
        modelo.addColumn("Saldo final");

        this.setModel(modelo);

        int[] anchos = {50, 200, 200, 200, 200};

        for (int i = 0; i < 5; i++) {
            getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }
    }else if("organizacion".equals(tipo)){

        while(resul.next()){
            nombres = resul.getString("nombre");
            setDireccion(resul.getString("direccion"));
            setEncargado(resul.getString("nombreRepresentante"));
            setNoEmpleado(resul.getString("nombreNoEmpleado"));
            numCuenta = "" + resul.getInt("numCuenta");

            renta = resul.getInt("fondo");
            tiempo = resul.getInt("tiempo");

            modelo.addColumn("Mes");
            modelo.addColumn("Pago/Cuota");
            modelo.addColumn("Interes");
            modelo.addColumn("Capital");
            modelo.addColumn("Saldo final");

            this.setModel(modelo);

            int[] anchos = {50,200,200,200,200};

            for(int i = 0; i < 5; i++){
                getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
    }
}

if(tiempo > 0){

    int e = 0;
    double  anual = 0.05 / 12;
    double pagos1 = renta * anual / (1 - (Math.pow((1 + anual),-tiempo)));
    double cuotas = pagos1 - ( renta / tiempo);

    while(this.tiempo >= e ){

        Object[] filas = new Object[this.tiempo];

        double  interes = 0;
        double capital = 0;


        if( e != 0){
            interes = renta * anual;
            capital = pagos1 - interes;
            renta -= pagos1;
        }
        filas[0] = e;
        filas[1] = (e == 0)? 0 :cortar.format(pagos1);
        filas[2] = cortar.format(interes);
        filas[3] = cortar.format(capital);
        filas[4] = cortar.format((renta <= 0)? 0 : renta);

        e ++;
        modelo.addRow(filas);
    }



    for(int i = 0; i < 10; i++){

        Object[] filas = {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,};
        modelo.addRow(filas);
    }

    this.setBackground(new Color(27,38,49));
    this.setForeground(new Color(255,255,255));
    this.setGridColor(new Color(0,164,255));

}else{

    Icon icon = new ImageIcon(getClass().getResource("/iconMin/boton-error32.png"));
    JOptionPane.showMessageDialog(null,"La busqueda no tubo exito","ERROR!",JOptionPane.ERROR_MESSAGE,icon);

this.removeAll();
this.updateUI();

nombres = "";
cc = "";
numCuenta = "";
encargado = "";
direccion = "";
    NoEmpleado = "";
    apellidos = "";
}

} catch (SQLException ex) {

Logger.getLogger(TablaAmortizacion.class.getName()).log(Level.SEVERE, null, ex);
   
}       
}

public JTable amortizacion(){
return this;
}

    public String getNombres() {
        return nombres;
    }

    public String getCc() {
        return cc;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNoEmpleado() {
        return NoEmpleado;
    }

    public void setNoEmpleado(String noEmpleado) {
        NoEmpleado = noEmpleado;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

}
