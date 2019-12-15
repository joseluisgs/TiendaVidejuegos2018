/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos;

import socios.*;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JOptionPane;
import utilidades.ConectorBD;
import utilidades.Utilidad;

/**
 *
 * @author link
 */
public class Juego {
    private int nJuego;
    private String nombre;
    private String distribuidor;
    private float precio;
    private String fecha;
    private String foto;
    
    public Juego(){
        
    }
    public Juego(int nJuego, String nombre, String distribuidor, float telefono, String fecha, String foto) {
        this.nJuego = nJuego;
        this.nombre = nombre;
        this.distribuidor = distribuidor;
        this.precio = precio;
        this.fecha = fecha;
        this.foto = foto;
    }
    
    
    /**
     * @return the nJuego
     */
    public int getCodigo() {
        return nJuego;
    }

    /**
     * @param codigo the nJuego to set
     */
    public void setCodigo(int codigo) {
        this.nJuego = codigo;
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
     * @return the distribuidor
     */
    public String getDistribuidor() {
        return distribuidor;
    }

    /**
     * @param correo the distribuidor to set
     */
    public void setDistribuidor(String correo) {
        this.distribuidor = correo;
    }


    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param telefono the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
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
        return "Juego{" + "nJuego=" + nJuego + ", nombre=" + nombre + ", distribuidor=" + distribuidor + ", precio=" + precio + ", fecha=" + fecha + ", foto=" + foto + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.nJuego;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.distribuidor);
        hash = 53 * hash + Float.floatToIntBits(this.precio);
        hash = 53 * hash + Objects.hashCode(this.fecha);
        hash = 53 * hash + Objects.hashCode(this.foto);
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
        final Juego other = (Juego) obj;
        if (this.nJuego != other.nJuego) {
            return false;
        }
        if (Float.floatToIntBits(this.precio) != Float.floatToIntBits(other.precio)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.distribuidor, other.distribuidor)) {
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
     public static ArrayList<Juego> listaJuegos(String filtro) {
        ArrayList<Juego> lista = new ArrayList<Juego>();
        ConectorBD c = ConectorBD.nuevaConexionBD();
        c.abrirBD();
        ResultSet rs = c.consultarBD("Select * from juegos  where nombre like \"%"+filtro+"%\" order by NJuego");
        
        try {
            while(rs.next()){
                Juego a = new Juego();
                a.setCodigo(rs.getInt("NJuego"));
                a.setNombre(rs.getString("nombre"));
                a.setDistribuidor(rs.getString("distribuidor"));
                a.setPrecio(rs.getFloat("precio"));
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
    
    public void insertarBD()  {
        ConectorBD c = ConectorBD.nuevaConexionBD();
        c.abrirBD();
        
        
        String consulta = "insert into juegos (nombre, distribuidor, precio, fecha, foto) values "
                + "('"+this.nombre+"','"+this.distribuidor+"','"+this.precio+"','"+this.fecha+"','"+this.foto+"')";
        
        //System.out.println(consulta);
        c.actualizarBD(consulta);
    
        c.cerrarBD();
    }


    public void eliminarBD() {
        ConectorBD c = ConectorBD.nuevaConexionBD();
        c.abrirBD();
        String consulta = "delete from juegos where nJuego = '"+this.nJuego+"'";
        //System.out.println(consulta);
        c.actualizarBD(consulta);
    
        c.cerrarBD();
    }

    public void modificarBD() {
        ConectorBD c = ConectorBD.nuevaConexionBD();
        c.abrirBD();
        String consulta = "update juegos set "
                + "nombre='"+this.nombre+"', distribuidor='"+this.distribuidor+"', precio='"+this.precio+"', fecha='"+this.fecha+"', foto='"+this.foto+"' where nJuego ="+this.nJuego+"";
       System.out.println(consulta);
        c.actualizarBD(consulta);
    
        c.cerrarBD();
    }

    
    
}
