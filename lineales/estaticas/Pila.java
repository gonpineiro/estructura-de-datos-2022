/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @author Gonzalo
 * 
 *         1. Crear un paquete lineales.estaticas e implementar la clase Pila,
 *         incluyendo todas las operaciones del TDA Pila.
 * 
 *         2. Crear un paquete tests.lineales e implementar la clase TestPila
 *         que permita probar todas las operaciones
 *         la clase Pila anterior con números enteros.
 * 
 *         3. En la clase TestPila escriba un método que, dada una pila llena
 *         con dígitos (0..9), veri que si la secuencia forma un número capicúa
 *         o no.
 *         Nota: Utilizar una pila auxiliar para facilitar la operación.
 * 
 *         4. Extienda la clase TestPila para comprobar que la misma clase Pila
 *         también funciona con elementos de tipo String
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
        int i = 0;

        if (!esVacia()) {
            str = "[";
            while ( i <= this.tope) {
                str = str + this.arreglo[i].toString();
                if (i < this.tope) {
                    str = str + ",";
                }
                i++;
            }
            str = str + "]";
        } else {
            str = "Pila Vacia!";
        }
        return str;
    }

    public Object obtenerTope() {
        /* Obtenemos el tope de la pila y lo retornamos */
        Object retorno = null;
        if (this.tope >= 0) {
            retorno = this.arreglo[this.tope];
        }
        return retorno;
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
        Pila clon = new Pila();
        int i = 0;

        while (i <= this.tope) {
            clon.arreglo[i] = this.arreglo[i];
            i++;
        }
        clon.tope = this.tope;
        return clon;
    }

    public boolean esCapiculaDigitos() {
        boolean esCapicua = true;

        if (!this.esVacia()) {

            /* Generamos una pila aux */
            Pila pilaAux = new Pila();

            int posicion = this.tope;
            do {
                /*
                 * Apilamos los elementos de la pila original a la auxiliar, asi obtenemos una
                 * pila invertida
                 */
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
