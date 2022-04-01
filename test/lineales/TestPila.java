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
        Pila pila = new Pila();

        System.out.println("# Inicilizamos una pila:");
        System.out.println("----------------------------------------------------");
        System.out.println("¿Está vacia?:\t\t\t[Retorna: true ]:\t\t" + pila.esVacia());
        System.out.println("Obtenemos el tope:\t\t[Retorna: null ]:\t\t" + pila.obtenerTope());
        System.out.println("Mostramos la pila:\t\t[Retorna: 'Pila vacia' ]:\t" + pila.toString());
        System.out.println("----------------------------------------------------");
        System.out.println("# Apilamos el 12 como entero");
        pila.apilar(12);
        System.out.println("¿Está vacia?:\t\t\t[Retorna: false ]:\t\t" + pila.esVacia());
        System.out.println("Obtenemos el tope:\t\t[Retorna: 12 ]:\t\t\t" + pila.obtenerTope());
        System.out.println("Mostramos la pila:\t\t[Retorna: [12] ]:\t\t" + pila.toString());

        System.out.println("");
        System.out.println("# Apilamos el 25, 48, y 23 como enteros, en ese orden");
        pila.apilar(25);
        pila.apilar(48);
        pila.apilar(23);
        System.out.println("¿Está vacia?:\t\t\t[Retorna: false ]:\t\t" + pila.esVacia());
        System.out.println("Obtenemos el tope:\t\t[Retorna: 12 ]:\t\t\t" + pila.obtenerTope());
        System.out.println("Mostramos la pila:\t\t[Retorna: [12] ]:\t\t" + pila.toString());
        
        System.out.println("");
        System.out.println("# Llenamos la Pila");
        System.out.println("Apilamos 16 numeros:\t\t[Retorna: true ]:\t\t" + llenarPila(16, pila));
        System.out.println("Apilamos 1 elemento :\t\t[Retorna: * ]:\t\t\t" + pila.apilar(50) + "\t\t * false: estática, TAMANIO > 20 | true: dinamicas");

        System.out.println("");
        System.out.println("# Mostramos la pila:\t\t\t\t\t\t" + pila.toString());
        System.out.println("Desapilamos un elemento:\t[Retorna: true ]:\t\t" + pila.desapilar());
        System.out.println("Mostramos la pila:\t\t\t\t\t\t" + pila.toString());
        System.out.println("Desapilamos un elemento:\t[Retorna: true ]:\t\t "+ pila.desapilar());
        System.out.println("Mostramos la pila:\t\t\t\t\t\t" + pila.toString());

        System.out.println("");
        System.out.println("# Vaciamos la pila:\t\t");
        pila.vaciar();
        System.out.println("Mostramos la pila:\t\t\t\t\t\t" + pila.toString());
        System.out.println("Desapilamos un elemento:\t[Retorna: false ]:\t\t" + pila.desapilar());

        /* Fin Pruebas basicas */        
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("# Clonamos la pila a una pila Aux");
        Pila pilaAux = pila.clone();
        System.out.println("¿Está vacia?:\t\t\t[Retorna: true ]:\t\t" + pila.esVacia());
        System.out.println("Mostramos la pilaAux:\t\t\t\t\t\t" + pilaAux.toString());
        System.out.println("Apilamos 18 numeros:\t\t[Retorna: true ]:\t\t" + llenarPila(20, pilaAux));
        System.out.println("Mostramos la pilaAux:\t\t\t\t\t\t" + pilaAux.toString());        
        System.out.println("Obtenemos el tope:\t\t[Retorna: 20 ]:\t\t\t" + pilaAux.obtenerTope());
        System.out.println("Obtenemos el tope:\t\t[Retorna: * ]:\t\t\t" + pilaAux.apilar(99) + "\t\t *false: estática, TAMANIO > 20 | true: dinamicas");

        System.out.println("");
        System.out.println("# Vaciamos la pilaAux:\t\t");
        pilaAux.vaciar();
        System.out.println("Mostramos la pila:\t\t\t\t\t\t" + pilaAux.toString());
        System.out.println("Desapilamos un elemento:\t[Retorna: false ]:\t\t" + pilaAux.desapilar());
        

        /*
         * Desapilamos un elemento de la nuevaPila, mostramos la orignal y mostramos la
         * nueva pila
         */

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

    public static boolean llenarPila(int cant, Pila pila) {
        boolean exito = false;
        for (int i = 1; i <= cant; i++) {
            exito = pila.apilar(i);
        }
        return exito;
    }
    public static boolean vaciarPila(Pila pila) {
        boolean exito = true;
        while (!pila.esVacia()) {
            pila.desapilar();
        }
        return exito;
    }
}
