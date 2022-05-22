package jerarquicas.dinamicas;

import lineales.dinamicas.*;

public class ArbolGen {
    public NodoGen raiz;

    public ArbolGen() {
        this.raiz = null;
    }

    public boolean insertar(Object elemento, Object padre) {
        // vamos a evaluar si el arbol no esta vacio
        boolean retorno = false;

        if (this.raiz != null) {
            // vamos a evaluar que sea el elemento padre buscado
            retorno = insertar(elemento, padre, this.raiz);
        } else {
            this.raiz = new NodoGen(elemento, null, null);
            retorno = true;
        }
        return retorno;
    }

    private boolean insertar(Object elemento, Object padre, NodoGen raiz) {
        // vamos a comparar el padre con la raiz
        boolean retorno = false;

        // en caso de que elemento raiz se el padre que buscamos
        if (raiz.getElemento().equals(padre)) {
            // vamos a comparar que este tenga hi
            if (raiz.getHijoIzquierdo() != null) {
                NodoGen aux = raiz.getHijoIzquierdo();
                while (aux.getHermanoDerecho() != null) {
                    aux = aux.getHermanoDerecho();
                }
                // le asignamos un nuevo hermano al elemento
                aux.setHermanoDerecho(new NodoGen(elemento, null, null));
                retorno = true;
            } else {
                // en caso de no teber HI le setemos el elemento como uno
                raiz.setHijoIzquierdo(new NodoGen(elemento, null, null));
                retorno = true;
            }
        } else {
            // en caso de no ser el padre nos modemos en preorden por el arbol
            NodoGen aux = raiz.getHijoIzquierdo();

            while (aux != null && !retorno) {
                retorno = retorno || insertar(elemento, padre, aux);
                aux = aux.getHermanoDerecho();
            }
        }
        return retorno;
    }

    public boolean pertenece(Object elemento) {
        boolean retorno = false;

        if (this.raiz != null) {
            retorno = pertenece(elemento, this.raiz);
        }

        return retorno;
    }

    private boolean pertenece(Object elemento, NodoGen raiz) {
        boolean retorno = false;

        if (raiz.getElemento().equals(elemento)) {
            retorno = true;
        } else {
            NodoGen aux = raiz.getHijoIzquierdo();
            while (aux != null && !retorno) {
                retorno = retorno || pertenece(elemento, aux);
                aux = aux.getHermanoDerecho();
            }
        }

        return retorno;
    }

    public Lista ancestros(Object elemento) {
        Lista retorno = new Lista();
        if (this.raiz != null) {
            ancestros(this.raiz, elemento, retorno);
        }
        return retorno;
    }

    private boolean ancestros(NodoGen raiz, Object elemento, Lista lista) {
        // vamos a recorrer el arbol en preorden asta encontrar el elemento
        boolean retorno = false;
        if (raiz != null) {

            if (raiz.getElemento().equals(elemento)) {
                lista.insertar(raiz.getElemento(), 1);
                retorno = true;
            } else {
                NodoGen aux = raiz.getHijoIzquierdo();

                while (aux != null && !retorno) {
                    retorno = retorno || ancestros(aux, elemento, lista);
                    aux = aux.getHermanoDerecho();
                }
                if (retorno) {
                    lista.insertar(raiz.getElemento(), 1);
                }
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

    private int altura(NodoGen raiz) {
        int retorno = 0;

        // si la raiz no es null evaluamos
        if (raiz.getHijoIzquierdo() != null) {
            // vamos a obtener el resultado de el hijo mas a la izquirda
            NodoGen aux = raiz.getHijoIzquierdo();
            int retornoHijos = altura(aux);
            aux = aux.getHermanoDerecho();
            // mientras halla hijos repite
            while (aux != null) {
                int retornoLlamado = altura(aux);
                if (retornoHijos <= retornoLlamado) {
                    retornoHijos = retornoLlamado;
                }
                aux = aux.getHermanoDerecho();
            }

            retorno = retornoHijos + 1;
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

    public int nivel(NodoGen raiz, Object elemento) {
        int retorno = 0;

        if (raiz != null) {
            // si el elemento esta en el punto retornamos 1
            if (raiz.getElemento().equals(elemento)) {
                retorno = 1;
            } else {
                // busamos por los hijos
                NodoGen aux = raiz.getHijoIzquierdo();
                int retornoHijos;

                while (aux != null && retorno == 0) {
                    retornoHijos = nivel(aux, elemento);
                    if (retornoHijos > 0) {
                        retorno = retornoHijos + 1;
                    }
                    aux = aux.getHermanoDerecho();
                }
            }
        }

        return retorno;
    }

    public Object padre(Object elemento) {
        Object retorno = null;
        if (this.raiz != null) {
            if (!this.raiz.getElemento().equals(elemento)) {
                retorno = padre(this.raiz, elemento);
            }
        }
        return retorno;
    }

    private Object padre(NodoGen raiz, Object elemento) {
        //
        Object retorno = null;
        if (raiz != null) {
            NodoGen aux = raiz.getHijoIzquierdo();
            boolean control = true;
            while (control && aux != null) {
                if (aux.getElemento().equals(elemento)) {
                    retorno = raiz.getElemento();
                    control = false;
                } else {
                    Object retornoHijo = padre(aux, elemento);
                    if (retornoHijo != null) {
                        retorno = retornoHijo;
                        control = false;
                    }
                }
                aux = aux.getHermanoDerecho();
            }
        }
        return retorno;
    }

    public Lista listarPreorden() {
        Lista retorno = new Lista();
        if (this.raiz != null) {
            listarPreorden(this.raiz, retorno);
        }
        return retorno;
    }

    private void listarPreorden(NodoGen raiz, Lista retorno) {
        // vamos a mostrar el elemento de la raiz
        retorno.insertar(raiz.getElemento(), retorno.longitud() + 1);

        // vamos a recorrer los hermanos usando el mismo algitmo
        NodoGen aux = raiz.getHijoIzquierdo();
        while (aux != null) {
            // usamos preorden con el aux actual
            listarPreorden(aux, retorno);
            // pasamos al siguiente hermano
            aux = aux.getHermanoDerecho();
        }
    }

    public Lista listarInorden() {
        Lista inorden = new Lista();
        if (this.raiz != null) {
            listarInorden(this.raiz, inorden);
        }
        return inorden;
    }

    private void listarInorden(NodoGen raiz, Lista inorden) {
        // si la subraiz es no es null
        if (raiz != null) {
            // tomamos el hijo izquierdo de raiz
            NodoGen aux = raiz.getHijoIzquierdo();
            if (aux != null) {
                listarInorden(aux, inorden);
                aux = aux.getHermanoDerecho();
            }
            inorden.insertar(raiz.getElemento(), inorden.longitud() + 1);
            while (aux != null) {
                listarInorden(aux, inorden);
                aux = aux.getHermanoDerecho();
            }
        }
    }

    public Lista listarPosorden() {
        Lista posorden = new Lista();
        if (this.raiz != null) {
            listarPosorden(this.raiz, posorden);
        }
        return posorden;
    }

    private void listarPosorden(NodoGen raiz, Lista posorden) {
        if (raiz != null) {
            NodoGen aux = raiz.getHijoIzquierdo();
            while (aux != null) {
                listarPosorden(aux, posorden);
                aux = aux.getHermanoDerecho();
            }

            posorden.insertar(raiz.getElemento(), posorden.longitud() + 1);
        }
    }

    public Lista listarPorNiveles() {
        // vamos a usar una cola para iterar
        Lista retorno = new Lista();
        Cola q = new Cola();
        q.poner(this.raiz);

        while (!q.esVacia()) {
            NodoGen aux = (NodoGen) q.obtenerFrente();
            q.sacar();
            retorno.insertar(aux.getElemento(), retorno.longitud() + 1);
            aux = aux.getHijoIzquierdo();
            while (aux != null) {
                q.poner(aux);
                aux = aux.getHermanoDerecho();
            }
        }
        return retorno;
    }

    public ArbolGen clone() {
        ArbolGen clon = new ArbolGen();
        // verificamos si existe la raiz del arbol
        if (this.raiz != null) {
            // clonenamos la raiz del alrbol
            clon.raiz = new NodoGen(this.raiz.getElemento(), null, null);
            // relizamos el llamado recursivo
            clone(this.raiz, clon.raiz);
        }
        return clon;
    }

    private void clone(NodoGen raiz, NodoGen raizClone) {
        // vamos a evaluar que el nodo raiz no se anull
        if (raiz != null) {
            // en este caso vamos a clonar el elemento de los hijos de raiz
            NodoGen aux = raiz.getHijoIzquierdo();

            if (aux != null) {
                // creamos el hijos izquierdo de el raizclone
                raizClone.setHijoIzquierdo(new NodoGen(aux.getElemento(), null, null));
                // nos pocicionamos en el HI de el nodoClon
                NodoGen auxClone = raizClone.getHijoIzquierdo();
                while (aux.getHermanoDerecho() != null) {
                    // clonamos los nodos hijos de raizClone
                    // nos movemos al siguiente hijo
                    aux = aux.getHermanoDerecho();
                    auxClone.setHermanoDerecho(new NodoGen(aux.getElemento(), null, null));
                    auxClone = auxClone.getHermanoDerecho();
                }

                // vamos a llamar con los demas hijos
                aux = raiz.getHijoIzquierdo();
                auxClone = raizClone.getHijoIzquierdo();
                while (aux != null) {
                    clone(aux, auxClone);
                    aux = aux.getHermanoDerecho();
                    auxClone = auxClone.getHermanoDerecho();
                }
            }
        }
    }

    public void vaciar() {
        this.raiz = null;
    }

    public String toString() {
        return toString(this.raiz);
    }

    private String toString(NodoGen raiz) {
        String retorno = "";
        if (raiz != null) {
            // visitamos el nodo n
            retorno += raiz.getElemento().toString() + "->";
            NodoGen aux = raiz.getHijoIzquierdo();
            while (aux != null) {
                retorno += aux.getElemento().toString() + ",";
                aux = aux.getHermanoDerecho();
            }

            // comenzamos el recorrido por los hijos de la subraiz
            aux = raiz.getHijoIzquierdo();
            while (aux != null) {
                retorno += "\n" + toString(aux);
                aux = aux.getHermanoDerecho();
            }
        }
        return retorno;
    }

    public Lista frontera() {
        Lista retorno = new Lista();
        if (this.raiz != null) {
            frontera(this.raiz, retorno);
        }
        return retorno;
    }

    private void frontera(NodoGen nodo, Lista frontera) {
        if (nodo.getHijoIzquierdo() != null) {
            NodoGen aux = nodo.getHijoIzquierdo();
            while (aux != null) {
                frontera(aux, frontera);
                aux = aux.getHermanoDerecho();
            }
        } else {
            frontera.insertar(nodo.getElemento(), frontera.longitud() + 1);
        }
    }

    public int grado() {
        int grado;
        if (raiz != null) {
            grado = grado(this.raiz, 0);
        } else {
            grado = -1;
        }
        return grado;
    }

    public int gradoSubarbol(Object elemento) {

        NodoGen nodo = obtenerNodo(elemento);

        return grado(nodo.getHijoIzquierdo(), 0);
    }

    private NodoGen obtenerNodo(Object elemento) {
        NodoGen nodo = null;
        if (raiz.getElemento() == elemento) {
            nodo = raiz;
        } else {
            nodo = obtenerNodo(elemento, raiz);
        }

        return nodo;
    }

    private NodoGen obtenerNodo(Object elemento, NodoGen raiz) {
        NodoGen nodo = null;
        if (raiz != null) {

            if (raiz.getElemento() == elemento) {
                nodo = raiz;
            } else {
                /* Buscamos por los HI */
                nodo = obtenerNodo(elemento, raiz.getHijoIzquierdo());

                if (nodo == null) {
                    /* Sino encontramos el elemento por los HI */
                    nodo = obtenerNodo(elemento, raiz.getHermanoDerecho());
                }
            }
        }

        return nodo;
    }

    private int grado(NodoGen nodo, int grado) {
        int gradoLocal = 0;

        if (nodo != null) {
            gradoLocal = 1;

            NodoGen aux = nodo;
            while (aux.getHermanoDerecho() != null) {
                aux = aux.getHermanoDerecho();
                gradoLocal++;
            }

            if (grado < gradoLocal) {
                grado = gradoLocal;
            }

            grado = grado(nodo.getHijoIzquierdo(), grado);
            grado = grado(nodo.getHermanoDerecho(), grado);
        }

        return grado;
    }

    public boolean sonFrontera(Lista unaLista) {
        boolean exito = false;

        Lista listaClone = unaLista.clone();

        exito = sonFrontera(listaClone, raiz, true);

        return exito;
    }

    public boolean sonFrontera(Lista unaLista, NodoGen raiz, boolean control) {
        boolean exito = control;

        if (exito) {
            if (raiz.getHijoIzquierdo() != null) {
                NodoGen aux = raiz.getHijoIzquierdo();
                while (aux != null) {
                    sonFrontera(unaLista, aux, control);
                    aux = aux.getHermanoDerecho();
                }
            } else {
                if (unaLista.localizar(raiz.getElemento()) != -1) {
                    unaLista.eliminar(unaLista.localizar(raiz.getElemento()));
                    exito = sonFrontera(unaLista, raiz, control);
                } else {
                    exito = false;
                }
            }
        }
        return exito;
    }

    public boolean verificarPatron(Lista lista) {
        Lista listaClone = lista.clone();

        boolean exito = false;

        if (raiz.getElemento() == listaClone.recuperar(1)) {
            listaClone.eliminar(1);
            exito = verificarPatron(listaClone, raiz.getHijoIzquierdo());
        }

        return exito;

    }

    private boolean verificarPatron(Lista lista, NodoGen nodo) {
        boolean exito = true;

        if (nodo != null) {
            if (nodo.getElemento() == lista.recuperar(1)) {
                lista.eliminar(1);
                if (nodo.getHijoIzquierdo() != null) {
                    exito = verificarPatron(lista, nodo.getHijoIzquierdo());
                } else {
                    exito = verificarPatron(lista, nodo.getHermanoDerecho());
                }
            } else {
                if (nodo.getHermanoDerecho() != null) {
                    exito = verificarPatron(lista, nodo.getHermanoDerecho());
                }
            }
        } else {
            if (lista.longitud() != 0) {
                exito = false;
            }
        }

        return exito;
    }

}
