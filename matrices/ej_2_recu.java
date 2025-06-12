public class ej_2_recu {
    final static int SEPARADOR = 0;
    final static int MAXFILAS = 7;
    final static int MAXCOLUMNAS = 20;
    final static double P = 25;
    final static int MAXB = 7;

    public static void main(String[] args) {
        int[][] matriz = {
                { 0, 300, 298, 298, 297, 0, 240, 233, 245, 240, 0, 257, 254, 254, 0, 234, 230, 222, 0, 0 },
                { 0, 310, 302, 284, 271, 0, 280, 263, 263, 0, 0, 0, 264, 264, 0, 234, 230, 0, 0, 0 },
                { 0, 310, 302, 294, 0, 0, 250, 243, 0, 245, 0, 257, 255, 253, 0, 234, 229, 0, 0, 0 },
                { 0, 315, 320, 395, 398, 0, 351, 333, 353, 0, 0, 0, 334, 354, 0, 454, 490, 499, 0, 0 },
                { 0, 410, 400, 397, 0, 0, 250, 243, 0, 0, 0, 257, 255, 253, 0, 234, 229, 220, 0, 0 },
                { 0, 0, 420, 430, 430, 450, 420, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 415, 425, 435, 420, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
        int[] arregloB = { 1, 2, 5, 0, 0, 0, 0 };
        int inicio = 0;
        int fin = -1;
        double dias = 0;
        int dia_b;
        inicio = buscar_inicio(arregloB, fin + 1, MAXB);
        fin = buscar_fin(arregloB, inicio, MAXB);
        double cant_dias_totales = fin - inicio + 1;
        for (int fila = inicio; fila <= fin; fila++) {
            dia_b = arregloB[fila]-1;
            if (recorrer_matriz(matriz[dia_b], arregloB, fila)) {
                dias++;
                fin--;
            }
        }
        dias = dias / cant_dias_totales;
        if (dias >= P) {
            System.out.println("Cumplio con " + P + "%" + " teniendo " + dias + " % ");
        }
        imprimir_arreglo(arregloB);
    }

    public static void imprimir_arreglo(int[] arregloB) {
        for (int i = 0; i < MAXB; i++) {
            System.out.println("|" + arregloB[i]);
        }
    }

public static boolean recorrer_matriz(int[] arreglo, int[] arregloB, int dia) {
    int inicio = 0;
    int fin = -1;
    boolean progresivoTotal = true;

    while (inicio < MAXCOLUMNAS && progresivoTotal) {
        inicio = buscar_inicio(arreglo, fin + 1, MAXCOLUMNAS);
        if (inicio < MAXCOLUMNAS) {
            fin = buscar_fin(arreglo, inicio, MAXCOLUMNAS);
            if (!entrenamiento_progresivo(arreglo, inicio, fin)) {
                progresivoTotal = false;
            }
        }
    }

    if (progresivoTotal) {
        System.out.println("Cumplio con el entrenamiento progresivo en el dia " + dia);
        eliminar_dia(arregloB, dia);
    }

    return progresivoTotal;
}


    public static void eliminar_dia(int[] arregloB, int dia) {
        while (dia < MAXB - 1) {
            arregloB[dia] = arregloB[dia + 1];
            dia++;
        }
    }

    public static int buscar_inicio(int[] arreglo, int inicio, int MAX) {
        while (inicio < MAX && arreglo[inicio] == SEPARADOR) {
            inicio++;
        }
        return inicio;
    }

    public static int buscar_fin(int[] arreglo, int fin, int MAX) {
        while (fin < MAX && arreglo[fin] != SEPARADOR) {
            fin++;
        }
        return fin - 1;
    }

    public static boolean entrenamiento_progresivo(int[] arreglo, int inicio, int fin) {
        boolean progresivo = true;
        while (inicio < fin) {
            if (arreglo[inicio] < arreglo[inicio + 1]) {
                progresivo = false;
            }
            inicio++;

        }
        return progresivo;
    }
}