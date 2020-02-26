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
public class Usuario {
    private int clave;
    private String nombre;
    private String contra;
    private int rol;

    public Usuario(int clave, String nombre, String contra, int rol) {
        this.clave = clave;
        this.nombre = nombre;
        this.contra = contra;
        this.rol = rol;
    }

    public Usuario(String nombre, String contra, int rol) {
        this.nombre = nombre;
        this.contra = contra;
        this.rol = rol;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
}
