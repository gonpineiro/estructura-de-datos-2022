package lineales.estaticas;

/**
 * @author Gonzalo Piñeiro FAI-3172
 */

public class Pila {

    /* Un arreglo de tipo Object, elemento de la pila */
    private Object[] arreglo;

    /* Entero que indica el indice del ultimo elemento ingresado, -1 si es vacio */
    private int tope;

    /* Indica el tamaño maximo de la pila */
    private static final int TAMANIO = 10;

    public Pila() {
        /* Contructor de la pila */
        this.arreglo = new Object[TAMANIO];
        this.tope = -1;
    }

    public boolean apilar(Object nuevoElem) {
        /* Agrega un elemento */
        boolean exito;

        if (this.tope + 1 >= this.TAMANIO) {
            /* Error pila llena */
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
        /* Desapila un elemento de la pila, asigna el valor null */
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

    @Override
    public String toString() {
        /* Retorna los valores que contiene la pila en formato String */
        String str = "";
        int i = 0;

        if (!esVacia()) {
            str = "[";
            while (i <= this.tope) {
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

}
