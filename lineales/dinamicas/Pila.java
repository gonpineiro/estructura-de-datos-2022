/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 * @author Gonzalo Piñeiro FAI-3172
 */

public class Pila {

    private Nodo tope;

    public Pila() {
        /* Contructor de la pila */
        this.tope = null;
    }

    public boolean apilar(Object elemento) {
        /* Creamos un nodo y lo enlazamos con el tope */
        Nodo nuevo = new Nodo(elemento, this.tope);

        /* Ahora el tope es el nuevo nodo */
        this.tope = nuevo;

        return true;
    }

    public boolean desapilar() {
        /* Desapila un nodo de la pila */
        boolean exito = false;
        if (!this.esVacia()) {
            Nodo nuevo = this.tope.getEnlace();
            this.tope = nuevo;
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope() {
        /* Obtenemos el tope de la pila */
        Object elemento;
        if (!esVacia()) {
            elemento = this.tope.getElement();
        } else {
            elemento = null;
        }
        return elemento;
    }

    public boolean esVacia() {
        /* Verificamos si es vacia */
        return this.tope == null;
    }

    public void vaciar() {
        /* Vaciamos la pila */
        this.tope = null;
    }

    public String toString() {
        /* Mostramos la pila */
        String value = "Pila vacia";

        if (this.tope == null) {
            value = "Pila Vacia!";
        } else {
            /* LLamado de funcion recursiva */
            value = "[" + toString(this.tope) + "]";
        }
        return value;
    }

    private String toString(Nodo actual) {
        String element = "";
        if (actual.getEnlace() == null) {
            /* Caso base */
            element = actual.getElement().toString();
        } else {
            /* Paso Recursivo */
            element = this.toString(actual.getEnlace()) + "," + actual.getElement().toString();
        }
        return element;
    }

    public Pila clone() {
        /* Clonamos una pila */
        Pila clon = new Pila();
        this.clone(clon, this.tope);
        return clon;
    }

    private void clone(Pila pilaClon, Nodo enlace) {

        if (enlace != null) {
            /* Nos movemos el siguente enlace */
            Nodo enlaceTope = enlace.getEnlace();

            /* Llamamos la funcion recursivamente */
            clone(pilaClon, enlaceTope);

            /* Apilamos los elementos del nodo y salimos */
            pilaClon.tope = new Nodo(enlace.getElement(), pilaClon.tope);
        }
    }
}