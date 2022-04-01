
package lineales.dinamicas;

/**
 * @author Gonzalo Piñeiro FAI-3172
 */

public class Nodo {
    private Object elem;
    private Nodo enlace;

    public Nodo(Object elemento, Nodo enlace) {
        /* Contructor del nodo */
        this.elem = elemento;
        this.enlace = enlace;
    }

    /* Modificadores */
    public void setElemento(Object elemento) {
        /* Asignamos el elemento */
        this.elem = elemento;
    }

    public void setEnlace(Nodo enlace) {
        /* Asignamos el enlace */
        this.enlace = enlace;
    }

    /* Observadores */
    public Object getElement() {
        /* Obtenemos el elelemtno del nodo */
        return this.elem;
    }

    public Nodo getEnlace() {
        /* Obtenemos el enlace del nodo */
        return this.enlace;
    }
}
