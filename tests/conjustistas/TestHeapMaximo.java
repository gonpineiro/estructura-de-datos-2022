package tests.conjustistas;

import conjuntitas.estaticas.ArbolHeapMaximo;

public class TestHeapMaximo {
    public static void main(String args[]) {
        ArbolHeapMaximo arbol = new ArbolHeapMaximo();

        arbol.insertar(10);
        arbol.insertar(6);
        arbol.insertar(7);
        arbol.insertar(2);
        arbol.insertar(5);
        arbol.insertar(8);
        arbol.insertar(4);
        arbol.insertar(2);
        arbol.insertar(11);
    }
}
