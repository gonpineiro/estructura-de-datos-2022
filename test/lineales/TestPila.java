/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

import lineales.dinamicas.Pila;

/**
 *
 * @author Gonzalo
 */
public class TestPila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pila pilaOriginal = new Pila();

        /* Mostramos la pilaOriginal Vacia */
        System.out.println("Mostramos la pilaOriginal Vacia");
        System.out.println(pilaOriginal.toString());
        System.out.println("______________________________________________________");

        /* Obtenemos el tope, va devolver un error */
        System.out.println("Obtenemos el tope, va devolver un error");
        System.out.println("Tope 1: " + pilaOriginal.obtenerTope());
        System.out.println("______________________________________________________");

        /* Verificamos si esta vacia */
        System.out.println("Verificamos si esta vacia");
        System.out.println(pilaOriginal.esVacia());
        System.out.println("______________________________________________________");

        /* Apilamos 4 elementos */
        pilaOriginal.apilar(1);
        pilaOriginal.apilar(2);
        pilaOriginal.apilar(3);
        pilaOriginal.apilar(4);

        /* Obtenemos el tope de la pila */
        System.out.println("Obtenemos el tope de la pila");
        System.out.println("Tope 2: " + pilaOriginal.obtenerTope());
        System.out.println("______________________________________________________");

        /* Desapilamos un elemento de la pila, lo mostramos y obtenemos el tope */
        System.out.println("Desapilamos un elemento de la pila, lo mostramos y obtenemos el tope");
        pilaOriginal.desapilar();
        System.out.println(pilaOriginal.toString());
        System.out.println("Tope 3: " + pilaOriginal.obtenerTope());
        System.out.println("______________________________________________________");


        /* Creamos una nueva pila y clonamos la pila original en la nueva */
        System.out.println("Creamos una nueva pila y clonamos la pila original en la nueva");
        Pila nuevaPila = pilaOriginal.clone();
        System.out.println(pilaOriginal.toString());
        System.out.println("______________________________________________________");

        /* Desapilamos un elemento de la nuevaPila, mostramos la orignal y mostramos la nueva pila */
        System.out.println("Desapilamos un elemento de la nuevaPila, mostramos la orignal y mostramos la nueva pila");
        nuevaPila.desapilar();
        System.out.println(pilaOriginal.toString());
        System.out.println(nuevaPila.toString());
        System.out.println("______________________________________________________");

        System.out.println("##########################");
        System.out.println("PRUEBA METODO CAPICUA");
        System.out.println("##########################");

        Pila pilaCapicua = new Pila();

        pilaCapicua.apilar(1);
        pilaCapicua.apilar(2);
        pilaCapicua.apilar(3);
        pilaCapicua.apilar(4);
        pilaCapicua.apilar(3);
        pilaCapicua.apilar(2);
        pilaCapicua.apilar(1);

        /* Verificamos si es capicua */
        System.out.println("______________________________________________________");
        
        pilaCapicua.vaciar();
        
        pilaCapicua.apilar(1);
        pilaCapicua.apilar(2);
        pilaCapicua.apilar(3);
        pilaCapicua.apilar(4);
        pilaCapicua.apilar(4);
        pilaCapicua.apilar(3);
        pilaCapicua.apilar(1);
        
        /* Verificamos si es capicua */
        System.out.println("______________________________________________________");
        
        System.out.println("##########################");
        System.out.println("PRUEBA PILAS STRING");
        System.out.println("##########################");
        
        /* Creamos la pila de Strings */
        Pila pilaString = new Pila();
        pilaString.apilar("Primer Elemento");
        pilaString.apilar("Segundo Elemento");
        pilaString.apilar("Tercer Elemento");
        pilaString.apilar("Cuarto Elemento");
        pilaString.apilar("Quinto Elemento");
        
        System.out.println("Mostrar Pila: " + pilaString.toString());
        System.out.println("Mostrar Tope: " + pilaString.obtenerTope());
        pilaString.desapilar();
        System.out.println("Mostrar Tope: " + pilaString.obtenerTope());
        
        pilaString.apilar("Nuevo Elemento!!!");
        System.out.println("Mostrar Pila: " + pilaString.toString());
        pilaString.vaciar();
        System.out.println("Mostrar Pila: " + pilaString.toString());       
        System.out.println("______________________________________________________");
        
        

    }

}
