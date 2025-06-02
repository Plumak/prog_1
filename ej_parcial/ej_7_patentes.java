package parciales;
/*
 * 7. Patentes en la reserva natural 
La reserva natural Sierra del Tigre desea controlar el ingreso y egreso de vehículos. Para ello, dispone de 
cámaras que identifican las patentes de los vehículos que ingresan y egresan del predio. Los ingresos y 
egresos se registran en dos arreglos arrI y arrE respectivamente. Ambos arreglos son de tamaño MAXA y 
almacenan las patentes como secuencias de caracteres separados por uno o más espacios. 
Por ejemplo, en los siguientes arreglos la patente del primer vehículo en ingresar al predio fue AA 123 ZZ, y el 
primero en egresar fue AB 987 EX. 
ArrI: 
A A 1 2 3 Z Z  P R G 0 1 0  A B 9 8 7 E X   
ArrE: 
A B 9 8 7 E X  A A 1 2 3 Z Z  F O R 0 0 1  
Se debe implementar un programa que verifique, al finalizar el día, que todos los autos que ingresaron hayan 
también egresado del predio. En caso de detectar algún vehículo que no haya egresado se debe almacenar la 
patente en un arreglo arrNoE.  
De igual manera, puede ocurrir que al ingreso del vehículo la patente no quede registrada pero si al egresar. 
En estos casos, se debe almacenar las patentes de los autos que no hayan quedado registrados en el arreglo 
arrI pero si en el arrE, en un arreglo arrNoI. 
Nota: los arreglos arrNoE y arrNoI son de tamaño MAXA y deben almacenar las patentes separadas por uno 
o más espacios.  
Siguiendo con el ejemplo anterior, los arreglos resultantes quedarían de la siguiente forma: 
ArrNoE 
P R G 0 1 0                   
ArrNoI: 
F O R 0 0 1                   
Aclaración: Asumir que cada vehículo puede ingresar o egresar una vez al día.
 */
public class PatentesReservaNatural {
    public static final int MAXA = 25;
    public static final char SEPARADOR= ' ';

public static void main(String[] args) {

    char[]arrI={' ','A','A','1','2','3','Z','Z',' ','P','R','G','0','1','0',' ','A','B','9','8','7','E','X',' ',' '};
    char[]arrE={' ',' ','A','B','9','8','7','E','X',' ','A','A','1','2','3','Z','Z',' ','F','O','R','0','0','1',' '};
    char[]arrNoE={' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
    char[]arrNoI={' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
    
    mostrarArreglo(arrI);
    mostrarArreglo(arrE);
    /*
     * recorrer ambos arreglos, para cada caso, si no existe la patente en el arreglo opuesto agregar al arreglo resultante
     * si el tamanio es el mismo y las patentes son iguales seguir con la proxima secuencia
     */
    
    //procedimiento para el arrI---> lo voy a comparar con el arrE y si no esta la secuencia lo voy a agregar en el arreglo arrNoE
    procesarArreglo(arrI,arrE,arrNoE);
    //procedimiento para el arrE---> lo voy a comparar con el arrI y si no esta la secuencia lo voy a agregar en el arreglo arrNoI
    procesarArreglo(arrE,arrI,arrNoI);
    
    System.out.println("registro patentes que no egresaron:");
    mostrarArreglo(arrNoE);
    System.out.println("registro patentes que no ingresaron:");
    mostrarArreglo(arrNoI);

    }


    public static void procesarArreglo(char[]arrA,char[]arrB,char[]arrC){
        int ini=0,fin=-1;

        while(ini<MAXA){
            ini=buscarIni(arrA,fin+1);
            if(ini<MAXA){
                fin=buscarFin(arrA,ini);
                if(!seEncuentraEnRegistroOpuesto(arrA,ini,fin,arrB)){
                    registrarPatente(arrC,ini,fin,arrA);
                }
            }
        }


    }


    public static void registrarPatente(char[]arrC,int ini, int fin,char[]arrA){

        //colocar la secuencia del arreglo A al arreglo C ---> siempre colocandola entre espacios y en el ultimo lugar disponible
        int pos = buscarUltimaPos(arrC);
        
        for(int i=ini;i<=fin;i++){
            arrC[pos]=arrA[i];
            pos++;
        }

    }

    public static int buscarUltimaPos(char[]arrC){
        //  |   | a |  b | c  |   |   |   | i=MAXA-1(6)   | 5 | 4 | 3
        //    0   1    2   3    4   5   6
        int i=MAXA-1;
        while(i>0 && arrC[i]==SEPARADOR){
            i--;
        }

        return i+1;
    }


    public static boolean seEncuentraEnRegistroOpuesto(char[]arrA,int ini, int fin, char[]arrB){
        int iniB=0,finB=-1;
        boolean existe=false;
        while(iniB<MAXA && !existe){
            iniB=buscarIni(arrB, finB+1);
            if(iniB<MAXA){
                finB=buscarFin(arrB,iniB);
                if((fin-ini+1)==(finB-iniB+1)&&sonIguales(ini, fin, arrA, iniB, finB, arrB)){
                    existe=true;
                }
            }
        }
        return existe;
    }
    



    public static boolean sonIguales(int ini,int fin, char[]arrA,int iniB, int finB, char[]arrB){
        while(ini<=fin && arrA[ini]==arrB[iniB]){
            ini++;
            iniB++;
        }
        return (ini>fin);//si ini para el arrA y el arrB se pasa(es mayor a fin), significa que recorri todas posiciones y son iguales.
    }

    public static int buscarIni(char[]arr,int pos){
        while(pos<MAXA && arr[pos]==SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char[]arr, int pos){
        while(pos<MAXA && arr[pos]!=SEPARADOR){
            pos++;
        }
        return pos-1;
    }

    public static void mostrarArreglo(char[]arr){
        for(int i=0;i<MAXA;i++){
            System.out.print("| "+arr[i]);
        }
        System.out.println();
    }


}