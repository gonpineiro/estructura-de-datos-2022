/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;

/**
 *
 * @author Gonzalo
 */
public class Parcial01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Cola cola = new Cola();
        cola.poner('A');
        cola.poner('A');
        cola.poner('A');
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

        contarCapicua(cola);
    }

    public static int contarCapicua(Cola cola) {
        /* <- AABAA$BAB$ABBA$AB <- */
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
            if (listaTemp.localizar('$') != -1) {

                /*
                 * Guardamos los elementos a una pila y cola hasta encontrar el $, pero no
                 * guardamos el $
                 */
                while (listaTemp.recuperar(1) != (Object) '$') {
                    Object elem = listaTemp.recuperar(1);
                    pilaTemp.apilar(elem);
                    colaClone.poner(elem);
                    listaTemp.eliminar(1);
                }

                /* Eliminamos el simbolo $ */
                listaTemp.eliminar(1);

                boolean control = true;
                while (pilaTemp.obtenerTope() != null && control) {
                    if (pilaTemp.obtenerTope() != colaClone.obtenerFrente()) {
                        control = false;

                        /* Vaciamos la pila y la cola */
                        pilaTemp.vaciar();
                        colaClone.vaciar();
                    }

                    /* Retiramos el elemento que fue comparado */
                    pilaTemp.desapilar();
                    colaClone.sacar();
                }

                if (control) {
                    contar++;
                }
            } else {
                while (listaTemp.longitud() != 0) {
                    Object elem = listaTemp.recuperar(1);
                    pilaTemp.apilar(elem);
                    colaClone.poner(elem);
                    listaTemp.eliminar(1);
                }

                boolean control = true;
                while (pilaTemp.obtenerTope() != null && control) {
                    if (pilaTemp.obtenerTope() != colaClone.obtenerFrente()) {
                        control = false;

                        /* Vaciamos la pila y la cola */
                        pilaTemp.vaciar();
                        colaClone.vaciar();
                    }

                    pilaTemp.desapilar();
                    colaClone.sacar();
                }

                if (control) {
                    contar++;
                }
            }

        }

        return contar;
    }
}
