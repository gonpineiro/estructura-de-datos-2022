package tests.simulacroSegundoParcial;

import conjuntistas.dinamicas.ABB;

public class Punto02 {
    public static void main(String args[]) {
        ABB arbol = new ABB();

        arbol.insertar(56);
        arbol.insertar(23);
        arbol.insertar(78);
        arbol.insertar(89);
        arbol.insertar(63);
        arbol.insertar(71);

        arbol.eliminarMinimo();

    }
}
