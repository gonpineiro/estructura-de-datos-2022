/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;

import lineales.estaticas.Pila;

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

    }

}
