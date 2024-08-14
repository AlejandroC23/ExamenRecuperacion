/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.EstudianteControlador;
import controlador.PersonaControlador;
import controlador.ProfesorControlador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Continente;
import modelo.Direccion;
import modelo.Estudiante;
import modelo.Pais;
import modelo.Persona;
import modelo.Profesor;

/**
 *
 * @author Alejandro
 */
public class Main {
    
    public static void cls(){
        for (int i = 0; i < 20; i++) {
            System.out.println("");
        }
    }
    
    public static void pause(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Comando para pausar en Windows
                new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
            } else {
                System.out.println("El comando 'pause' no es compatible con este sistema operativo.");
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al intentar pausar la consola: " + ex.getMessage());
        }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        
        String opc;
        
        do{
            cls();
            System.out.println("""
                        -----------------------------
                                Menú Principal
                        -----------------------------
                          1. Agregar Estudiante
                          2. Agregar Profesor
                          3. Mostrar Personas
                          4. Salir
                        -----------------------------
                """);
            System.out.print("        Opción: ");
            opc = s.next();
            switch (opc){
                case "1" -> {
                    cls();
                    agregarEstudiante();
                }
                case "2" -> {
                    cls();
                    agregarProfesor();
                }
                case "3" -> {
                    mostrarPersonas();
                }
                case "4" -> {
                    cls();
                    System.out.println("¡SALIENDO!");
                }
                default -> {
                    cls();
                    System.out.println("¡ERROR INGRESE UNA OPCIÓN CORRECTA!");
                    pause();
                }
            }
        }while(!opc.equals("4"));
    }
    
    public static void agregarEstudiante() throws IOException{
        
        Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Persona per = new Persona();
        Direccion dir = new Direccion();
        Pais pais = new Pais();
        Continente cont = new Continente();
        
        System.out.println("        ---------------------------------");
        System.out.println("           Ingreso de datos Estudiantes  ");
        System.out.println("        ---------------------------------");
        //Persona
        System.out.print("  Ingrese los nombres: ");
        per.setNombre(br.readLine().toUpperCase());
        System.out.print("  Ingrese los apellidos: ");
        per.setApellido(br.readLine().toUpperCase());
        System.out.print("  Ingrese la cédula: ");
        per.setCedula(s.nextInt());
        //Direccion
        System.out.println("        ---------------------------------");
        System.out.println("                     Dirección           ");
        System.out.println("        ---------------------------------");
        System.out.print("  Ingrese la calle: ");
        dir.setCalle(br.readLine().toUpperCase());
        System.out.print("  Ingrese la ciudad: ");
        dir.setCiudad(br.readLine().toUpperCase());
        System.out.print("  Ingrese el código postal: ");
        dir.setCodPostal(s.nextInt());
        //Direccion - País
        System.out.print("  Ingrese el país: ");
        pais.setNombrePais(br.readLine().toUpperCase());
        //Dirección - País - Continente
        System.out.print("  Ingrese el continente: ");
        cont.setNombreContinente(br.readLine().toUpperCase());
        
        pais.setContinente(cont);
        dir.setPais(pais);
        per.setDireccion(dir);
        
        PersonaControlador perC = new PersonaControlador();
        perC.crearPersona(per);
        int idPersona = perC.buscarIdPersona(per.getCedula());
        
        EstudianteControlador estC = new EstudianteControlador();
        estC.crearEstudiante(idPersona);
        
        cls();
        System.out.println("      ¡CREACIÓN EXITOSA!");
        per.identificacion();
        pause();
    }
    
    public static void agregarProfesor() throws IOException{
        
        Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Persona per = new Persona();
        Profesor pro = new Profesor();
        Direccion dir = new Direccion();
        Pais pais = new Pais();
        Continente cont = new Continente();
        
        System.out.println("        ---------------------------------");
        System.out.println("            Ingreso de datos Profesor    ");
        System.out.println("        ---------------------------------");
        //Persona
        System.out.print("  Ingrese los nombres: ");
        per.setNombre(br.readLine().toUpperCase());
        System.out.print("  Ingrese los apellidos: ");
        per.setApellido(br.readLine().toUpperCase());
        System.out.print("  Ingrese la cédula: ");
        per.setCedula(s.nextInt());
        System.out.print("  Ingrese el despacho: ");
        pro.setDespacho(br.readLine().toUpperCase());
        //Direccion
        System.out.println("        ---------------------------------");
        System.out.println("                     Dirección           ");
        System.out.println("        ---------------------------------");
        System.out.print("  Ingrese la calle: ");
        dir.setCalle(br.readLine().toUpperCase());
        System.out.print("  Ingrese la ciudad: ");
        dir.setCiudad(br.readLine().toUpperCase());
        System.out.print("  Ingrese el código postal: ");
        dir.setCodPostal(s.nextInt());
        //Direccion - País
        System.out.print("  Ingrese el país: ");
        pais.setNombrePais(br.readLine().toUpperCase());
        //Dirección - País - Continente
        System.out.print("  Ingrese el continente: ");
        cont.setNombreContinente(br.readLine().toUpperCase());
        
        pais.setContinente(cont);
        dir.setPais(pais);
        per.setDireccion(dir);
        
        PersonaControlador perC = new PersonaControlador();
        perC.crearPersona(per);
        int idPersona = perC.buscarIdPersona(per.getCedula());
        
        ProfesorControlador proC = new ProfesorControlador();
        proC.crearProfesor(idPersona, pro);
        
        cls();
        System.out.println("      ¡CREACIÓN EXITOSA!");
        per.identificacion();
        System.out.print("Despacho: " + pro.getDespacho() + "\n");
        pause();
    }
    
    public static void mostrarPersonas() {
        Scanner s = new Scanner(System.in);
        
        String opc;
        
        do{
            cls();
            System.out.println("""
                        -----------------------------
                                Menú Principal
                        -----------------------------
                          1. Ver Estudiantes
                          2. Ver Profesores
                          3. Regresar
                        -----------------------------
                """);
            System.out.print("        Opción: ");
            opc = s.next();
            switch (opc){
                case "1" -> {
                    cls();
                    EstudianteControlador estC = new EstudianteControlador();
                    ArrayList<Estudiante> listadoEstudiantes = estC.listarEstudiantes();
                    for(Estudiante p : listadoEstudiantes){
                        p.identificacion();
                    }
                    pause();
                }
                case "2" -> {
                    cls();
                    ProfesorControlador proC = new ProfesorControlador();
                    ArrayList<Profesor> listadoProfesores = proC.listarProfesores();
                    for(Profesor p : listadoProfesores){
                        p.identificacion();
                    }
                    pause();
                }
                case "3" -> {
                    cls();
                    System.out.println("¡REGRESANDO!");
                    pause();
                }
                default -> {
                    cls();
                    System.out.println("¡ERROR INGRESE UNA OPCIÓN CORRECTA!");
                    pause();
                }
            }
        }while(!opc.equals("3"));
    }
}
