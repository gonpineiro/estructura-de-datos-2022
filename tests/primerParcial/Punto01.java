/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.primerParcial;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;

/**
 *
 * @author Gonzalo
 */
public class Punto01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Cola cola = new Cola();
        cola.poner('A');
        cola.poner('A');
        cola.poner('B');
        cola.poner('A');
        cola.poner('A');

        cola.poner('$');

        cola.poner('B');
        cola.poner('A');
        cola.poner('B');

        cola.poner('$');

        cola.poner('A');
        cola.poner('B');
        cola.poner('B');
        cola.poner('A');

        cola.poner('$');
        cola.poner('A');
        cola.poner('B');

        /* <- AABAA$BAB$ABBA$AB <- */
        System.out.println(contarCapicua(cola));
    }

    public static int contarCapicua(Cola cola) {

        int contar = 0;

        Cola colaClone = cola.clone();
        Lista listaTemp = new Lista();
        Pila pilaTemp = new Pila();

        /* Generamos una lista con los elementos para facilitar la iteracion */
        while (colaClone.obtenerFrente() != null) {
            listaTemp.insertar(colaClone.obtenerFrente(), listaTemp.longitud() + 1);
            colaClone.sacar();
        }

        while (listaTemp.longitud() != 0) {
            /* Iteramos hasta que la lista se encuentra vacia */
            if (listaTemp.localizar('$') != -1) {
                /*
                 * Guardamos los elementos a una pila y cola hasta encontrar el $, pero no
                 * guardamos el $
                 */
                while (listaTemp.recuperar(1) != (Object) '$') {
                    modificarEstr(pilaTemp, colaClone, listaTemp);
                }

                /* Eliminamos el simbolo $ */
                listaTemp.eliminar(1);

                if (esCapicua(pilaTemp, colaClone)) {
                    contar++;
                }

            } else {
                while (listaTemp.longitud() != 0) {
                    modificarEstr(pilaTemp, colaClone, listaTemp);
                }

                if (esCapicua(pilaTemp, colaClone)) {
                    contar++;
                }
            }
        }

        return contar;
    }

    /**
     * Recibe una pila y una cola, y va comparando el tope de la pila
     * con el frente de la cola, por cada comparacion eliminamos el tope de la pila
     * y el frente de la cola. Si encuentra un elemento difente, retorna un false,
     * si se vacian las esctructuras sin encontrar diferencia retorna un true. *
     */

    public static boolean esCapicua(Pila pila, Cola cola) {

        boolean control = true;
        while (pila.obtenerTope() != null && control) {
            if (pila.obtenerTope() != cola.obtenerFrente()) {
                control = false;

                /* Vaciamos la pila y la cola */
                pila.vaciar();
                cola.vaciar();
            }

            pila.desapilar();
            cola.sacar();
        }

        return control;
    }

    /**
     * Modifica las estructuras para luego realizar el control.
     */
    public static void modificarEstr(Pila pila, Cola cola, Lista lista) {
        Object elem = lista.recuperar(1);
        pila.apilar(elem);
        cola.poner(elem);
        lista.eliminar(1);
    }
}
