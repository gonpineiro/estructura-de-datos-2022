/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @author Gonzalo
 */
public class Pila {

    /* Un arreglo de tipo Object, elemento de la pila */
    private Object[] arreglo;
    
    /* Entero que indica el indice del ultimo elemento ingresado, -1 si es vacio */
    private int tope;
    
    /* Indica el tamaño maximo de la pila */
    private static final int TAMANIO = 20;

    public Pila() {
        /* Contructor de la pila */
        this.arreglo = new Object[TAMANIO];
        this.tope = -1;
    }

    public boolean apilar(Object nuevoElem) {
        /* Agrega a la pila un elemento */
        boolean exito;

        if (this.tope + 1 >= this.TAMANIO) {
            /* Error pila vacia */
            exito = false;
        } else {
            // pone el elemento en el tope de la pila
            this.tope++;
            this.arreglo[tope] = nuevoElem;
            exito = true;
        }
        return exito;
    }

    public boolean desapilar() {
        /* Desapila un elemento de la pila, asigna el valor null a la pila */
        boolean exito;

        if (this.tope == -1) {
            /* Error pila vacia */
            exito = false;
        } else {
            /* asignamos un valor null a la ultima posicion que tiene un elemento */
            this.arreglo[tope] = null;
            this.tope--;
            exito = true;
        }
        return exito;
    }

    @Override
    public String toString() {
        /* Retorna los valores que contiene la pila en formato String */

        String str = "";

        int longi = this.arreglo.length;

        for (int i = 0; i < longi; i++) {
            str += this.arreglo[i] + ", ";
        }

        return str;
    }

    public Object obtenerTope() {
        /* Obtenemos el tope de la pila y lo retornamos */
        Object valor;
        if (this.esVacia()) {
            /* Error pila vacia */
            valor = "pila vacia";
        } else {
            /* Guardamos el tope en valor */
            valor = this.arreglo[tope];
        }
        return valor;
    }

    public boolean esVacia() {
        /* Retorna un booleano informando si la pila esta vacia o tiene un elemento */
        return this.tope == -1;
    }

    public void vaciar() {
        /* Vacia toda la pila */

        int ite = this.tope + 1;
        for (int j = 0; j < ite; j++) {
            this.arreglo[j] = null;
        }
        this.tope = -1;
    }

    @Override
    public Pila clone() {
        /* Clona la pila actual, y retona la pila clonada */
        Pila pilaAux = new Pila();

        int ite = this.tope + 1;

        for (int i = 0; i < ite; i++) {
            pilaAux.apilar(this.arreglo[i]);
        }

        return pilaAux;
    }

    public boolean esCapiculaDigitos() {
        boolean esCapicua = true;

        if (!this.esVacia()) {

            /* Generamos una pila aux */
            Pila pilaAux = new Pila();

            int posicion = this.tope;
            do {
                /* Apilamos los elementos de la pila original a la auxiliar, asi obtenemos una pila invertida */
                pilaAux.apilar(this.arreglo[posicion]);
                posicion--;
            } while (this.tope != pilaAux.tope);

            posicion = this.tope;
            do {
                if (this.arreglo[posicion] != pilaAux.obtenerTope()) {
                    esCapicua = false;
                }
                posicion--;
                pilaAux.desapilar();

            } while (esCapicua && posicion != -1);

        } else {
            /* Como la pila se encuentra vacia, no podemos decir que es capicua */
            esCapicua = false;
        }

        return esCapicua;
    }
}
