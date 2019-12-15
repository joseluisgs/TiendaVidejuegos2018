/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socios;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utilidades.ConectorBD;
import utilidades.Utilidad;

/**
 *
 * @author link
 */
public class Socio {
    private int nSocio;
    private String nombre;
    private String correo;
    private String password;
    private String telefono;
    private String fecha;
    private String foto;
    
    public Socio(){
        
    }
    public Socio(int nSocio, String nombre, String correo, String password, String telefono, String fecha, String foto) {
        this.nSocio = nSocio;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.telefono = telefono;
        this.fecha = fecha;
        this.foto = foto;
    }
    
    
    /**
     * @return the nSocio
     */
    public int getCodigo() {
        return nSocio;
    }

    /**
     * @param codigo the nSocio to set
     */
    public void setCodigo(int codigo) {
        this.nSocio = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Socio{" + "nSocio=" + nSocio + ", nombre=" + nombre + ", correo=" + correo + ", password=" + password + ", telefono=" + telefono + ", fecha=" + fecha + ", foto=" + foto + '}';
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.nSocio;
        hash = 71 * hash + Objects.hashCode(this.nombre);
        hash = 71 * hash + Objects.hashCode(this.correo);
        hash = 71 * hash + Objects.hashCode(this.password);
        hash = 71 * hash + Objects.hashCode(this.telefono);
        hash = 71 * hash + Objects.hashCode(this.fecha);
        hash = 71 * hash + Objects.hashCode(this.foto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Socio other = (Socio) obj;
        if (this.nSocio != other.nSocio) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        return true;
    }
    
    
    
    // Metodos de la BD
     public static ArrayList<Socio> listaSocios(String filtro) {
        ArrayList<Socio> lista = new ArrayList<Socio>();
        ConectorBD c = ConectorBD.nuevaConexionBD();
        c.abrirBD();
        ResultSet rs = c.consultarBD("Select * from socios  where nombre like \"%"+filtro+"%\" order by NSocio");
        
        try {
            while(rs.next()){
                Socio a = new Socio();
                a.setCodigo(rs.getInt("NSocio"));
                a.setNombre(rs.getString("nombre"));
                a.setCorreo(rs.getString("correo"));
                a.setPassword(rs.getString("password"));
                a.setTelefono(rs.getString("telefono"));
                a.setFecha(rs.getString("fecha"));
                a.setFoto(rs.getString("foto"));
                lista.add(a);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mensaje:"+ex.getMessage()+"\nEstado: "+ex.getSQLState()+"\nCodigo de error:"+ex.getErrorCode(),
                        "Error de consulta",JOptionPane.ERROR_MESSAGE);
        }
        
        c.cerrarBD();
        
        return lista;
        
    }
    
    public void insertarBD() {
        try {
            ConectorBD c = ConectorBD.nuevaConexionBD();
            c.abrirBD();
            
            // Ciframos el password
            
            cifrarPassword();
            
            String consulta = "insert into socios (nombre, correo, password, telefono, fecha, foto) values "
                    + "('"+this.nombre+"','"+this.correo+"','"+this.password+"','"+this.telefono+"','"+this.fecha+"','"+this.foto+"')";
            
            //System.out.println(consulta);
            c.actualizarBD(consulta);
            
            c.cerrarBD();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cifrarPassword() throws NoSuchAlgorithmException {
        // Ciframos la contraseña
        Utilidad u = Utilidad.nuevaInstancia();
        String pass = u.convertirSHA256(this.password);
        this.password = pass;
    }

    public void eliminarBD() {
        ConectorBD c = ConectorBD.nuevaConexionBD();
        c.abrirBD();
        String consulta = "delete from socios where nSocio = '"+this.nSocio+"'";
        //System.out.println(consulta);
        c.actualizarBD(consulta);
    
        c.cerrarBD();
    }

    public void modificarBD()  {
         ConectorBD c = ConectorBD.nuevaConexionBD();
        c.abrirBD();
        try {
            cifrarPassword();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
        }
        String consulta = "update socios set "
                + "nombre='"+this.nombre+"', correo='"+this.correo+"', password='"+this.password+"', telefono='"+this.telefono+"', fecha='"+this.fecha+"', foto='"+this.foto+"' where nSocio ="+this.nSocio+"";
       //System.out.println(consulta);
        c.actualizarBD(consulta);
    
        c.cerrarBD();
    }

    public boolean existeBD() {
        boolean sal = true;
        ConectorBD c = ConectorBD.nuevaConexionBD();
        c.abrirBD();
        String consulta = "Select count(*) as existe from socios where correo='"+this.correo+"'";
        ResultSet rs = c.consultarBD(consulta);
        
        int existe = 0;
        try {
            while(rs.next()){
                existe = rs.getInt("existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mensaje:"+ex.getMessage()+"\nEstado: "+ex.getSQLState()+"\nCodigo de error:"+ex.getErrorCode(),
                        "Error de consulta",JOptionPane.ERROR_MESSAGE);
        }
        
        c.cerrarBD();
        if(existe==0) sal = false;
        return sal;
    }

    
    
}
