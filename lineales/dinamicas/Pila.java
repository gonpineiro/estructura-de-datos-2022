/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author Gonzalo
 * 
 *         1. Crear un paquete lineales.dinamicas e implementar las clases Pila
 *         y Nodo, con todas las operaciones especi cadas para el TDA Pila
 * 
 *         2. Utilice la clase TestPila del paquete tests.lineales anterior
 *         (Ejercicio 2.1) para probar que todas las operaciones de
 *         la clase Pila funcionan igual que antes (debe lograrlo cambiando
 *         solamente el nombre del paquete importado).
 * 
 *         3. En el paquete tests.lineales agregue clases para probar las
 *         operaciones de la clase Pila con elementos del TDA
 *         Alumno de nido en el Apunte 1 (Introducción y Repaso).
 */

public class Pila {

    private Nodo tope;

    public Pila() {
        /* Contructor de la pila */
        this.tope = null;
    }

    /**
     * Ingresamos un nodo a la Pila
     * 
     * @return booleano
     */
    public boolean apilar(Object elemento) {
        // creamos un nodo y le enlasamos con el tope
        Nodo nuevo = new Nodo(elemento, this.tope);
        // ahora el tope es el nuevo nodo
        this.tope = nuevo;

        // retornamos true
        return true;
    }

    /**
     * sacamos el elemento tope de la pila
     * 
     * @return booleano
     */
    public boolean desapilar() {
        boolean retorno = false;
        if (!this.esVacia()) {
            Nodo nuevo = this.tope.getEnlace();
            this.tope = nuevo;
            retorno = true;
        }
        return retorno;
    }

    /**
     * obtenemos el elemento tope de la pila
     * 
     * @return Object
     */
    public Object obtenerTope() {
        Object retorno;
        if (!esVacia()) {
            retorno = this.tope.getElement();
        } else {
            retorno = null;
        }
        return retorno;
    }

    /**
     * verificamos si la pila esta vacia
     * 
     * @return boolean
     */
    public boolean esVacia() {
        return this.tope == null;
    }

    /**
     * vaciamos la pila
     */
    public void vaciar() {
        this.tope = null;
    }

    /**
     * retornamos una cadena con la pila en el orden en que fue apilado
     * 
     * @return String
     */
    public String toString() {
        String value = "Pila vacia";

        if (this.tope == null) {
            value = "Pila Vacia!";
        } else {
            value = "[" + toStringStep(this.tope) + "]";
        }
        return value;
    }

    private String toStringStep(Nodo actual) {
        String element = "";
        if (actual.getEnlace() == null) {
            /* Caso base */
            element = actual.getElement().toString();
        } else {
            /* Paso Recursivo */
            element = this.toStringStep(actual.getEnlace()) + "," + actual.getElement().toString();
        }
        return element;
    }

    /**
     * retornamos un clon de la pila actual
     * 
     * @return Pila
     */

    public Pila clone() {
        Pila clon = new Pila();
        this.cloneRecursivoStep(clon, this.tope);
        return clon;
    }

    /**
     * es el paso recursivo para armar la pila clon
     * 
     * @param pilaClon
     * @param enlace
     */
    private void cloneRecursivoStep(Pila pilaClon, Nodo enlace) {

        if (enlace != null) {
            // nos movemos al siguiente enlace
            Nodo enlaceTope = enlace.getEnlace();
            // llamamos a la funcion recursivamente
            cloneRecursivoStep(pilaClon, enlaceTope);
            // apilamos los elementos del nodo cuando salimos
            pilaClon.tope = new Nodo(enlace.getElement(), pilaClon.tope);
        }
    }
}