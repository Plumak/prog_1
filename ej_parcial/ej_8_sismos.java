package ej_parcial;

public class ej_8_sismos {
    final static int MAX = 21;
    final static double SEPARADOR = 0;
    public static void main (String [] args){
        int inicio =0;
        int fin = -1;
        int contador =1;
        double [] arregloS = {0, 2.1, 1.5 ,4.1, 0, 3.4, 0, 2.5, 3.0, 0, 3.8, 0, 2.7, 2.7, 3.9, 2.5, 0, 4.2, 2.0, 0, 0};
        double N = PedirNumero();
        double M = PedirNumero();
while (inicio < MAX){
    inicio = buscar_inicio(arregloS, fin+1);
    if (inicio < MAX){
        fin = buscar_fin (arregloS, inicio);
        if(HayNSismos(arregloS, inicio,fin, N) && HayMasMPromedio(arregloS, inicio,fin,M)){
            System.out.println("Hubo al menos " + N + " sismos" + " y los sismos tuvieron un promedio mayor a " + M + " en el dia :" + contador);

        }
        contador++;
    }
}
    }
    public static double PedirNumero(){
        double numero;
        System.out.println("Ingrese un numero :");
        numero = Utils.leerInt();
        return numero;
    }
    public static int buscar_inicio(double [] arregloS, int inicio){
        while (inicio < MAX && arregloS[inicio] == SEPARADOR){
            inicio++;
        }
        return inicio;
    }
    public static int buscar_fin(double [] arregloS, int fin){
        while (fin < MAX && arregloS[fin] != SEPARADOR){
            fin++;
        }
        return fin-1;
    }
    public static boolean HayNSismos(double [] arregloS, int inicio, int fin, double N){
        boolean HayNSismos = false;
        if(fin-inicio+1 >= N){
            HayNSismos = true;
        }
        return HayNSismos;
    }
    public static boolean HayMasMPromedio(double [] arreglo, int inicio, int fin, double M){
        int promedio = 0;
        boolean HayMSismos = false;
        for(int i = inicio ; i <= fin ; i++){
         promedio += arreglo[i];
        }
      promedio = promedio / (fin-inicio+1);
      if (promedio >= M){
        HayMSismos = true;
      }
      return HayMSismos;
    }
}
