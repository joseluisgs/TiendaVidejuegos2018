/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import socios.Socio;
import utilidades.ConectorBD;
import utilidades.Utilidad;

/**
 *
 * @author link
 */
public class VentanaLogin extends javax.swing.JFrame {

    /**
     * Creates new form VentanaLogin
     */
    public VentanaLogin() {
        initComponents();
        prepararVentana();
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
        jPanel1 = new javax.swing.JPanel();
        tUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tPassword = new javax.swing.JPasswordField();
        bAceptar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        lFoto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        radioAdministrador = new javax.swing.JRadioButton();
        radioUsuario = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Usuario:");

        jLabel2.setText("Contraseña:");

        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        lFoto.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lFoto.setForeground(new java.awt.Color(204, 51, 0));
        lFoto.setMaximumSize(new java.awt.Dimension(95, 95));
        lFoto.setMinimumSize(new java.awt.Dimension(95, 95));
        lFoto.setSize(new java.awt.Dimension(95, 95));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 51, 0));
        jLabel3.setText("IFP VIRGEN GAMES 1.0b");

        radioAdministrador.setText("Administrador");

        radioUsuario.setText("Usuario");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(bAceptar)
                                .addGap(41, 41, 41)
                                .addComponent(bCancelar)
                                .addGap(30, 30, 30))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(radioAdministrador)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(radioUsuario))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                        .addComponent(tUsuario))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioAdministrador)
                    .addComponent(radioUsuario))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAceptar)
                    .addComponent(bCancelar))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void limpiarCampos() {
        // TODO add your handling code here:
        this.tUsuario.setText("");
        this.tPassword.setText("");
    }

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        // TODO add your handling code here:
        if(this.radioAdministrador.isSelected()){
            accesoAdministrador();
        }else if(this.radioUsuario.isSelected()){
            accesoUsuario();
        }       
    }//GEN-LAST:event_bAceptarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.cerrarAplicacion();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaLogin().setVisible(true);
            }
        });
    }
   
    
    private void prepararVentana() {
        this.setTitle("Login");
        this.setLocationRelativeTo(null);
        //tienda.setSize(600, 400);
        this.setResizable(false);
        ponerIconos();
        
        // Añadimos los radio butos al grupo para que se gestionen los cambios automaticamente
        this.grupoOpciones.add(this.radioAdministrador);
        this.grupoOpciones.add(this.radioUsuario);
        //Marcamos
        this.radioAdministrador.setSelected(true);
        this.setVisible(true);
        limpiarCampos();
        
        
        
    }
    
    private void ponerIconoVentana() {
        Utilidad c = Utilidad.nuevaInstancia();
        Toolkit t = Toolkit.getDefaultToolkit();
        this.setIconImage(t.getImage(c.getPatImagenes()+"icono.png"));
    }
    
    private void ponerIconos() {
        Utilidad c = Utilidad.nuevaInstancia();
        
        // Icono Ventana
        Toolkit t = Toolkit.getDefaultToolkit();
        this.setIconImage(t.getImage(c.getPatImagenes()+"icono.png"));
       
        //Ponemos el icono como imagen label
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(c.getPatImagenes()+"icono.png").getImage().getScaledInstance(55, 55, Image.SCALE_DEFAULT));
        this.lFoto.setIcon(imageIcon);
        
        imageIcon = new ImageIcon(new ImageIcon(c.getPatImagenes()+"aceptar.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        this.bAceptar.setIcon(imageIcon);
        
        imageIcon = new ImageIcon(new ImageIcon(c.getPatImagenes()+"cancelar.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        this.bCancelar.setIcon(imageIcon);
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar;
    private javax.swing.ButtonGroup grupoOpciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lFoto;
    private javax.swing.JRadioButton radioAdministrador;
    private javax.swing.JRadioButton radioUsuario;
    private javax.swing.JPasswordField tPassword;
    private javax.swing.JTextField tUsuario;
    // End of variables declaration//GEN-END:variables

    private void accesoAdministrador() {
        ConectorBD c = ConectorBD.nuevaConexionBD();
        c.abrirBD();
        String consulta="Select password from administrador where usuario = '"+this.tUsuario.getText()+"'";
        //System.out.println(consulta);
        ResultSet rs = c.consultarBD(consulta);
        String password = null;
        try {
            while(rs.next()){
                password = rs.getString("password");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mensaje:"+ex.getMessage()+"\nEstado: "+ex.getSQLState()+"\nCodigo de error:"+ex.getErrorCode(),
                        "Error de consulta",JOptionPane.ERROR_MESSAGE);
        }
        c.cerrarBD();
        //System.out.println(password);
        // Comrpbamos los password
        Utilidad u = Utilidad.nuevaInstancia();
        if(password!=null && password.equals(u.convertirSHA256(this.tPassword.getText()))){
            //System.out.println("Cierto");
            VentanaPrincipal tienda = VentanaPrincipal.nuevaVentana();
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Nombre de usuario incorrecto o contraseña inválida",
                        "Error de autentificación",JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
        }
    
    
    }

    private void accesoUsuario() {
        ConectorBD c = ConectorBD.nuevaConexionBD();
        c.abrirBD();
        String consulta="Select password from socios where correo = '"+this.tUsuario.getText()+"'";
        //System.out.println(consulta);
        ResultSet rs = c.consultarBD(consulta);
        String password = null;
        try {
            while(rs.next()){
                password = rs.getString("password");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mensaje:"+ex.getMessage()+"\nEstado: "+ex.getSQLState()+"\nCodigo de error:"+ex.getErrorCode(),
                        "Error de consulta",JOptionPane.ERROR_MESSAGE);
        }
        c.cerrarBD();
        //System.out.println(password);
        // Comrpbamos los password
        Utilidad u = Utilidad.nuevaInstancia();
        if(password!=null && password.equals(u.convertirSHA256(this.tPassword.getText()))){
            iniciarCompra();
        }else{
            JOptionPane.showMessageDialog(null, "Nombre de usuario incorrecto o contraseña inválida",
                        "Error de autentificación",JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
            
        }
    
    }
    
    private void cerrarAplicacion() {
        //Preguntamos si queremos cerrar
        int seleccion = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir de la aplicacion?", "Salir", JOptionPane.YES_NO_OPTION);
        if (seleccion == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }

    private void iniciarCompra() {
        //System.out.println("Cierto");
        ConectorBD c = ConectorBD.nuevaConexionBD();
        c.abrirBD();
        String consulta="Select * from socios where correo = '"+this.tUsuario.getText()+"'";
        //System.out.println(consulta);
        ResultSet rs = c.consultarBD(consulta);
        Socio a = new Socio();
 
        try {
            while(rs.next()){
                a = new Socio();
                a.setCodigo(rs.getInt("NSocio"));
                a.setNombre(rs.getString("nombre"));
                a.setCorreo(rs.getString("correo"));
                a.setPassword(rs.getString("password"));
                a.setTelefono(rs.getString("telefono"));
                a.setFecha(rs.getString("fecha"));
                a.setFoto(rs.getString("foto"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mensaje:"+ex.getMessage()+"\nEstado: "+ex.getSQLState()+"\nCodigo de error:"+ex.getErrorCode(),
                        "Error de consulta",JOptionPane.ERROR_MESSAGE);
        }
        c.cerrarBD();
        VentanaCompras v = new VentanaCompras(this,a);
        this.dispose();
    }
}
