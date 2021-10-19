
package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tablas.TablaAmortizacion;

/**
 *
 * @author 
 * Saray lopez tobinson
 * Miler vargas mola
 */
public class VentanaAmortizacion extends JPanel{
    
private JLabel etiTitular;
private JLabel etiCc,etiTitle;
private final JTextField campoBusqueda;
private final JPanel panel1;
private final JPanel panel2;
private final JButton btnBuscar;
private String tipo;
TablaAmortizacion buscar = null;

  public VentanaAmortizacion(){

this.setSize(670,400);
this.setLayout(null);
tipo = "persona";

panel1 = new JPanel();
panel1.setBackground(new Color(19,28,51));
panel1.setBounds(0,0,670,40);
panel1.setLayout(null);
    
etiTitle = new JLabel("Amortización");
etiTitle.setFont(new Font("Sansita",3,18));
etiTitle.setForeground(new Color(0,164,255));
etiTitle.setBounds(38,10,150,30);
panel1.add(etiTitle);

campoBusqueda = new JTextField(20);
campoBusqueda.setForeground(new Color(0,164,255));
campoBusqueda.setFont(new Font("Sansita",1,12));
campoBusqueda.setBounds(280,6,235,30);

btnBuscar = new JButton(new ImageIcon( getClass().getResource("/iconMin/buscar.png")));
btnBuscar.setBackground(new Color(19,28,51));
btnBuscar.setBorder(BorderFactory.createLineBorder(new Color(19,28,51)));
btnBuscar.setBounds(515,6,30,30);


panel2 = new JPanel();
panel2.setBackground(new Color(27,38,49));
panel2.setBounds(0,40,670,360);
panel2.setLayout(null);

   JButton org = new JButton(new ImageIcon(getClass().getResource("/iconMax/orgMax.png")));
   org.setBounds(100,120,128,128);
   org.setBackground(new Color(27,38,49));
   org.setBorder(BorderFactory.createLineBorder(new Color(27,38,49)));
   panel2.add(org);

   JLabel mensaje1 = new JLabel("Organización");
   mensaje1.setForeground(new Color(0,164,255));
   mensaje1.setFont(new Font("SansSerif",3,14));
   mensaje1.setBounds(120,260,120,30);
   panel2.add(mensaje1);

   JButton persona = new JButton(new ImageIcon(getClass().getResource("/iconMax/persona.png")));
   persona.setBounds(330,120,128,128);
   persona.setBackground(new Color(27,38,49));
   persona.setBorder(BorderFactory.createLineBorder(new Color(27,38,49)));
   panel2.add(persona);

   JLabel mensaje2 = new JLabel("Persona");
   mensaje2.setForeground(new Color(0,164,255));
   mensaje2.setFont(new Font("SansSerif",3,14));
   mensaje2.setBounds(335,260,120,30);
   panel2.add(mensaje2);
   System.out.println(tipo);
   org.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
     tipo = "organizacion";

     panel1.removeAll();
     panel1.repaint();
     panel1.add(campoBusqueda);
     panel1.add(btnBuscar);
     panel1.add(etiTitle);

     panel2.removeAll();
     panel2.repaint();
     System.out.println(tipo);
     JLabel etiImg = new JLabel(new ImageIcon(getClass().getResource("/iconMax/amortizacion.png")));
     etiImg.setBounds(187,40,260,260);
     panel2.add(etiImg);

    }
   });

   persona.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
     tipo = "persona";


     System.out.println(tipo);
     panel1.removeAll();
     panel1.repaint();
     panel1.add(campoBusqueda);
     panel1.add(btnBuscar);
     panel1.add(etiTitle);

     panel2.removeAll();
     panel2.repaint();

     JLabel etiImg = new JLabel(new ImageIcon(getClass().getResource("/iconMax/amortizacion.png")));
     etiImg.setBounds(187,40,260,260);
     panel2.add(etiImg);

    }
   });



//==========================================================
//                          Buscar                         |
//==========================================================

btnBuscar.addActionListener(new ActionListener(){
@Override
public void actionPerformed(ActionEvent evento){

String busqueda = campoBusqueda.getText(); 
campoBusqueda.setText("");
        
if(!"".equals(busqueda)) {

    if("persona".equals(tipo)){

    panel1.removeAll();
    panel1.repaint();

    panel2.removeAll();
    panel2.repaint();

    TablaAmortizacion datos = new TablaAmortizacion(busqueda, tipo);
    var titular = datos.getNombres() + " " + datos.getApellidos();
    var cc = "" + datos.getCc();
    var numCuenta = datos.getNumCuenta();

    etiTitular = new JLabel("Titular: " + titular);
    etiTitular.setBackground(new Color(27, 38, 49));
    etiTitular.setFont(new Font("SansSerif", Font.ITALIC, 14));
    etiTitular.setForeground(new Color(0, 164, 255));
    etiTitular.setBounds(0, 20, 320, 30);
    panel2.add(etiTitular);

    etiCc = new JLabel("N° CC: " + cc);
    etiCc.setBackground(new Color(27, 38, 49));
    etiCc.setFont(new Font("SansSerif", Font.ITALIC, 14));
    etiCc.setForeground(new Color(0, 164, 255));
    etiCc.setBounds(0, 60, 210, 30);
    panel2.add(etiCc);

    JLabel etiNumCuenta = new JLabel("N° Cuenta: " + numCuenta);
    etiNumCuenta.setBackground(new Color(27, 38, 49));
    etiNumCuenta.setFont(new Font("SansSerif", Font.ITALIC, 14));
    etiNumCuenta.setForeground(new Color(0, 164, 255));
    etiNumCuenta.setBounds(0, 100, 210, 30);
    panel2.add(etiNumCuenta);

    buscar = new TablaAmortizacion(busqueda, tipo);

    JScrollPane tablebusqueda = new JScrollPane(buscar.amortizacion());
    tablebusqueda.setBounds(0, 150, 660, 180);

    panel2.add(tablebusqueda);
    panel1.add(etiTitle);
    panel1.add(campoBusqueda);
    panel1.add(btnBuscar);

}else if("organizacion".equals(tipo)){

        panel1.removeAll();
        panel1.repaint();

        panel2.removeAll();
        panel2.repaint();

        TablaAmortizacion datos = new TablaAmortizacion(busqueda,tipo);
        var empresa = datos.getNombres();
        var direccion = "" + datos.getDireccion();
        var encargado = "" + datos.getEncargado();
        var noEmpleado = "" + datos.getNoEmpleado();
        var numCuenta = datos.getNumCuenta();

        etiTitular = new JLabel("Titular: " + empresa);
        etiTitular.setBackground(new Color(27,38,49));
        etiTitular.setFont(new Font("SansSerif",Font.ITALIC,14));
        etiTitular.setForeground(new Color(0,164,255));
        etiTitular.setBounds(0,10,320,30);
        panel2.add(etiTitular);

        etiCc= new JLabel("Dirección: " + direccion);
        etiCc.setBackground(new Color(27,38,49));
        etiCc.setFont(new Font("SansSerif",Font.ITALIC,14));
        etiCc.setForeground(new Color(0,164,255));
        etiCc.setBounds(0,40,210,30);
        panel2.add(etiCc);


        JLabel etiEnacardo = new JLabel("Encargado: " + encargado);
        etiEnacardo.setBackground(new Color(27,38,49));
        etiEnacardo.setFont(new Font("SansSerif",Font.ITALIC,14));
        etiEnacardo.setForeground(new Color(0,164,255));
        etiEnacardo.setBounds(0,70,310,30);
        panel2.add(etiEnacardo);

        JLabel etiNoEmpleado = new JLabel("No empleado: " + noEmpleado);
        etiNoEmpleado.setBackground(new Color(27,38,49));
        etiNoEmpleado.setFont(new Font("SansSerif",Font.ITALIC,14));
        etiNoEmpleado.setForeground(new Color(0,164,255));
        etiNoEmpleado.setBounds(0,100,310,30);
        panel2.add(etiNoEmpleado);


        JLabel  etiNumCuenta= new JLabel("N° Cuenta: " + numCuenta);
        etiNumCuenta.setBackground(new Color(27,38,49));
        etiNumCuenta.setFont(new Font("SansSerif",Font.ITALIC,14));
        etiNumCuenta.setForeground(new Color(0,164,255));
        etiNumCuenta.setBounds(0,120,210,30);
        panel2.add(etiNumCuenta);

        buscar = new TablaAmortizacion(busqueda,tipo);

        JScrollPane tablebusqueda = new JScrollPane(buscar.amortizacion());
        tablebusqueda.setBounds(0,150,660,180);

        panel2.add(tablebusqueda);
        panel1.add(etiTitle);
        panel1.add(campoBusqueda);
        panel1.add(btnBuscar);

}
}
}
});

this.add(panel1);
this.add(panel2);
this.setBackground(new Color(27,38,49));
this.setVisible(true);
}

public JPanel getAmortizacion(){
    setLocation(0,0);
    return this;
}
  
}
