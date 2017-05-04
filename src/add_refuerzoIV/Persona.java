/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package add_refuerzoIV;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class Persona implements Serializable {
    
    private String nombre;
    private String direccion;
    private int codpostal;
    private int telf;

    public Persona(){}
    
    public Persona(String nombre, String direccion, int codpostal, int telf) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.codpostal = codpostal;
        this.telf = telf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(int codpostal) {
        this.codpostal = codpostal;
    }

    public int getTelf() {
        return telf;
    }

    public void setTelf(int telf) {
        this.telf = telf;
    }


    
    
}
