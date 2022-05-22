package tests.jerarquicas;

import jerarquicas.dinamicas.ArbolGen;
import lineales.dinamicas.*;

public class TestGenericoTest {

        static String sOk = " OK! ";
        static String sErr = "ERROR";
        public static final String NEGRO = "";
        public static final String ROJO = "";
        public static final String VERDE = "";
        public static final String AMARILLO = "";
        public static final String AZUL = "";
        public static final String PURPLE = "";
        public static final String CYAN = "";
        public static final String BLANCO = "";

        public static final String ANSI_RED_BACKGROUND = "";
        public static final String ANSI_GREEN_BACKGROUND = "";
        public static final String ANSI_YELLOW_BACKGROUND = "";
        public static final String ANSI_BLUE_BACKGROUND = "";
        public static final String ANSI_PURPLE_BACKGROUND = "";
        public static final String ANSI_CYAN_BACKGROUND = "";
        public static final String ANSI_WHITE_BACKGROUND = "";

        public static final String RESET = "";

        public static void main(String args[]) {

                Lista lista = new Lista();
                lista.insertar(1, lista.longitud() + 1);
                lista.insertar(3, lista.longitud() + 1);
                lista.insertar(7, lista.longitud() + 1);
                lista.insertar(9, lista.longitud() + 1);
                lista.insertar(9, lista.longitud() + 1);

                ArbolGen a = new ArbolGen();

                a.insertar(1, null);

                a.insertar(2, 1);
                a.insertar(3, 1);
                a.insertar(4, 1);

                a.insertar(5, 3);
                a.insertar(6, 3);
                a.insertar(7, 3);

                a.insertar(9, 7);
                
                a.verificarPatron(lista);

        }

}
