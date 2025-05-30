package ej_parcial;

public class ej_2_mesas {
    final static int MAXC = 20;
    final static int MAXM = 5;
    final static int SEPARADOR = 0;

    public static void main(String[] args) {
        int[] arregloC = { 4, 3, 8, 6, 2, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int[] arregloM = { 2, 3, 5, 6, 12 };
        // resultado = alumnos 4 mesa 3 | alumnos 3 mesa 2 | alumnos 8 mesa 5 | alumnos 6 mesa 4 // 
        int inicio =0;
        int fin = -1;
        boolean asigno = false;
        while(inicio < MAXC && !asigno){
            inicio = buscar_inicio(arregloC, fin+1);
            if(inicio < MAXC){
                fin = buscar_fin(arregloC,inicio);
                for(int i = inicio ; i <=fin ; i++){
                    asignar_mesas(arregloC, arregloM,inicio);
                    asigno = true;
                }
            }
        }
    }
    public static void asignar_mesas(int [] arregloC, int [] arregloM, int pos){
        int i =0;
        while(i < MAXM && arregloC[pos] > arregloM[i]){
            i++;
        }
        if(i == MAXM){
            System.out.println("No se encontro mesas disponibles.");
        }
        else if (arregloC[pos] <= arregloM[i]){
            System.out.println("La cant alumnos " + arregloC[pos] + "fue asignada al aula " + (i+1));
            eliminar_cant_alumnos(arregloC, pos);
            arregloM[i] = -arregloM[i];
        }
        else{
            System.out.println("Mesa no asignada");
        }
    
    }
    public static void eliminar_cant_alumnos(int [] arregloC, int pos){
        while(pos < MAXC-1){
            arregloC[pos] = arregloC[pos+1];
            pos++;
        }
    }
    public static int buscar_inicio(int [] arregloC, int inicio){
        while (inicio < MAXC && arregloC[inicio] == SEPARADOR){
        inicio++;
        }
        return inicio;
    }
    public static int buscar_fin(int [] arregloC, int fin){
        while(fin < MAXC && arregloC[fin] != SEPARADOR){
            fin++;
        }
        return fin-1;
    }
}
