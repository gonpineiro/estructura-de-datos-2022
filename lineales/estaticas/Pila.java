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

    private Object[] arreglo;
    private int tope;
    private static final int TAMANIO = 20;

    public Pila() {
        this.arreglo = new Object[TAMANIO];
        this.tope = -1;
    }

    public boolean apilar(Object nuevoElem) {
        boolean exito;

        if (this.tope + 1 >= this.TAMANIO) {
            // error pila llena
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
        boolean exito;

        if (this.tope == -1) {
            // error pila vacia
            exito = false;
        } else {
            // asignamos un valor null al ultimo elemento de la pila
            this.arreglo[tope] = null;
            this.tope--;
            exito = true;
        }
        return exito;
    }

    @Override
    public String toString() {
        String str = "";

        int longi = this.arreglo.length;

        for (int i = 0; i < longi; i++) {
            str += " " + this.arreglo[i];
        }

        return str;
    }

    public Object obtenerTope() {
        Object valor;
        if (this.esVacia()) {
            // error pila vacia
            valor = "pila vacia";
        } else {
            valor = this.arreglo[tope];
        }
        return valor;
    }

    public boolean esVacia() {
        return this.tope == -1;
    }
    
    public void vaciar(){
        int ite = this.tope + 1;
        for (int j = 0; j < ite; j++) {
            this.arreglo[j] = null;
        }
    }

    @Override
    public Pila clone() {
        Pila pilaAux = new Pila();
        
        int ite = this.tope + 1;
        
        for (int i = 0; i < ite; i++) {
            pilaAux.apilar(this.arreglo[i]);
        }
        
        return pilaAux;
    }
}
