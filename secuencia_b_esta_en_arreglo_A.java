public static boolean secuencia_b_esta_en_arregloA(int [] arregloA,int [] arregloB, int inicio, int fin, int inicioB, int finB){
if (fin-inicio+1 == finB-inicioB+1){ 
while (inicio<= fin && inicioB<= finB && arregloA[inicio] == arregloB[inicioB]){
inicio++;
inicioB++;
}}
return inicio > fin;
}
