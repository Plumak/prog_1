import java.util.Base64;

public class ej_9_recu {
    final static int MAXF = 4;
    final static int MAXC = 15;
    final static int SEPARADOR = 0;
    final static int MAXA = 3; 
    final static int X = 600;
 public static void main (String [] args){
    int[][] matriz = {
            {  0,  0, 150, 200, 165,   0, 154, 352, 240, 256,   0, 900, 750,   0,   0 },
            {  0, 940, 105, 265, 845, 215,   0, 245, 765, 348,   0, 741, 125, 541,   0 },
            {  0, 851, 543, 625, 845, 914,   0, 754, 184, 452, 637, 917,   0,   0,   0 }
        };
        int [] arregloA = {1,2,0};
        int [] arregloB = {3,0,0};
        int a = 0;
        int b = 0;
        while(a < MAXA && arregloA[a] != SEPARADOR){
        chequear_promedios(matriz[arregloA[a]-1], arregloA[a]-1 );
        a++;
        }
        while(b < MAXA && arregloB[b] != SEPARADOR){
        chequear_mes(matriz[arregloB[b]-1]);
        b++;
        }
 }
 public static void chequear_promedios (int [] arreglo, int mes ){
    int inicio = 0;
    int fin = -1;
    int suma = 0;
    int promedio = 0;
    int contador_secuencias = 0;
    while (inicio < MAXC){
        inicio = buscar_inicio(arreglo, fin+1);
        if(inicio < MAXC){
            fin = buscar_fin(arreglo, inicio);
            contador_secuencias++;
            suma+= sumar_sec(arreglo,inicio,fin);
        }
    }
    promedio = suma / contador_secuencias;
    System.out.println("El promedio en el mes  "+ mes + "es = " + promedio );
 }
 public static void chequear_mes(){

 }
}
