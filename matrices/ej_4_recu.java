public class ej_4_recu{
    final static int MAXFILAS = 4;
    final static int MAXCOLUMNAS = 15;
    final static int X = 2;
    final static int SEPARADOR = 0;
    public static void main (String [] args){
int[][] matriz = {
            {0, 625, 815, 900, 0, 562, 952, 300, 0, 365, 169, 254, 0, 0, 0},
            {0, 958, 62, 57, 221, 0, 596, 623, 600, 0, 587, 889, 984, 0, 0},
            {0, 0, 700, 257, 0, 0, 0, 854, 958, 388, 0, 954, 842, 925, 0},
            {0, 988, 899, 874, 0, 254, 258, 652, 200, 0, 568, 958, 210, 0, 0}
        };
int valor = 0;
int aux = 0;
int count =0;
        for(int i = 0 ; i < MAXFILAS; i++){
            valor = recorrer_matriz(matriz[i]);
            if(valor > aux && count > X ){
                aux = valor;
                count++;
            }
            System.out.println("Se cumplio la incrementacion");
        }
    }
    public static int recorrer_matriz(int [] arreglo){
        int inicio =0;
        int fin =-1;
        int promedio_hora=0;
        int contador_secuencias =0;
        while(inicio < MAXCOLUMNAS){
            inicio = buscar_inicio(arreglo, fin+1);
            if(inicio < MAXCOLUMNAS){
                fin = buscar_fin(arreglo, inicio);
                promedio_hora += promedio(arreglo,inicio,fin);
                contador_secuencias++;

            }
        }
        promedio_hora = promedio_hora / contador_secuencias;
        return promedio_hora;
    }
    public static int promedio (int [] arreglo, int inicio, int fin){
        int suma =0;
        int divisor = fin - inicio + 1;
        for(int i = inicio ; i <= fin ; i++){
            suma+= arreglo[i];
        }
        suma = suma / divisor;
        return suma;
    }
    public static int buscar_inicio(int [] arreglo, int inicio){
        while(inicio < MAXCOLUMNAS && arreglo[inicio] == SEPARADOR){
            inicio++;
        }
    return inicio;
    }
    public static int buscar_fin (int [] arreglo, int fin){
        while (fin < MAXCOLUMNAS && arreglo[fin] != SEPARADOR){
            fin++;
        }
        return fin-1;
    }
}
