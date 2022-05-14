package jerarquicas.dinamicas;

public class NodoGen {
    private Object elemento;
    private NodoGen hijoIzquierdo;
    private NodoGen HermanoDerecho;

    public NodoGen(Object elemento, NodoGen hijoIzquiedo, NodoGen hermanoDerecho) {
        this.elemento = elemento;
        this.hijoIzquierdo = hijoIzquiedo;
        this.HermanoDerecho = hermanoDerecho;
    }

    public Object getElemento() {
        return this.elemento;
    }

    public NodoGen getHijoIzquierdo() {
        return this.hijoIzquierdo;
    }

    public NodoGen getHermanoDerecho() {
        return this.HermanoDerecho;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public void setHijoIzquierdo(NodoGen hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setHermanoDerecho(NodoGen hermanoDerecho) {
        this.HermanoDerecho = hermanoDerecho;
    }
}
