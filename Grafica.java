import java.util.LinkedList;
import java.util.Random;

public class Grafica<T>{

	private class Vertice{
		public T elemento;
		public LinkedList<Grafica.Vertice> adyacentes;

		public Vertice(T e){
			this.elemento = e;
			adyacentes = new LinkedList<Grafica.Vertice>();
		} 
		
		public int getGrado(){
			return adyacentes.size();
		}
        public T getElemento(){
            return this.elemento;
        }



	}

	private LinkedList<Vertice> vertices;
	private int aristas;


	public Grafica(){
		vertices = new LinkedList<Vertice>();
		aristas = 0;
	}


	public void agrega(T e){
		Vertice  vertice = new Vertice(e);
		vertices.add(vertice);
	}
	public void conecta(T a, T b) {
        Vertice va = new Vertice(a);
        Vertice vb = new Vertice(b);
        va.adyacentes.add(vb);
        vb.adyacentes.add(va);
        aristas ++;
    }

    private double barabasi(T n, T ie){
        Vertice i = new Vertice(ie);
        Vertice nuevo = new Vertice(n);
    	int ki = i.getGrado();
    	int suma=1;
    	for(Vertice v: vertices){
    		suma+=v.getGrado();
        }
    	double res = ki / suma;
    	return res; 
    }
    public void conectaBarabasi(T nuevo){
        Random r = new Random();
    	double c = 0;
    	double b = 0;
    	for(int i = 0; i<vertices.size(); i++){
    		b = barabasi(nuevo,vertices.get(i).getElemento());
    		c = r.nextDouble();
    		if(c < b){
    			conecta(nuevo,vertices.get(i).getElemento());
    		}
    	}
    }
    private String getVertices(){
        String s = "";       
        for(int i=0; i<vertices.size(); i++)
            s += vertices.get(i).getElemento() + " ";
        return s;                     
    }

    private String getArista(){
        LinkedList<String> ady = new LinkedList<String>();
        String s= "";
        for(Vertice v: vertices){
            s = String.valueOf(v.adyacentes);
            ady.add(s);
        }
        return ady.toString();
    }


    @Override 
    public String toString(){
        String s = "La grafica contiene los vertices y aristas : \n [" + getVertices() + "]\n " + " " + getArista();

        return s;
    }


}