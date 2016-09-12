import java.util.LinkedList;
import java.util.Random;

public class Grafica<T>{

    /**
    *
    *Constructor de Vertices**/

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

    /**
    *Variables: Todo grafo tendra un numero de aristas y una lista de vertices*/

	private LinkedList<Vertice> vertices;
	private int aristas;

    /**
    *Inicializacion de valores de la grafica*/
	public Grafica(){
		vertices = new LinkedList<Vertice>();
		aristas = 0;
	}

    /**
    *
    *Castea Numeros
    *y los asigna como lista de vertices 
    *@param l-  la lista de numeros a asignar 
    **/

    public void setVertices(LinkedList<Integer> l){         
        LinkedList<Vertice> lv = new LinkedList<Vertice>();
        for(Integer i: l){
            Vertice v = new Vertice(i);
            lv.add(v);    
        }
        this.vertices = lv;

    }

    /**
    *
    *Agrega un entero a la grafica **/
	public void agrega(Integer e){
		Vertice  vertice = new Vertice(e);
		vertices.add(vertice);
	}

    /**Conecta dos elementos **/
    public void conectaEnteros(Integer a, Integer b){
        Vertice va = new Vertice(a);
        Vertice vb = new Vertice(b);
        va.adyacentes.add(vb);
        vb.adyacentes.add(va);
        aristas ++;   
    }


    /**
    *Dados el elemento nuevo y el elemento i-esimo
    *calcular con el modelo de barabasi**/
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
    //@param nuevo -El valor del elemento a agregar
    /**
    *Conecta un elemento a la grafica de acuerdo con el criterio del modelo de barabasi**/

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

    /**Devuelve una representacion en cadena de los vertices**/
    private String getVertices(){
        String s = "";       
        for(Vertice v : vertices){
            s+= v.getElemento() + " ";
        }    
        return s;             
    }

    private String getGrados(){
        String s = "";
        for(Vertice v: vertices){
            s+= v.getGrado() + " ";
        }
        return "Los vertices tienen los grados: " + s;
    }

    public String principal(LinkedList<Integer> l){               
        setVertices(l);
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


    public String toString(){
        String s = "";
        String a = "";
        s= "La grafica tiene los siguientes vertices: " + getVertices();
        a=  getGrados();
        return s + a;
    }


}