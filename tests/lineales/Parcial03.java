/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import jerarquicas.dinamicas.ArbolBin;
import lineales.dinamicas.Pila;

/**
 *
 * @author Gonzalo
 */
public class Parcial03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArbolBin arbol = new ArbolBin();

        arbol.insertar('A', null, 'I');
        arbol.insertar('D', 'A', 'I');

        arbol.insertar('B', 'A', 'D');
        arbol.insertar('E', 'D', 'D');

        arbol.insertar('C', 'B', 'D');

        System.out.println(arbol.toString());

        arbol.completarHermanos();

        System.out.println(arbol.toString());

    }

}
