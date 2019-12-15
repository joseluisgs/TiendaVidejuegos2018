/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendavideojuegos;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import productos.Juego;
import socios.Socio;

/**
 *
 * @author joseluisgs
 */
public class TablaJuegosModel extends DefaultTableModel {

    
    public TablaJuegosModel() {

        // Añadimos Cabecera
        this.addColumn("NJuego");
        this.addColumn("Nombre");
        this.addColumn("Distribuidor");
        this.addColumn("Precio");
        this.addColumn("Fecha");
        this.addColumn("Foto");
 
    }
    
    public TablaJuegosModel(String[] columnas) {
        this.setColumnIdentifiers(columnas);
    }
    public void setFila(ArrayList<Juego> filaJuegos){
        // Añadimos Filas
        if(filaJuegos!=null) {
            for(Juego a: filaJuegos) {
                Vector v = new Vector();
                v.add(a.getCodigo());
                v.add(a.getNombre());
                v.add(a.getDistribuidor());
                v.add(a.getPrecio());
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
