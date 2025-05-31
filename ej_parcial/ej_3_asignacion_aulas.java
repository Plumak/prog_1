package ej_parcial;
public class ej_3_asignacion_aulas {
    final static int MAX =20;
    final static int SEPARADOR =0;
    final static int MAXA = 3;
    public static void main (String []args){
        int [] arreglo={0,0,34,2,12,25,0,32,55,12,3,88,14,0,0,17,36,19,0,0};
        int [] arreglo_aulas= {2,3,6};
        int inicio =0;
        int fin = -1;
        while(inicio < MAX){
            inicio = buscar_inicio(arreglo, fin+1);
            if(inicio< MAX){
                fin = buscar_fin(arreglo,inicio);
               if(asignacion(arreglo,arreglo_aulas, inicio,fin)){
                fin=inicio;
            }

            }
        }
    }
    public static void mostrar_arreglo(int[] arreglo, int MAX) {
		for (int i = 0; i < MAX; i++) {
			System.out.print("|" + arreglo[i]);
		}
	}
    public static int buscar_inicio(int [] arreglo, int inicio){
        while(inicio < MAX && arreglo[inicio] == SEPARADOR){
            inicio++;
        }
        return inicio;
    }
    public static int buscar_fin(int [] arreglo, int fin){
        while(fin < MAX && arreglo[fin] != SEPARADOR){
            fin++;
        }
        return fin-1;
    }
    public static boolean asignacion(int [] arreglo, int [] arreglo_aulas, int inicio, int fin){
        boolean asigno =false;
        int cant_alumnos = fin-inicio+1;
        int i =0;
        while(i < MAXA && cant_alumnos > arreglo_aulas[i]){
            i++;
        }
        if(i == MAXA){
            System.out.println("No se encontro aula disponible.");
        }
       else{
        System.out.println("La cantidad de alumnos " + cant_alumnos +" fue asignada al aula " + (i+1));
        eliminar_secuencia(arreglo,inicio,fin);
        arreglo_aulas[i] = - arreglo_aulas[i];
        asigno = true;

       }
       return asigno;
    }
    public static void eliminar_secuencia(int [] arreglo, int inicio, int fin){
        for(int i = inicio ; i<=fin ; i++){
            corrimiento_izquierda(arreglo, i);
        }
    }
    public static void corrimiento_izquierda(int [] arreglo, int pos){
        while(pos < MAX-1){
            arreglo[pos] = arreglo[pos+1];
            pos++;
        }
    }
}
