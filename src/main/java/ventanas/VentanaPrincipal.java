
package ventanas;

import baseDatos.DatosEmpleados;
import baseDatos.DatosOrganizacion;
import baseDatos.DatosPersonas;
import baseDatos.DatosSucursales;
import metodo.RoundedBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
	*
	* @authores
	* saray lopez tobinson
	* Miler vargas mola
	*
	*/

public class VentanaPrincipal extends JFrame{


	private JButton btnRegistrar;
	private JButton btnRegistro;
	private JButton btnSucursales;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private JButton btnInicio;
	private JButton btnBuscar;
	private JButton btnRefres;
	private JTextField campoBuscar;
	private JProgressBar progreso;
	private JPanel panel1;
	private JPanel panel2;
	private JLabel reloj;
	private JLabel bienvenido;
	private JLabel mensaje;
	private int hora,minuto,segundos;
	private int dia,year,mes;
	private Date fecha;
	private ImageIcon imgInicio1;
	private JLabel imgInicio2;
	private boolean verificacion;
	private int aumento;
	private JLabel error;
	private JLabel mensajeError;
	private JRadioButton checkOrganizacion;
	private JRadioButton checkPersonas;

	Sucursales registro = new Sucursales();
	RegistroPersonas personas = new RegistroPersonas();
	RegistroOrganizacion organizacion = new RegistroOrganizacion();

	public VentanaPrincipal(){

		this.getContentPane().setLayout(null);
		this.setSize(730,400);
		this.getContentPane().setBackground(new Color(19,28,51));
		this.setTitle("Bienvenido");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		aumento = 35;
		verificacion = true;
		agregar();

		reloj = new JLabel("" + getHora() + ":" + getMinuto());
		reloj.setHorizontalAlignment(JLabel.CENTER);
		reloj.setFont(new Font("SansSerif",3,18));
		reloj.setForeground(new Color(0,164,255));
		reloj.setBounds(20,50,120,30);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(19,28,51));
		btnRegistrar.setFont(new Font("SansSerif",3,14));
		btnRegistrar.setForeground(new Color(0,164,255));
		btnRegistrar.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
		btnRegistrar.setBounds(20,130,120,30);
		btnRegistrar.setBorder(new RoundedBorder(15));

		btnRegistro = new JButton("Registros");
		btnRegistro.setBorder(new RoundedBorder(15));
		btnRegistro.setBackground(new Color(19,28,51));
		btnRegistro.setFont(new Font("SansSerif",3,14));
		btnRegistro.setForeground(new Color(0,164,255));
		btnRegistro.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
		btnRegistro.setBounds(20,190,120,30);
		btnRegistro.setBorder(new RoundedBorder(15));

		btnSucursales = new JButton("Sucursales");
		btnSucursales.setBorder(new RoundedBorder(15));
		btnSucursales.setBackground(new Color(19,28,51));
		btnSucursales.setFont(new Font("SansSerif",Font.ITALIC,14));
		btnSucursales.setForeground(new Color(0,164,255));
		btnSucursales.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
		btnSucursales.setBounds(20,250,120,30);
		btnSucursales.setBorder(new RoundedBorder(15));

		btnInicio = new JButton("Inicio");
		btnInicio.setBorder(new RoundedBorder(15));
		btnInicio.setBackground(new Color(19,28,51));
		btnInicio.setFont(new Font("SansSerif",Font.ITALIC,14));
		btnInicio.setForeground(new Color(0,164,255));
		btnInicio.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
		btnInicio.setBounds(20,310,120,30);
		btnInicio.setBorder(new RoundedBorder(15));

		panel1 = new JPanel();
		panel1.setBackground(new Color(19,28,51));
		panel1.setBounds(0,0,160,400);
		panel1.setLayout(null);
		panel1.add(reloj);
		panel1.add(btnRegistrar);
		panel1.add(btnRegistro);
		panel1.add(btnSucursales);

		imgInicio2 = new JLabel(new ImageIcon(getClass().getResource("/iconMax/inicio.png")));
		imgInicio2.setBounds(300,180,256,200);

		bienvenido = new JLabel("Bienvenido");
		bienvenido.setHorizontalAlignment(JLabel.CENTER);
		bienvenido.setFont(new Font("FreeMono",3,50));
		bienvenido.setForeground(new Color(0,164,255));
		bienvenido.setBounds(90,100,320,80);

		mensaje = new JLabel("En que podemos ayudarte hoy");
		mensaje.setHorizontalAlignment(JLabel.CENTER);
		mensaje.setFont(new Font("FreeMono",3,15));
		mensaje.setForeground(new Color(0,164,255));
		mensaje.setBounds(120,157,280,30);

		panel2 = new JPanel();
		panel2.setBackground(new Color(27,38,49));
		panel2.setBounds(160,0,570,400);
		panel2.setLayout(null);
		panel2.add(bienvenido);
		panel2.add(imgInicio2);
		panel2.add(mensaje);

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBorder(new RoundedBorder(15));
		btnSiguiente.setBackground(new Color(27,38,49));
		btnSiguiente.setFont(new Font("SansSerif",Font.ITALIC,14));
		btnSiguiente.setForeground(new Color(0,164,255));
		btnSiguiente.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
		btnSiguiente.setBounds(440,330,120,25);
		btnSiguiente.setBorder(new RoundedBorder(15));

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new RoundedBorder(15));
		btnCancelar.setBackground(new Color(27,38,49));
		btnCancelar.setFont(new Font("SansSerif",Font.ITALIC,14));
		btnCancelar.setForeground(new Color(0,164,255));
		btnCancelar.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
		btnCancelar.setBounds(20,330,120,25);
		btnCancelar.setBorder(new RoundedBorder(15));

		progreso = new JProgressBar();
		progreso.setValue(35);
		progreso.setBackground(new Color(27,38,49));
		progreso.setForeground(new Color(0,164,255));
		progreso.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
		progreso.setBounds(166,347,250,5);

//===================================================
//                  Accion de registrar
//===================================================


		btnRegistrar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evt){

				setAumento(35);
				getProgreso().setValue(getAumento());
				btnSiguiente.setText((getAumento() == 35 )? "Siguiente":"Guardar");
				ventanaRegistro();

				setSize(730,400);
				setLocationRelativeTo(null);

			}
		});

//===================================================
//                  Accion de registros
//===================================================

		btnRegistro.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evt) {

				panel1.removeAll();
				panel1.updateUI();

				setSize(730,400);
				setLocationRelativeTo(null);

				panel1.setBounds(0, 0, 160, 400);
				panel1.add(btnInicio);
				panel1.add(reloj);
				panel1.add(btnSucursales);
				panel1.add(btnRegistro);
				panel1.add(btnRegistrar);

				panel2.removeAll();
				panel2.updateUI();

				JLabel titulo = new JLabel("Registros",JLabel.CENTER);
				titulo.setForeground(new Color(0,164,255));
				titulo.setFont(new Font("SansSerif",3,18));

				JPanel cabecera = new JPanel(new FlowLayout());
				cabecera.setBackground(new Color(19,28,51));
				cabecera.add(titulo);
				cabecera.setBounds(0,0,570,40);
				panel2.add(cabecera);

				//======================================================
				//															botón de Organización
				//======================================================

				JButton btnOrganizacion = new JButton(new ImageIcon(getClass().getResource("/iconMax/organi.png")));
				btnOrganizacion.setBackground(new Color(27,38,49));
				btnOrganizacion.setBounds(80,110,65,65);
				btnOrganizacion.setBorder((BorderFactory.createLineBorder(new Color(27,38,49))));
				panel2.add(btnOrganizacion);

				JLabel mensaje1 = new JLabel("C. Organizaciones");
				mensaje1.setFont(new Font("SansSerif",2,12));
				mensaje1.setForeground(new Color(0,164,255));
				mensaje1.setBounds(60,180,190,30);
				panel2.add(mensaje1);

				//======================================================
				//															botón de sucursal
				//======================================================

				JButton btnSucur = new JButton(new ImageIcon(getClass().getResource("/iconMax/minSucur.png")));
				btnSucur.setBackground(new Color(27,38,49));
				btnSucur.setBounds(270,110,65,65);
				btnSucur.setBorder((BorderFactory.createLineBorder(new Color(27,38,49))));
				panel2.add(btnSucur);

				JLabel mensaje2 = new JLabel("R. Sucursales");
				mensaje2.setFont(new Font("SansSerif",2,12));
				mensaje2.setForeground(new Color(0,164,255));
				mensaje2.setBounds(260,180,190,30);
				panel2.add(mensaje2);

				//======================================================
				//															botón de Ahorro
				//======================================================

				JButton btnAhorro = new JButton(new ImageIcon(getClass().getResource("/iconMax/bntAhorro.png")));
				btnAhorro.setBackground(new Color(27,38,49));
				btnAhorro.setBounds(80,240,65,65);
				btnAhorro.setBorder((BorderFactory.createLineBorder(new Color(27,38,49))));
				panel2.add(btnAhorro);

				JLabel mensaje3 = new JLabel("Amortizacion");
				mensaje3.setFont(new Font("SansSerif",2,12));
				mensaje3.setForeground(new Color(0,164,255));
				mensaje3.setBounds(70,310,190,30);
				panel2.add(mensaje3);

				//======================================================
				//							botón de Cuenta corriente y cliente
				//======================================================

				JButton btnCuentas = new JButton(new ImageIcon(getClass().getResource("/iconMax/clienCorrien.png")));
				btnCuentas.setBackground(new Color(27,38,49));
				btnCuentas.setBounds(270,240,65,65);
				btnCuentas.setBorder((BorderFactory.createLineBorder(new Color(27,38,49))));
				panel2.add(btnCuentas);

				JLabel mensaje4 = new JLabel("Cuentas");
				mensaje4.setFont(new Font("SansSerif",2,12));
				mensaje4.setForeground(new Color(0,164,255));
				mensaje4.setBounds(270,310,210,30);
				panel2.add(mensaje4);

				//============================
				//							botón de Empleados		|
				//============================

				JButton btnEmple = new JButton(new ImageIcon(getClass().getResource("/iconMax/empleados.png")));
				btnEmple.setBackground(new Color(27,38,49));
				btnEmple.setBounds(418,120,128,128);
				btnEmple.setBorder((BorderFactory.createLineBorder(new Color(27,38,49))));
				panel2.add(btnEmple);

				JLabel mensaje5 = new JLabel("Empleados");
				mensaje5.setFont(new Font("SansSerif",2,12));
				mensaje5.setForeground(new Color(0,164,255));
				mensaje5.setBounds(430,250,210,30);
				panel2.add(mensaje5);

				panel2.setBounds(160,0,570,400);

				//panel2.add(venRegistro.getVentanaRegistro());

				//=====================================================
				//											Boton Organizacion
				//=====================================================

				btnOrganizacion.addActionListener(new ActionListener(){
					@Override
					public  void actionPerformed(ActionEvent evt){

						panel1.removeAll();
						panel1.updateUI();

						panel1.setBounds(0, 0, 160, 400);
						panel1.add(btnInicio);
						panel1.add(reloj);
						panel1.add(btnSucursales);
						panel1.add(btnRegistro);
						panel1.add(btnRegistrar);

						panel2.removeAll();
						panel2.updateUI();
						panel2.setBounds(160,0,1200,400);
						setSize(1260,400);
						setLocationRelativeTo(null);
						panel2.setBounds(160,0,1200,400);
						DatosOrganizacion inicia = new DatosOrganizacion();
						panel2.add(inicia.getDatosOrganizacion());

					}
				});

				//=====================================================
				//																Boton Cuentas
				//=====================================================

				btnCuentas.addActionListener(new ActionListener(){
					@Override
					public  void actionPerformed(ActionEvent evt){

						panel1.removeAll();
						panel1.updateUI();

						panel1.setBounds(0, 0, 160, 400);
						panel1.add(btnInicio);
						panel1.add(reloj);
						panel1.add(btnSucursales);
						panel1.add(btnRegistro);
						panel1.add(btnRegistrar);

						panel2.removeAll();
						panel2.updateUI();
						panel2.setBounds(160,0,1200,400);
						setSize(1260,400);
						setLocationRelativeTo(null);
						panel2.setBounds(160,0,1200,400);
						DatosPersonas inicia = new DatosPersonas();
						panel2.add(inicia.getDatosOrganizacion());

					}
				});

				//=====================================================
				//											Boton Amortizacion
				//=====================================================

				btnAhorro.addActionListener(new ActionListener(){
					@Override
					public  void actionPerformed(ActionEvent evt){
						panel1.removeAll();
						panel1.updateUI();

						panel1.setBounds(0, 0, 160, 400);
						panel1.add(btnInicio);
						panel1.add(reloj);
						panel1.add(btnSucursales);
						panel1.add(btnRegistro);
						panel1.add(btnRegistrar);

						panel2.removeAll();
						panel2.updateUI();
						panel2.setBounds(160,0,570,400);
						setSize(820,400);
						setLocationRelativeTo(null);
						panel2.setBounds(160,0,690,400);
						VentanaAmortizacion inicia = new VentanaAmortizacion();
						panel2.add(inicia.getAmortizacion());

					}
				});


				//===================================================
				//                  Accion de Sucursales
				//===================================================

				btnSucur.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent evt){
						panel1.removeAll();
						panel1.updateUI();

						panel1.setBounds(0, 0, 160, 400);
						panel1.add(btnInicio);
						panel1.add(reloj);
						panel1.add(btnSucursales);
						panel1.add(btnRegistro);
						panel1.add(btnRegistrar);

						panel2.removeAll();
						panel2.updateUI();
						panel2.setBounds(160,0,1200,400);
						setSize(1110,400);
						setLocationRelativeTo(null);

						DatosSucursales inicia = new DatosSucursales();
						panel2.add(inicia.getDatosSucursales());

					}
				});

				//===================================================
				//                  Accion de Empleados
		//===================================================

				btnEmple.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent evt){
						panel1.removeAll();
						panel1.updateUI();

						panel1.setBounds(0, 0, 160, 400);
						panel1.add(btnInicio);
						panel1.add(reloj);
						panel1.add(btnSucursales);
						panel1.add(btnRegistro);
						panel1.add(btnRegistrar);

						panel2.removeAll();
						panel2.updateUI();
						panel2.setBounds(160,0,640,400);
						setSize(805,400);
						setLocationRelativeTo(null);

						DatosEmpleados inicia = new DatosEmpleados();
						panel2.add(inicia.getDatosEmpleados());

					}
				});

			}
		});

//===================================================
//                  Accion de Sucursales
//===================================================

		btnSucursales.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evt){
				panel1.removeAll();
				panel1.updateUI();

				panel1.setBounds(0, 0, 160, 400);
				panel1.add(btnInicio);
				panel1.add(reloj);
				panel1.add(btnSucursales);
				panel1.add(btnRegistro);
				panel1.add(btnRegistrar);

				panel2.removeAll();
				panel2.updateUI();
				panel2.setBounds(160,0,570,400);
				setSize(730,400);
				setLocationRelativeTo(null);
				ventanaSucursal();

			}
		});

//===================================================
//             Accion de boton Inicio
// ===================================================

		btnInicio.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evt){

				setSize(730,400);
				setLocationRelativeTo(null);

				getPanel1().removeAll();
				getPanel1().repaint();

				getPanel1().add(getReloj());
				getPanel1().add(getBtnRegistrar());
				getPanel1().add(getBtnClientes());
				getPanel1().add(getbtnSucursales());

				getPanel2().removeAll();
				getPanel2().repaint();

				getPanel2().add(getBienvenido());
				getPanel2().add(getImgInicio2());
				getPanel2().add(getMensaje());

				setAumento(35);
				getProgreso().setValue(getAumento());
				setSize(730,400);
				setLocationRelativeTo(null);
			}
		});

//===================================================
//                Accion de siguiente
//===================================================

		btnSiguiente.addActionListener(new ActionListener(){


			@Override
			public void actionPerformed(ActionEvent evt) {

//veri = (getAumento() >= 100)?true:veri;

				setAumento((getAumento() >= 100) ? 35 : getAumento() + 35);

				RegistroPersonas per = new RegistroPersonas();
				RegistroOrganizacion org = new RegistroOrganizacion();

				getProgreso().setValue(getAumento());

				btnSiguiente.setText((getAumento() == 35) ? "Siguiente" : "Terminar");

					ventanaRegistro();

			}
		});

//===================================================
//                Accion de Cancelar
//===================================================

		btnCancelar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evt){

				setSize(730,400);

				setAumento(35);
				getProgreso().setValue(getAumento());
				btnSiguiente.setText((getAumento() == 35 )? "Siguiente":"Guardar");
				ventanaRegistro();

			}
		});

		this.getContentPane().add(panel1);
		this.getContentPane().add(panel2);

		this.setSize(730,400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);

		do {

			agregar();

			reloj.setText((segundos % 2 == 0)? "" + hora + ":" + minuto + ":" + segundos : "" + hora + " " + minuto + " " + segundos );

			try {

				Thread.sleep(1000);

			} catch (InterruptedException e) {

			}

		}while(verificacion == true);

	}

	public void ventanaSucursal() {

		setSize(730,400);
		setLocationRelativeTo(null);

		getPanel1().removeAll();
		getPanel1().repaint();

		getPanel1().add(getReloj());
		getPanel1().add(getBtnRegistrar());
		getPanel1().add(getBtnClientes());
		getPanel1().add(getBtnInicio());
		getPanel1().add(getbtnSucursales());

		panel2.removeAll();
		panel2.updateUI();

		Sucursales ver = new Sucursales();
		panel2.add(ver.getSucursales());

	}

	public  void ventanaRegistro(){

		int casos = 1;

		casos = (aumento == 35)? 1 : casos;
		casos = (aumento > 35 && aumento < 71 )? 2 : casos;
		casos = (aumento > 70 && aumento < 110)? 3 : casos;


		switch(casos){

			case 1:{

				try{

					JLabel etiPregunta = new JLabel("¿Es una organización  o una persona?");
					etiPregunta.setHorizontalAlignment(JLabel.CENTER);
					etiPregunta.setBackground(new Color(27,38,49));
					etiPregunta.setFont(new Font("SansSerif",Font.ITALIC,14));
					etiPregunta.setForeground(new Color(0,164,255));
					etiPregunta.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
					etiPregunta.setBounds(100,70,350,30);
					etiPregunta.setBorder(new RoundedBorder(15));

					checkOrganizacion = new JRadioButton("Organizacion");
					checkOrganizacion.setBorder(new RoundedBorder(15));
					checkOrganizacion.setBackground(new Color(27,38,49));
					checkOrganizacion.setFont(new Font("SansSerif",Font.ITALIC,14));
					checkOrganizacion.setForeground(new Color(0,164,255));
					checkOrganizacion.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
					checkOrganizacion.setBounds(166,150,200,25);
					checkOrganizacion.setBorder(new RoundedBorder(15));
					checkOrganizacion.setSelected(true);

					checkPersonas = new JRadioButton("Persona");
					checkPersonas.setBorder(new RoundedBorder(15));
					checkPersonas.setBackground(new Color(27,38,49));
					checkPersonas.setForeground(new Color(0,164,255));
					checkPersonas.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
					checkPersonas.setBounds(166,200,200,25);
					checkPersonas.setBorder(new RoundedBorder(15));

					ButtonGroup pare = new ButtonGroup();
					pare.add(checkOrganizacion);
					pare.add(checkPersonas);

					panel1.removeAll();
					panel1.repaint();

					panel1.add(btnInicio);
					panel1.add(reloj);
					panel1.add(btnSucursales);
					panel1.add(btnRegistro);
					panel1.add(btnRegistrar);

					panel2.removeAll();
					panel2.repaint();

					panel2.add(etiPregunta);
					panel2.add(checkOrganizacion);
					panel2.add(checkPersonas);
					panel2.add(progreso);
					panel2.add(btnSiguiente);
					panel2.add(btnCancelar);


				}catch(Exception e){

					error = new JLabel(new ImageIcon("/iconMax/error.png"));
					error.setBounds(200,20,200,200);

					mensajeError = new JLabel("Error inesperado!");
					mensajeError.setHorizontalAlignment(JLabel.CENTER);
					mensajeError.setFont(new Font("FreeMono",3,14));
					mensajeError.setForeground(new Color(224,8,10));
					mensajeError.setBorder(BorderFactory.createLineBorder(new Color(224,8,10)));
					mensajeError.setBounds(70,220,440,40);
					mensajeError.setBorder(new RoundedBorder(15));


					panel1.removeAll();
					panel1.repaint();

					panel1.add(btnInicio);
					panel1.add(reloj);
					panel1.add(btnSucursales);
					panel1.add(btnRegistro);
					panel1.add(btnRegistrar);

					panel2.removeAll();
					panel2.repaint();

					panel2.add(error);
					panel2.add(mensajeError);

				}

			}break;


//========================================================
//          Pregunta es cliente o empleado

			case 2:{


				JScrollPane scroll = new JScrollPane();
				scroll.setBackground(new Color(27,38,49));
				scroll.setBounds(40,15,520,310);
				scroll.setBorder(BorderFactory.createLineBorder(new Color(27,38,49)));


				if(checkPersonas.isSelected()){

//veri = true;

					scroll.setViewportView(personas.iniciaRegistroPersona(this.dia,this.mes,this.year,this.btnSiguiente,this.btnCancelar,this.progreso,this.aumento));

					ImageIcon icon = new ImageIcon(getClass().getResource("/iconMin/persona.png"));

					JLabel ima = new JLabel();
					ima.setIcon(icon);
					ima.setToolTipText("Persona");
					ima.setBounds(3,10,40,40);

					panel1.removeAll();
					panel1.repaint();

					panel1.add(btnInicio);
					panel1.add(reloj);
					panel1.add(btnSucursales);
					panel1.add(btnRegistro);
					panel1.add(btnRegistrar);

					panel2.removeAll();
					panel2.repaint();

					panel2.add(ima);
					panel2.add(scroll);
					panel2.add(btnCancelar);
					panel2.add(btnSiguiente);
					panel2.add(progreso);

				}

				if(checkOrganizacion.isSelected()) {

//  veri = true;
					scroll.setViewportView(organizacion.iniciaRegistroOrganizacion(this.dia,this.mes,this.year,this.btnSiguiente,this.btnCancelar,this.progreso,this.aumento));

					ImageIcon icon = new ImageIcon(getClass().getResource("/iconMin/organizacion.png"));

					JLabel ima = new JLabel();
					ima.setIcon(icon);
					ima.setToolTipText("Organización");
					ima.setBounds(3,10,40,40);

					panel1.removeAll();
					panel1.repaint();

					panel1.add(btnInicio);
					panel1.add(reloj);
					panel1.add(btnSucursales);
					panel1.add(btnRegistro);
					panel1.add(btnRegistrar);

					panel2.removeAll();
					panel2.repaint();

					panel2.add(scroll);
					panel2.add(ima);
					panel2.add(btnCancelar);
					panel2.add(btnSiguiente);
					panel2.add(progreso);

				}

			}break;

			case 3:{

				try {

					ImageIcon formulario = new ImageIcon(getClass().getResource("/iconMax/formulario.png"));

					JLabel ima = new JLabel();
					ima.setIcon(formulario);
					ima.setBounds(180,10,260,260);

					JLabel finRegistro = new JLabel("Registro Finalizado");
					finRegistro.setHorizontalAlignment(JLabel.CENTER);
					finRegistro.setFont(new Font("FreeMono",3,14));
					finRegistro.setForeground(new Color(0,164,255));
					finRegistro.setBorder(BorderFactory.createLineBorder(new Color(0,164,255)));
					finRegistro.setBounds(200,280,220,40);
					finRegistro.setBorder(new RoundedBorder(15));

					panel1.add(btnInicio);
					panel2.removeAll();
					panel2.repaint();

					panel2.add(ima);
					panel2.add(finRegistro);


				} catch (Exception e) {

				}
			}break;

		}
	}
	public  void agregar(){
		int dia,mes,year,hora,minuto,segundos;

		this.setFecha(new Date());

		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd");
		dia = Integer.parseInt(formatoFecha.format(getFecha()));

		SimpleDateFormat formatoMes = new SimpleDateFormat("MM");
		mes = Integer.parseInt(formatoMes.format(getFecha()));

		SimpleDateFormat formatoYear = new SimpleDateFormat("yyyy");
		year = Integer.parseInt(formatoYear.format(getFecha()));

		SimpleDateFormat formatoHora = new SimpleDateFormat("hh");
		hora = Integer.parseInt(formatoHora.format(getFecha()));

		SimpleDateFormat formatoMinuto = new SimpleDateFormat("mm");
		minuto = Integer.parseInt(formatoMinuto.format(getFecha()));

		SimpleDateFormat formatoSegundos = new SimpleDateFormat("ss");
		segundos = Integer.parseInt(formatoSegundos.format(getFecha()));

		this.setDia(dia);
		this.setMes(mes);
		this.setYear(year);
		this.setHora(hora);
		this.setMinuto(minuto);
		this.setSegundos(segundos);

		//System.out.println("dia: " + dia + "- mes: " + mes + " - año: " + anyo );

	}//fin asignar fecha


	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public JButton getBtnClientes() {
		return btnRegistro;
	}


	public void setBtnClientes(JButton btnClientes) {
		this.btnRegistro = btnClientes;
	}


	public JButton getbtnSucursales() {
		return btnSucursales;
	}


	public void setbtnSucursales(JButton btnSucursales) {
		this.btnSucursales = btnSucursales;
	}


	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}


	public void setBtnSiguiente(JButton btnSiguiente) {
		this.btnSiguiente = btnSiguiente;
	}


	public JButton getBtnCancelar() {
		return btnCancelar;
	}


	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}


	public JButton getBtnInicio() {
		return btnInicio;
	}


	public void setBtnInicio(JButton btnInicio) {
		this.btnInicio = btnInicio;
	}

	public JProgressBar getProgreso() {
		return progreso;
	}

	public void setProgreso(JProgressBar progreso) {
		this.progreso = progreso;
	}

	public JPanel getPanel1() {
		return panel1;
	}

	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}

	public JPanel getPanel2() {
		return panel2;
	}

	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}

	public JLabel getReloj() {
		return reloj;
	}

	public void setReloj(JLabel reloj) {
		this.reloj = reloj;
	}

	public JLabel getBienvenido() {
		return bienvenido;
	}

	public void setBienvenido(JLabel bienvenido) {
		this.bienvenido = bienvenido;
	}

	public JLabel getMensaje() {
		return mensaje;
	}

	public void setMensaje(JLabel mensaje) {
		this.mensaje = mensaje;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ImageIcon getImgInicio1() {
		return imgInicio1;
	}

	public void setImgInicio1(ImageIcon imgInicio1) {
		this.imgInicio1 = imgInicio1;
	}

	public JLabel getImgInicio2() {
		return imgInicio2;
	}

	public void setImgInicio2(JLabel imgInicio2) {
		this.imgInicio2 = imgInicio2;
	}

	public boolean isVerificacion() {
		return verificacion;
	}

	public void setVerificacion(boolean verificacion) {
		this.verificacion = verificacion;
	}

	public int getAumento() {
		return aumento;
	}

	public void setAumento(int aumento) {
		this.aumento = aumento;
	}

	public void limpiarPanel2(){

		this.panel2.removeAll(); //Limpiar
		this.panel2.repaint(); //reformar

	}

	public void mostrar(JLabel etiPregunta, JRadioButton botonRadio1, JRadioButton botonRadio2) {


		panel2.add(btnSiguiente);
		panel2.add(progreso);
		panel2.add(etiPregunta);
		panel2.add(botonRadio1);
		panel2.add(botonRadio2);
		this.add(panel2);
	}
}
