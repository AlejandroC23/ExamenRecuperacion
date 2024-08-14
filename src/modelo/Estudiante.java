/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Alejandro
 */
public class Estudiante extends Persona {
    private int idEstudiante;

    public Estudiante() {
    }

    public Estudiante(int idEstudiante, int idPersona, String nombre, String apellido, int cedula, Direccion direccion) {
        super(idPersona, nombre, apellido, cedula, direccion);
        this.idEstudiante = idEstudiante;
    }
    
}
