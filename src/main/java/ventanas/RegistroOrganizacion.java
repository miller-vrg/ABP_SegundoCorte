
package ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import datos.Conector;
import metodo.RoundedBorder;
import tablas.TablaOrganizacion;
import tablas.TablaPersonas;

/**
	*
	* @author
	* Saray lopez tobinson
	* Miler vargas Mola
	*/

public class RegistroOrganizacion extends JPanel {

	private JLabel encabezado;
	private JLabel nombre1;
	private JTextField campoNombreEmpresa;
	private JLabel direccion;
	private JTextField campoDireccion;
	private JLabel tipo;
	private JComboBox tipoCuenta,tipoOrganizacion;
	private JLabel representate;
	private JLabel nombre2;
	private JTextField campoPrimerNombreRepre;
	private JTextField campoSegundoNombreRepre;
	private JLabel segundoNombreRepre;
	private JLabel primerApellidoRepre;
	private JTextField campoSegundoApelliRepre;
	private JTextField campoPrimerApelliRepre;
	private JLabel segundoApellidoRepre;
	private JLabel ccRepre;
	private JTextField campoCcRepre;
	private JLabel noEmpleado;
	private JLabel nombre3;
	private JTextField campoPrimerNombreNoEmple;
	private JLabel segundoNombreNoEmple;
	private JTextField campoSegundoNombreNoEmple;
	private JTextField campoCcNoEmple;
	private JLabel ccNoEmple;
	private JTextField campoSegundoApelliNoEmple;
	private JLabel segundoApellidoNoEmple;
	private JTextField campoPrimerApelliNoEmple;
	private JTextField campoCodigoOficina;
	private JLabel primerApellidoNoEmple;
	private int numCuenta,tiempo;
	private double fondo;

	public RegistroOrganizacion(){
		fondo = 0;
		tiempo = 0;
		this.setBackground(new Color(27,38,49));
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(27,38,49));
		this.setSize(520,310);


	}

	public JPanel iniciaRegistroOrganizacion(int dia, int mes, int year,JButton btnSiguiente, JButton btnCancelar, JProgressBar progreso, int aumento) {

		try{

			this.removeAll();
			this.updateUI();

			setLayout(new GridBagLayout());
			GridBagConstraints constraints = new GridBagConstraints();

			encabezado = new JLabel("Organización");
			encabezado.setHorizontalAlignment(JLabel.CENTER);
			encabezado.setFont(new Font("SansSerif",3,12));
			encabezado.setForeground(new Color(0,164,255));
			encabezado.setSize(400,10);
			encabezado.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
			encabezado.setBorder(new RoundedBorder(10));

			constraints.gridx = 0;
			constraints.gridy = 0;
			constraints.gridwidth = 3;
			constraints.gridheight = 1;
			constraints.weightx = 1.0;
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.anchor = GridBagConstraints.CENTER;
			constraints.insets = new Insets(10,10,20,30);
			this.add(encabezado,constraints);
			constraints.insets = new Insets(10,10,10,30);

			nombre1 = new JLabel("nombre: ");
			nombre1.setFont(new Font("SansSerif",3,12));
			nombre1.setForeground(new Color(0,164,255));

			constraints.gridx = 0;
			constraints.gridy = 1;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			constraints.fill = GridBagConstraints.NONE;
			constraints.anchor = GridBagConstraints.WEST;
			this.add(nombre1,constraints);

			campoNombreEmpresa = new JTextField(20);
			campoNombreEmpresa.setFont(new Font("SansSerif",3,12));
			campoNombreEmpresa.setToolTipText("Nombre de la empresa");
			campoNombreEmpresa.setSize(150,30);

			constraints.gridx = 1;
			constraints.gridy = 1;
			constraints.gridwidth = 2;
			constraints.gridheight = 1;
			constraints.weightx = 1.0;
			this.add(campoNombreEmpresa,constraints);
			constraints.weightx = 0.0;

			direccion = new JLabel("Direccion: ");
			direccion.setFont(new Font("SansSerif",3,12));
			direccion.setForeground(new Color(0,164,255));

			constraints.gridx = 0;
			constraints.gridy = 2;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			this.add(direccion,constraints);

			campoDireccion = new JTextField("",20);
			campoDireccion.setFont(new Font("SansSerif",3,12));
			campoDireccion.setToolTipText("Direccion");
			campoDireccion.setSize(150,30);

			constraints.gridx = 1;
			constraints.gridy = 2;
			constraints.gridwidth = 2;
			constraints.gridheight = 1;
			constraints.weightx = 1.0;
			this.add(campoDireccion,constraints);
			constraints.weightx = 0.0;

			JLabel etiCodigoOfi = new JLabel("Codigo Oficina: ");
			etiCodigoOfi.setFont(new Font("SansSerif",3,12));
			etiCodigoOfi.setForeground(new Color(0,164,255));

			constraints.gridx = 0;
			constraints.gridy = 3;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			this.add(etiCodigoOfi,constraints);

			campoCodigoOficina = new JTextField("",20);
			campoCodigoOficina.setFont(new Font("SansSerif",3,12));
			campoCodigoOficina.setToolTipText("Direccion");
			campoCodigoOficina.setSize(150,30);

			constraints.gridx = 1;
			constraints.gridy = 3;
			constraints.gridwidth = 2;
			constraints.gridheight = 1;
			constraints.weightx = 1.0;
			this.add(campoCodigoOficina,constraints);
			constraints.weightx = 0.0;

			tipo = new JLabel("Tipo de organización: ");
			tipo.setFont(new Font("SansSerif",3,12));
			tipo.setForeground(new Color(0,164,255));

			constraints.gridx = 0;
			constraints.gridy = 4;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			this.add(tipo,constraints);

			DefaultComboBoxModel modelo = new DefaultComboBoxModel();
			modelo.addElement("Publica");
			modelo.addElement("Privada");

			tipoOrganizacion = new JComboBox(modelo);
			tipoOrganizacion.setFont(new Font("SandsSerif",3,12));
			tipoOrganizacion.setForeground(new Color(0,164,255));
			tipoOrganizacion.setBackground(new Color(27,38,49));
			tipoOrganizacion.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));

			constraints.gridx = 1;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			this.add(tipoOrganizacion,constraints);

			tipo = new JLabel("Tipo de cuenta: ");
			tipo.setFont(new Font("SansSerif",3,12));
			tipo.setForeground(new Color(0,164,255));

			constraints.gridx = 0;
			constraints.gridy = 5;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			this.add(tipo,constraints);

			DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
			modelo1.addElement("Cliente");
			modelo1.addElement("Corriente");
			modelo1.addElement("Ahorro");

			tipoCuenta = new JComboBox(modelo1);
			tipoCuenta.setFont(new Font("SandsSerif",3,12));
			tipoCuenta.setForeground(new Color(0,164,255));
			tipoCuenta.setBackground(new Color(27,38,49));
			tipoCuenta.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));

			constraints.gridx = 1;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			this.add(tipoCuenta,constraints);

//============================================================
//                     Representante
//============================================================

			representate = new JLabel("Representante");
			representate.setHorizontalAlignment(JLabel.CENTER);
			representate.setFont(new Font("SansSerif",3,12));
			representate.setForeground(new Color(0,164,255));
			representate.setSize(400,10);
			representate.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
			representate.setBorder(new RoundedBorder(10));

			constraints.gridx = 0;
			constraints.gridy = 6;
			constraints.gridwidth = 3;
			constraints.gridheight = 1;
			constraints.weightx = 1.0;
			constraints.insets = new Insets(10,10,20,30);
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.anchor = GridBagConstraints.CENTER;
			this.add(representate,constraints);
			constraints.insets = new Insets(10,10,10,30);
			constraints.weightx = 0.0;

			nombre2 = new JLabel("Primer nombre");
			nombre2.setForeground(new Color(0,164,255));
			nombre2.setFont(new Font("SansSerif",3,12));

			constraints.gridx = 0;
			constraints.gridy = 7;
			constraints.gridwidth = 3;
			constraints.gridheight = 1;
			constraints.fill = GridBagConstraints.VERTICAL;
			constraints.anchor = GridBagConstraints.WEST;
			this.add(nombre2,constraints);


			campoPrimerNombreRepre = new JTextField("",20);
			campoPrimerNombreRepre.setFont(new Font("SansSerif",3,12));
			campoPrimerNombreRepre.setForeground(new Color(0,164,255));

			constraints.gridx = 1;
			constraints.gridwidth = 2;
			constraints.gridheight = 1;
			this.add(campoPrimerNombreRepre,constraints);

			segundoNombreRepre = new JLabel("Segundo nombre: ");
			segundoNombreRepre.setFont(new Font("SansSerif",3,12));
			segundoNombreRepre.setForeground(new Color(0,164,255));

			constraints.gridx = 0;
			constraints.gridy = 8;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			this.add(segundoNombreRepre,constraints);

			campoSegundoNombreRepre = new JTextField("",20);
			campoSegundoNombreRepre.setFont(new Font("SansSerif",3,12));

			constraints.gridx = 1;
			constraints.gridwidth = 2;
			constraints.gridheight = 1;
			constraints.weightx = 1.0;
			this.add(campoSegundoNombreRepre,constraints);
			constraints.weightx = 0.0;

			primerApellidoRepre = new JLabel("Primer apellido: ");
			primerApellidoRepre.setFont(new Font("SansSerif",3,12));
			primerApellidoRepre.setForeground(new Color(0,164,255));

			constraints.gridx = 0;
			constraints.gridy = 9;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			this.add(primerApellidoRepre,constraints);

			campoPrimerApelliRepre = new JTextField("",20);
			campoPrimerApelliRepre.setFont(new Font("SansSerif",3,12));

			constraints.gridx = 1;
			constraints.gridwidth = 2;
			constraints.gridheight = 1;
			constraints.weightx = 1.0;
			this.add(campoPrimerApelliRepre,constraints);
			constraints.weightx = 0.0;

			segundoApellidoRepre = new JLabel("Segundo apellido: ");
			segundoApellidoRepre.setFont(new Font("SansSerif",3,12));
			segundoApellidoRepre.setForeground(new Color(0,164,255));

			constraints.gridx = 0;
			constraints.gridy = 10;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			this.add(segundoApellidoRepre,constraints);

			campoSegundoApelliRepre = new JTextField("",20);
			campoSegundoApelliRepre.setFont(new Font("SansSerif",3,12));

			constraints.gridx = 1;
			constraints.gridwidth = 2;
			constraints.gridheight = 1;
			constraints.weightx = 1.0;
			this.add(campoSegundoApelliRepre,constraints);
			constraints.weightx = 0.0;

			ccRepre = new JLabel("N° CC: ");
			ccRepre.setFont(new Font("SansSerif",3,12));
			ccRepre.setForeground(new Color(0,164,255));

			constraints.gridx = 0;
			constraints.gridy = 11;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			this.add(ccRepre,constraints);

			campoCcRepre= new JTextField("",20);
			campoCcRepre.setFont(new Font("SansSerif",3,12));

			constraints.gridx = 1;
			constraints.gridwidth = 2;
			constraints.gridheight = 1;
			constraints.weightx = 1.0;
			this.add(campoCcRepre,constraints);
			constraints.weightx = 0.0;

//============================================================
//                      No empleado 
//============================================================

			noEmpleado = new JLabel("No empleado");
			noEmpleado.setHorizontalAlignment(JLabel.CENTER);
			noEmpleado.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
			noEmpleado.setFont(new Font("SansSerif",3,12));
			noEmpleado.setForeground(new Color(0,164,255));
			representate.setSize(400,10);
			noEmpleado.setBorder(new RoundedBorder(10));

			constraints.gridx = 0;
			constraints.gridy = 12;
			constraints.gridwidth = 3;
			constraints.gridheight = 1;
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.anchor = GridBagConstraints.CENTER;
			constraints.weightx = 1.0;
			constraints.insets = new Insets(10,10,20,30);
			this.add(noEmpleado,constraints);
			constraints.weightx = 0.0;
			constraints.insets = new Insets(10,10,10,30);
			constraints.fill = GridBagConstraints.NONE;

			nombre3 = new JLabel("Primer nombre");
			nombre3.setForeground(new Color(0,164,255));
			nombre3.setFont(new Font("SansSerif",3,12));

			constraints.gridx = 0;
			constraints.gridy = 13;
			constraints.gridwidth = 2;
			constraints.gridheight = 1;
			constraints.anchor = GridBagConstraints.WEST;
			this.add(nombre3,constraints);


			campoPrimerNombreNoEmple = new JTextField("",20);
			campoPrimerNombreNoEmple.setFont(new Font("SansSerif",3,12));
			campoPrimerNombreNoEmple.setForeground(new Color(0,164,255));

			constraints.gridx = 1;
			constraints.gridwidth = 2;
			constraints.gridheight = 1;
			this.add(campoPrimerNombreNoEmple,constraints);

			segundoNombreNoEmple = new JLabel("Segundo nombre: ");
			segundoNombreNoEmple.setFont(new Font("SansSerif",3,12));
			segundoNombreNoEmple.setForeground(new Color(0,164,255));

			constraints.gridx = 0;
			constraints.gridy = 14;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			this.add(segundoNombreNoEmple,constraints);

			campoSegundoNombreNoEmple = new JTextField("",20);
			campoSegundoNombreNoEmple.setFont(new Font("SansSerif",3,12));

			constraints.gridx = 1;
			constraints.gridwidth = 2;
			constraints.gridheight = 1;
			constraints.weightx = 1.0;
			this.add(campoSegundoNombreNoEmple,constraints);
			constraints.weightx = 0.0;

			primerApellidoNoEmple  = new JLabel("Primer apellido: ");
			primerApellidoNoEmple.setFont(new Font("SansSerif",3,12));
			primerApellidoNoEmple.setForeground(new Color(0,164,255));

			constraints.gridx = 0;
			constraints.gridy = 15;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			this.add(primerApellidoNoEmple,constraints);

			campoPrimerApelliNoEmple  = new JTextField("",20);
			campoPrimerApelliNoEmple.setFont(new Font("SansSerif",3,12));

			constraints.gridx = 1;
			constraints.gridwidth = 2;
			constraints.gridheight = 1;
			constraints.weightx = 1.0;
			this.add(campoPrimerApelliNoEmple,constraints);
			constraints.weightx = 0.0;

			segundoApellidoNoEmple  = new JLabel("Segundo apellido: ");
			segundoApellidoNoEmple.setFont(new Font("SansSerif",3,12));
			segundoApellidoNoEmple.setForeground(new Color(0,164,255));

			constraints.gridx = 0;
			constraints.gridy = 16;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			this.add(segundoApellidoNoEmple,constraints);

			campoSegundoApelliNoEmple  = new JTextField("",20);
			campoSegundoApelliNoEmple.setFont(new Font("SansSerif",3,12));

			constraints.gridx = 1;
			constraints.gridwidth = 2;
			constraints.gridheight = 1;
			constraints.weightx = 1.0;
			this.add(campoSegundoApelliNoEmple,constraints);
			constraints.weightx = 0.0;

			ccNoEmple  = new JLabel("N° CC: ");
			ccNoEmple.setFont(new Font("SansSerif",3,12));
			ccNoEmple.setForeground(new Color(0,164,255));

			constraints.gridx = 0;
			constraints.gridy = 17;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			this.add(ccNoEmple,constraints);

			campoCcNoEmple = new JTextField("",20);
			campoCcNoEmple.setFont(new Font("SansSerif",3,12));

			constraints.gridx = 1;
			constraints.gridwidth = 2;
			constraints.gridheight = 1;
			constraints.weightx = 1.0;
			this.add(campoCcNoEmple,constraints);
			constraints.weightx = 0.0;

			JButton bntFondo = new JButton("Fondo");
			bntFondo.setFont(new Font("SandsSerif",3,12));
			bntFondo.setForeground(new Color(0,164,255));
			bntFondo.setBackground(new Color(0,0,33));
			bntFondo.setSize(120,30);
			bntFondo.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));

			constraints.gridx = 0;
			constraints.gridy = 18;
			constraints.gridwidth = 2;
			constraints.gridheight = 1;
			constraints.fill = GridBagConstraints.HORIZONTAL;
			this.add(bntFondo,constraints);

			bntFondo.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent evt){

					guardar();

				}
			});

		} catch (NumberFormatException ex) {

			JLabel error = new JLabel(new ImageIcon("/run/media/gasler/Nuevo vol/abpSarayLopezMIlerCargasGrupo4/img/iconMax/error.png"));
			error.setBounds(200,20,200,200);

			JLabel mensajeError = new JLabel("Error inesperado!");
			mensajeError.setHorizontalAlignment(JLabel.CENTER);
			mensajeError.setFont(new Font("SansSerif", 3, 14));
			mensajeError.setForeground(new Color(224, 8, 10));
			mensajeError.setBounds(130, 250, 200, 40);

			limpiar();
			removeAll();
			updateUI();
			setLayout(null);

			add(error);
			add(mensajeError);
		}
		return this;
	}

//==============================================================
	//                  Guardar
//==============================================================

	public void guardar() {

		if (!(
			"".equals(campoNombreEmpresa.getText())  &&
				"".equals(campoDireccion.getText())  &&
				"".equals(campoPrimerNombreRepre.getText())  &&
				"".equals(campoSegundoNombreRepre.getText())  &&
				"".equals(campoSegundoApelliRepre.getText())  &&
				"".equals(campoPrimerApelliRepre.getText()) &&
				"".equals(campoCcRepre.getText()) &&
				"".equals(campoPrimerNombreNoEmple.getText())  &&
				"".equals(campoSegundoNombreNoEmple.getText())  &&
				"".equals(campoSegundoApelliNoEmple.getText())  &&
				"".equals(campoPrimerApelliNoEmple.getText())  &&
				"".equals(campoCcNoEmple.getText())  &&
				"".equals(campoCodigoOficina.getText()))){

			PreparedStatement prepared = null;
			Conector objtConec = new Conector();
			Connection conexion = null;

			JTextField fon = null;
			boolean entrada = false;

			try {

				conexion = objtConec.getConexion();

				numCuenta = crearNumCuenta();

				var tipoCuentaTxt = tipoCuenta.getSelectedItem().toString();
				var tipoOrganizacionTxt = tipoOrganizacion.getSelectedItem().toString();
				var ccRepre = Integer.parseInt(campoCcRepre.getText());
				var ccNoEmple = Integer.parseInt(campoCcNoEmple.getText());
				var codigoOficina = Integer.parseInt(campoCodigoOficina.getText());
				var repreName = campoPrimerNombreRepre.getText() + " " + campoSegundoNombreRepre.getText();
				var noEmplea = campoPrimerNombreNoEmple.getText() + " " + campoSegundoNombreNoEmple.getText();

				System.out.println(tipoCuentaTxt);

				if ("Ahorro".equals(tipoCuentaTxt)) {

					JFrame venAhorro = new JFrame("Cuenta Ahorro");
					venAhorro.setSize(500, 250);
					venAhorro.getContentPane().setLayout(null);
					venAhorro.getContentPane().setBackground(new Color(27, 38, 49));

					JLabel titulo = new JLabel("Amortización", JLabel.CENTER);
					titulo.setForeground(new Color(0, 164, 255));
					titulo.setFont(new Font("Sansita", 3, 18));

					JPanel panel = new JPanel(new FlowLayout());
					panel.setBackground(new Color(19, 28, 51));
					panel.setBounds(0, 0, 501, 40);
					panel.add(titulo);

					JLabel renta = new JLabel("Renta: ");
					renta.setForeground(new Color(0, 164, 255));
					renta.setFont(new Font("Sansita", 1, 12));
					renta.setBounds(47, 50, 120, 30);

					JTextField txtFon = new JTextField("",20);
					txtFon.setBounds(140, 50, 200, 30);

					JLabel interes = new JLabel("Interes:            5% Anual");
					interes.setForeground(new Color(0, 164, 255));
					interes.setFont(new Font("Sansita", 1, 12));
					interes.setBounds(47, 110, 200, 30);

					JLabel cuotas = new JLabel("Cuotas: ");
					cuotas.setForeground(new Color(0, 164, 255));
					cuotas.setFont(new Font("Sansita", 1, 12));
					cuotas.setBounds(47, 160, 120, 30);

					JTextField txtCuotas = new JTextField("",20);
					txtCuotas.setBounds(140, 160, 200, 30);

					JLabel conte = new JLabel(new ImageIcon(getClass().getResource("/iconMax/ahorros.png")));
					conte.setBounds(360, 40, 128, 128);

					JButton btnGuardar = new JButton("Guardar");
					btnGuardar.setForeground(new Color(0, 164, 255));
					btnGuardar.setBorder(BorderFactory.createLineBorder(new Color(0, 164, 255)));
					btnGuardar.setBorder(new RoundedBorder(15));
					btnGuardar.setBackground(new Color(27, 38, 49));
					btnGuardar.setBounds(360, 176, 120, 20);

					venAhorro.getContentPane().add(panel);
					venAhorro.getContentPane().add(renta);
					venAhorro.getContentPane().add(txtFon);
					venAhorro.getContentPane().add(interes);
					venAhorro.getContentPane().add(txtCuotas);
					venAhorro.getContentPane().add(cuotas);
					venAhorro.getContentPane().add(conte);
					venAhorro.getContentPane().add(btnGuardar);

					venAhorro.setResizable(false);
					venAhorro.setLocationRelativeTo(null);
					venAhorro.setVisible(true);

					btnGuardar.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {


							try {

								numCuenta = crearNumCuenta();
								tiempo = Integer.parseInt(txtCuotas.getText());
								fondo = Double.parseDouble(txtFon.getText());

								txtFon.setText("");
								txtCuotas.setText("");

								PreparedStatement prepared = null;
								Conector objtConec = new Conector();
								Connection conexion = null;

								try {

									if (!( fondo == 0 && tiempo == 0)) {
										venAhorro.setVisible(false);
										conexion = objtConec.getConexion();
										prepared = conexion.prepareStatement("INSERT INTO organizacion " +
											"(numCuenta," + //1
											"nombre," + //2
											"direccion," + //3
											"tipo," + //4
											"tipoCuenta," + //5
											"codigoOficina," + //6
											"codigo," + //7
											"fondo," + //8
											"tiempo," + //9
											"nombreRepresentate," + //10
											"apellido1Representate," + //11
											"apellido2Representate," + //12
											"ccRepre," + //13
											"nombreNoEmpleado," + //14
											"apellido1NoEmpleado," + //15
											"apellido2NoEmpleado," + //16
											"ccNoEmple) " //17
											+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

										prepared.setInt(1, numCuenta);
										prepared.setString(2, campoNombreEmpresa.getText());
										prepared.setString(3, campoDireccion.getText());
										prepared.setString(4, tipoOrganizacionTxt);
										prepared.setString(5, tipoCuentaTxt);
										prepared.setInt(6, codigoOficina);
										prepared.setInt(7, codigoSeguridad());
										prepared.setDouble(8, fondo);
										prepared.setInt(9, tiempo);
										prepared.setString(10, repreName);
										prepared.setString(11, campoPrimerApelliRepre.getText());
										prepared.setString(12, campoSegundoApelliRepre.getText());
										prepared.setInt(13, ccRepre);
										prepared.setString(14, noEmplea);
										prepared.setString(15, campoPrimerApelliNoEmple.getText());
										prepared.setString(16, campoSegundoApelliNoEmple.getText());
										prepared.setInt(17, ccNoEmple);

										prepared.executeUpdate();

										Object[] fila = new Object[17];

										fila[0] = numCuenta;
										fila[1] = campoNombreEmpresa.getText();
										fila[2] = campoDireccion.getText();
										fila[3] = tipoOrganizacionTxt;
										fila[4] = tipoCuentaTxt;
										fila[5] = codigoOficina;
										fila[6] = codigoSeguridad();
										fila[7] = fondo;
										fila[8] = tiempo;
										fila[9] = repreName;
										fila[10] = campoPrimerApelliRepre.getText();
										fila[11] = campoSegundoApelliRepre.getText();
										fila[12] = ccRepre;
										fila[13] = noEmplea;
										fila[14] = campoPrimerApelliNoEmple.getText();
										fila[15] = campoSegundoApelliNoEmple.getText();
										fila[16] = ccNoEmple;


										TablaOrganizacion agregar = new TablaOrganizacion();
										agregar.modelo(fila);
										limpiar();

									} else {
										JLabel error = new JLabel(new ImageIcon("/iconMax/error.png"));
										error.setBounds(200, 20, 200, 200);

										JLabel mensajeError = new JLabel("Error Campos vacios!");
										mensajeError.setHorizontalAlignment(JLabel.CENTER);
										mensajeError.setFont(new Font("SansSerif", 3, 14));
										mensajeError.setForeground(new Color(224, 8, 10));
										mensajeError.setBounds(130, 250, 200, 40);

										limpiar();
										removeAll();
										updateUI();
										setLayout(null);

										add(error);
										add(mensajeError);
									}
								} catch (SQLException ex) {

									JLabel error = new JLabel(new ImageIcon("/iconMax/error.png"));
									error.setBounds(200, 20, 200, 200);

									JLabel mensajeError = new JLabel("Error inesperado!");
									mensajeError.setHorizontalAlignment(JLabel.CENTER);
									mensajeError.setFont(new Font("SansSerif", 3, 14));
									mensajeError.setForeground(new Color(224, 8, 10));
									mensajeError.setBounds(130, 250, 200, 40);

									limpiar();
									removeAll();
									updateUI();
									setLayout(null);

									add(error);
									add(mensajeError);
									System.out.println("Tenemos un problema aqui en Registro de Personas");
									ex.printStackTrace(System.out);
								}
							} catch (NumberFormatException error) {
								venAhorro.removeAll();
								venAhorro.repaint();
								venAhorro.setTitle("Error!");

								JLabel img = new JLabel(new ImageIcon(getClass().getResource("/iconMax/errorMin.png")));
								img.setForeground(new Color(224,8,10));
								img.setFont(new Font("SansSerif",3,14));
								img.setBounds(180,50,128,128);

								JLabel falla = new JLabel("Algunos campos no son admitidos");
								falla.setForeground(new Color(224,8,10));
								falla.setFont(new Font("SansSerif",3,14));
								falla.setBounds(140,205,210,30);
								venAhorro.add(img);
								venAhorro.add(falla);

							}
						}
					});

				} else {

					var veri = true;
					ImageIcon imgFondo;
					imgFondo = new ImageIcon(getClass().getResource("/iconMin/fon.png"));

					do {
						try {

							JFrame vFon = new JFrame("Fondo");
							vFon.setSize(400, 98);
							vFon.setLayout(null);
							vFon.getContentPane().setBackground(new Color(27, 38, 49));

							JLabel txt = new JLabel("Dijite el fondo: ");
							txt.setFont(new Font("SansSerif", 3, 14));
							txt.setForeground(new Color(0, 164, 255));
							txt.setBounds(10, 20, 150, 30);

							fon = new JTextField(20);
							fon.setFont(new Font("SansSerif", 3, 14));
							fon.setForeground(new Color(0, 164, 255));
							fon.setBounds(170, 20, 150, 30);

							JButton btn = new JButton();
							btn.setIcon(imgFondo);
							btn.setBackground(new Color(27, 38, 49));
							btn.setBounds(325, 20, 30, 30);
							btn.setBorder(BorderFactory.createLineBorder(new Color(27, 38, 49)));
							btn.setBorder(new RoundedBorder(15));

							vFon.add(txt);
							vFon.add(fon);
							vFon.add(btn);

							vFon.setResizable(false);
							vFon.setLocationRelativeTo(null);
							vFon.setVisible(true);

							JTextField finalFon = fon;

							btn.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent evt) {
									fondo = Double.parseDouble(finalFon.getText());
									vFon.setVisible(false);

									if(!(
										numCuenta == 0 &&
											"".equals(campoNombreEmpresa.getText()) &&
											"".equals(campoDireccion.getText()) &&
											"".equals(campoPrimerNombreRepre.getText()) &&
											"".equals(campoSegundoNombreRepre.getText()) &&
											"".equals(campoSegundoApelliRepre.getText()) &&
											"".equals(campoPrimerApelliRepre.getText()) &&
											"".equals(campoCcRepre.getText()) &&
											"".equals(campoPrimerNombreNoEmple.getText()) &&
											"".equals(campoSegundoNombreNoEmple.getText()) &&
											"".equals(campoSegundoApelliNoEmple.getText()) &&
											"".equals(campoPrimerApelliNoEmple.getText()) &&
											"".equals(campoCcNoEmple.getText()))) {

										PreparedStatement prepared = null;
										Conector objtConec = new Conector();
										Connection conexion = null;

										try {

											if ( fondo == 0) {

												conexion = objtConec.getConexion();
												prepared = conexion.prepareStatement("INSERT INTO organizacion " +
													"(numCuenta," +//1
													"nombre," +//2
													"direccion," +//3
													"tipo," + //4
													"tipoCuenta," +//5
													"codigoOficina," +//6
													"codigo," + //7
													"fondo," + //8
													"nombreRepresentate," +//9
													"apellido1Representate," +//10
													"apellido2Representate," +//11
													"ccRepre," + //12
													"nombreNoEmpleado," + //13
													"apellido1NoEmpleado," + //14
													"apellido2NoEmpleado," + //15
													"ccNoEmple) " //16
													+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

												prepared.setInt(1, numCuenta);
												prepared.setString(2, campoNombreEmpresa.getText());
												prepared.setString(3, campoDireccion.getText());
												prepared.setString(4, tipoOrganizacionTxt);
												prepared.setString(5, tipoCuentaTxt);
												prepared.setInt(6, codigoOficina);
												prepared.setInt(7, codigoSeguridad());
												prepared.setDouble(8, fondo);
												prepared.setString(9, repreName);
												prepared.setString(10, campoPrimerApelliRepre.getText());
												prepared.setString(11, campoSegundoApelliRepre.getText());
												prepared.setInt(12, ccRepre);
												prepared.setString(13, noEmplea);
												prepared.setString(14, campoPrimerApelliNoEmple.getText());
												prepared.setString(15, campoSegundoApelliNoEmple.getText());
												prepared.setInt(16, ccNoEmple);

												prepared.executeUpdate();

												Object[] fila = new Object[16];

												fila[0] = numCuenta;
												fila[1] = campoNombreEmpresa.getText();
												fila[2] = campoDireccion.getText();
												fila[3] = tipoOrganizacionTxt;
												fila[4] = tipoCuentaTxt;
												fila[5] = codigoOficina;
												fila[6] = codigoSeguridad();
												fila[7] = fondo;
												fila[8] = campoPrimerNombreRepre.getText() + " " + campoSegundoNombreRepre.getText();
												fila[9] = campoPrimerApelliRepre.getText();
												fila[10] = campoSegundoApelliRepre.getText();
												fila[11] = ccRepre;
												fila[12] = campoPrimerNombreNoEmple.getText() + " " + campoSegundoNombreNoEmple.getText();
												fila[13] = campoPrimerApelliNoEmple.getText();
												fila[14] = campoSegundoApelliNoEmple.getText();
												fila[15] = ccNoEmple;

												TablaOrganizacion agregar = new TablaOrganizacion();
												agregar.modelo(fila);
												limpiar();
											}else{

												JLabel img = new JLabel(new ImageIcon("/iconMax/error.png"));
												img.setBounds(200, 20, 200, 200);

												JLabel mensajeError = new JLabel("Campos Vacios");
												mensajeError.setHorizontalAlignment(JLabel.CENTER);
												mensajeError.setFont(new Font("SansSerif", 3, 14));
												mensajeError.setForeground(new Color(224, 8, 10));
												mensajeError.setBounds(130, 250, 200, 40);

												limpiar();
												removeAll();
												updateUI();
												setLayout(null);

												add(img);
												add(mensajeError);
											}


										} catch (SQLException ex) {
											System.out.println("Tenemos un problema aqui en Registro de Personas");

											vFon.removeAll();
											vFon.repaint();
											vFon.setSize(500, 250);

											JLabel img = new JLabel(new ImageIcon(getClass().getResource("/iconMax/errorMin.png")));
											img.setForeground(new Color(224,8,10));
											img.setFont(new Font("SansSerif",3,14));
											img.setBounds(180,50,128,128);

											JLabel falla = new JLabel("Error inesperados!");
											falla.setForeground(new Color(224,8,10));
											falla.setFont(new Font("SansSerif",3,14));
											falla.setBounds(140,205,210,30);
											vFon.add(img);
											vFon.add(falla);

											ex.printStackTrace(System.out);
										}
									}else{

										vFon.removeAll();
										vFon.repaint();
										vFon.setSize(500, 250);

										JLabel img = new JLabel(new ImageIcon(getClass().getResource("/iconMax/errorMin.png")));
										img.setForeground(new Color(224,8,10));
										img.setFont(new Font("SansSerif",3,14));
										img.setBounds(180,50,128,128);

										JLabel falla = new JLabel("Algunos campos no son admitidos");
										falla.setForeground(new Color(224,8,10));
										falla.setFont(new Font("SansSerif",3,14));
										falla.setBounds(140,205,210,30);
										vFon.add(img);
										vFon.add(falla);

									}

								}
							});
							veri = false;
						} catch (NumberFormatException error) {

							JLabel img = new JLabel(new ImageIcon("/iconMax/error.png"));
							img.setBounds(200, 20, 200, 200);

							JLabel mensajeError = new JLabel("Los valores no son admitidos");
							mensajeError.setHorizontalAlignment(JLabel.CENTER);
							mensajeError.setFont(new Font("SansSerif", 3, 14));
							mensajeError.setForeground(new Color(224, 8, 10));
							mensajeError.setBounds(130, 250, 200, 40);

							limpiar();
							removeAll();
							updateUI();
							setLayout(null);

							add(img);
							add(mensajeError);
						}

					} while (veri == true);


				}
			} catch (SQLException ex) {

				JLabel error = new JLabel(new ImageIcon("/iconMax/error.png"));
				error.setBounds(200, 20, 200, 200);

				JLabel mensajeError = new JLabel("Error inesperado!");
				mensajeError.setHorizontalAlignment(JLabel.CENTER);
				mensajeError.setFont(new Font("SansSerif", 3, 14));
				mensajeError.setForeground(new Color(224, 8, 10));
				mensajeError.setBounds(130, 250, 200, 40);

				limpiar();
				removeAll();
				updateUI();
				setLayout(null);

				add(error);
				add(mensajeError);
				System.out.println("Tenemos un problema aqui en Registro de Organizacion");
				ex.printStackTrace(System.out);
			}
		}else{

			JLabel error = new JLabel(new ImageIcon(getClass().getResource("/iconMax/error.png")));
			error.setBounds(100, 0, 260, 260);

			JLabel mensajeError = new JLabel("Error Campos vacios!");
			mensajeError.setHorizontalAlignment(JLabel.CENTER);
			mensajeError.setFont(new Font("SansSerif", 3, 14));
			mensajeError.setForeground(new Color(224, 8, 10));
			mensajeError.setBounds(130, 250, 200, 40);

			limpiar();
			removeAll();
			updateUI();
			setLayout(null);

			add(error);
			add(mensajeError);

		}
	}//Fin guardar

//==========================================
//              Numero cuenta
//==========================================

	public int crearNumCuenta(){
		int num = 0;

		Connection conec = null;
		PreparedStatement prepared = null;
		ResultSet resul = null;
		Conector objtConec = new Conector();

		try {


			conec = objtConec.getConexion();
			prepared = conec.prepareStatement("SELECT numCuenta FROM organizacion");
			resul = prepared.executeQuery();

			while(resul.next()){

				num = resul.getInt("numCuenta");
			}

		} catch (SQLException ex) {

			Logger.getLogger(RegistroPersonas.class.getName()).log(Level.SEVERE, null, ex);

		}
		return num + 1;
	}// FIn Numero cuenta


//==========================================
//              Codigo de seguridad
//==========================================

	public int codigoSeguridad(){
		int codigo = 0;

		String x = String.valueOf(numCuenta);
		char[] codi = x.toCharArray();
		int[] num = new int[9];

		for (int i = codi.length - 1; i == 0 ; i--){

			num[i] = Integer.parseInt(String.valueOf(codi[i]));

			codigo += ((i + 2)%2 == 0)?num[i] * 3 :num[i] * 1;

		}
		codigo = (codigo / 10)-(codigo%10);

		codigo = (codigo < 0 )? codigo * -1: codigo;
		return codigo;

	}//Fin Codigo de seguridad

	//====================================================
	//              Limpiar
//====================================================

	public void limpiar () {
		numCuenta = 0;
		campoNombreEmpresa.setText("");
		campoDireccion.setText("");
		campoPrimerNombreRepre.setText("");
		campoSegundoNombreRepre.setText("");
		campoSegundoApelliRepre.setText("");
		campoPrimerApelliRepre.setText("");
		campoCcRepre.setText("");
		campoPrimerNombreNoEmple.setText("");
		campoSegundoNombreNoEmple.setText("");
		campoSegundoApelliNoEmple.setText("");
		campoPrimerApelliNoEmple.setText("");
		campoCcNoEmple.setText("");
		campoCcRepre.setText("");
		campoCodigoOficina.setText("");
		fondo = 0;
		tiempo = 0;
	}

}

