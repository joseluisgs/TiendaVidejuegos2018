/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Ventas.LineaVenta;
import Ventas.Venta;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import utilidades.ConectorBD;
import utilidades.Utilidad;

/**
 *
 * @author link
 */
public class VentanaInformes extends javax.swing.JFrame {
    //private VentanaGestionSocios ventana=null;
    private VentanaPrincipal anterior=null;
    /**
     * Creates new form VentanaTicket
     */
    
    public VentanaInformes(VentanaPrincipal anterior) {
        this.anterior = anterior;
        initComponents();
        prepararVentana();
    }
    
    private void prepararVentana() {
        this.setTitle("Generador de informes");
        this.setLocationRelativeTo(null);
        //tienda.setSize(600, 400);
        this.setResizable(false);
        ponerIconos();
        anterior.setVisible(false);
        this.tInforme.setText("");
        this.anterior.setVisible(false);
        this.setVisible(true);  
        
        this.grupoOpciones.add(this.radioMasVendidos);
        this.grupoOpciones.add(this.radioSocios);
        this.grupoOpciones.add(this.radioGanancias);
        

    }
    
    private void ponerIconos() {
        Utilidad c = Utilidad.nuevaInstancia();
        Toolkit t = Toolkit.getDefaultToolkit();
        this.setIconImage(t.getImage(c.getPatImagenes()+"icono.png"));
        //Ponemos el icono como imagen label
        
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(c.getPatImagenes()+"imprimir.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        this.bGuardar.setIcon(imageIcon);
       

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoOpciones = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tInforme = new javax.swing.JTextArea();
        bGuardar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        radioMasVendidos = new javax.swing.JRadioButton();
        radioGanancias = new javax.swing.JRadioButton();
        radioSocios = new javax.swing.JRadioButton();
        bInforme = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generación de informes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tInforme.setEditable(false);
        tInforme.setColumns(20);
        tInforme.setRows(5);
        jScrollPane1.setViewportView(tInforme);

        bGuardar.setText("Guardar e imprimir");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones de informe"));

        radioMasVendidos.setSelected(true);
        radioMasVendidos.setText("Más Vendidos");

        radioGanancias.setText("Ganancias");

        radioSocios.setText("Socios");

        bInforme.setText("Generar");
        bInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInformeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(radioMasVendidos)
                .addGap(27, 27, 27)
                .addComponent(radioGanancias)
                .addGap(18, 18, 18)
                .addComponent(radioSocios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bInforme)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioMasVendidos)
                    .addComponent(radioGanancias)
                    .addComponent(radioSocios)
                    .addComponent(bInforme)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 521, Short.MAX_VALUE)
                        .addComponent(bGuardar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bGuardar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        // TODO add your handling code here:
        guardarFichero();
    }//GEN-LAST:event_bGuardarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.anterior.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void bInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInformeActionPerformed
        // TODO add your handling code here:
        generarInforme();
    }//GEN-LAST:event_bInformeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaInformes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInformes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInformes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInformes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bInforme;
    private javax.swing.ButtonGroup grupoOpciones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioGanancias;
    private javax.swing.JRadioButton radioMasVendidos;
    private javax.swing.JRadioButton radioSocios;
    private javax.swing.JTextArea tInforme;
    // End of variables declaration//GEN-END:variables

    private void guardarFichero() {
        // Primero es obtener la ruta del fichero a guardar con un elemento de la interfaz
        JFileChooser elegirRuta = new JFileChooser();
        elegirRuta.setDialogTitle("Indica el nombre del Ticket"); 
        FileNameExtensionFilter filtroFichero=new FileNameExtensionFilter("TXT","txt");
        elegirRuta.setFileFilter(filtroFichero);
        int seleccion = elegirRuta.showSaveDialog(this);
        // Si pulsa guardar o aceptar
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = elegirRuta.getSelectedFile();
            //System.out.println("fichero " + fichero.getAbsolutePath());
            escribirFichero(fichero, this.tInforme.getText());
            // guardamos el fichero como sabemos
            imprimirFichero(fichero);
            
        }
    }
    
    private void escribirFichero(File file, String texto) {
        File fichero = file; // no hace falta pero asi uso la funcion directa que vimos en clase
        PrintWriter f = null;
        try {
            //System.out.println("Escribiendo en el fichero:"+fichero.getAbsolutePath());
            f = new PrintWriter(new FileWriter(fichero));
            f.println(texto);             
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error al salvar",JOptionPane.ERROR_MESSAGE);
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (f != null)
               f.close();
               JOptionPane.showMessageDialog(null, "Fichero: "+fichero.getName()+" guardado con éxito","Fichero guardado",JOptionPane.INFORMATION_MESSAGE);
           } catch (Exception e2) {
              JOptionPane.showMessageDialog(null, e2.getMessage(),"Error al salvar",JOptionPane.ERROR_MESSAGE);
           }
        }
    }

    private void imprimirFichero(File file) {
        Desktop app = Desktop.getDesktop();
        try{
            app.edit(file);
            //app.mail();
            //app.browse(new URI("https://www.google.es/search?q=uri"));
            //app.print(new File("prueba.txt"));
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }

    private void generarInforme() {
        if(this.radioMasVendidos.isSelected()){
            generarMasVendidos();
        }else if(this.radioGanancias.isSelected()){
            generarGanancias();
        }else if(this.radioSocios.isSelected()){
            generarSocios();
        }
    }

    private void generarMasVendidos() {
        String consulta="select juegos.nombre, sum(lineaventas.cantidad) as cantidad, sum(lineaventas.precio) as recaudacion "
                + "from lineaventas, juegos where lineaventas.nJuego = juegos.nJuego "
                + "group by lineaventas.nJuego "
                + "order by recaudacion desc";
        ConectorBD bd = ConectorBD.nuevaConexionBD();
        bd.abrirBD();
        ResultSet rs = bd.consultarBD(consulta);
        String sal="LOS MÁS VENDIDOS:\n";
        sal+="---------------------\n";
        try {
            while(rs.next()){
                sal+="NOMBRE: "+ rs.getString("nombre")+"\t\t";
                sal+="CANTIDAD: "+ rs.getString("cantidad")+"\t";
                sal+="RECAUDACIÓN: "+ rs.getString("recaudacion")+"€\t";
                sal+="\n";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mensaje:"+ex.getMessage()+"\nEstado: "+ex.getSQLState()+"\nCodigo de error:"+ex.getErrorCode(),
                        "Error de consulta",JOptionPane.ERROR_MESSAGE);
        }
        this.tInforme.setText(sal);
        bd.cerrarBD();
        
    }

    private void generarGanancias() {
        String consulta="select fecha, sum(total) as total from ventas group by fecha order by fecha asc";
        ConectorBD bd = ConectorBD.nuevaConexionBD();
        bd.abrirBD();
        ResultSet rs = bd.consultarBD(consulta);
        String sal="GANANCIAS POR VENTAS:\n";
        sal+="---------------------\n";
        try {
            rs.next(); // Me salto la venta fictica
            while(rs.next()){
                sal+="FECHA: "+ rs.getString("fecha")+"\t\t";
                sal+="RECAUDACIÓN: "+ rs.getString("total")+"€\t";
                sal+="\n";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mensaje:"+ex.getMessage()+"\nEstado: "+ex.getSQLState()+"\nCodigo de error:"+ex.getErrorCode(),
                        "Error de consulta",JOptionPane.ERROR_MESSAGE);
        }
        this.tInforme.setText(sal);
        bd.cerrarBD();
    }
    
    private void generarSocios() {
        String consulta="select distinct socios.nombre, socios.correo, count(ventas.nSocio) as ventas, sum(ventas.total) as recaudacion\n" +
                        "from socios,ventas where socios.nSocio=ventas.nSocio\n" +
                        "group by socios.nombre order by recaudacion asc";
        ConectorBD bd = ConectorBD.nuevaConexionBD();
        bd.abrirBD();
        ResultSet rs = bd.consultarBD(consulta);
        String sal="SOCIOS QUE MÁS COMPRAN:\n";
        sal+="---------------------\n";
        try {
            while(rs.next()){
                sal+="NOMBRE: "+ rs.getString("nombre")+"\t";
                sal+="EMAIL: "+ rs.getString("correo")+"\t";
                sal+="CANTIDAD: "+ rs.getString("ventas")+"\t";
                sal+="RECAUDACIÓN: "+ rs.getString("recaudacion")+"€\t";
                sal+="\n";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mensaje:"+ex.getMessage()+"\nEstado: "+ex.getSQLState()+"\nCodigo de error:"+ex.getErrorCode(),
                        "Error de consulta",JOptionPane.ERROR_MESSAGE);
        }
        this.tInforme.setText(sal);
        bd.cerrarBD();
    }
   
}
