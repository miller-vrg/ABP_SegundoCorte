package tablas;

	import datos.Conector;

	import javax.swing.*;
	import javax.swing.table.DefaultTableModel;
	import java.awt.*;
	import java.sql.*;

/**
	*
	* @author
	* Saray Lopez tobinson
	* Miler Vargas Mola
	*/

public class TablaEmpleados extends JTable {

	//==============================================
	//									Quitar la edición de la tabla
	//==============================================

	DefaultTableModel modelo = new DefaultTableModel(){
		@Override
		public boolean isCellEditable(int row, int column){

			return false;
		}

	};

	public TablaEmpleados() {

	}

	public TablaEmpleados(String consulta){

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

			modelo.addColumn("N°");//1
			modelo.addColumn("Codigo");//2
			modelo.addColumn("Nombre1");//3
			modelo.addColumn("Nombre2");//4
			modelo.addColumn("Apellido1");//5
			modelo.addColumn("Apellido2 ");//6
			modelo.addColumn("CC#");//7


			this.setModel(modelo);

			             //{ 1   2   3   4   5   6  7 }
			int[] anchos = {50,60,100,100,100,100,110};

			for(int x = 0; x < 7; x++){

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

			for(int i = 0; i < 40; i++){

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

	public JTable verRegistroEmpleados(){
		this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		return this;
	}

}



