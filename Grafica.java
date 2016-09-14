	import java.util.LinkedList;
	import java.util.Random;
	import java.util.Iterator;
	import java.util.NoSuchElementException; 
	import java.util.Iterator;


	public class Grafica<T>{

		private class Vertice{
			public Integer e;
			public LinkedList<Grafica.Vertice> vecinos;

			public Vertice(Integer e){
				this.e = e;
				vecinos = new LinkedList<Grafica.Vertice>();
			}

			public double getDegree(){
				return this.vecinos.size();
			}
			
			public int getElemento(){
				return this.e;
			}

			public LinkedList<Grafica.Vertice> getVecinos(){
				return this.vecinos;
			}
		}

		private class Arista{
	        public Vertice o;
	        public Vertice d;

	        public Arista(Vertice o, Vertice d){
	            this.o = o;
	            this.d = d;
	        }
	        public String toString(){
	        	String s = "A : ( " + o.getElemento()+","+d.getElemento() + ")";
	        	return s;
	        }
	    }

	    private LinkedList<Vertice> vertices;
	    private LinkedList<Arista> aristas;

	    public Grafica(){
	    	vertices = new LinkedList<Vertice>();
	    	aristas = new LinkedList<Arista>();
	    }

	    public void agrega(Integer a){
	    	if(!vertices.contains(a))
	    		vertices.add(new Vertice(a));
	    }

	    public void conecta(Vertice va, Vertice vb){
	    	va.vecinos.add(vb);
	    	vb.vecinos.add(va);
	    	Arista ar = new Arista(va,vb);
	    	this.aristas.add(ar);
	    }


	    public int getNumVert(){
	    	return this.vertices.size();
	    }

	    public int getNumArist(){
	    	return this.aristas.size();
	    }

	    public double suma(){
	    	double s = 0;
	    	for(Vertice v : vertices){
	    		s += v.getDegree();
	    	}
	    	return s;
	    }

	    public double probabilidad(Vertice nuevo, Vertice i){
	    	double sigma = suma();
	    	double degree = i.getDegree();
	    	double resultado = degree / sigma;
	    	return resultado;
	    }

	    public void conectaBarabasi(Vertice n){
	    	Random rnd = new Random();
	    	double r = rnd.nextDouble();
	    	double p = 0;
	    	for(Vertice v : vertices){
	    		p = probabilidad(n,v);
	    		if(r<p){
	    			conecta(v,n);
	    		}
	    	}
		}

	

	    public void redBarabasi(Integer n){
	    	LinkedList<Vertice> lv = new LinkedList<Vertice>();
	    	for (int i= 1; i<= n; i++){
	    		Vertice v = new Vertice(i);
	    		lv.add(v);
	    	}
	    	this.vertices = lv;
	    	conecta(vertices.get(0),vertices.get(1));
	    	for(int j = 2; j<vertices.size(); j++){
	    		conectaBarabasi(vertices.get(j));
	    	}
	    }

	    public String toStringArista(){
	    	String s = "";
	    	for(Arista a : aristas){
	    		s+= "( " + a.toString() + ")";
	    	}
	    	return s;
	    }

	    public String toStringVertices(){
	    	String s = "";
	    	for(Vertice v : vertices){
	    		s+= "[ " + "( " +v.getElemento() + ")" +"]";
	    	}
	    	return s;
	    }

	   	public LinkedList<Arista> eliminaLoop(){
	   		Iterator<Arista> it = aristas.iterator(); 
	   		while(it.hasNext()){
	   			Arista a = it.next();
	   			if(a.o.getElemento() == a.d.getElemento())
	   				it.remove();
	   		}
	   		return aristas;
	   	}

	  

	    public String toString(){
	    	String s = "";
	    	s = "\n la grafica tiene los vertices: \n " + toStringVertices() + " tiene las aristas: \n" + eliminaLoop();
	    	String x = "\n La grafica tiene : " + getNumVert() + " vertices y " + getNumArist() + " aristas"; 
	    	return s+x;
	    }	

	}