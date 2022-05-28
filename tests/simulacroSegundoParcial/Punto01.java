package tests.simulacroSegundoParcial;

import jerarquicas.dinamicas.ArbolGen;
import lineales.dinamicas.Lista;

public class Punto01 {
    public static void main(String[] args) {
        ArbolGen arbol = new ArbolGen();

        Lista listaTrue = new Lista();
        listaTrue.insertar(20, listaTrue.longitud() + 1);
        listaTrue.insertar(54, listaTrue.longitud() + 1);
        listaTrue.insertar(27, listaTrue.longitud() + 1);
        listaTrue.insertar(17, listaTrue.longitud() + 1);
        
        Lista listaFalse = new Lista();
        listaFalse.insertar(20, listaTrue.longitud() + 1);
        listaFalse.insertar(17, listaTrue.longitud() + 1);

        arbol.insertar(20, null);
        arbol.insertar(13, 20);
        arbol.insertar(54, 20);

        arbol.insertar(15, 13);
        arbol.insertar(12, 13);

        arbol.insertar(11, 54);
        arbol.insertar(27, 54);
        arbol.insertar(4, 54);

        arbol.insertar(17, 27);

        System.out.println(arbol.verificarCamino(listaTrue));
        System.out.println(arbol.verificarCamino(listaFalse));

    }
}
