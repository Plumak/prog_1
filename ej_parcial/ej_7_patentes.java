package ej_parcial;

public class ejercicio_patentes {
	final static int MAX = 25;
	final static char SEPARADOR = ' ';

	public static void main(String[] args) {
		char[] ArrI = { ' ', 'A', 'A', '1', '2', '3', 'Z', 'Z', ' ', 'P', 'R', 'G', '0', '1', '0', ' ', 'A', 'B', '9',
				'8', '7', 'E', 'X', ' ', ' ' };
		char[] ArrE = { ' ', ' ', 'A', 'B', '9', '8', '7', 'E', 'X', ' ', 'A', 'A', '1', '2', '3', 'Z', 'Z', ' ', 'F',
				'O', 'R', '0', '0', '1', ' ' };
		int inicio = 0;
		int fin = -1;
		int inicioB = 0;
		int finB = -1;
		while (inicio < MAX) {
			inicio = buscar_inicio(ArrI, fin + 1);
			inicioB = buscar_inicio(ArrE, finB + 1);
			if (inicio < MAX) {
				fin = buscar_fin(ArrI, inicio);
				finB = buscar_fin(ArrE, inicioB);
				if (esta_presente(ArrI, ArrE, inicio, fin, inicioB, finB)) {
					eliminar_patente(ArrI, inicio, fin);
					eliminar_patente(ArrE, inicioB, finB);
					fin = inicio;
					finB = inicioB;
				}
			}
		}
		imprimir_arreglo(ArrI);
		imprimir_arreglo(ArrE);
	}

	public static void imprimir_arreglo(char[] arreglo) {
		for (int i = 0; i < MAX; i++) {
			System.out.print("|" + arreglo[i]);
		}
	}

	public static void eliminar_patente(char[] arreglo, int inicio, int fin) {
		int i = inicio;
		while(i <= fin) {
			corrimiento_izquierda(arreglo, inicio);
			i++;
		}
	}

	public static void corrimiento_izquierda(char[] arreglo, int pos) {
		while (pos < MAX - 1) {
			arreglo[pos] = arreglo[pos + 1];
			pos++;
		}
	}

	public static int buscar_inicio(char[] arreglo, int inicio) {
		while (inicio < MAX && arreglo[inicio] == SEPARADOR) {
			inicio++;
		}
		return inicio;
	}

	public static int buscar_fin(char[] arreglo, int fin) {
		while (fin < MAX && arreglo[fin] != SEPARADOR) {
			fin++;
		}
		return fin - 1;
	}

	public static boolean esta_presente(char[] ArrI, char[] ArrE, int inicio, int fin, int inicioB, int finB) {
		boolean presente = false;
		if (fin - inicio + 1 == finB - inicioB + 1 && son_iguales(ArrI, ArrE, inicio, fin, inicioB, finB)) {
			presente = true;
		}
		return presente;
	}

	public static boolean son_iguales(char[] ArrI, char[] ArrE, int inicio, int fin, int inicioB, int finB) {
		boolean iguales =false;
		while (inicio <= fin && inicioB <= finB) {
        if (ArrI[inicio] != ArrE[inicioB]) {
            iguales = false; 
        }
        inicio++;
        inicioB++;
    }

    iguales =  true; 
		return iguales;
	}
}