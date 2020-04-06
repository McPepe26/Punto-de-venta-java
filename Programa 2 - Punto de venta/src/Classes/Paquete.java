/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author ja-za
 */
public class Paquete extends Producto{
    
    private ArrayList<DetallePaquete> productos;
    
    public Paquete(int clave, String descripcion, double precio) {
        super(clave, descripcion, precio, 0, 1);
        productos = new ArrayList<>();
    }

    public Paquete(String descripcion, double precio) {
        this(-1, descripcion, precio);
    }
    
    public void agregarProducto(DetallePaquete nuevo){
        productos.add(nuevo);
    }
    
    public void quitarProducto(int detalle){
        productos.remove(detalle);
    }
    
    public void modificarProducto(int pos, DetallePaquete mod){
        productos.set(pos, mod);
    }
    
    public void eliminarProducto(int pos){
        productos.remove(pos);
    }

    public ArrayList<DetallePaquete> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<DetallePaquete> productos) {
        this.productos = productos;
    }
    
    public void vaciarLista(){
        while(!productos.isEmpty()){
            productos.remove(0);
        }
    }
    
}
