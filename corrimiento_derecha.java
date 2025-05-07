package tp5;

public class corrimiento_derecha {
    final static int MAX = 10;
    public static void corrimientoDerecha(int [] arreglo, int pos){
int i = MAX-1;
while(i>pos){
arreglo [i]= arreglo[ i -1];
i--;
}
}
}
