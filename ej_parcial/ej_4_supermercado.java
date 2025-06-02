package ej_parcial;

public class ej_4_supermercado {
    final static int MAX = 25;
    final static int MAXR = 2;
    final static int R = 22;
    final static int SEPARADOR = 0;

    public static void main(String[] args) {
        int[] arregloP = { 0, 0, 12, 9, 18, 0, 15, 5, 4, 7, 10, 0, 8, 9, 12, 0, 19, 10, 9, 0, 0, 0, 0, 0, 0 };
        int[] arregloT = { 8, 9 };
        int inicio = 0;
        int fin = -1;
        int C = 2;
        while (inicio < MAX) {
            inicio = buscar_inicio(arregloP, fin + 1);
            if (inicio < MAX) {
                fin = buscar_fin(arregloP, inicio);
                if (tiene_elemento_promocion(arregloP, arregloT, inicio, fin) && C > 0) {
                    agregar_producto(arregloP, inicio, fin);
                    C--;
                    fin++;
                }
            }
        }
        System.out.println("Quedo " + C + "stock de R");   
        mostrar_arreglo(arregloP);
    }

    public static void mostrar_arreglo(int[] arreglo) {
        for (int i = 0; i < MAX; i++) {
            System.out.print("|" + arreglo[i]);
        }
    }

    public static void agregar_producto(int[] arregloP, int inicio, int fin) {
        while (inicio <= fin && arregloP[inicio] < R) {
            inicio++;
        }
        corrimiento_derecha(arregloP, inicio);
        arregloP[inicio] = R;
    }

    public static void corrimiento_derecha(int[] arregloP, int inicio) {
        int i = MAX - 1;
        while (i > inicio) {
            arregloP[i] = arregloP[i - 1];
            i--;
        }
    }

    public static boolean tiene_elemento_promocion(int[] arregloP, int[] arregloT, int inicio, int fin) {
        boolean esta = false;
        for (int i = inicio; i <= fin; i++) {
            for (int j = 0; j < MAXR; j++) {
                if (arregloP[i] == arregloT[j]) {
                    esta = true;
                }
            }
        }
        return esta;
    }

    public static int buscar_inicio(int[] arregloP, int inicio) {
        while (inicio < MAX && arregloP[inicio] == SEPARADOR) {
            inicio++;
        }
        return inicio;
    }

    public static int buscar_fin(int[] arregloP, int fin) {
        while (fin < MAX && arregloP[fin] != SEPARADOR) {
            fin++;
        }
        return fin - 1;
    }
}
