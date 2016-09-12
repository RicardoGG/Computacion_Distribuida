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

		for(int i=1; i<=c; i++){
			l.add(i);
		}	

		g.conectaEnteros(7,8);
		
		
		System.out.println(g.principal(l));		
		String s = g.toString();
		System.out.println(s);	

	//
		}
}