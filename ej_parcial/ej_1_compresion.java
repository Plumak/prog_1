package ej_parcial;

public class ej_tipo_parcial_1 {
    final static int MAX = 20;
    final static int SEPARADOR = 0;

    public static void main(String[] args) {
        int[] arregloM = { 0, 67, 67, 67, 67, 67, 67, 67, 67, 0, 14, 0, 33, 33, 33, 33, 0, 5, 98, 0 };
            // arreglo resultante 0 -8 67 0 14 0 -4 33 0 5 98 0 0 0 0 0 0 0 0 0
        int inicio = 0;
        int fin = -1;
        while (inicio < MAX) {
            inicio = buscar_inicio(arregloM, fin + 1);
            if (inicio < MAX) {
                fin = buscar_fin(arregloM, inicio);
                if (se_repite(arregloM, inicio, fin)) {
                    int cant_nros = fin-inicio+1;
                    int valor_inicial = arregloM[inicio];
                    eliminar_secuencia(arregloM, inicio, fin, cant_nros);
                    insertamos_cantidad(arregloM,inicio,fin, valor_inicial);
                    fin=inicio;
                }
            }
        }
        imprimir_arreglo(arregloM);
    }

     public static boolean se_repite(int[] arregloM, int inicio, int fin) {
        int valor = arregloM[inicio];
        for (int i = inicio + 1; i <= fin; i++) {
            if (arregloM[i] != valor) {
                return false;
            }
        }
        return true;
    }

    public static void imprimir_arreglo(int[] arregloM) {
        for (int i = 0; i < MAX; i++) {
            System.out.println(" | " + arregloM[i]);
        }
    }
    public static void eliminar_secuencia(int[] arregloM, int inicio, int fin, int cant) {
        while (inicio <= fin) {
            corrimiento_izquierda(arregloM, inicio, fin, cant);
            inicio++;
        }
    }
    public static void insertamos_cantidad(int [] arregloM, int inicio, int fin, int valor_inicial){
        int i = MAX -1;
        int cant = fin-inicio+1;
        while(inicio < i){
            arregloM[i] = arregloM[i-1];
            i--;
        }
         arregloM[inicio] = -cant;
         arregloM[inicio+1] = valor_inicial;
    }

 public static void corrimiento_izquierda(int[] arregloM, int inicio, int fin, int cant) {
        while (inicio < MAX - 1) {
            arregloM[inicio] = arregloM[inicio + 1];
            inicio++;
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
