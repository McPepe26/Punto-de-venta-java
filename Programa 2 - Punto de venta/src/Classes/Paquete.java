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
    
    public Paquete(int clave, String descripcion) {
        super(clave, descripcion, 0, 0);
        productos = new ArrayList<>();
    }

    public Paquete(String descripcion) {
        this(-1, descripcion);
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
    
}
