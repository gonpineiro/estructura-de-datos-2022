/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

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

        System.out.println("");
        System.out.println("----------------------------------------------------");
        System.out.println("# Inicilizamos una pila:");
        System.out.println("----------------------------------------------------");
        System.out.println("");

        System.out.println("¿Está vacia?:\t\t\t[Retorna: true ]:\t\t" + pila.esVacia());
        System.out.println("Obtenemos el tope:\t\t[Retorna: null ]:\t\t" + pila.obtenerTope());
        System.out.println("Mostramos la pila:\t\t[Retorna: 'Pila vacia' ]:\t" + pila.toString());

        System.out.println("");
        System.out.println("# Apilamos el 12 como entero");
        System.out.println("");

        pila.apilar(12);
        System.out.println("¿Está vacia?:\t\t\t[Retorna: false ]:\t\t" + pila.esVacia());
        System.out.println("Obtenemos el tope:\t\t[Retorna: 12 ]:\t\t\t" + pila.obtenerTope());
        System.out.println("Mostramos la pila:\t\t[Retorna: [12] ]:\t\t" + pila.toString());

        System.out.println("");
        System.out.println("# Apilamos el 25, 48, y 23 como enteros, en ese orden");
        System.out.println("");

        pila.apilar(25);
        pila.apilar(48);
        pila.apilar(23);

        System.out.println("¿Está vacia?:\t\t\t[Retorna: false ]:\t\t" + pila.esVacia());
        System.out.println("Obtenemos el tope:\t\t[Retorna: 23 ]:\t\t\t" + pila.obtenerTope());
        System.out.println("Mostramos la pila:\t\t\t\t\t\t" + pila.toString());

        System.out.println("");
        System.out.println("# Llenamos la Pila");
        System.out.println("");

        System.out.println("Apilamos 6 numeros:\t\t[Retorna: true ]:\t\t" + llenarPilaNumeros(6, pila));
        System.out.println("Apilamos 1 elemento :\t\t[Retorna: * ]:\t\t\t" + pila.apilar(50)
                + "\t\t * false: estática, TAMANIO > 20 | true: dinamicas");
        System.out.println("# Mostramos la pila:\t\t\t\t\t\t" + pila.toString());
        System.out.println("Desapilamos un elemento:\t[Retorna: true ]:\t\t" + pila.desapilar());
        System.out.println("Mostramos la pila:\t\t\t\t\t\t" + pila.toString());
        System.out.println("Desapilamos un elemento:\t[Retorna: true ]:\t\t " + pila.desapilar());
        System.out.println("Mostramos la pila:\t\t\t\t\t\t" + pila.toString());

        System.out.println("");
        System.out.println("# Vaciamos la pila:\t\t");
        System.out.println("");

        pila.vaciar();
        System.out.println("Mostramos la pila:\t\t\t\t\t\t" + pila.toString());
        System.out.println("Desapilamos un elemento:\t[Retorna: false ]:\t\t" + pila.desapilar());

        /* Fin Pruebas basicas */

        /* Incio prueba clonar */
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("# Clonamos la pila a una pila Aux, agregamos elementos a pila para no clonar un vacio");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("");

        System.out.println("Apilamos el 59:\t\t\t[Retorna: true ]:\t\t" + pila.apilar(59));
        Pila pilaAux = pila.clone();
        System.out.println("¿Está vacia?:\t\t\t[Retorna: false ]:\t\t" + pila.esVacia());
        System.out.println("Mostramos la pilaAux:\t\t\t\t\t\t" + pilaAux.toString());
        System.out.println("Apilamos 9 numeros:\t\t[Retorna: true ]:\t\t" + llenarPilaNumeros(9, pilaAux));
        System.out.println("Mostramos la pilaAux:\t\t\t\t\t\t" + pilaAux.toString());
        System.out.println("Obtenemos el tope:\t\t[Retorna: 9 ]:\t\t\t" + pilaAux.obtenerTope());
        System.out.println("Apilamos un numero:\t\t[Retorna: * ]:\t\t\t" + pilaAux.apilar(99));
        System.out.println("Desapilamos un elemento:\t[Retorna: true ]:\t\t" + pilaAux.desapilar());
        System.out.println("Obtenemos el tope:\t\t[Retorna: 8 ]:\t\t\t" + pilaAux.obtenerTope());

        System.out.println("");
        System.out.println("# Vaciamos la pilaAux:\t\t");
        System.out.println("");

        pilaAux.vaciar();
        System.out.println("Mostramos la pila:\t\t\t\t\t\t" + pilaAux.toString());
        System.out.println("Desapilamos un elemento:\t[Retorna: false ]:\t\t" + pilaAux.desapilar());

        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("# Prueba Pila String,  Inicilizamos una pilaString:");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("");

        Pila pilaString = new Pila();
        System.out.println("# Apilamos 'Primer elemento'");
        System.out.println("");

        System.out.println("¿Está vacia?:\t\t\t[Retorna: true ]:\t\t" + pilaString.esVacia());
        System.out.println("Obtenemos el tope:\t\t[Retorna: null ]\t\t" + pilaString.obtenerTope());
        System.out.println("Mostramos la pila:\t\t\t\t\t\t" + pilaString.toString());
        System.out.println("Apilamos 1 elemento:\t\t[Retorna: true ]:\t\t" + pilaString.apilar("Primer Elemento"));
        System.out.println("¿Está vacia?:\t\t\t[Retorna: false ]:\t\t" + pilaString.esVacia());
        System.out.println("Obtenemos el tope:\t\t\t\t\t\t" + pilaString.obtenerTope());
        System.out.println("Mostramos la pila:\t\t\t\t\t\t" + pilaString.toString());

        System.out.println("");
        System.out.println("# Apilamos Nueve elementos mas");
        System.out.println("");

        pilaString.apilar("Segundo Elemento");
        pilaString.apilar("Tercer Elemento");
        pilaString.apilar("Cuarto Elemento");
        pilaString.apilar("Quinto Elemento");
        pilaString.apilar("Sexto Elemento");
        pilaString.apilar("Septimo Elemento");
        pilaString.apilar("Octavo Elemento");
        pilaString.apilar("Noveno Elemento");
        pilaString.apilar("Decimo Elemento");

        System.out.println("Mostramos la pila:\t\t\t\t\t\t" + pilaString.toString());
        System.out.println("Obtenemos el tope:\t\t\t\t\t\t" + pilaString.obtenerTope());
        System.out.println("Apilamos 1 elemento:\t\t[Retorna: false ]:\t\t" + pilaString.apilar("Nuevo Elemento"));
        System.out.println("Desapilamos un elemento:\t[Retorna: true ]:\t\t" + pilaString.desapilar());
        System.out.println("Obtenemos el tope:\t\t\t\t\t\t" + pilaString.obtenerTope());

        System.out.println("");
        System.out.println("# Vaciamos la pila");
        System.out.println("");

        pilaString.vaciar();
        System.out.println("¿Está vacia?:\t\t\t[Retorna: true ]:\t\t" + pilaString.esVacia());
        System.out.println("Obtenemos el tope:\t\t[Retorna: null ]:\t\t" + pilaString.obtenerTope());
        System.out.println("Desapilamos un elemento:\t[Retorna: false ]:\t\t" + pilaString.desapilar());
        System.out.println("Mostramos la pila:\t\t[Retorna: 'Pila vacia' ]:\t" + pilaString.toString());

        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("# Prueba Pila digitos capicua");
        System.out.println("------------------------------------------------------------------------------------");
        
        Pila pilaCapi = new Pila();
        pilaCapi.apilar(1);
        pilaCapi.apilar(2);
        pilaCapi.apilar(3);
        pilaCapi.apilar(2);
        
        System.out.println("");
        System.out.println("# Apilamos 1,2,3,2");
        System.out.println("");

        System.out.println("Mostramos la pila:\t\t\t\t\t\t" + pilaCapi.toString());
        System.out.println("¿Es Capicua?: \t\t\t[Retorna: false ]:\t\t" + esCapiculaDigitos(pilaCapi));

        System.out.println("");
        System.out.println("# Apilamos 1, tenemos un numero impar de elementos");
        System.out.println("");

        pilaCapi.apilar(1);
        System.out.println("Mostramos la pila:\t\t\t\t\t\t" + pilaCapi.toString());
        System.out.println("¿Es Capicua?:\t\t\t\t\t\t\t" + esCapiculaDigitos(pilaCapi));

        System.out.println("");
        System.out.println("# Vaciamos la pila");
        System.out.println("");
        pilaCapi.vaciar();
        System.out.println("Mostramos la pila:\t\t\t\t\t\t" + pilaCapi.toString());
        System.out.println("¿Es Capicua?:\t\t\t\t\t\t\t" + esCapiculaDigitos(pilaCapi));

        pilaCapi.apilar(1);
        pilaCapi.apilar(2);
        pilaCapi.apilar(2);
        pilaCapi.apilar(1);

        System.out.println("");
        System.out.println("# Apilamos 1, 2, 2");
        System.out.println("");
        System.out.println("Mostramos la pila:\t\t\t\t\t\t" + pilaCapi.toString());
        System.out.println("¿Es Capicua?:\t\t\t\t\t\t\t" + esCapiculaDigitos(pilaCapi));

        System.out.println("");
        System.out.println("# Apilamos 1, tenemos un numero par de elementoss");
        System.out.println("");
        System.out.println("Mostramos la pila:\t\t\t\t\t\t" + pilaCapi.toString());
        System.out.println("¿Es Capicua?:\t\t\t\t\t\t\t" + esCapiculaDigitos(pilaCapi));

    }

    public static boolean llenarPilaNumeros(int cant, Pila pila) {
        boolean exito = false;
        for (int i = 1; i <= cant; i++) {
            exito = pila.apilar(i);
        }
        return exito;
    }

    public static boolean esCapiculaDigitos(Pila pila) {
        boolean esCapicua = true;

        Pila pilaAuxUno = new Pila();
        Pila pilaClone = new Pila();

        if (!pila.esVacia()) {
            pilaClone = pila.clone();

            /* Apilamos todos los elementos de pila a pilaAuxUno y pilaAuxDos */
            while (pilaClone.obtenerTope() != null) {
                pilaAuxUno.apilar(pilaClone.obtenerTope());
                pilaClone.desapilar();
            }

            pilaClone = pila.clone();

            /* Recorremos las pilas para detectar si son capicua */
            while (pilaClone.obtenerTope() != null && esCapicua) {
                if (pilaClone.obtenerTope() != pilaAuxUno.obtenerTope()) {
                    esCapicua = false;
                }
                pilaClone.desapilar();
                pilaAuxUno.desapilar();
            }

        } else {
            esCapicua = false;
        }

        return esCapicua;
    }
}
