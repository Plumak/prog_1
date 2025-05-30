package ej_parcial;

public class ej_6_producto_regalo {
    final static int MAX = 28;
    final static int MAXR = 2;
    final static int SEPARADOR = 0;

    public static void main(String[] args) {
        int[] arregloP = { 0, 0, 9, 12, 18, 0, 1, 5, 43, 73, 88, 0, 8, 9, 52, 0, 1, 10, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int[] arregloR = {44,6};
        int inicio = 0;
        int fin = -1;
    //    boolean agrego_productos = false;
        while (inicio < MAX) {
            inicio = buscar_inicio(arregloP, fin + 1);
            if (inicio < MAX) {
                fin = buscar_fin(arregloP, inicio);
                for (int i = 0; i < MAXR; i++) {
                    insertar_producto(arregloP, inicio, fin, arregloR[i]);
                    fin++;
                }
            
            }
        }
        mostrar_arreglo(arregloP);
    }
    public static void mostrar_arreglo(int [] arregloP){
        for (int i = 0; i < MAX ; i++){
            System.out.print(" | " + arregloP[i]);
        }
    }

    public static void insertar_producto(int[] arregloP, int inicio, int fin, int R) {
        while (inicio <= fin && arregloP[inicio] < R) {
            inicio++;
        }
        corrimiento_derecha(arregloP, inicio);
        arregloP[inicio] = R;
    }

    public static void corrimiento_derecha(int[] arregloP, int pos) {
        int i = MAX - 1;
        while (i > pos) {
            arregloP[i] = arregloP[i - 1];
            i--;
        }
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