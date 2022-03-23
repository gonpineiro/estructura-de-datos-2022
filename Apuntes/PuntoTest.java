/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apuntes;

/**
 *
 * @author Gonzalo
 */
public class PuntoTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Punto miPunto = new Punto(5.4, 6.78);
        System.out.println(miPunto.toString());

        Punto punto1 = new Punto(2.7, 3.2);
        Punto punto2 = new Punto(2.7, 3.5);
        Punto punto3 = new Punto(3.8, 3.2);
        Punto punto4 = new Punto(2.7, 3.1);
        
        System.out.println(punto1.comparteTo(punto1));
        System.out.println(punto2.comparteTo(punto3));
        System.out.println(punto3.comparteTo(punto2));
        System.out.println(punto1.comparteTo(punto2));
        System.out.println(punto1.comparteTo(punto4));
        
        System.out.println("_________________");
        /* Otras pruebas */
        String s1 = "HOLA";
        String s2 = "AGUA";
        String s3 = "HORA";
        String s4 = "agua";
        String s5 = "agua";

        System.out.println(s1.compareTo(s2));
        System.out.println(s2.compareTo(s1));
        System.out.println(s1.compareTo(s3));
        System.out.println(s4.compareTo(s5));
        System.out.println(s2.compareTo(s5));

    }

}
