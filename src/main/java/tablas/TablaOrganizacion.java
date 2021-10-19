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

public class TablaOrganizacion extends JTable{

	//==============================================
	//									Quitar la edición de la tabla
	//==============================================

	DefaultTableModel modelo = new DefaultTableModel(){
		@Override
		public boolean isCellEditable(int row, int column){

			return false;
		}

	};

	public TablaOrganizacion() {

	}

	public TablaOrganizacion(String consulta){

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

			modelo.addColumn("N° Cuenta");//1
			modelo.addColumn("Organización");//2
			modelo.addColumn("Dirección");//3
			modelo.addColumn("Tipo org");//4
			modelo.addColumn("Tipo Cuenta");//5
			modelo.addColumn("Oficina");//6
			modelo.addColumn("Codigo");//7
			modelo.addColumn("Representante");//8
			modelo.addColumn("Apellido1");//9
			modelo.addColumn("Apellido2");//10
			modelo.addColumn("CC#");//11
			modelo.addColumn("No empleado");//12
			modelo.addColumn("Apellido1");//13
			modelo.addColumn("Apellido2 ");//14
			modelo.addColumn("CC#");//15
			modelo.addColumn("Fondo");//16
			modelo.addColumn("Tiempo");//17

			this.setModel(modelo);

			             //{ 1   2   3   4  5  6  7  8   9  10  11  12  13  14  15  16  17}
			int[] anchos = {100,100,100,90,90,90,50,120,100,100,100,120,100,100,100,150,50};

			for(int x = 0; x < 17; x++){

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

			for(int i = 0; i < 20; i++){

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
		this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		return this;
	}

}

