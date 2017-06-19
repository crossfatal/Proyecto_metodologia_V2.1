/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static BaseDeDatos.Conexion.getConnection;
import static BaseDeDatos.Conexion.stmt;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carl
 */
public class Administrador {

    DefaultTableModel modelo;

  /*  public void inicarAdministrador() {

        VistaResidente(adm.TablaResidente, "");

    }
    */

    public void VistaResidente(JTable tablaD) {
        Connection con = getConnection();

        DefaultTableModel modo = new DefaultTableModel();
        String Sql;
        /*String St;
        if (St.equals("")){
            
           Sql="SELECT * FROM stock";
            } else {
                
              Sql="SELECT * FROM stock WHERE id_stock='"+St+"'";
            }
*/
        try {
            Sql = "select*from residente;";

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            String[] fila = new String[7];
            String[] titulos = {"Rut", "Nombre", "Apellido_M", "Apellido_P", "Sexo", "Tiempo_R", "Observación"};
            modelo = new DefaultTableModel(null, titulos);
            while (rs.next()) {

                fila[0] = rs.getString("rut");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("apellido_m");
                fila[3] = rs.getString("apellido_p");
                fila[4] = rs.getString("sexo");
                fila[5] = rs.getString("tiempo_r");
                fila[6] = rs.getString("observacion");
                modelo.addRow(fila);

            }

            stmt.close();
            con.close();
            tablaD.setModel(modelo);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "ALERTA: Hubo un error desconocido");
            System.err.println("SQLException: " + err.getMessage());
            System.exit(0);

        }

    }
}
