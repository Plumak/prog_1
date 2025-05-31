package ej_parcial;

public class ej_1_compresion {
    final static int MAX = 20;
    final static int SEPARADOR = 0;

    public static void main(String[] args) {
        int[] arregloM = { 0, 67, 67, 67, 67, 67, 67, 67, 67, 0, 14, 0, 33, 33, 33, 33, 0, 5, 98, 0 };
        // arreglo resultante 0 -8 67 0 14 0 -4 33 0 5 98 0 0 0 0 0 0 0 0 0
        int inicio = 0;
        int fin = -1;
        int cant_repeticiones = 0;
        int primerPosicion = 0;
        int valor = 0;

        while (inicio < MAX) {

            inicio = buscar_inicio(arregloM, fin + 1);
            if (inicio < MAX) {
                fin = buscar_fin(arregloM, inicio);
                cant_repeticiones = fin - inicio + 1;
                if (se_repite(arregloM, inicio, fin)) {
                    primerPosicion = inicio;
                    valor = arregloM[inicio];
                    eliminar_secuencia(arregloM, inicio, fin);
                    corrimientoDerecha(arregloM, primerPosicion, valor);
                     arregloM[inicio] = -cant_repeticiones;
                    fin = inicio+1;
                }
            }
        }
        imprimir_arreglo(arregloM);
    }

    public static void corrimientoDerecha(int[] arregloM, int pos, int valor) {
        int i = MAX - 1;
        while (i > pos) {
            arregloM[i] = arregloM[i - 1];
            i--;
        }
        arregloM[pos] = valor;
    }

    public static boolean se_repite(int[] arregloM, int inicio, int fin) {
        boolean se_repite = false;
        while (inicio < MAX && arregloM[inicio] == arregloM[inicio + 1]) {

            inicio++;
            se_repite = true;
        }
        return se_repite;
    }

    public static void imprimir_arreglo(int[] arregloM) {
        for (int i = 0; i < MAX; i++) {
            System.out.print(" | " + arregloM[i]);
        }
    }

    public static void eliminar_secuencia(int[] arregloM, int inicio, int fin) {
        for (int i = inicio; i < fin; i++) {
            corrimiento_izquierda(arregloM, inicio);
        }
    }

    public static void corrimiento_izquierda(int[] arregloM, int i) {
        while (i < MAX - 1) {
            arregloM[i] = arregloM[i + 1];
            i++;
        }
    }

    public static int buscar_inicio(int[] arregloM, int inicio) {
        while (inicio < MAX && arregloM[inicio] == SEPARADOR) {
            inicio++;
        }
        return inicio;
    }

    public static int buscar_fin(int[] arregloM, int fin) {
        while (fin < MAX && arregloM[fin] != SEPARADOR) {
            fin++;
        }
        return fin - 1;
    }
}
