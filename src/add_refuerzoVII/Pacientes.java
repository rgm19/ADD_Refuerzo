/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package add_refuerzoVII;

/**
 *
 * @author usuario5
 */
public class Pacientes {
    
    private int id;
    private String nombre;
    private String apellidos;
    private String fechaAlta;
    private String dni;
    private String fechaBaja;

    public Pacientes() {
    }

    public Pacientes(int id, String nombre, String apellidos, String fechaAlta, String dni, String fechaBaja) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaAlta = fechaAlta;
        this.dni = dni;
        this.fechaBaja = fechaBaja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    @Override
    public String toString() {
        return "Pacientes{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaAlta=" + fechaAlta + ", dni=" + dni + ", fechaBaja=" + fechaBaja + '}';
    }
    
    
}
