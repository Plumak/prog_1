package tp5;
public class corrimiento_izquierda {
    final static int MAX = 10;

public static void correrIzquierda(char [] arreglo,int pos){
while(pos < MAX -1){
arreglo[pos] = arreglo [pos+1];
pos++;
}
}
}
