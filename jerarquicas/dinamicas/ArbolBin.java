package jerarquicas.dinamicas;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

public class ArbolBin {

    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    public boolean insertar(Object elementoNuevo, Object elementoPadre, char posicion) {
        /***
         * inseramos el elementoNuevo como uno de los hijos (I/D) indicados por pocicion
         * elementoPadre es el elemento que vamos a buscar por arbol
         * en caso de que no este retorna falso, si el hijo indicado esta ocupado
         * retorna falso
         */

        boolean retorno = true;

        // si el arbol esta vacio, lo guardamos como raiz
        if (this.raiz == null) {
            this.raiz = new NodoArbol(elementoNuevo, null, null);
        } else {
            // si el arbol no esta vacio, vamos a buscar a su padre por preorden
            retorno = auxInsertarPreorden(this.raiz, elementoNuevo, elementoPadre, posicion);
        }

        return retorno;
    }

    private boolean auxInsertarPreorden(NodoArbol raiz, Object nuevoElemento, Object elementoPadre, char posicion) {
        /***
         * buscamos en raiz el elemnto padre, pero si no es igual, recorremos preorden
         */
        boolean retorno = false;

        if (raiz.getElemento().equals(elementoPadre)) {
            // encontramos el padre a insertar
            if (posicion == 'I' && raiz.getIzquierdo() == null) {
                // si la pocicion es I, y el hijo izquierdo es null
                // insetamos el nuevo elemento
                raiz.setIzquierdo(new NodoArbol(nuevoElemento, null, null));
                retorno = true;
            }

            if (posicion == 'D' && raiz.getDerecho() == null) {
                // si la pocicion es D, y el hijo derecho es null
                // insetamos el nuevo elemento
                raiz.setDerecho(new NodoArbol(nuevoElemento, null, null));
                retorno = true;
            }
        } else {
            if (raiz.getIzquierdo() != null) {
                // si el hijo izquierdo es distinto null, entonces hacemos el llamado recursivo
                retorno = retorno || auxInsertarPreorden(raiz.getIzquierdo(), nuevoElemento, elementoPadre, posicion);
            }

            if (raiz.getDerecho() != null) {
                // si el hijo derecho es distinto de null, entonces hacemos el llamado recursivo
                retorno = retorno || auxInsertarPreorden(raiz.getDerecho(), nuevoElemento, elementoPadre, posicion);
            }
        }

        return retorno;
    }

    public boolean esVacio() {
        boolean retorno = false;
        if (this.raiz == null) {
            retorno = true;
        }

        return retorno;
    }

    public int altura() {
        int retorno = -1;

        if (this.raiz != null) {
            retorno = altura(this.raiz);
        }

        return retorno;
    }

    private int altura(NodoArbol raiz) {
        // vamos a evaluar si la raiz no es null
        int retorno = -1;

        if (raiz != null) {
            // vamos a recorrer en
            int retornoIzquirda = altura(raiz.getIzquierdo());
            int retornoDerecha = altura(raiz.getDerecho());

            if (retornoIzquirda >= retornoDerecha) {
                retorno = retornoIzquirda + 1;
            } else {
                retorno = retornoDerecha + 1;
            }
        }

        return retorno;
    }

    public int nivel(Object elemento) {
        int retorno = -1;

        if (this.raiz != null) {
            retorno = retorno + nivel(this.raiz, elemento);
        }
        return retorno;
    }

    private int nivel(NodoArbol raiz, Object elemento) {
        // evaluamos si el elemento es el nodo actual en ese caso retorno 1
        int retorno = 0;
        boolean control = true;

        if (raiz.getElemento().equals(elemento)) {
            retorno = 1;
        } else {

            // si el HI no es null, nos metemos
            if (raiz.getIzquierdo() != null) {
                int retornoIzquierda = nivel(raiz.getIzquierdo(), elemento);
                if (retornoIzquierda > 0) {
                    retorno = 1 + retornoIzquierda;
                    control = false;
                }
            }

            if (control && raiz.getDerecho() != null) {
                int retornoDerecha = nivel(raiz.getDerecho(), elemento);
                if (retornoDerecha > 0) {
                    retorno = 1 + retornoDerecha;
                }
            }
        }

        return retorno;
    }

    public Object padre(Object elemento) {
        Object retorno = null;

        if (!this.esVacio()) {
            if (!this.raiz.getElemento().equals(elemento)) {
                retorno = padre(this.raiz, elemento);
            }
        }

        return retorno;
    }

    private Object padre(NodoArbol raiz, Object elemento) {
        // el valor de retorno que esta seteado en null
        Object retorno = null;
        boolean control = true;

        if (raiz.getIzquierdo() != null) {
            // mientras que el hijo izquierdo no sea null
            if (raiz.getIzquierdo().getElemento().equals(elemento)) {
                retorno = raiz.getElemento();
                control = false;
            } else {
                retorno = padre(raiz.getIzquierdo(), elemento);
                if (retorno != null) {
                    control = false;
                }
            }
        }

        if (control && raiz.getDerecho() != null) {
            // mientras que el hijo derecho no sea null, y el control sea verdadero
            if (raiz.getDerecho().getElemento().equals(elemento)) {
                retorno = raiz.getElemento();
            } else {
                retorno = padre(raiz.getDerecho(), elemento);
            }
        }

        return retorno;
    }

    public Lista listarPreorden() {
        Lista preorden = new Lista();
        if (this.raiz != null) {
            listarPreorden(this.raiz, preorden);
        }
        return preorden;
    }

    private void listarPreorden(NodoArbol raiz, Lista preorden) {
        if (raiz != null) {
            preorden.insertar(raiz.getElemento(), preorden.longitud() + 1);

            listarPreorden(raiz.getIzquierdo(), preorden);
            listarPreorden(raiz.getDerecho(), preorden);
        }
    }

    public Lista listarPosorden() {
        Lista posorden = new Lista();
        if (this.raiz != null) {
            listarPosorden(this.raiz, posorden);
        }
        return posorden;
    }

    private void listarPosorden(NodoArbol raiz, Lista posorden) {
        if (raiz != null) {
            listarPosorden(raiz.getIzquierdo(), posorden);
            listarPosorden(raiz.getDerecho(), posorden);
            posorden.insertar(raiz.getElemento(), posorden.longitud() + 1);
        }
    }

    public Lista listarInorden() {
        Lista inorden = new Lista();
        if (this.raiz != null) {
            listarInorden(this.raiz, inorden);
        }
        return inorden;
    }

    private void listarInorden(NodoArbol raiz, Lista inorden) {
        if (raiz != null) {
            listarInorden(raiz.getIzquierdo(), inorden);
            inorden.insertar(raiz.getElemento(), inorden.longitud() + 1);
            listarInorden(raiz.getDerecho(), inorden);
        }
    }

    public Lista listarPorNiveles() {
        // usamos una cola para poder recorrer los niveles
        Cola cola = new Cola();
        Lista nivel = new Lista();
        if (raiz != null) {
            // ponemos el nodo raiz en la cola
            cola.poner(this.raiz);
            // recorremos mientras la cola no este vacia
            while (!cola.esVacia()) {
                // obtenemos el tope de la cola
                NodoArbol aux = (NodoArbol) cola.obtenerFrente();
                nivel.insertar(aux.getElemento(), nivel.longitud() + 1);
                cola.sacar();

                // si el hijo izquierdo no es vacio lo ponemos en la cola
                if (aux.getIzquierdo() != null) {
                    cola.poner(aux.getIzquierdo());
                }
                // si el hijo derecho no es vacio lo ponemos en la cola
                if (aux.getDerecho() != null) {
                    cola.poner(aux.getDerecho());
                }
            }
        }
        return nivel;
    }

    public ArbolBin clone() {
        ArbolBin clon = new ArbolBin();
        if (this.raiz != null) {
            clon.raiz = new NodoArbol(this.raiz.getElemento(), null, null);
            clone(this.raiz, clon.raiz);
        }

        return clon;
    }

    private void clone(NodoArbol raizOriginal, NodoArbol raizClone) {
        // vamos a evalur si tenemos el HI en el nodo original
        if (raizOriginal.getIzquierdo() != null) {
            // creamos un nodo arbol con los elementos de este HI
            NodoArbol cloneIzquierdo = new NodoArbol(raizOriginal.getIzquierdo().getElemento(), null, null);
            raizClone.setIzquierdo(cloneIzquierdo);
            clone(raizOriginal.getIzquierdo(), raizClone.getIzquierdo());
        }

        if (raizOriginal.getDerecho() != null) {
            // creamos un nodo arbol con los elementos de este HI
            NodoArbol cloneDerecho = new NodoArbol(raizOriginal.getDerecho().getElemento(), null, null);
            raizClone.setDerecho(cloneDerecho);
            clone(raizOriginal.getDerecho(), raizClone.getDerecho());
        }
    }

    public void vaciar() {
        this.raiz = null;
    }

    public String toString() {
        // retornamos un string
        String retorno = "Arbol vacio";

        if (this.raiz != null) {
            retorno = toString(this.raiz);
        }

        return retorno;
    }

    private String toString(NodoArbol raiz) {
        String retorno = "";
        if (raiz != null) {
            retorno = raiz.getElemento().toString() + ":";

            // obtenemos los hijos de este sub arbol
            NodoArbol izquierdo = raiz.getIzquierdo();
            NodoArbol derecho = raiz.getDerecho();
            // concatenamos lo que contengan esos hijos
            if (izquierdo != null) {
                retorno = retorno + " HI:" + izquierdo.getElemento().toString();
            } else {
                retorno = retorno + " HI:-";
            }

            if (derecho != null) {
                retorno = retorno + " HD:" + derecho.getElemento().toString();
            } else {
                retorno = retorno + " HD:-";
            }
            // creamos el salto de linea para darle formato
            retorno = retorno + "\n";
            // y relizamos algun recorrido de arbol
            if (izquierdo != null) {
                retorno = retorno + toString(izquierdo);
            }

            if (derecho != null) {
                retorno = retorno + toString(derecho);
            }
        }
        // retornamos dicho string generado
        return retorno;
    }

    public Lista frontera() {
        Lista retorno = new Lista();
        if (this.raiz != null) {
            frontera(this.raiz, retorno);
        }
        return retorno;
    }

    private void frontera(NodoArbol raiz, Lista lista) {
        // si el nodo no es null
        if (raiz != null) {
            // evaluamos si no tenemos HI y si no tenemos HD en caso insertamos
            if (raiz.getIzquierdo() == null && raiz.getDerecho() == null) {
                lista.insertar(raiz.getElemento(), 1);
            } else {
                // caos contrario buscamos en los subarboles
                if (raiz.getIzquierdo() != null) {
                    frontera(raiz.getIzquierdo(), lista);
                }
                if (raiz.getDerecho() != null) {
                    frontera(raiz.getDerecho(), lista);
                }
            }
        }
    }

}
