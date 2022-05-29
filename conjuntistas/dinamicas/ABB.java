package conjuntistas.dinamicas;

import conjuntistas.dinamicas.NodoBB;
import lineales.dinamicas.Lista;

/**
 *
 * @author Gonzalo Piñeiro
 */
public class ABB {

    private NodoBB raiz;

    public ABB() {
        this.raiz = null;
    }

    public boolean insertar(Comparable elemento) {
        boolean retorno = false;

        if (this.raiz == null) {
            // en caso de no tener raiz la insertamos y retornamos true
            this.raiz = new NodoBB(elemento, null, null);
            retorno = true;
        } else {
            // en caso de tener raiz hacemos uso de un metodo recursivo
            retorno = insertar(this.raiz, elemento);
        }

        return retorno;
    }

    private boolean insertar(NodoBB subRaiz, Comparable elemento) {
        // comparamos con el elemento actual
        boolean retorno;
        if (subRaiz.getElemento().equals(elemento)) {
            retorno = false;
        } else {
            // en caso de que no sea igual a la raiz vamos a comprar con la raiz
            // comparamos con la raiz
            if (subRaiz.getElemento().compareTo(elemento) > 0) {
                // en caso de que sea menor a la subraiz
                if (subRaiz.getIzquierdo() != null) {
                    // en caso de tener un hijo izquierdo llamamos recursivamente
                    retorno = insertar(subRaiz.getIzquierdo(), elemento);
                } else {
                    // en caso de no tener un hijo izquierdo insertamos
                    subRaiz.setIzquierdo(new NodoBB(elemento, null, null));
                    retorno = true;
                }
            } else {
                // en caso de que sea mayor a la subraiz
                if (subRaiz.getDerecho() != null) {
                    // en caso de tener un hijo izquierdo llamamos recursivamente
                    retorno = insertar(subRaiz.getDerecho(), elemento);
                } else {
                    // en caso de no tener un hijo izquierdo insertamos
                    subRaiz.setDerecho(new NodoBB(elemento, null, null));
                    retorno = true;
                }
            }
        }
        return retorno;
    }

    public boolean eliminar(Comparable elemento) {
        boolean retorno = false;
        if (this.raiz != null) {
            if (this.raiz.getElemento().equals(elemento)) {
                // eliminamos la raiz por lo cual se refefine dicha raiz
                this.raiz = remplazar(this.raiz);
                retorno = true;
            } else if (this.raiz.getElemento().compareTo(elemento) > 0) {
                retorno = eliminar(this.raiz, this.raiz.getIzquierdo(), elemento, 'I');
            } else {
                retorno = eliminar(this.raiz, this.raiz.getDerecho(), elemento, 'D');
            }
        }
        return retorno;
    }

    private boolean eliminar(NodoBB padre, NodoBB subRaiz, Comparable elemento, char hijo) {
        boolean retorno = false;

        if (subRaiz != null) {
            Comparable x = subRaiz.getElemento();

            if (x.equals(elemento)) {
                NodoBB remplazo = remplazar(subRaiz);
                // en caso de que la raiz del subarbol sea el elemento se verifica alguna de las
                // condiciones
                if (hijo == 'I') {
                    padre.setIzquierdo(remplazo);
                } else {
                    // el subarbol es el hd de el padre
                    padre.setDerecho(remplazo);
                }
                retorno = true;
            } else {
                if (x.compareTo(elemento) > 0) {
                    retorno = eliminar(subRaiz, subRaiz.getIzquierdo(), elemento, 'I');
                } else {
                    retorno = eliminar(subRaiz, subRaiz.getDerecho(), elemento, 'D');
                }
            }
        }
        return retorno;
    }

    private NodoBB remplazar(NodoBB subRaiz) {
        NodoBB remplazo = null;
        // evaluamos la condicion de dicho subarbol
        switch (condicion(subRaiz)) {
            case 0:
                remplazo = null;
                break;
            case 1:
                remplazo = metodo2(subRaiz);
                break;
            case 2:
                remplazo = metodo3(subRaiz);
                break;
        }
        return remplazo;
    }

    private int condicion(NodoBB nodo) {
        int retorno = 0;
        // pasamos la raiz y evaluamos cuales de los metodos usar
        if (nodo.getIzquierdo() != null && nodo.getDerecho() != null) {
            // tenemos los dos hijos por lo que tenemos que usar el metodo 3
            retorno = 2;
        } else if (raiz.getIzquierdo() != null || raiz.getDerecho() != null) {
            // tiene al menos un hijo usamos el metodo 2
            retorno = 1;
        }
        // en caso de no pasar por alguno de los if esto significa que usa el metodo 1
        return retorno;
    }

    private NodoBB metodo2(NodoBB nodo) {
        NodoBB retorno;
        if (nodo.getIzquierdo() != null) {
            retorno = nodo.getIzquierdo();
        } else {
            retorno = nodo.getDerecho();
        }
        return retorno;
    }

    private NodoBB metodo3(NodoBB nodo) {
        // obtenemos nuestro candidato
        NodoBB candidatoDerecho = candidatoB(nodo.getDerecho());
        // obtenemos el valor de este nodo
        nodo.setElemento(candidatoDerecho.getElemento());
        // eliminamos el elemento de candidato a por D
        eliminar(nodo, nodo.getDerecho(), candidatoDerecho.getElemento(), 'D');
        // retornamos el nuevo nodo
        return nodo;
    }

    private int cantidadHijos(NodoBB nodo) {
        int hijos = 0;
        if (nodo.getIzquierdo() != null && nodo.getDerecho() != null) {
            // tiene los dos hijos
            hijos = 2;
        } else if (nodo.getIzquierdo() != null && nodo.getDerecho() == null) {
            // tiene al menos un hijo
            hijos = 1;
        }
        // en caso de que no pase por ningun if no tiene hijos
        return hijos;
    }

    private NodoBB candidatoA(NodoBB raiz) {
        NodoBB aux = raiz;
        while (aux.getDerecho() != null) {
            aux = aux.getDerecho();
        }
        return aux;
    }

    private NodoBB candidatoB(NodoBB raiz) {
        NodoBB aux = raiz;
        while (aux.getIzquierdo() != null) {
            aux = aux.getIzquierdo();
        }
        return aux;
    }

    public boolean pertenece(Comparable elemento) {
        boolean retorno = false;
        if (this.raiz != null) {
            retorno = perteneceAux(this.raiz, elemento);
        }
        return retorno;
    }

    private boolean perteneceAux(NodoBB subRaiz, Comparable elemento) {
        boolean retorno = false;
        // si el nodo no es null
        if (subRaiz != null) {
            // si el elemento es ta en esta nodo retorno true
            if (subRaiz.getElemento().equals(elemento)) {
                retorno = true;
            } else {
                // sino busco si es menor a el nodo por HI
                if (subRaiz.getElemento().compareTo(elemento) > 0) {
                    retorno = perteneceAux(subRaiz.getIzquierdo(), elemento);
                } else {
                    // sino busco por el ID
                    retorno = perteneceAux(subRaiz.getDerecho(), elemento);
                }
            }
        }
        return retorno;
    }

    public Lista lista() {
        Lista retorno = new Lista();

        if (this.raiz != null) {
            listaAux(this.raiz, retorno);
        }

        return retorno;
    }

    private void listaAux(NodoBB subRaiz, Lista retorno) {
        // recorremos en preorden
        if (subRaiz != null) {
            listaAux(subRaiz.getIzquierdo(), retorno);
            retorno.insertar(subRaiz.getElemento(), retorno.longitud() + 1);
            listaAux(subRaiz.getDerecho(), retorno);
        }
    }

    public Lista listarRango(Comparable minimo, Comparable maximo) {
        // vamos a buscar en el arbol los elementos en el rango
        Lista listaRango = new Lista();

        if (minimo.compareTo(maximo) <= 0) {
            // en caso de que minimos sea menor o igual a maximo
            // se ejecuta el algoritmo de comparacion
            if (this.raiz != null) {
                listaRangoAuz(this.raiz, listaRango, minimo, maximo);
            }
        }

        return listaRango;
    }

    private void listaRangoAuz(NodoBB subRaiz, Lista retorno, Comparable minimo, Comparable maximo) {
        // si la subraiz esta entre los maximos minimos
        if (subRaiz.getElemento().compareTo(minimo) >= 0 && subRaiz.getElemento().compareTo(maximo) <= 0) {
            // hacemos lo mismo con nuetro HI que es menor al subarbol
            if (subRaiz.getIzquierdo() != null) {
                // tenemos un HI por lo cual vamos a recorrerlo de la misma forma
                listaRangoAuz(subRaiz.getIzquierdo(), retorno, minimo, maximo);
            }
            // insertamos el elemento actual en la lista
            retorno.insertar(subRaiz.getElemento(), retorno.longitud() + 1);
            // hacemos los mismo con el HD que es el mayor del subarbol actual
            if (subRaiz.getDerecho() != null) {
                // tenemos un HD y vamos a recorrerlo
                listaRangoAuz(subRaiz.getDerecho(), retorno, minimo, maximo);
            }
        } else {
            // en caso de que no este entre el rango
            if (subRaiz.getDerecho() != null && subRaiz.getElemento().compareTo(minimo) < 0) {
                // en caso de que el subarbol sea manor al valor minimo busco por el lado
                // derecho
                listaRangoAuz(subRaiz.getDerecho(), retorno, minimo, maximo);
            } else {
                // en caso de se sea mayor al maximo buscamos por el lado izquierdo
                if (subRaiz.getIzquierdo() != null && subRaiz.getElemento().compareTo(maximo) > 0) {
                    listaRangoAuz(subRaiz.getIzquierdo(), retorno, minimo, maximo);
                }
            }
        }
    }

    public Comparable minimoElem() {
        Comparable minimo = null;
        if (this.raiz != null) {
            minimo = candidatoB(this.raiz).getElemento();
        }
        return minimo;
    }

    public Comparable maximoElem() {
        Comparable minimo = null;
        if (this.raiz != null) {
            minimo = candidatoA(this.raiz).getElemento();
        }
        return minimo;
    }

    public ABB clone() {
        ABB clon = new ABB();

        if (this.raiz != null) {
            clon.raiz = new NodoBB(this.raiz.getElemento(), null, null);
            // hacemos el llamado recursivo para ir armando el arbol
            cloneAux(this.raiz, clon.raiz);
        }

        return clon;
    }

    private void cloneAux(NodoBB subRaiz, NodoBB subRaizClone) {
        if (subRaiz != null) {
            if (subRaiz.getIzquierdo() != null) {
                // tenemos HI lo clonamos y los llamamos con ese
                subRaizClone.setIzquierdo(new NodoBB(subRaiz.getIzquierdo().getElemento(), null, null));
                // hacemos el llamado recursivo
                cloneAux(subRaiz.getIzquierdo(), subRaizClone.getIzquierdo());
            }

            if (subRaiz.getDerecho() != null) {
                // tenemos HD lo clonamos y los llamamos con ese
                subRaizClone.setDerecho(new NodoBB(subRaiz.getDerecho().getElemento(), null, null));
                // hacemos el llamado recursivo
                cloneAux(subRaiz.getDerecho(), subRaizClone.getDerecho());
            }
        }
    }

    public void vaciar() {
        // se eliminan por perdida de referencia
        this.raiz = null;
    }

    public boolean esVacio() {
        boolean retorno = true;
        if (this.raiz != null) {
            retorno = false;
        }
        return retorno;
    }

    public String toString() {
        // retornamos un string
        String retorno = "Arbol vacio";

        if (this.raiz != null) {
            retorno = auxToString(this.raiz);
        }

        return retorno;
    }

    private String auxToString(NodoBB raiz) {
        String retorno = "";
        if (raiz != null) {
            retorno = raiz.getElemento().toString() + ":";

            NodoBB izquierdo = raiz.getIzquierdo();
            NodoBB derecho = raiz.getDerecho();

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

            retorno = retorno + "\n";

            if (izquierdo != null) {
                retorno = retorno + auxToString(izquierdo);
            }

            if (derecho != null) {
                retorno = retorno + auxToString(derecho);
            }
        }
        return retorno;
    }

    /* Extras */

    public void eliminarMayores(Comparable elemento) {
        if (this.raiz != null) {
            Comparable elementoRaiz = this.raiz.getElemento();
            if (elementoRaiz.compareTo(elemento) >= 0) {
                this.raiz = primerMenor(this.raiz, elemento);
            } else {
                eliminarMayores(this.raiz, this.raiz.getDerecho(), elemento);
            }
        }
    }

    private void eliminarMayores(NodoBB padre, NodoBB nodo, Comparable elemento) {
        if (nodo != null) {
            if (nodo.getElemento().compareTo(elemento) >= 0) {
                padre.setDerecho(nodo.getIzquierdo());
                eliminarMayores(nodo, nodo.getDerecho(), elemento);
            } else {
                eliminarMayores(nodo, nodo.getDerecho(), elemento);
            }
        }
    }

    private NodoBB primerMenor(NodoBB nodo, Comparable elemento) {
        NodoBB retorno = null;
        if (nodo != null) {
            if (nodo.getElemento().compareTo(elemento) < 0) {
                if (nodo.getDerecho() != null) {
                    nodo.setDerecho(primerMenor(nodo.getDerecho(), elemento));
                }
                retorno = nodo;
            } else {
                retorno = primerMenor(nodo.getIzquierdo(), elemento);
            }
        }
        return retorno;
    }

    public void eliminarMenores(Comparable elemento) {
        if (this.raiz != null) {
            Comparable elementoRaiz = this.raiz.getElemento();
            if (elementoRaiz.compareTo(elemento) <= 0) {
                this.raiz = primerMayor(this.raiz, elemento);
            } else {
                eliminarMenoresAux(this.raiz, this.raiz.getIzquierdo(), elemento);
            }
        }
    }

    private void eliminarMenoresAux(NodoBB padre, NodoBB nodo, Comparable elemento) {
        if (nodo != null) {
            if (nodo.getElemento().compareTo(elemento) <= 0) {
                padre.setIzquierdo(nodo.getDerecho());
                eliminarMenoresAux(nodo, nodo.getIzquierdo(), elemento);
            } else {
                eliminarMenoresAux(nodo, nodo.getIzquierdo(), elemento);
            }
        }
    }

    private NodoBB primerMayor(NodoBB nodo, Comparable elemento) {
        NodoBB retorno = null;
        if (nodo != null) {
            if (nodo.getElemento().compareTo(elemento) > 0) {
                if (nodo.getIzquierdo() != null) {
                    nodo.setIzquierdo(primerMenor(nodo.getIzquierdo(), elemento));
                }
                retorno = nodo;
            } else {
                retorno = primerMenor(nodo.getDerecho(), elemento);
            }
        }
        return retorno;
    }

    public ABB clonarRango(Comparable minimo, Comparable maximo) {
        ABB clon = new ABB();
        if (this.raiz != null && minimo.compareTo(maximo) < 0) {
            clon.raiz = clonarRangoAux(minimo, maximo, this.raiz);
        }
        return clon;
    }

    private NodoBB clonarRangoAux(Comparable minimo, Comparable maximo, NodoBB node) {
        if (node != null) {
            NodoBB hd = node.getDerecho();
            NodoBB hi = node.getIzquierdo();
            Comparable elem = node.getElemento();
            if (elem.compareTo(minimo) >= 0 && elem.compareTo(maximo) <= 0) {
                node = new NodoBB(elem, null, null);
                node.setDerecho(clonarRangoAux(minimo, maximo, hd));
                node.setIzquierdo(clonarRangoAux(minimo, maximo, hi));
            } else {
                node = clonarRangoAux(minimo, maximo, hi);
                if (node == null) {
                    node = clonarRangoAux(minimo, maximo, hd);
                }
            }
        }
        return node;
    }

    public int amplitudSurabol(Comparable elemento) {
        int retorno = -1;
        if (this.raiz != null) {
            retorno = amplitudAux(this.raiz, elemento);
        }
        return retorno;
    }

    private int amplitudAux(NodoBB nodo, Comparable elemento) {
        int retorno = -1;
        NodoBB izquierdo = nodo.getIzquierdo();
        NodoBB derecho = nodo.getDerecho();
        // tenemos que tener al menos un hijo par apodever pasar
        if (izquierdo != null || derecho != null) {
            Comparable elem = nodo.getElemento();
            if (elem.equals(elemento)) {
                // pasamos a realizar el calculo de aplitud
                int valorRaiz = (int) elem;
                int valorIzquiedo = (int) derecho.getElemento();
                int valorDerecho = (int) izquierdo.getElemento();
                if (izquierdo != null && derecho != null) {
                    retorno = valorDerecho - valorIzquiedo;
                } else if (izquierdo != null) {
                    retorno = valorRaiz - valorIzquiedo;
                } else {
                    retorno = valorDerecho - valorRaiz;
                }
            } else if (elemento.compareTo(elem) < 0) {
                // si el elemento es menor pasamos a buscar pode la izquierda
                retorno = amplitudAux(izquierdo, elemento);
            } else {
                // sino por la derecha
                retorno = amplitudAux(derecho, elemento);
            }
        }
        return retorno;
    }

    public void eliminarMinimo() {
        if (raiz != null) {
            if (raiz.getIzquierdo() == null && raiz.getDerecho() == null) {
                /* Cuando la raiz es el unico elemento */
                raiz = null;
            } else {
                if (raiz.getIzquierdo() == null && raiz.getDerecho() != null) {
                    /* Cuando no tiene hijo izquierdo */
                    raiz = raiz.getDerecho();
                } else {
                    /* Cuando tiene hijo izquierdo */
                    eliminarMinimo(raiz);
                }
            }
        }
    }

    private void eliminarMinimo(NodoBB raiz) {
        if (raiz.getIzquierdo().getIzquierdo() == null) {
            raiz.setIzquierdo(null);
        } else {
            eliminarMinimo(raiz.getIzquierdo());
        }
    }
}
