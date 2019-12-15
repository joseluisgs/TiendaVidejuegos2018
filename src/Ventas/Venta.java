/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import java.util.ArrayList;
import socios.Socio;
import utilidades.ConectorBD;

/**
 *
 * @author link
 */
public class Venta {
    private int nVenta;
    private Socio socio;
    private float total;
    private String fecha;
    private ArrayList<LineaVenta> lineas;

    public Venta() {
    }

    public Venta(int nVenta, Socio socio, float total, String fecha) {
        this.nVenta = nVenta;
        this.socio = socio;
        this.total = total;
        this.fecha = fecha;
        lineas = new ArrayList<LineaVenta>();
    }

    public int getCodigo() {
        return nVenta;
    }

    public void setCodigo(int nVenta) {
        this.nVenta = nVenta;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<LineaVenta> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<LineaVenta> lineas) {
        this.lineas = lineas;
    }
    
    public void añadirLinea(LineaVenta linea){
        this.lineas.add(linea);
    }
    @Override
    public String toString() {
        return "Venta{" + "nVenta=" + nVenta + ", nSocio=" + socio.getCodigo() + ", total=" + total + ", fecha=" + fecha + '}';
    }
    
    public void insertarBD()  {
        ConectorBD c = ConectorBD.nuevaConexionBD();
        c.abrirBD();
        
        // Si tengo el autoincremet en el motor o en el diseño de la tabla, no necesito insertar el nVenta
        String consulta = "INSERT INTO ventas VALUES ('"+this.nVenta+"','"+this.socio.getCodigo()+"','"+this.total+"','"+this.fecha+"')";
        
        //System.out.println(consulta);
        int sal=c.actualizarBD(consulta);
        c.cerrarBD();
        
        // Ahora toca las lineas de ventas
        //System.out.println(sal);
        if(sal!=0){
            insertarLineasVentas();
        }
    }

    private void insertarLineasVentas() {
        for(LineaVenta l: this.lineas){
            l.insertarBD();
        }
    }
    
    
}
