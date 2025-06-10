package matrices;

public class ejercicio_corrimiento {
    final static int MAXFILA = 4;
    final static int MAXCOLUMNA = 5;

    public static void main(String[] args) {
        int[][] matriz = { 
        { 1, 2, 3, 4, 5 }, 
        { 2, 3, 99, 6, 4 }, 
        { 1, 12, 122, 143, 5 }, 
        { 0, 1, 0, 4, 6 }
        };
        imprimir_matriz(matriz);
        int fila = obtener_fila();
        int columna = obtener_columna();
        if (fila_valida(fila) && columna_valida(columna)) {
            corrimiento_derecha(matriz[fila], columna);
        }
        else{
            System.out.println("Ingreso un nro fuera del rango permitido.");
        }
        imprimir_matriz(matriz);
    }

    public static void corrimiento_derecha(int[] arreglo, int columna) {
        int i = MAXCOLUMNA - 1;
        while (i > columna) {
            arreglo[i] = arreglo[i - 1];
            i--;
        }
    }

    public static boolean fila_valida(int fila) {
        boolean valida = false;
        if (fila < MAXFILA && fila >= 0) {
            valida = true;
        }
        return valida;
    }

    public static boolean columna_valida(int columna) {
        boolean valida = false;
        if (columna < MAXCOLUMNA && columna >= 0) {
            valida = true;
        }
        return valida;
    }

    public static void imprimir_matriz(int[][] matriz) {
        for (int fila = 0; fila < MAXFILA; fila++) {
             for (int columna = 0; columna < MAXCOLUMNA; columna++) {
             System.out.print(" | " + matriz[fila][columna]);
          //  imprimir_arreglo(matriz[fila]);
        }
    }
    }

    /* public static void imprimir_arreglo(int[] arreglo) {
        for (int columna = 0; columna < MAXCOLUMNA; columna++) {
            System.out.print("|" + arreglo[columna]);
        }
    } */

    public static int obtener_fila() {
        int numero;
        System.out.println("Ingrese una numero de fila del 0 al 3");
        numero = Utils.leerInt();
        return numero;
    }

    public static int obtener_columna() {
        int numero;
        System.out.println("Ingrese una numero de dolumna del 0 al 4");
        numero = Utils.leerInt();
        return numero;

    }

}