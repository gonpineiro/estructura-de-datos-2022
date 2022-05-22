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
public class Parcial02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Pila pila = new Pila();
        Pila pilaDos = new Pila();

        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        pila.apilar(4);

        pilaDos.apilar(1);
        pilaDos.apilar(2);
        pilaDos.apilar(3);
        pilaDos.apilar(4);

        pila.equals(pilaDos);
    }

}
