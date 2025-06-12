public class ej_1_recu {
    final static int MAXFILAS = 3;
    final static int MAXCOLUMNAS = 20;
    final static char SEPARADOR = 'x';
    final static int MAXB = 3;
    final static int R = 2;

    public static void main(String[] args) {
        char[][] matriz = {
                { 'x', 't', 'a', 'C', 'M', 'O', 't', 'a', 'a', 't', 'O', 'C', 't', 't', 'a', 'O', 'M', 'C', 't', 'x' },
                { 'x', 'r', 'r', 'r', 'C', 'C', 'O', 'O', 'r', 'r', 'C', 'r', 'G', 'G', 'G', 'r', 'r', 'x', 'x', 'x' },
                { 'x', 'm', 'G', 'm', 'h', 'h', 'L', 'G', 'G', 'O', 'h', 'h', 'm', 'm', 'O', 'B', 'M', 'C', 'x', 'x' }

        };
        char[] arregloB = { 'C', 'O', 'L' };
        int contador = 0;
        for (int i = 0; i < MAXFILAS; i++) {
            contador = recorrer_matriz(matriz[i], arregloB);
        }
        System.out.println("Se eliminaron " + contador + " plantas");
        imprimir_matriz(matriz);

    }

    public static int recorrer_matriz(char[] arreglo, char[] arregloB) {
        int inicio = 0;
        int fin = -1;
        int contador = 0;
        int cant_no_cultivadas = 0;
        while (inicio < MAXCOLUMNAS) {
            inicio = buscar_inicio(arreglo, fin + 1);
            if (inicio < MAXCOLUMNAS) {
                fin = buscar_fin(arreglo, inicio);
                cant_no_cultivadas = fin - inicio + 1;
                if (cant_no_cultivadas > R) {
                    contador += activar_laser(arreglo, inicio, fin, arregloB);
                    fin = fin - contador;
                }
            }
        }
        return contador;
    }

    public static int activar_laser(char[] arreglo, int inicio, int fin, char[] arregloB) {
        int contador_eliminadas = 0;
        for (int j = inicio; j <= fin; j++) {
            if (eliminar_malezas(arreglo, arregloB, j)) {
                contador_eliminadas++;
            }
        }
        return contador_eliminadas;
    }

    public static void imprimir_matriz(char[][] matriz) {
        for (int f = 0; f < MAXFILAS; f++) {
            for (int c = 0; c < MAXCOLUMNAS; c++) {
                System.out.print(matriz[f][c] + " ");
            }
            System.out.println();
        }
    }

    public static boolean eliminar_malezas(char[] arreglo, char[] arregloB, int j) {
        boolean elimino = false;
        if (!es_beneficiosa(arreglo[j], arregloB)) {
            eliminar_planta(arreglo, j);
            elimino = true;
        }
        return elimino;
    }

    public static void eliminar_planta(char[] arreglo, int inicio) {
        while (inicio < MAXCOLUMNAS - 1) {
            arreglo[inicio] = arreglo[inicio + 1];
            inicio++;
        }
    }

    public static boolean es_beneficiosa(char planta, char[] arregloB) {
        boolean beneficiosa = true;
        int i = 0;
        while (i < MAXB && planta != arregloB[i]) {
            i++;
        }
        if (i == MAXB) {
            beneficiosa = false;
        }
        return beneficiosa;
    }

    public static boolean es_maleza(char[] arreglo, int inicio) {
        boolean maleza = false;
        if (arreglo[inicio] >= 'A' && arreglo[inicio] <= 'Z') {
            maleza = true;
        }
        return maleza;
    }

    public static boolean cultivada(char[] arreglo, int inicio) {
        boolean cultivada = false;
        if (arreglo[inicio] <= 'z' && arreglo[inicio] >= 'a') {
            cultivada = true;
        }
        return cultivada;
    }

    public static int buscar_inicio(char[] arreglo, int inicio) {
        while (inicio < MAXCOLUMNAS && cultivada(arreglo, inicio)) {
            inicio++;
        }
        return inicio;
    }

    public static int buscar_fin(char[] arreglo, int fin) {
        while (fin < MAXCOLUMNAS && !cultivada(arreglo, fin)) {
            fin++;
        }
        return fin - 1;
    }

}