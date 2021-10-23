
package ventanas;

import datos.Conector;
import metodo.RoundedBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import tablas.TablaPersonas;


/**
 *
 * @author
 * Saray Lopez Tobinson
 * Miler Vargas Mola
 */

public class RegistroPersonas extends JPanel {

    private JLabel nombre1;
    private JTextField campoNombre1;
    private JLabel nombre2;
    private JTextField campoNombre2;
    private JLabel apellido1;
    private JTextField campoApellido1;
    private JLabel apellido2;
    private JTextField campoApellido2;
    private JSpinner spiDia;
    private JLabel nacimiento;
    private JTextField campoCc;
    private JLabel cc;
    private SpinnerNumberModel modelo2;
    private JSpinner spiMes;
    private SpinnerNumberModel modelo3;
    private JSpinner spiYear;
    private JLabel sexo;
    private JRadioButton masculino;
    private JRadioButton femenino;
    private JLabel address;
    private JTextField campoAddress;
    private JLabel etiPregunta,etiFondo;
    private boolean entrada = false;
    private JComboBox tipoCuenta;
    private JTextField campoCodigoOficina,campoFondo;
    private String sex,tipoCuentaTxt,fecha;
    private int numCuenta;
    private JLabel etiCodigoOficina;
    private double fondo = 0;
    private int tiempo = 0;


public RegistroPersonas(){

this.setBackground(new Color(27,38,49));
this.setLayout(new GridBagLayout());
this.setBackground(new Color(27,38,49));

}

public JPanel iniciaRegistroPersona(int dia, int mes, int year,JButton btnSiguiente, JButton btnCancelar, JProgressBar progreso, int aumento) {

try{

	removeAll();
	updateUI();
	setLayout(new GridBagLayout());

nombre1 = new JLabel("Primer nombres: ");
nombre1.setFont(new Font("SansSerif",3,12));
nombre1.setForeground(new Color(0,164,255));

GridBagConstraints constraints = new GridBagConstraints();
constraints.gridx = 0;
constraints.gridy = 0;
constraints.gridwidth = 1;
constraints.gridheight = 1;
constraints.weightx = 1.0;
constraints.fill = GridBagConstraints.NONE;
constraints.anchor = GridBagConstraints.WEST;
constraints.insets = new Insets(10,5,8,10);
this.add(nombre1,constraints);
constraints.insets = new Insets(10,5,10,5);

campoNombre1 = new JTextField(20);
campoNombre1.setToolTipText("Primer nombre");
campoNombre1.setFont(new Font("SansSerif",3,12));
campoNombre1.setForeground(new Color(0,164,255));
campoNombre1.setSize(200,30);

constraints.gridx = 1;
constraints.gridy = 0;
constraints.gridwidth = 3;
constraints.gridheight = 1;
constraints.weightx = 1.0;
this.add(campoNombre1,constraints);
constraints.weightx = 0.0;

nombre2 = new JLabel("Segundo nombres: ");
nombre2.setFont(new Font("SansSerif",3,12));
nombre2.setForeground(new Color(0,164,255));

constraints.gridx = 0;
constraints.gridy = 1;
constraints.gridwidth = 1;
constraints.gridheight = 1;
this.add(nombre2,constraints);

campoNombre2 = new JTextField("",20);
campoNombre2.setFont(new Font("SansSerif",3,12));
campoNombre2.setForeground(new Color(0,164,255));
campoNombre2.setSize(200,30);

constraints.gridx = 1;
constraints.gridy = 1;
constraints.gridwidth = 3;
constraints.gridheight = 1;
constraints.weightx = 1.0;
this.add(campoNombre2,constraints);
constraints.weightx = 0.0;

apellido1 = new JLabel("Primer apellido: ");
apellido1.setFont(new Font("SansSerif",3,12));
apellido1.setForeground(new Color(0,164,255));

constraints.gridx = 0;
constraints.gridy = 2;
constraints.gridwidth = 1;
constraints.gridheight = 1;
this.add(apellido1,constraints);

campoApellido1 = new JTextField("",20);
campoApellido1.setFont(new Font("SansSerif",3,12));
campoApellido1.setForeground(new Color(0,164,255));

constraints.gridx = 1;
constraints.gridy = 2;
constraints.gridwidth = 3;
constraints.gridheight = 1;
constraints.weightx = 1.0;
this.add(campoApellido1,constraints);
constraints.weightx = 0.0;

apellido2 = new JLabel("Segundo apellido: ");
apellido2.setFont(new Font("SansSerif",3,12));
apellido2.setForeground(new Color(0,164,255));

constraints.gridx = 0;
constraints.gridy = 3;
constraints.gridwidth = 1;
constraints.gridheight = 1;
this.add(apellido2,constraints);

campoApellido2 = new JTextField("",20);
campoApellido2.setFont(new Font("SansSerif",3,12));
campoApellido2.setForeground(new Color(0,164,255));

constraints.gridx = 1;
constraints.gridy = 3;
constraints.gridwidth = 3;
constraints.gridheight = 1;
constraints.weightx = 1.0;
this.add(campoApellido2,constraints);
constraints.weightx = 0.0;

cc = new JLabel("N° CC: ");
cc.setFont(new Font("SansSerif",3,12));
cc.setForeground(new Color(0,164,255));

constraints.gridx = 0;
constraints.gridy = 4;
constraints.gridwidth = 1;
constraints.gridheight = 1;
this.add(cc,constraints);

campoCc = new JTextField("",20);
campoCc.setFont(new Font("SansSerif",3,12));
campoCc.setForeground(new Color(0,164,255));

constraints.gridx = 1;
constraints.gridy = 4;
constraints.gridwidth = 3;
constraints.gridheight = 1;
constraints.weightx = 1.0;
this.add(campoCc,constraints);
constraints.weightx = 0.0;

nacimiento = new JLabel("Nacimiento: ");
nacimiento.setFont(new Font("SansSerif",3,12));
nacimiento.setForeground(new Color(0,164,255));

constraints.gridx = 0;
constraints.gridy = 5;
constraints.gridwidth = 1;
constraints.gridheight = 1;
this.add(nacimiento,constraints);

SpinnerNumberModel modelo1 = new SpinnerNumberModel();
modelo1.setMaximum(30);
modelo1.setMinimum(1);
modelo1.setValue(dia);

spiDia = new JSpinner(modelo1);
spiDia.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
spiDia.setForeground(new Color(0,164,255));
spiDia.setFont(new Font("SansSerif",2,12));

constraints.gridx = 1;
constraints.gridy = 5;
constraints.gridwidth = 1;
constraints.gridheight = 1;
constraints.fill = GridBagConstraints.VERTICAL;
this.add(spiDia,constraints);

modelo2 = new SpinnerNumberModel();
modelo2.setMaximum(12);
modelo2.setMinimum(1);
modelo2.setValue(mes);

spiMes = new JSpinner(modelo2);
spiMes.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
spiMes.setBackground(new Color(27,38,49));
spiMes.setForeground(new Color(0,164,255));
spiMes.setFont(new Font("SansSerif",2,12));

constraints.gridx = 2;
constraints.gridy = 5;
constraints.gridwidth = 1;
constraints.gridheight = 1;
this.add(spiMes,constraints);

modelo3 = new SpinnerNumberModel();
modelo3.setMaximum(year-18);
modelo3.setMinimum(1910);
modelo3.setValue(year-18);

spiYear = new JSpinner(modelo3);
spiYear.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
spiYear.setBackground(new Color(27,38,49));
spiYear.setForeground(new Color(0,164,255));
spiYear.setFont(new Font("SansSerif",2,12));

constraints.gridx = 3;
constraints.gridy = 5;
constraints.gridwidth = 1;
constraints.gridheight = 1;
constraints.weightx = 0.0;
this.add(spiYear,constraints);
constraints.weightx = 1.0;

sexo = new JLabel("sexo ");
sexo.setFont(new Font("SansSerif",3,12));
sexo.setForeground(new Color(0,164,255));

constraints.gridx = 0;
constraints.gridy = 6;
constraints.gridwidth = 1;
constraints.gridheight = 1;
this.add(sexo,constraints);

masculino = new JRadioButton("Masculino");
masculino.setBackground(new Color(27,38,49));
masculino.setForeground(new Color(0,164,255));
masculino.setSelected(true);

constraints.gridx = 1;
constraints.gridy = 6;
constraints.gridwidth = 1;
constraints.gridheight = 1;
this.add(masculino,constraints);

femenino = new JRadioButton("Femenino");
femenino.setBackground(new Color(27,38,49));
femenino.setForeground(new Color(0,164,255));

constraints.gridx = 2;
constraints.gridy = 6;
constraints.gridwidth = 1;
constraints.gridheight = 1;
this.add(femenino,constraints);

ButtonGroup v = new ButtonGroup();
v.add(masculino);
v.add(femenino);

address = new JLabel("Dirección: ");
address.setFont(new Font("SansSerif",3,12));
address.setForeground(new Color(0,164,255));

constraints.gridx = 0;
constraints.gridy = 7;
constraints.gridwidth = 1;
constraints.gridheight = 1;
this.add(address,constraints);

campoAddress = new JTextField("",20);
campoAddress.setFont(new Font("SansSerif",1,12));
campoAddress.setForeground(new Color(0,164,255));

constraints.gridx = 1;
constraints.gridy = 7;
constraints.gridwidth = 3;
constraints.gridheight = 1;
constraints.weightx = 1.0;
this.add(campoAddress,constraints);
this.setBounds(90,30,340,240);
constraints.weightx = 0.0;

etiCodigoOficina = new JLabel("Codigo oficina: ");
etiCodigoOficina.setBackground(new Color(27,38,49));
etiCodigoOficina.setFont(new Font("SansSerif",Font.ITALIC,14));
etiCodigoOficina.setForeground(new Color(0,164,255));

constraints.gridx = 0;
constraints.gridy = 8;
constraints.gridwidth = 1;
constraints.gridheight = 1;
constraints.weightx = 0.0;
this.add(etiCodigoOficina,constraints);

campoCodigoOficina = new JTextField("",20);
campoCodigoOficina.setFont(new Font("SandsSerif",3,12));
campoCodigoOficina.setForeground(new Color(0,164,255));

constraints.gridx = 1;
constraints.gridy = 8;
constraints.gridwidth = 2;
constraints.gridheight = 1;
constraints.weightx = 1.0;
this.add(campoCodigoOficina,constraints);

    etiPregunta = new JLabel("Tipo cuenta: ");
    etiPregunta.setBackground(new Color(27,38,49));
    etiPregunta.setFont(new Font("SansSerif",Font.ITALIC,14));
    etiPregunta.setForeground(new Color(0,164,255));

    constraints.gridx = 0;
    constraints.gridy = 9;
    constraints.gridwidth = 1;
    constraints.gridheight = 1;
    this.add(etiPregunta,constraints);

    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    modelo.addElement("Cliente");
    modelo.addElement("Corriente");
    modelo.addElement("Ahorro");

    tipoCuenta = new JComboBox(modelo);
    tipoCuenta.setFont(new Font("SandsSerif",3,12));
    tipoCuenta.setForeground(new Color(0,164,255));
    tipoCuenta.setBackground(new Color(27,38,49));
    tipoCuenta.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));

    constraints.gridx = 1;
    constraints.gridy = 9;
    constraints.gridwidth = 1;
    constraints.gridheight = 1;
    this.add(tipoCuenta,constraints);

    JButton bntFondo = new JButton("Fondo");
    bntFondo.setFont(new Font("SandsSerif",3,12));
    bntFondo.setForeground(new Color(0,164,255));
    bntFondo.setBackground(new Color(0,0,33));
    bntFondo.setSize(120,30);
    bntFondo.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));

    constraints.gridx = 2;
    constraints.gridy = 9;
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

JLabel mensajeError = new JLabel("Algunos campos no son validos");
mensajeError.setHorizontalAlignment(JLabel.CENTER);
mensajeError.setFont(new Font("FreeMono",3,14));
mensajeError.setForeground(new Color(224,8,10));
mensajeError.setBorder(BorderFactory.createLineBorder(new Color(224,8,10)));
mensajeError.setBounds(70,220,440,40);
mensajeError.setBorder(new RoundedBorder(15));

    this.add(error);
    this.add(mensajeError);
}
    return this;
}

//==============================================================
    //                  Guardar
//==============================================================

public void guardar() {

							if(!(
										"".equals(campoNombre1.getText())  &&
											"".equals(campoApellido1.getText())  &&
											"".equals(campoApellido2.getText())  &&
											"".equals(campoAddress.getText())  &&
											"".equals(campoCc.getText()) &&
											"".equals(campoCodigoOficina.getText()))){

	PreparedStatement prepared = null;
	Conector objtConec = new Conector();
	Connection conexion = null;

	JTextField fon = null;
	boolean entrada = false;

	try {

		conexion = objtConec.getConexion();

		numCuenta = crearNumCuenta();
		sex = (masculino.isSelected()) ? "Masculino" : "Femenino";
		fecha = "" + spiDia.getValue() + "-" + spiMes.getValue() + "-" + spiYear.getValue();

		tipoCuentaTxt = tipoCuenta.getSelectedItem().toString();

		System.out.print(tipoCuentaTxt);

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

			JTextField txtFon = new JTextField(20);
			txtFon.setBounds(140, 50, 200, 30);
			txtFon.setForeground(new Color(0,164,255));

			JLabel interes = new JLabel("Interes:            5% Anual");
			interes.setForeground(new Color(0, 164, 255));
			interes.setFont(new Font("Sansita", 1, 12));
			interes.setBounds(47, 110, 200, 30);

			JLabel cuotas = new JLabel("Cuotas: ");
			cuotas.setForeground(new Color(0, 164, 255));
			cuotas.setFont(new Font("Sansita", 1, 12));
			cuotas.setBounds(47, 160, 120, 30);

			JTextField txtCuotas = new JTextField(20);
			txtCuotas.setBounds(140, 160, 200, 30);
			txtCuotas.setForeground(new Color(0,164,255));

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
					if (!(
						"".equals(campoNombre1.getText()) &&
							"".equals(campoApellido1.getText()) &&
							"".equals(campoApellido2.getText()) &&
							"".equals(campoAddress.getText()) &&
							"".equals(campoCc.getText()) &&
							"".equals(campoCodigoOficina.getText()))) {

						try {
							venAhorro.setVisible(false);
							tiempo = Integer.parseInt(txtCuotas.getText());
							fondo = Double.parseDouble(txtFon.getText());


							PreparedStatement prepared = null;
							Conector objtConec = new Conector();
							Connection conexion = null;

							try {

								if (fondo != 0 && tiempo != 0) {

									conexion = objtConec.getConexion();
									prepared = conexion.prepareStatement("INSERT INTO persona (numCuenta,nombre1,nombre2,apellido1,apellido2,cc,direccion,nacimiento,sexo,tipoCuenta,codigoOficina,codigo,fondo,tiempo) "
										+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

									prepared.setInt(1, numCuenta);
									prepared.setString(2, campoNombre1.getText());
									prepared.setString(3, campoNombre2.getText());
									prepared.setString(4, campoApellido1.getText());
									prepared.setString(5, campoApellido2.getText());
									prepared.setString(6, campoCc.getText());
									prepared.setString(7, campoAddress.getText());
									prepared.setString(8, fecha);
									prepared.setString(9, sex);
									prepared.setString(10, tipoCuentaTxt);
									prepared.setInt(11, Integer.parseInt(campoCodigoOficina.getText()));
									prepared.setInt(12, codigoSeguridad());
									prepared.setDouble(13, fondo);
									prepared.setInt(14, tiempo);

									prepared.executeUpdate();

									Object[] fila = new Object[14];

									fila[0] = numCuenta;
									fila[1] = campoNombre1.getText();
									fila[2] = campoNombre2.getText();
									fila[3] = campoApellido1.getText();
									fila[4] = campoApellido2.getText();
									fila[5] = campoCc.getText();
									fila[6] = campoAddress.getText();
									fila[7] = fecha;
									fila[8] = sex;
									fila[9] = tipoCuentaTxt;
									fila[10] = campoCodigoOficina.getText();
									fila[11] = codigoSeguridad();
									fila[12] = fondo;
									fila[13] = tiempo;

									Icon icon = new ImageIcon(getClass().getResource("/iconMin/exito.png"));
									JOptionPane.showMessageDialog(null,"Guaradado exitoso","",JOptionPane.INFORMATION_MESSAGE,icon);

									TablaPersonas agregar = new TablaPersonas();
									agregar.modelo(fila);
									limpiar();


								} else {

									JLabel error = new JLabel(new ImageIcon(getClass().getResource("/iconMax/error.png")));
									error.setBounds(100, 0, 260, 260);

									JLabel mensajeError = new JLabel("Error fondos vacios!");
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

								JLabel error = new JLabel(new ImageIcon(getClass().getResource("/iconMax/error.png")));
								error.setBounds(100, 0, 260, 260);

								JLabel mensajeError = new JLabel("Error inesperados con MariaDB!");
								mensajeError.setHorizontalAlignment(JLabel.CENTER);
								mensajeError.setFont(new Font("SansSerif", 3, 14));
								mensajeError.setForeground(new Color(224, 8, 10));
								mensajeError.setBounds(130, 250, 310, 40);

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
							venAhorro.setVisible(false);
							guardar();

						}

					} else {
						venAhorro.setVisible(false);
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

				}
			});

		} else {

			var veri = true;
			ImageIcon imgFondo;
			imgFondo = new ImageIcon(getClass().getResource("/iconMin/fon.png"));

			do {
				try {

					JFrame vFon = new JFrame("Fondo");
					vFon.setSize(395, 98);
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

							if (!(
								"".equals(campoNombre1.getText()) &&
									"".equals(campoApellido1.getText()) &&
									"".equals(campoApellido2.getText()) &&
									"".equals(campoAddress.getText()) &&
									"".equals(campoCc.getText()) &&
									"".equals(campoCodigoOficina.getText()))) {

								fondo = Double.parseDouble(finalFon.getText());
								vFon.setVisible(false);

								PreparedStatement prepared = null;
								Conector objtConec = new Conector();
								Connection conexion = null;

								try {

									if (fondo != 0) {

										conexion = objtConec.getConexion();
										prepared = conexion.prepareStatement("INSERT INTO persona (numCuenta,nombre1,nombre2,apellido1,apellido2,cc,direccion,nacimiento,sexo,tipoCuenta,codigoOficina,codigo,fondo) "
											+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);");

										prepared.setInt(1, numCuenta);
										prepared.setString(2, campoNombre1.getText());
										prepared.setString(3, campoNombre2.getText());
										prepared.setString(4, campoApellido1.getText());
										prepared.setString(5, campoApellido2.getText());
										prepared.setString(6, campoCc.getText());
										prepared.setString(7, campoAddress.getText());
										prepared.setString(8, fecha);
										prepared.setString(9, sex);
										prepared.setString(10, tipoCuentaTxt);
										prepared.setInt(11, Integer.parseInt(campoCodigoOficina.getText()));
										prepared.setInt(12, codigoSeguridad());
										prepared.setDouble(13, fondo);

										prepared.executeUpdate();

										Object[] fila = new Object[13];

										fila[0] = numCuenta;
										fila[1] = campoNombre1.getText();
										fila[2] = campoNombre2.getText();
										fila[3] = campoApellido1.getText();
										fila[4] = campoApellido2.getText();
										fila[5] = campoCc.getText();
										fila[6] = campoAddress.getText();
										fila[7] = fecha;
										fila[8] = sex;
										fila[9] = tipoCuentaTxt;
										fila[10] = campoCodigoOficina.getText();
										fila[11] = codigoSeguridad();
										fila[12] = fondo;

										Icon icon = new ImageIcon(getClass().getResource("/iconMin/exito.png"));
										JOptionPane.showMessageDialog(null,"Guaradado exitoso","",JOptionPane.INFORMATION_MESSAGE,icon);

										TablaPersonas agregar = new TablaPersonas();
										agregar.modelo(fila);
										limpiar();
									} else {

										JLabel error = new JLabel(new ImageIcon(getClass().getResource("/iconMax/error.png")));
										error.setBounds(200, 20, 200, 200);

										JLabel mensajeError = new JLabel("Fondo vacio!");
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

									}


								} catch (SQLException ex) {
									System.out.println("Tenemos un problema aqui en Registro de Personas");
									ex.printStackTrace(System.out);
								}

							}else{

								vFon.setVisible(false);
							}


						}
					});
					veri = false;
				} catch (NumberFormatException error) {
					JLabel img = new JLabel(new ImageIcon(getClass().getResource("/iconMax/error.png")));
					img.setBounds(100, 0, 260, 260);

					JLabel mensajeError = new JLabel("Valores no admitidos!");
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
		System.out.println("Tenemos un problema aqui en Registro de Personas");
		ex.printStackTrace(System.out);
	}
} else {


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
    prepared = conec.prepareStatement("SELECT numCuenta FROM persona");
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

for (int i = 0; i < codi.length - 1; i++){

num[i] = Integer.parseInt(String.valueOf(codi[i]));

codigo += ((i + 2)%2 == 0)?num[i] * 3 :num[i] * 1;

}
codigo = (codigo / 10)-(codigo%10);

codigo = (codigo < 0 )? codigo * -1: codigo;
return codigo;

}//Fin Codigo de seguridad


public boolean isEntrada() {

return entrada;
}

//====================================================
    //              Limpiar
//====================================================

    public void limpiar () {
        numCuenta = 0;
        campoNombre1.setText("");
        campoNombre2.setText("");
        campoApellido1.setText("");
        campoApellido2.setText("");
        campoCc.setText("");
        campoAddress.setText("");
        campoCodigoOficina.setText("");
        fecha = "";
        tipoCuentaTxt = "";
        fondo = 0;
        tiempo = 0;
    }


public void setEntrada(boolean entrada) {
        this.entrada = entrada;
    }
}//Fin clase
