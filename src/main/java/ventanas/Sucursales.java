
package ventanas;

import datos.Conector;
import metodo.RoundedBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

/**
*
* @author
* Saray lopez tobinso
* Miler Vargas Mola
	*
*/

public class Sucursales extends JPanel{

private JPanel panelCabecera;
private JLabel etiPregunta;
private JLabel etiCabecera;
private JLabel etiSucur,etiEmple;
private JTextField txtCodigo,txtCc;
private JTextField txtDireccion,txtPostal;
private JTextField txtNombre1,txtNombre2;
private JTextField txtApellido1,txtApellido2;
private JButton btnSucursal,btnEmpleados;
private boolean personas = false;
private boolean organizacion = false;

public Sucursales(){

this.setLayout(null);
this.setBackground(new Color(27,38,49));
this.setBounds(0,0,570,400);
this.setVisible(true);

etiCabecera = new JLabel("Registro interno",JLabel.CENTER);
etiCabecera.setForeground(new Color(0,165,255));
etiCabecera.setFont(new Font("SansSerif",3,18));

panelCabecera = new JPanel(new FlowLayout());
panelCabecera.add(etiCabecera);
panelCabecera.setBackground(new Color(19,28,51));
panelCabecera.setBounds(0,0,570,40);
this.add(panelCabecera);

etiPregunta = new JLabel("¿Sucursal o empleados?", JLabel.CENTER);
etiPregunta.setForeground(new Color(0,164,255));
etiPregunta.setFont(new Font("SansSerif",3,16));
etiPregunta.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
etiPregunta.setBorder(new RoundedBorder(15));
etiPregunta.setBounds(110,70,350,30);
this.add(etiPregunta);

	btnSucursal = new JButton( new ImageIcon(getClass().getResource("/iconMax/sucur.png")));
	btnSucursal.setBackground(new Color(27,38,49));
	btnSucursal.setBorder(BorderFactory.createLineBorder(new Color(27,38,49)));
	btnSucursal.setBounds(113,140,128,128);
	this.add(btnSucursal);

	etiSucur = new JLabel("Sucursal", JLabel.CENTER);
	etiSucur.setForeground(new Color(0,164,255));
	etiSucur.setFont(new Font("SansSerif",3,14));
	etiSucur.setBounds(110,278,120,30);
	this.add(etiSucur);

	btnEmpleados = new JButton( new ImageIcon(getClass().getResource("/iconMax/empleado.png")));
	btnEmpleados.setBackground(new Color(27,38,49));
	btnEmpleados.setBorder(BorderFactory.createLineBorder(new Color(27,38,49)));
	btnEmpleados.setBounds(293,140,128,128);
	this.add(btnEmpleados);

	etiEmple = new JLabel("Empleado", JLabel.CENTER);
	etiEmple.setForeground(new Color(0,164,255));
	etiEmple.setFont(new Font("SansSerif",3,14));
	etiEmple.setBounds(300,278,120,30);
	this.add(etiEmple);

	btnSucursal.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			ejecutaSucursal(evt);
		}
	});

	btnEmpleados.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			ejecutaEmpleados(evt);
		}
	});

}

	//==============================================
	//											Ejecución de Sucursales
//==============================================

	private void ejecutaSucursal(ActionEvent evt) {

	JPanel contenedor = new JPanel();
	contenedor.setBackground(new Color(27,38,49));
	contenedor.setLayout(null);

		JLabel titulo = new JLabel("Registro Sucursales",JLabel.CENTER);
		titulo.setForeground(new Color(0,164,255));
		titulo.setBounds(160,5,220,30);
		titulo.setFont(new Font("SansSerif",3,18));

		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(new Color(19,28,51));
		panel1.setBounds(0,0,570,50);
		panel1.add(titulo);

		JPanel panel2 = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		panel2.setBackground(new Color(27,38,49));
		panel2.setBounds(0,20,570,400);

		JLabel etiCodigo = new JLabel("Codigo: ");
		etiCodigo.setForeground(new Color(0,164,255));
		etiCodigo.setFont(new Font("SansSerif",3,12));

		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.insets = new Insets(20,30,0,10);
		panel2.add(etiCodigo,constraints);

		txtCodigo = new JTextField(20);
		txtCodigo.setFont(new Font("SansSerif",3,12));
		txtCodigo.setForeground(new Color(0,164,255));

		constraints.gridx = 1;
		constraints.insets = new Insets(10,10,0,30);
		panel2.add(txtCodigo,constraints);

		//=========================================================================
		//																				codigo postal
		//=========================================================================

		JLabel etiPostal = new JLabel("Codigo Postal: ");
		etiPostal.setForeground(new Color(0,164,255));
		etiPostal.setFont(new Font("SansSerif",3,12));

		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(20,30,10,10);
		panel2.add(etiPostal,constraints);

		txtPostal = new JTextField(20);
		txtPostal.setFont(new Font("SansSerif",3,12));
		txtPostal.setForeground(new Color(0,164,255));

		constraints.gridx = 1;
		constraints.insets = new Insets(20,10,0,30);
		panel2.add(txtPostal,constraints);

		//=========================================================================


		JLabel etiDireccion = new JLabel("Dirección: ");
		etiDireccion.setForeground(new Color(0,164,255));
		etiDireccion.setFont(new Font("SansSerif",3,12));

		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.insets = new Insets(20,30,10,10);
		panel2.add(etiDireccion,constraints);

		txtDireccion = new JTextField(20);
		txtDireccion.setFont(new Font("SansSerif",3,12));
		txtDireccion.setForeground(new Color(0,164,255));

		constraints.gridx = 1;
		constraints.insets = new Insets(20,10,0,30);
		panel2.add(txtDireccion,constraints);

		JLabel etiTitle = new JLabel("Encargado",JLabel.CENTER);
		etiTitle.setForeground(new Color(0,164,255));
		etiTitle.setFont(new Font("SansSerif",3,14));
		etiTitle.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
		etiTitle.setBorder(new RoundedBorder(15));

		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.insets = new Insets(20,30,10,10);
		panel2.add(etiTitle,constraints);

		JLabel etiNombre1 = new JLabel("Primer nombre: ");
		etiNombre1.setForeground(new Color(0,164,255));
		etiNombre1.setFont(new Font("SansSerif",3,12));

		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.insets = new Insets(20,30,10,10);
		panel2.add(etiNombre1,constraints);

		txtNombre1 = new JTextField(20);
		txtNombre1.setFont(new Font("SansSerif",3,12));
		txtNombre1.setForeground(new Color(0,164,255));

		constraints.gridx = 1;
		constraints.insets = new Insets(20,10,0,30);
		panel2.add(txtNombre1,constraints);

		JLabel etiNombre2 = new JLabel("Segundo nombre: ");
		etiNombre2.setForeground(new Color(0,164,255));
		etiNombre2.setFont(new Font("SansSerif",3,12));

		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.insets = new Insets(20,30,0,10);
		panel2.add(etiNombre2,constraints);

		txtNombre2= new JTextField(20);
		txtNombre2.setForeground(new Color(0,164,255));
		txtNombre2.setFont(new Font("SansSerif",3,12));

		constraints.gridx = 1;
		constraints.insets = new Insets(20,10,10,30);
		panel2.add(txtNombre2,constraints);

		//============================================

		JLabel etiApellido1 = new JLabel("Primer Apellido: ");
		etiApellido1.setForeground(new Color(0,164,255));
		etiApellido1.setFont(new Font("SansSerif",3,12));

		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.insets = new Insets(20,30,10,10);
		panel2.add(etiApellido1,constraints);

		txtApellido1 = new JTextField(20);
		txtApellido1.setFont(new Font("SansSerif",3,12));
		txtApellido1.setForeground(new Color(0,164,255));

		constraints.gridx = 1;
		constraints.insets = new Insets(20,10,0,30);
		panel2.add(txtApellido1,constraints);

		JLabel etiApellido2 = new JLabel("Segundo Apellido: ");
		etiApellido2.setForeground(new Color(0,164,255));
		etiApellido2.setFont(new Font("SansSerif",3,12));

		constraints.gridx = 0;
		constraints.gridy = 7;
		constraints.insets = new Insets(20,30,0,10);
		panel2.add(etiApellido2,constraints);

		txtApellido2= new JTextField(20);
		txtApellido2.setForeground(new Color(0,164,255));
		txtApellido2.setFont(new Font("SansSerif",3,12));

		constraints.gridx = 1;
		constraints.insets = new Insets(20,10,10,30);
		panel2.add(txtApellido2,constraints);

		JLabel etiCc = new JLabel("N° CC: ");
		etiCc.setForeground(new Color(0,164,255));
		etiCc.setFont(new Font("SansSerif",3,12));

		constraints.gridx = 0;
		constraints.gridy = 8;
		constraints.insets = new Insets(20,30,0,10);
		panel2.add(etiCc,constraints);

		txtCc= new JTextField(20);
		txtCc.setForeground(new Color(0,164,255));
		txtCc.setFont(new Font("SansSerif",3,12));

		constraints.gridx = 1;
		constraints.insets = new Insets(20,10,10,30);
		panel2.add(txtCc,constraints);

		JScrollPane scroll = new JScrollPane(panel2);
		scroll.setBackground(new Color(27,38,49));
		scroll.setBounds(0,50,570,310);
		scroll.setBorder(BorderFactory.createLineBorder(new Color(27,38,49)));

	 JButton	btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(19,28,51));
		btnGuardar.setForeground(new Color(0,164,255));
		btnGuardar.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
		btnGuardar.setBorder(new RoundedBorder(15));
		btnGuardar.setBounds(430,10,120,25);

		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				eventoBtnGuardar(evt);
			}
		});

		panel1.add(btnGuardar);
		this.removeAll();
		this.updateUI();
		this.add(panel1);
		this.add(panelCabecera);
		this.add(scroll);
	}

	private void eventoBtnGuardar(ActionEvent evt) {

		try{

			var codigo = Integer.parseInt(txtCodigo.getText());
			var cc = Integer.parseInt(txtCc.getText());
			var codigoPostal = Integer.parseInt(txtPostal.getText());

			//=======================================
			/*Si los campos estan vacios 											|
				* no entra a al condicional  								 	|
				* para evitar campos vacios 											|
				*///====================================

			if(!("".equals(txtCodigo) || "".equals(txtDireccion) ||
				"".equals(txtNombre1) || "".equals(txtApellido1) ||
				"".equals(txtApellido2) || "".equals(txtCc) ||
				"".equals(txtPostal))) {

				var consulta = "INSERT INTO sucursales" +
					"(codigo,postal,direccion,cargo,nombre1,nombre2,apellido1,apellido2,cc) " +
					"VALUES(?,?,?,?,?,?,?,?,?);";

				Conector objConec = new Conector();
				PreparedStatement prepared = null;

				try {
					Connection conec = objConec.getConexion();
					prepared = conec.prepareStatement(consulta);

					prepared.setInt(1,codigo);
					prepared.setInt(2,codigoPostal);
					prepared.setString(3,txtDireccion.getText());
					prepared.setString(4,"Encargado");
					prepared.setString(5,txtNombre1.getText());
					prepared.setString(6,txtNombre2.getText());
					prepared.setString(7,txtApellido1.getText());
					prepared.setString(8,txtApellido2.getText());
					prepared.setInt(9,cc);
					prepared.executeUpdate();//Actualizar DB (Maria DB)

					limpiarSucursales();

					this.removeAll();
					this.updateUI();

					JLabel img = new JLabel(new ImageIcon(getClass().getResource("/iconMax/formulario.png")));
					img.setBounds(180, 50, 130, 130);

					JLabel mensaje = new JLabel("Se guardo con exito",JLabel.CENTER);
					mensaje.setForeground(new Color(0,164,255));
					mensaje.setFont(new Font("SansSerif",3,14));
					mensaje.setBounds(120,190,280,40);

					this.add(mensaje);
					this.add(img);

				} catch (SQLException e) {

					limpiarSucursales();
					this.removeAll();
					this.updateUI();

					JLabel img = new JLabel(new ImageIcon(getClass().getResource("/iconMax/error.png")));
					img.setBounds(180, 50, 260, 260);

					JLabel mensaje = new JLabel("Algunos Valores no son admitidos",JLabel.CENTER);
					mensaje.setForeground(new Color(0,164,255));
					mensaje.setFont(new Font("SansSerif",3,14));
					mensaje.setBounds(120,310,280,40);

					this.add(mensaje);
					this.add(img);

					e.printStackTrace();

				}
			}else{
				limpiarSucursales();
				JOptionPane.showMessageDialog(null,"Hay campos Vacios","...",JOptionPane.WARNING_MESSAGE);

			}
		}catch(NumberFormatException e){
			limpiarSucursales();
			this.removeAll();
			this.updateUI();

			JLabel img = new JLabel(new ImageIcon(getClass().getResource("/iconMax/error.png")));
			img.setBounds(140, 50, 260, 260);

			JLabel mensaje = new JLabel("Algunos campos estan vacios ",JLabel.CENTER);
			mensaje.setForeground(new Color(255,21,82));
			mensaje.setFont(new Font("SansSerif",3,14));
			mensaje.setBounds(120,310,280,40);

			this.add(mensaje);
			this.add(img);

		}
	}

	public void limpiarSucursales() {

		txtCc.setText("");
		txtNombre1.setText("");
		txtNombre2.setText("");
		txtApellido1.setText("");
		txtApellido2.setText("");
		txtDireccion.setText("");
		txtCodigo.setText("");
		txtPostal.setText("");

	}

//==============================================
	//											Ejecución de empleados
//==============================================

	private void ejecutaEmpleados(ActionEvent evt) {

		this.removeAll();
		this.updateUI();
		this.add(panelCabecera);

			JPanel contenedor = new JPanel();
			contenedor.setBackground(new Color(27,38,49));
			contenedor.setLayout(null);

			JLabel titulo = new JLabel("Registro empleados",JLabel.CENTER);
			titulo.setForeground(new Color(0,164,255));
			titulo.setBounds(160,5,220,30);
			titulo.setFont(new Font("SansSerif",3,18));

			JPanel panel1 = new JPanel();
			panel1.setLayout(null);
			panel1.setBackground(new Color(19,28,51));
			panel1.setBounds(0,0,570,50);
			panel1.add(titulo);

			JPanel panel2 = new JPanel(new GridBagLayout());
			GridBagConstraints constraints = new GridBagConstraints();
			panel2.setBackground(new Color(27,38,49));
			panel2.setBounds(0,20,570,400);

			JLabel etiCodigo = new JLabel("Codigo oficina: ");
			etiCodigo.setForeground(new Color(0,164,255));
			etiCodigo.setFont(new Font("SansSerif",3,12));

			constraints.gridx = 0;
			constraints.gridy = 0;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.anchor = GridBagConstraints.NORTH;
			constraints.insets = new Insets(20,30,0,10);
			panel2.add(etiCodigo,constraints);

			txtCodigo = new JTextField(20);
			txtCodigo.setFont(new Font("SansSerif",3,12));
			txtCodigo.setForeground(new Color(0,164,255));

			constraints.gridx = 1;
			constraints.insets = new Insets(10,10,0,30);
			panel2.add(txtCodigo,constraints);

			//=========================================================================
			//																				Codigo Nombres
			//=========================================================================

		JLabel etiNombre1 = new JLabel("Primer nombre: ");
		etiNombre1.setForeground(new Color(0,164,255));
		etiNombre1.setFont(new Font("SansSerif",3,12));

		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.insets = new Insets(20,30,10,10);
		panel2.add(etiNombre1,constraints);

		txtNombre1 = new JTextField(20);
		txtNombre1.setFont(new Font("SansSerif",3,12));
		txtNombre1.setForeground(new Color(0,164,255));

		constraints.gridx = 1;
		constraints.insets = new Insets(20,10,0,30);
		panel2.add(txtNombre1,constraints);

		JLabel etiNombre2 = new JLabel("Segundo nombre: ");
		etiNombre2.setForeground(new Color(0,164,255));
		etiNombre2.setFont(new Font("SansSerif",3,12));

		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.insets = new Insets(20,30,0,10);
		panel2.add(etiNombre2,constraints);

		txtNombre2= new JTextField(20);
		txtNombre2.setForeground(new Color(0,164,255));
		txtNombre2.setFont(new Font("SansSerif",3,12));

		constraints.gridx = 1;
		constraints.insets = new Insets(20,10,10,30);
		panel2.add(txtNombre2,constraints);

		//=========================================================================
		// 																Campo Apellidos
		//=========================================================================

		JLabel etiApellido1 = new JLabel("Primer Apellido: ");
		etiApellido1.setForeground(new Color(0,164,255));
		etiApellido1.setFont(new Font("SansSerif",3,12));

		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.insets = new Insets(20,30,10,10);
		panel2.add(etiApellido1,constraints);

		txtApellido1 = new JTextField(20);
		txtApellido1.setFont(new Font("SansSerif",3,12));
		txtApellido1.setForeground(new Color(0,164,255));

		constraints.gridx = 1;
		constraints.insets = new Insets(20,10,0,30);
		panel2.add(txtApellido1,constraints);

		JLabel etiApellido2 = new JLabel("Segundo Apellido: ");
		etiApellido2.setForeground(new Color(0,164,255));
		etiApellido2.setFont(new Font("SansSerif",3,12));

		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.insets = new Insets(20,30,0,10);
		panel2.add(etiApellido2,constraints);

		txtApellido2= new JTextField(20);
		txtApellido2.setForeground(new Color(0,164,255));
		txtApellido2.setFont(new Font("SansSerif",3,12));

		constraints.gridx = 1;
		constraints.insets = new Insets(20,10,10,30);
		panel2.add(txtApellido2,constraints);

		//=========================================================================
		//																							Campo N° CC
		//=========================================================================

			JLabel etiCc = new JLabel("N° CC: ");
			etiCc.setForeground(new Color(0,164,255));
			etiCc.setFont(new Font("SansSerif",3,12));

			constraints.gridx = 0;
			constraints.gridy = 5;
			constraints.insets = new Insets(20,30,0,10);
			panel2.add(etiCc,constraints);

			txtCc= new JTextField(20);
			txtCc.setForeground(new Color(0,164,255));
			txtCc.setFont(new Font("SansSerif",3,12));

			constraints.gridx = 1;
			constraints.insets = new Insets(20,10,10,30);
			panel2.add(txtCc,constraints);

			JScrollPane scroll = new JScrollPane(panel2);
			scroll.setBackground(new Color(27,38,49));
			scroll.setBounds(0,50,570,310);
			scroll.setBorder(BorderFactory.createLineBorder(new Color(27,38,49)));
//=========================================================================

		JButton	btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(19,28,51));
		btnGuardar.setForeground(new Color(0,164,255));
		btnGuardar.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
		btnGuardar.setBorder(new RoundedBorder(15));
		btnGuardar.setBounds(430,10,120,25);

			btnGuardar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					guardarEmpledos(evt);
				}
			});

			panel1.add(btnGuardar);
			this.removeAll();
			this.updateUI();
			this.add(panel1);
			this.add(panelCabecera);
			this.add(scroll);
		}

	public void guardarEmpledos(ActionEvent evt) {

		try{

			var codigo = Integer.parseInt(txtCodigo.getText());
			int cc = Integer.parseInt(txtCc.getText());

			//=======================================
			/*Si los campos estan vacios 											|
				* no entra a al condicional  								 	|
				* para evitar campos vacios 											|
				*///====================================

			if(!("".equals(txtCodigo) || 	"".equals(txtNombre1) ||
				"".equals(txtApellido1) || "".equals(txtApellido2) ||
				"".equals(txtCc) || "".equals(txtPostal))) {

				var consulta = "INSERT INTO empleados" +
					"(codigo,nombre1,nombre2,apellido1,apellido2,cc) " +
					"VALUES(?,?,?,?,?,?)";

				Conector objConec = new Conector();
				PreparedStatement prepared = null;

				try {
					Connection conec = objConec.getConexion();
					prepared = conec.prepareStatement(consulta);

					prepared.setInt(1,codigo); //1
					prepared.setString(2,txtNombre1.getText()); //5
					prepared.setString(3,txtNombre2.getText()); //6
					prepared.setString(4,txtApellido1.getText()); // 7
					prepared.setString(5,txtApellido2.getText());//8
					prepared.setInt(6,cc);//9
					prepared.executeUpdate();//Actualizar DB (Maria DB)

					limpiarEmpleados();

					this.removeAll();
					this.updateUI();

					JLabel img = new JLabel(new ImageIcon(getClass().getResource("/iconMax/formulario.png")));
					img.setBounds(140, 50, 130, 130);

					JLabel mensaje = new JLabel("Se guardo con exito",JLabel.CENTER);
					mensaje.setForeground(new Color(0,164,255));
					mensaje.setFont(new Font("SansSerif",3,14));
					mensaje.setBounds(120,190,280,40);

					this.add(mensaje);
					this.add(img);

				} catch (SQLException e) {

					limpiarEmpleados();
					this.removeAll();
					this.updateUI();

					JLabel img = new JLabel(new ImageIcon(getClass().getResource("/iconMax/error.png")));
					img.setBounds(140, 50, 260, 260);

					JLabel mensaje = new JLabel("Algunos Valores no son admitidos",JLabel.CENTER);
					mensaje.setForeground(new Color(255,21,82));
					mensaje.setFont(new Font("SansSerif",3,14));
					mensaje.setBounds(120,310,280,40);

					this.add(mensaje);
					this.add(img);

					e.printStackTrace();

				}
			}else{
				limpiarEmpleados();
				JOptionPane.showMessageDialog(null,"Hay campos Vacios","...",JOptionPane.WARNING_MESSAGE);

			}
		}catch(NumberFormatException e){
			limpiarEmpleados();
			this.removeAll();
			this.updateUI();

			JLabel img = new JLabel(new ImageIcon(getClass().getResource("/iconMax/error.png")));
			img.setBounds(140, 50, 260, 260);

			JLabel mensaje = new JLabel("Algunos campos estan vacios ",JLabel.CENTER);
			mensaje.setForeground(new Color(255,21,82));
			mensaje.setFont(new Font("SansSerif",3,14));
			mensaje.setBounds(120,310,280,40);

			this.add(mensaje);
			this.add(img);

		}
	}

	public void limpiarEmpleados() {

		txtCc.setText("");
		txtNombre1.setText("");
		txtNombre2.setText("");
		txtApellido1.setText("");
		txtApellido2.setText("");
		txtCodigo.setText("");

	}

	public JPanel getSucursales(){

return this;
}

}
