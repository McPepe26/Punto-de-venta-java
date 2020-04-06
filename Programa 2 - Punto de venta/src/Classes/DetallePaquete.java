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
public class DetallePaquete {
    private int clave;
    private int clavePaquete;
    private int productoPaquete;
    private int cantidad;

    public DetallePaquete(int clave, int clavePaquete, int productoPaquete, int cantidad) {
        this.clave = clave;
        this.clavePaquete = clavePaquete;
        this.productoPaquete = productoPaquete;
        this.cantidad = cantidad;
    }

    public DetallePaquete(int clavePaquete, int productoPaquete, int cantidad) {
        this(-1, clavePaquete, productoPaquete, cantidad);
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getClavePaquete() {
        return clavePaquete;
    }

    public void setClavePaquete(int clavePaquete) {
        this.clavePaquete = clavePaquete;
    }

    public int getProductoPaquete() {
        return productoPaquete;
    }

    public void setProductoPaquete(int productoPaquete) {
        this.productoPaquete = productoPaquete;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
