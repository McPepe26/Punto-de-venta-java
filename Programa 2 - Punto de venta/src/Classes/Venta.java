/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ja-za
 */
public class Venta {
    private int clave;
    private Date fecha;
    private Usuario vendedor;
    private ArrayList<DetalleVenta> detalles;
    private int ULTIMO;

    public Venta(int clave, Date fecha, Usuario vendedor, ArrayList<DetalleVenta> detalles) {
        this.clave = clave;
        this.fecha = fecha;
        this.vendedor = vendedor;
        this.detalles = detalles;
    }

    public Venta(Date fecha, Usuario vendedor, ArrayList<DetalleVenta> detalles) {
        this.fecha = fecha;
        this.vendedor = vendedor;
        this.detalles = detalles;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String getFechaToString() {
        return new SimpleDateFormat("dd-MM-yyyy").format(fecha);
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public ArrayList<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetalleVenta> detalles) {
        this.detalles = detalles;
    }
    
    public void agregarItem(Producto p, int cantidad){
        ULTIMO = detalles.size();
        detalles.add(new DetalleVenta(p, cantidad));
    }
    
    private void quitarItem(){
        detalles.remove(ULTIMO);
        ULTIMO--;
    }
    
    public void agregarItemUltimo(){
        if(ULTIMO >= 0){
            detalles.get(ULTIMO).agregar();
        }
    }
    
    public int quitarItemUltimo(){
        if(ULTIMO >= 0){
            detalles.get(ULTIMO).quitar();
            if(detalles.get(ULTIMO).getCantidad() == 0){
                quitarItem();
            }
        }
        return detalles.size();
    }
    
    public double calcularTotal(){
        double total = 0;
        for(DetalleVenta v : detalles){
            total += v.getCantidad()*v.getProducto().getPrecio();
        }
        return total;
    }
    
    public double calcularTotalUltimo(){
        return detalles.get(ULTIMO).total();
    }
    
    public boolean estaVacia(){
        return detalles.isEmpty();
    }
    
    public DetalleVenta getUltimo(){
        return detalles.get(ULTIMO);
    }
    
}
