package matrices;

public class ej_prefinal {
    final static int MAXF = 4;
    final static int MAXC = 16;
    final static char SEPARADOR = ' ';

    public static void main(String [] args) {
        char[][] matriz = {
                { ' ', 'e', 'l', ' ', 'a', 'g', 'e', 'n', 't', 'e', ' ', ' ', ' ', ' ', ' ', ' '},
                { ' ', 'J', 'a', 'm', 'e', 's', ' ', 'B', 'o', ' ', 's', 'e', ' ', ' ', ' ', ' '},
                { ' ', 'e', 'n', 'c', 'u', 'e', 'n', 't', 'r', 'a', ' ', 'e', 'n', ' ', ' ', ' '},
                { ' ', 'C', 'o', 'l', 'o', 'n', 'i', 'a', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '} };
        for (int i = 0; i < MAXF; i++) {
            recorrer_matriz(matriz[i]);
        }
        imprimir_matriz(matriz);
    }

    public static void imprimir_matriz(char[][] matriz) {
        for (int f = 0; f < MAXF; f++) {
            for (int c = 0; c < MAXC; c++) {
                System.out.print(matriz[f][c] + " ");
            }
            System.out.println();
        }
    }

    public static void recorrer_matriz(char [] arreglo) {
        int inicio = 0;
        int fin = -1;
        while (inicio < MAXC) {
            inicio = buscar_inicio(arreglo, fin + 1);
            if (inicio < MAXC) {
                fin = buscar_fin(arreglo, inicio);
                if (arranca_mayuscula(arreglo, inicio)) {
                     invertir_secuencia(arreglo, inicio, fin);
                    for (int i = inicio; i <= fin; i++) {
                        if (es_vocal(arreglo[i])) {
                            corrimiento_derecha(arreglo, i);
                            i++;
                           fin++;
                        }
                    }
                }
            }
        }
    }

    public static boolean es_vocal(char letra) {
        boolean vocal = false;
        if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
            vocal = true;
        }
        return vocal;
    }

    public static void corrimiento_derecha(char[] arreglo, int pos) {
        int i = MAXC - 1;
        while (i > pos) {
            arreglo[i] = arreglo[i-1];
            i--;
        }
    }

    public static boolean es_minuscula(char letra) {
        boolean minuscula = false;
        if (letra <= 'z' && letra >= 'a') {
            minuscula = true;
        }
        return minuscula;
    }

    public static void invertir_secuencia(char[] arreglo, int inicio, int fin) {
        while (inicio < fin) {
            char aux = arreglo[inicio];
            arreglo[inicio] = arreglo[fin];
            arreglo[fin] = aux;
            inicio++;
            fin--;
        }
    }


    public static boolean arranca_mayuscula(char[] arreglo, int inicio) {
        boolean mayuscula = false;
        if (arreglo[inicio] >= 'A' && arreglo[inicio] <= 'Z') {
            mayuscula = true;
        }
        return mayuscula;
    }

    public static int buscar_inicio(char[] arreglo, int inicio) {
        while (inicio < MAXC && arreglo[inicio] == SEPARADOR) {
            inicio++;
        }
        return inicio;
    }

    public static int buscar_fin(char[] arreglo, int fin) {
        while (fin < MAXC && arreglo[fin] != SEPARADOR) {
            fin++;
        }
        return fin - 1;
    }
}