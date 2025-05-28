package ej_parcial;

public class ejercicio_empanadas {
    final static int MAX = 16;

    public static void main(String[] args) {
        int[] arreglo = { -1, 5, 5, 7, 7, -6, 4, 9, 10, -4, 1, 1, 2, 7, -9, -8 };
        int inicio = 0;
        int fin = -1;
        int empanada = 0;
        int nro_pedido = 0;
        int contador = 1;
        int pos =0;
        nro_pedido = PedirNroPedido();
        empanada = PedirEmpanada();
        boolean agregue_empanada = false;
        while (inicio < MAX && !agregue_empanada) {
            inicio = buscar_inicio(arreglo, fin + 1);
            if (inicio < MAX) {
                fin = buscar_fin(arreglo, inicio);
                if (nro_pedido == contador && empanada_valida(empanada)){
                    pos = recorrer_pedido(arreglo, inicio, fin, empanada);
                    corrimiento_derecha(arreglo, pos);
                    arreglo[pos] = empanada;
                    agregue_empanada = true;
                }
                contador++;

            }
        }
        mostrar_arreglo(arreglo);
    }

    public static boolean empanada_valida(int empanada) {
        boolean valida = false;
        if (empanada > 0) {
            valida = true;
        }

        return valida;
    }

    public static int recorrer_pedido(int[] arreglo, int inicio, int fin, int empanada) {
        while (inicio < MAX && inicio <= fin && arreglo[inicio] < empanada) {
            inicio++;
        }
        return inicio;
    }

    public static void corrimiento_derecha(int[] arreglo, int pos) {
        int i = MAX - 1;
        while (i > pos) {
            arreglo[i] = arreglo[i - 1];
            i--;
        }
    }

    public static int PedirNroPedido() {
        int numero;
        System.out.println("Ingrese un numero de pedido:");
        numero = Utils.leerInt();
        return numero;
    }

    public static int PedirEmpanada() {
        int numero;
        System.out.println("Ingrese una empanada:");
        numero = Utils.leerInt();
        return numero;
    }

    public static int buscar_inicio(int[] arreglo, int inicio) {
        while (inicio < MAX && arreglo[inicio] < 0) {
            inicio++;
        }
        return inicio;
    }

    public static int buscar_fin(int[] arreglo, int fin) {
        while (fin < MAX && arreglo[fin] > 0) {
            fin++;
        }
        return fin - 1;
    }

    public static void mostrar_arreglo(int[] arreglo) {
        for (int i = 0; i < MAX; i++) {
            System.out.print("|" + arreglo[i]);
        }
    }

}