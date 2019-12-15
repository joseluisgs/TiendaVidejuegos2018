/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendavideojuegos;

import Ventanas.VentanaLogin;
import java.util.logging.Level;
import java.util.logging.Logger;
import productos.Juego;
import socios.Socio;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import utilidades.Utilidad;

/**
 *
 * @author link
 */
public class TiendaVideojuegos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Cambiamos el aspecto gráfico
        //cambiarLookAndFeel();
        //Forzamos el recolector de basura
        System.gc();
        
        
        //VentanaPrincipal tienda = VentanaPrincipal.nuevaVentana();
        VentanaLogin login = new VentanaLogin();

        
        
    }
    
    private static void cambiarLookAndFeel(){
        // Cambiamos look & Feel
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.mac.MacLookAndFeel");
             } catch (ClassNotFoundException ex) {
            Logger.getLogger(TiendaVideojuegos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TiendaVideojuegos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TiendaVideojuegos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TiendaVideojuegos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
