/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import jerarquicas.dinamicas.ArbolBin;

/**
 *
 * @author Gonzalo
 */
public class TestArbolBin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolBin arbol = new ArbolBin();

        arbol.insertar(1, null, 'I');
        arbol.insertar(3, 1, 'I');
        arbol.insertar(2, 1, 'D');
        arbol.insertar(4, 1, 'D');
        arbol.insertar(5, 1, 'D');
        arbol.insertar(6, 1, 'D');
        arbol.insertar(7, 1, 'D');
        
    }
}
