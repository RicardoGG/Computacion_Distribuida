import java.util.LinkedList;
import java.util.Random;

public class Grafica<T>{

	private class Vertice{
		public T elemento;
		LinkedList<Grafica.Vertice> adyacentes;

		public Vertice(T e){
			this.elemento = e;
			adyacentes = new LinkedList<Grafica.Vertice>();
		} 
		
		public int getGrado(){
				return adyacentes.size();
		}
	}

	private LinkedList<Vertice> vertices;
	private int aristas;

	public Grafica(){
		vertices = new LinkedList<Vertice>();
		aristas = 0;
	}

	public void inserta(T e){
		Vertice  vertice = new Vertice(e);
		vertices.add(vertice);
	}
	public void conecta(Vertice a, Vertice b) {
        a.adyacentes.add(b);
        b.adyacentes.add(a);
        aristas ++;
    }

    public double barabasi(Vertice nuevo, Vertice i){
    	int ki = i.getGrado();
    	int suma = 0;
    	for(Vertice v: vertices){
    		suma+=v.getGrado();
    	}
    	double res = ki / suma;
    	return res; 
    }
    public void conectaBarabasi(Vertice nuevo){
    	Random r = new Random();
    	double c = 0;
    	double b = 0;
    	for(int i = 0; i<vertices.size(); i++){
    		b = barabasi(nuevo,vertices.get(i));
    		c = r.nextDouble();
    		if(c < b){
    			conecta(nuevo,vertices.get(i));
    		}
    	}
    }

}