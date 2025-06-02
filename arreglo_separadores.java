package ej_parcial;

public class arreglo_separadores {
    final static int MAX = 10;
final static int MAXS = 2;
    public static void main(String[] args) {
        char[] separadores = { ' ', '0' };
        char[] arreglo = { ' ', 'a', '0', 'b', 'c', 'u', ' ', 'p', ' ', ' ' };
        int inicio = 0;
        int fin = -1;

        while (inicio < MAX) {
            inicio = buscar_inicio(arreglo, separadores, fin + 1);
            if (inicio < MAX) {
                fin = buscar_fin(arreglo, separadores, inicio);
                System.out.println(inicio + "|" + fin);
            }
        }
    }

    public static boolean esSeparador(char elemento, char[] separadores) {
        boolean separador =false;
        for (int i = 0; i < MAXS; i++) {
            if (elemento == separadores[i]) {
               separador=true;
            }
        }
        return separador;
    }

    public static int buscar_inicio(char[] arreglo, char[] separadores, int inicio) {
        while (inicio < MAX && esSeparador(arreglo[inicio], separadores)) {
            inicio++;
        }
        return inicio;
    }

    public static int buscar_fin(char[] arreglo, char[] separadores, int inicio) {
        while (inicio < MAX && !esSeparador(arreglo[inicio], separadores)) {
            inicio++;
        }
        return inicio - 1;
    }
}
