public class ej_3_recu {
    final static int MAXFILAS = 4;
    final static int MAXCOLUMNAS = 15;

    public static void main (String []args){
         char[][] matriz = {
            {' ','e', 'l',' ' , 'a', 'g', 'e', 'n', 't', 'e' ,' ' ,' ' ,' ' ,' ' ,' ' ,' '},
            {' ','J', 'a', 'm', 'e', 's',' ','B', 'o', ' ' , 's', 'e',' ' ,' ' ,' ' ,' '},
            {' ','e', 'n', 'c', 'u', 'e', 'n', 't', 'r', 'a', ' ' , 'e', 'n' ,' ' ,' ' ,' '},
            {' ','C', 'o', 'l', 'o', 'n', 'i', 'a' ,' ' ,' ' ,' ' ,' ' ,' ' ,' ', ' ', ' '}
        };
        for(int i = 0; i < MAXFILAS ; i++){
            recorrer_matriz(matriz[i]);
        }
    }
    public static void recorrer_matriz(char [] arreglo){
        
    }
}
