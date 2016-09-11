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
		Grafica<Integer> g = new Grafica<Integer>();

		g.agrega(10);
		g.agrega(11);
		g.agrega(112);	
		g.agrega(32);

		LinkedList<Integer> m = g.listaVertices();
		System.out.println(g.principal(m));
		System.out.println(g.aCadena());

		
			
	}

	//
}