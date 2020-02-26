/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author ja-za
 */
public class DetalleVenta {
    private int clave;
    private Producto producto;
    private int cantidad;

    public DetalleVenta(int clave, Producto producto, int cantidad) {
        this.clave = clave;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public DetalleVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double total(){
        return cantidad*producto.getPrecio();
    }
    
    public void agregar(){
        cantidad++;
    }
    
    public void quitar(){
        cantidad--;
    }
}
