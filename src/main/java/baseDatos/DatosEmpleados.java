package baseDatos;

import metodo.RoundedBorder;
import tablas.TablaEmpleadoConCuenta;
import tablas.TablaEmpleados;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
	*
	* @author
	* Saray Lopez tobinson
	* Miler Vargas Mola
 	*
	*/

public class DatosEmpleados extends JPanel {

	private JTextField campoBuscar;

	public DatosEmpleados(){
		this.setLayout(null);
		this.setBackground(new Color(27,38,49));
		iniciar();
	}

	public void iniciar(){

		ImageIcon imgePersona = new ImageIcon(getClass().getResource("/iconMax/persona.png"));
		JButton persona = new JButton(imgePersona);

//if(isSelected()){

		var  consulta = "SELECT * FROM empleados";
		TablaEmpleados tEmpleados= new TablaEmpleados(consulta);

		JPanel cabecera = new JPanel();
		cabecera.setBackground(new Color(27,38,49));
		cabecera.setLayout(null);


		JScrollPane tabla = new JScrollPane();
		tabla.setViewportView(tEmpleados.verRegistroEmpleados());
		tabla.setBounds(0,40,640,330);
		tabla.setBackground(new Color(27,38,49));
		tabla.setBorder(BorderFactory.createLineBorder(new Color(27,38,49)));

		JButton btnBuscar = new JButton(new ImageIcon(getClass().getResource("/iconMin/buscar.png")));
		btnBuscar.setBackground(new Color(27,38,49));
		btnBuscar.setBorder(new RoundedBorder(15));
		btnBuscar.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
		btnBuscar.setBounds(380,5,30,30);

		campoBuscar = new JTextField(20);
		campoBuscar.setBounds(80,5,300,30);

		JButton btnRefres = new JButton(new ImageIcon( getClass().getResource("/iconMin/refrescar.png")));
		btnRefres.setBackground(new Color(27,38,49));
		btnRefres.setBorder(BorderFactory.createLineBorder(new Color(27,38,49)));
		btnRefres.setBounds(420,5,30,30);

		JButton btnConCuenta = new JButton("Ver con cuenta");
		btnConCuenta.setForeground(new Color(0,164,255));
		btnConCuenta.setBackground(new Color(27,38,49));
		btnConCuenta.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
		btnConCuenta.setBorder( new RoundedBorder(15));
		btnConCuenta.setBounds(470,5,140,30);

		JPanel PanelTable = new JPanel();
		PanelTable.setBounds(0,0,1100,40);
		PanelTable.setBackground(new Color(27,38,49));
		PanelTable.setLayout(null);

		PanelTable.add(btnConCuenta);
		PanelTable.add(campoBuscar);
		PanelTable.add(btnBuscar);
		PanelTable.add(btnRefres);

		this.setBounds(160,0,1200,400);
		this.add(PanelTable);
		this.add(tabla);
		setSize(1200,400);

//===================================================
//                Accion de Con cuenta              |
//===================================================

		btnConCuenta.addActionListener( new ActionListener(){
			@Override

				public void actionPerformed(ActionEvent evt){

				final String consulta = " SELECT e.cuenta ,e.codigo ,e.nombre1,e.nombre2,e.apellido1,e.apellido2,e.cc\n" +
						"FROM   empleados e ,persona p ,organizacion o \n" +
						"WHERE e.cc = o.ccRepre OR e.cc = p.cc \n" +
						"GROUP BY e.cc ORDER BY e.cuenta;";

				removeAll();
				updateUI();

				setSize(1200,400);

				TablaEmpleadoConCuenta tConCuenta = new TablaEmpleadoConCuenta( consulta );

				tabla.setViewportView(tConCuenta.verEmpleadoConCuenta());

				setBounds(0,0,1200,400);
				add(PanelTable);
				add(tabla);

			};
		});

//===================================================
//                Accion de Buscar                  |
//===================================================

		btnBuscar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evt){


				String busqueda = campoBuscar.getText();
				campoBuscar.setText("");

				String where = "SELECT * FROM empleados WHERE  cc='" + busqueda + "'";
				where += "OR codigo='" + busqueda + "'";

				if(!"".equals(busqueda)){

					TablaEmpleados buscar = new TablaEmpleados(where);

					removeAll();
					updateUI();

					setSize(1200,400);

					JScrollPane tablebusqueda = new JScrollPane(buscar.verRegistroEmpleados());
					tablebusqueda.setBounds(0,40,1100,360);

					setBounds(0,0,1200,400);
					add(PanelTable);
					add(tablebusqueda);

				}
			}
		});

//===================================================
//                Boton editar
//===================================================

		btnRefres.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evt){

				tabla.setViewportView(tEmpleados.verRegistroEmpleados());

				setBounds(0,0,1200,400);
				add(PanelTable);
				add(tabla);

			}
		});


	}

	public JPanel getDatosEmpleados(){

		setLocation(0,0);
		return this;
	}

}
