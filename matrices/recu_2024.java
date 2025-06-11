public class recu_2024 {
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
        int inicio = 0;
        int fin = -1;
        int contador_eliminadas = 0;
        for (int i = 0; i < MAXFILAS; i++) {
            while (inicio < MAXCOLUMNAS) {
                inicio = buscar_inicio(matriz[i], fin + 1);
                if (inicio < MAXCOLUMNAS) {
                    fin = buscar_fin(matriz[i], inicio);
                    if (cant_no_cultivadas(matriz[i], inicio, fin) > R) {
                        for (int j = inicio; j <= fin; j++) {
                            if (eliminar_malezas(matriz[i], arregloB, j)) {
                                fin--;
                                contador_eliminadas++;
                            }
                        }
                    }
                }
            }
        }
        imprimir_matriz(matriz);
        System.out.println("La cantidad de malezas eliminadas es: " + contador_eliminadas);

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
        if (es_maleza(arreglo, j) && !es_beneficiosa(arreglo[j], arregloB)) {
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
        boolean beneficiosa = false;
        for (int i = 0; i < MAXB; i++) {
            if (planta == arregloB[i]) {
                beneficiosa = true;
            }
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

    public static int cant_no_cultivadas(char[] arreglo, int inicio, int fin) {
        int contador = 0;
        for (int i = inicio; i < fin; i++) {
            if (cant_consecutivas(arreglo,i)){
                contador++;
            }
        }
        return contador;
    }
    public static boolean cant_consecutivas(char [] arreglo, int i){
        boolean consecutiva = false;
        if(es_maleza(arreglo,i) && es_maleza(arreglo,i+1)){
            consecutiva=true;
        }
        return consecutiva;
    }

    public static int buscar_inicio(char[] arreglo, int inicio) {
        while (inicio < MAXCOLUMNAS && arreglo[inicio] == SEPARADOR) {
            inicio++;
        }
        return inicio;
    }

    public static int buscar_fin(char[] arreglo, int fin) {
        while (fin < MAXCOLUMNAS && arreglo[fin] != SEPARADOR) {
            fin++;
        }
        return fin - 1;
}
}