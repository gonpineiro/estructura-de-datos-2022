/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apuntes;

/**
 *
 * @author Gonzalo
 */
public class Punto {

    // atributos
    private double x;
    private double y;

    public int comparteTo(Object obj) {
        // se compara tomando el primer lugar x y luego y

        int resultado;
        Punto otro = (Punto) obj;
        if (this.x < otro.x) {
            resultado = -1;
        } else if (this.x > otro.x) {
            resultado = 1;
        } else {
            // x es igual, debo ver a y
            if (this.y < otro.y) {
                resultado = -2;
            } else if (this.y > otro.y) {
                resultado = 2;
            } else {
                resultado = 0;
            }
        }
        return resultado;
    }

    public Punto(double nX, double nY) {
        this.x = nX;
        this.y = nY;
    }

    @Override
    public String toString() {
        return "Punto{" + "x=" + x + ", y=" + y + '}';
    }

    @Override
    public boolean equals(Object obj) {
        boolean res;
        if (obj == null) {
            res = false;
        } else {
            Punto otro = (Punto) obj;
            res = (this.x == otro.x && this.y == otro.y);
        }

        return res;
    }

    // interfaz
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
