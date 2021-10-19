package baseDatos;

import metodo.RoundedBorder;
import tablas.TablaOrganizacion;
import tablas.TablaPersonas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
	*
	* @author
	* Saray Lopez tobinson
	* Miler Vargas Mola
	*/

public class DatosOrganizacion extends JPanel {

	private JTextField campoBuscar;

	public DatosOrganizacion(){
		this.setLayout(null);
		this.setBackground(new Color(27,38,49));
		iniciar();
	}

	public void iniciar(){

		ImageIcon imgePersona = new ImageIcon(getClass().getResource("/iconMax/persona.png"));
		JButton persona = new JButton(imgePersona);

//if(isSelected()){

		var  consulta = "SELECT * FROM organizacion";
		TablaOrganizacion tOrganizacion= new TablaOrganizacion(consulta);

		JPanel cabecera = new JPanel();
		cabecera.setBackground(new Color(27,38,49));
		cabecera.setLayout(null);


		JScrollPane tabla = new JScrollPane();
		tabla.setViewportView(tOrganizacion.verRegistroPersonas());
		tabla.setBounds(0,40,1097,330);
		tabla.setBackground(new Color(27,38,49));
		tabla.setBorder(BorderFactory.createLineBorder(new Color(27,38,49)));

		JButton btnBuscar = new JButton(new ImageIcon(getClass().getResource("/iconMin/buscar.png")));
		btnBuscar.setBackground(new Color(27,38,49));
		btnBuscar.setBorder(new RoundedBorder(15));
		btnBuscar.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
		btnBuscar.setBounds(640,5,30,30);

		campoBuscar = new JTextField(20);
		campoBuscar.setBounds(340,5,300,30);

		JButton btnRefres = new JButton(new ImageIcon( getClass().getResource("/iconMin/refrescar.png")));
		btnRefres.setBackground(new Color(27,38,49));
		btnRefres.setBorder(BorderFactory.createLineBorder(new Color(27,38,49)));
		btnRefres.setBounds(680,5,30,30);

		JPanel PanelTable = new JPanel();
		PanelTable.setBounds(0,0,1100,40);
		PanelTable.setBackground(new Color(27,38,49));
		PanelTable.setLayout(null);
		PanelTable.add(btnBuscar);
		PanelTable.add(campoBuscar);
		PanelTable.add(btnRefres);

		this.setBounds(160,0,1200,400);
		this.add(PanelTable);
		this.add(tabla);
		setSize(1200,400);

//===================================================
//                Accion de Buscar                  |
//===================================================

		btnBuscar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evt){


				String busqueda = campoBuscar.getText();
				campoBuscar.setText("");

				String where = "SELECT * FROM organizacion WHERE numCuenta='" + busqueda +"' ";
				where += "OR cc='" + busqueda + "'";
				where += "OR codigoOficina='" + busqueda + "'";
				where += "OR codigo='" + busqueda + "'";
				where += "OR fondo='" + busqueda + "'";

				if(!"".equals(busqueda)){

					TablaOrganizacion buscar = new TablaOrganizacion(where);

					removeAll();
					updateUI();

					setSize(1200,400);

					JScrollPane tablebusqueda = new JScrollPane(buscar.verRegistroPersonas());
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

				setBounds(0,0,1200,400);
				add(PanelTable);
				add(tabla);

			}
		});


	}

	public JPanel getDatosOrganizacion(){

		setLocation(0,0);
		return this;
	}

}
