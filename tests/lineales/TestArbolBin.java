/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import jerarquicas.dinamicas.ArbolBin;
import jerarquicas.dinamicas.NodoArbol;
import lineales.dinamicas.Lista;

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

        arbol.insertar(2, 1, 'I');
        arbol.insertar(3, 1, 'D');

        arbol.insertar(4, 2, 'I');
        arbol.insertar(5, 2, 'D');

        arbol.insertar(6, 3, 'D');
        arbol.insertar(8, 6, 'D');
        arbol.insertar(9, 8, 'D');

        Lista lista = arbol.obtenerAncestros(9);
        
        Lista listaDesc = arbol.obtenerDescendientes(3);

        System.out.println(listaDesc.toString());
        
    }
}
