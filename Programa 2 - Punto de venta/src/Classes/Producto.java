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
public class Producto {
    private int clave;
    private String descripcion;
    private double precio;
    private int cantidad;
    private int tipo;

    public Producto(int clave, String descripcion, double precio, int cantidad, int tipo) {
        this.clave = clave;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    public Producto(String descripcion, double precio, int cantidad, int tipo) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
