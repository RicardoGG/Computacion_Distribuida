import java.util.Scanner;
import java.util.LinkedList;

public class Practica1{

	public static void main(String[] args){
		LinkedList<Integer> l= new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		int c;
		//Leemos la entrada
		System.out.println("Dame un numero entero:");
		c = sc.nextInt();

		//Creamos la lista
		//for(int i=0; i<c; i++){
		//	l.add(i);
		//}

		Grafica<Integer> g = new Grafica<Integer>();
		//Agregamos los nodos a la lista de vertices
		for(int i=1; i<=c;i++){
			g.agrega(i);
		}

		



		System.out.println(g.toString());

	}

	//
}