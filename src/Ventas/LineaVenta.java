/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import productos.Juego;
import utilidades.ConectorBD;

/**
 *
 * @author link
 */
public class LineaVenta {
    private Venta venta;
    private Juego juego;
    private float precio;
    private int cantidad;

    public LineaVenta() {
    }

    public LineaVenta(Venta venta, Juego juego, float precio, int cantidad) {
        this.venta = venta;
        this.juego = juego;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setnVenta(Venta venta) {
        this.venta = venta;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "LineaVenta{" + "nVenta=" + venta.getCodigo() + ", nJuego=" + juego.getCodigo() + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }
    
    public void insertarBD()  {
        ConectorBD c = ConectorBD.nuevaConexionBD();
        c.abrirBD();
        
        // Si tengo el aitoincrement en la tabla no hace falta insertar el código de la linea de venta
        String consulta = "INSERT INTO lineaventas VALUES ('"+this.venta.getCodigo()+"','"+this.juego.getCodigo()+"','"+this.precio+"','"+this.cantidad+"')";
        
        //System.out.println(consulta);
        c.actualizarBD(consulta);
    
        c.cerrarBD();
    }
    
    
    
}
