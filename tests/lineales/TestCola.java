/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import lineales.estaticas.Cola;

/**
 *
 * @author Gonzalo
 */
public class TestCola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cola cola = new Cola();

        System.out.println("");
        System.out.println("----------------------------------------------------");
        System.out.println("# Inicilizamos una cola:");
        System.out.println("----------------------------------------------------");
        System.out.println("");

        System.out.println("¿Está vacia?:\t\t\t[Retorna: true ]:\t\t" + cola.esVacia());
        System.out.println("Obtenemos el frente:\t\t[Retorna: null ]:\t\t" + cola.obtenerFrente());
        System.out.println("Mostramos la cola:\t\t[Retorna: 'Pila vacia' ]:\t" + cola.toString());

        System.out.println("");
        System.out.println("# Ponemos el 12 como entero");
        System.out.println("");

        cola.poner(12);
        System.out.println("¿Está vacia?:\t\t\t[Retorna: false ]:\t\t" + cola.esVacia());
        System.out.println("Obtenemos el frente:\t\t[Retorna: 12 ]:\t\t\t" + cola.obtenerFrente());
        System.out.println("Mostramos la cola:\t\t[Retorna: [12] ]:\t\t" + cola.toString());

        System.out.println("");
        System.out.println("# Ponemos el 25, 48, y 23 como enteros, en ese orden");
        System.out.println("");

        cola.poner(25);
        cola.poner(48);
        cola.poner(23);

        System.out.println("¿Está vacia?:\t\t\t[Retorna: false ]:\t\t" + cola.esVacia());
        System.out.println("Obtenemos el frente:\t\t[Retorna: 12 ]:\t\t\t" + cola.obtenerFrente());
        System.out.println("Mostramos la cola:\t\t\t\t\t\t" + cola.toString());

        System.out.println("");
        System.out.println("# Llenamos la Cola");
        System.out.println("");

        cola.poner(59);
        cola.poner(75);
        cola.poner(16);
        cola.poner(36);
        cola.poner(51);

        System.out.println("Ponemos 1 elemento :\t\t[Retorna: * ]:\t\t\t" + cola.poner(50)
                + "\t\t * false: estática, TAMANIO > 10 | true: dinamicas");
        System.out.println("# Mostramos la cola:\t\t\t\t\t\t" + cola.toString());
        System.out.println("Sacamos un elemento:\t[Retorna: true ]:\t\t" + cola.sacar());
        System.out.println("Mostramos la cola:\t\t\t\t\t\t" + cola.toString());
        System.out.println("Sacamos un elemento:\t[Retorna: true ]:\t\t " + cola.sacar());
        System.out.println("Mostramos la cola:\t\t\t\t\t\t" + cola.toString());

        System.out.println("");
        System.out.println("# Vaciamos la cola:\t\t");
        System.out.println("");

        cola.vaciar();
        System.out.println("Mostramos la cola:\t\t\t\t\t\t" + cola.toString());
        System.out.println("Sacamos un elemento:\t[Retorna: false ]:\t\t" + cola.sacar());

        /* Fin Pruebas basicas */

        /* Incio prueba clonar */
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("# Clonamos la cola a una cola Aux, agregamos elementos a cola para no clonar un vacio");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("");

        System.out.println("Ponemos el 59:\t\t\t[Retorna: true ]:\t\t" + cola.poner(59));
        Cola colaAux = cola.clone();
        System.out.println("¿Está vacia?:\t\t\t[Retorna: false ]:\t\t" + cola.esVacia());
        System.out.println("Mostramos la colaAux:\t\t\t\t\t\t" + colaAux.toString());
        System.out.println("Mostramos la colaAux:\t\t\t\t\t\t" + colaAux.toString());
        System.out.println("Obtenemos el frente:\t\t[Retorna: 59 ]:\t\t\t" + colaAux.obtenerFrente());
        System.out.println("Ponemos un numero:\t\t[Retorna: * ]:\t\t\t" + colaAux.poner(99));
        System.out.println("Sacamos un elemento:\t[Retorna: true ]:\t\t" + colaAux.sacar());
        System.out.println("Obtenemos el frente:\t\t[Retorna: 8 ]:\t\t\t" + colaAux.obtenerFrente());

        System.out.println("");
        System.out.println("# Vaciamos la colaAux:\t\t");
        System.out.println("");

        colaAux.vaciar();
        System.out.println("Mostramos la cola:\t\t\t\t\t\t" + colaAux.toString());
        System.out.println("Sacamos un elemento:\t[Retorna: false ]:\t\t" + colaAux.sacar());

        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("# Prueba Cola String,  Inicilizamos una colaString:");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("");

        Cola colaString = new Cola();
        System.out.println("# Ponemos un 'Primer elemento'");
        System.out.println("");

        System.out.println("¿Está vacia?:\t\t\t[Retorna: true ]:\t\t" + colaString.esVacia());
        System.out.println("Obtenemos el frente:\t\t[Retorna: null ]\t\t" + colaString.obtenerFrente());
        System.out.println("Mostramos la cola:\t\t\t\t\t\t" + colaString.toString());
        System.out.println("Ponemos 1 elemento:\t\t[Retorna: true ]:\t\t" + colaString.poner("Primer Elemento"));
        System.out.println("¿Está vacia?:\t\t\t[Retorna: false ]:\t\t" + colaString.esVacia());
        System.out.println("Obtenemos el frente:\t\t\t\t\t\t" + colaString.obtenerFrente());
        System.out.println("Mostramos la cola:\t\t\t\t\t\t" + colaString.toString());

        System.out.println("");
        System.out.println("# Ponemos Nueve elementos mas");
        System.out.println("");

        colaString.poner("Segundo Elemento");
        colaString.poner("Tercer Elemento");
        colaString.poner("Cuarto Elemento");
        colaString.poner("Quinto Elemento");
        colaString.poner("Sexto Elemento");
        colaString.poner("Septimo Elemento");
        colaString.poner("Octavo Elemento");
        colaString.poner("Noveno Elemento");
        colaString.poner("Decimo Elemento");

        System.out.println("Mostramos la cola:\t\t\t\t\t\t" + colaString.toString());
        System.out.println("Obtenemos el frente:\t\t\t\t\t\t" + colaString.obtenerFrente());
        System.out.println("Ponemos 1 elemento:\t\t[Retorna: false ]:\t\t" + colaString.poner("Nuevo Elemento"));
        System.out.println("Sacamos un elemento:\t[Retorna: true ]:\t\t" + colaString.sacar());
        System.out.println("Obtenemos el frente:\t\t\t\t\t\t" + colaString.obtenerFrente());

        System.out.println("");
        System.out.println("# Vaciamos la cola");
        System.out.println("");

        colaString.vaciar();
        System.out.println("¿Está vacia?:\t\t\t[Retorna: true ]:\t\t" + colaString.esVacia());
        System.out.println("Obtenemos el frente:\t\t[Retorna: null ]:\t\t" + colaString.obtenerFrente());
        System.out.println("Sacamos un elemento:\t[Retorna: false ]:\t\t" + colaString.sacar());
        System.out.println("Mostramos la cola:\t\t[Retorna: 'Pila vacia' ]:\t" + colaString.toString());

    }
}
