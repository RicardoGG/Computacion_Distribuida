import java.util.LinkedList;
import java.util.Random;

public class Grafica<T>{

	private class Vertice{
		public Integer elemento;
		public LinkedList<Grafica.Vertice> adyacentes;

		public Vertice(Integer e){
			this.elemento = e;
			adyacentes = new LinkedList<Grafica.Vertice>();
		} 
		
		public int getGrado(){
			return adyacentes.size();
		}
        public Integer getElemento(){
            return this.elemento;
        }

	}

	private LinkedList<Vertice> vertices;
	private int aristas;


	public Grafica(){
		vertices = new LinkedList<Vertice>();
		aristas = 0;
	}

    public LinkedList<Integer> listaVertices(){         
         LinkedList<Integer> l = new LinkedList<Integer>();
         for(Vertice v: vertices)
            l.add(v.getElemento());
        return l;
    }

	public void agrega(Integer e){
		Vertice  vertice = new Vertice(e);
		vertices.add(vertice);
	}
//
	////public void conecta(T a, T b) {
    ////    Vertice va = new Vertice(a);
    ////    Vertice vb = new Vertice(b);
    ////    va.adyacentes.add(vb);
    //    vb.adyacentes.add(va);
      //  aristas ++;
    //}

    public void conectaEnteros(Integer a, Integer b){
        Vertice va = new Vertice(a);
        Vertice vb = new Vertice(b);
        va.adyacentes.add(vb);
        vb.adyacentes.add(va);
        aristas ++;   
    }

    private double barabasi(Integer n, Integer ie){
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
    public void conectaBarabasi(Integer nuevo){
        Random r = new Random();
    	double c = 0;
    	double b = 0;
    	for(int i = 0; i<vertices.size(); i++){
    		b = barabasi(nuevo,vertices.get(i).getElemento());
    		c = r.nextDouble();
    		if(c < b){
    			conectaEnteros(nuevo,vertices.get(i).getElemento());
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


    public String principal(LinkedList<Integer> l){               
        if(l.size()==2){
            conectaEnteros(l.get(0), l.get(1));
            return "Conectando los unicos dos elementos "+ l.get(0) + " --------" + l.get(1);
        }
        if(l.size()>2){
            for(int i = 0; i<l.size(); i++){
                    conectaBarabasi(l.get(i));
            }
            return"Todos los elementos conectados";
        }
        
        return "error";
    }


    public String aCadena(){
        String s = "";
            for(Vertice v : vertices){
                s+= "el vertice : " + v.getElemento() + " " + "tiene como adyacentes " + v.adyacentes + " \n";
            }
        return s;
    }


}