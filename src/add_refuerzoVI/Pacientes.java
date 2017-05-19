package add_refuerzoVI;
// Generated 19-may-2017 12:01:19 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Pacientes generated by hbm2java
 */
public class Pacientes  implements java.io.Serializable {


     private short id;
     private String nombre;
     private String apellidos;
     private Date fechaAlta;
     private String dni;
     private String fechaIngreso;

    public Pacientes() {
    }

	
    public Pacientes(short id, String nombre, String apellidos, String dni, String fechaIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
    }
    public Pacientes(short id, String nombre, String apellidos, Date fechaAlta, String dni, String fechaIngreso) {
       this.id = id;
       this.nombre = nombre;
       this.apellidos = apellidos;
       this.fechaAlta = fechaAlta;
       this.dni = dni;
       this.fechaIngreso = fechaIngreso;
    }
   
    public short getId() {
        return this.id;
    }
    
    public void setId(short id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public Date getFechaAlta() {
        return this.fechaAlta;
    }
    
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getFechaIngreso() {
        return this.fechaIngreso;
    }
    
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }




}


