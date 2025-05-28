package ej_parcial;

public class ej_tipo_parcial_2 {
    final static int MAXC = 20;
    final static int MAXM = 5;
    final static int SEPARADOR = 0;

    public static void main(String[] args) {
        int[] arregloC = { 4, 3, 8, 6, 2, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int[] arregloM = { 2, 3, 5, 6, 12 };
        // el 4 entro en 5, 3 en 3, 8 en 12, 6 en 6, 2 en 2. Quedaria libre 12 // 
        int inicio = arregloC[0];
        int fin = -1;
        while (inicio < MAXC) {
            inicio = buscar_inicio(arregloC, fin + 1);
            if (inicio < MAXC) {
                fin = buscar_fin(arregloC, inicio);
                for (int i = inicio; i <= fin; i++){
                    buscar_capacidad(arregloC, i, arregloM);
                }
            }
        }
        imprimir_arreglo(arregloC, MAXC);
        imprimir_arreglo(arregloM, MAXM);
    }
    public static void imprimir_arreglo(int[] arreglo, int MAX) {
        for (int i = 0; i < MAX; i++) {
            System.out.println(" | " + arreglo[i]);
        }
    }

    public static void buscar_capacidad(int[] arregloC, int i, int[] arregloM) {
        for (int posM = 0; posM < MAXM; posM++) {
            if (arregloC[i] == arregloM[posM] || arregloC[i] < arregloM[posM]) {
                    nro_negativo(arregloM, posM);
                    borrar_mesa(arregloC, i);
                    System.out.println("El cliente nro " + i + "fue asignada a la mesa " + posM);
            }
            else{
                System.out.println("No hay mesa con capacidad necesaria.");
            }
        }
        System.out.println("No hay mesas disponibles");
    }
    public static void borrar_mesa( int [] arregloC, int i){
        while(i < MAXC-1){
            arregloC[i] = arregloC[i+1];
            i++;
        }
    }
    public static void nro_negativo(int [] arregloM, int posM){
      arregloM[posM] = -arregloM[posM];
    }

    public static int buscar_inicio(int[] arregloM, int inicio) {
        while (inicio < MAXC && arregloM[inicio] == SEPARADOR) {
            inicio++;
        }
        return inicio;
    }

    public static int buscar_fin(int[] arregloM, int fin) {
        while (fin < MAXC && arregloM[fin] != SEPARADOR) {
            fin++;
        }
        return fin - 1;
    }
}
