/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendavideojuegos;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import socios.Socio;

/**
 *
 * @author joseluisgs
 */
public class TablaSociosModel extends DefaultTableModel {

    
    public TablaSociosModel() {

        // Añadimos Cabecera
        this.addColumn("NSocio");
        this.addColumn("Nombre");
        this.addColumn("E-Mail");
        //this.addColumn("Contraseña"); // No voy a mostrar la contraseña
        this.addColumn("Telefono");
        this.addColumn("Fecha");
        this.addColumn("Foto");
 
    }
    
    public TablaSociosModel(String[] columnas) {
        this.setColumnIdentifiers(columnas);
    }
    public void setFila(ArrayList<Socio> filaAlumnos){
        // Añadimos Filas
        if(filaAlumnos!=null) {
            for(Socio a: filaAlumnos) {
                Vector v = new Vector();
                v.add(a.getCodigo());
                v.add(a.getNombre());
                v.add(a.getCorreo());
                //v.add(a.getPassword());
                v.add(a.getTelefono());
                v.add(a.getFecha());
                v.add(a.getFoto());
                this.addRow(v);

            }
        }
    }
   
    
      @Override
        public boolean isCellEditable(int row, int column){
            // make read only fields except column 0,13,14
            //return column == 0 || column == 13 || column == 14;
            return false;
    }
        

}
