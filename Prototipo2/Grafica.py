from Vertice import *
from Arista import *
import random

class Graph:
	"""Variables de clase: 
		Una lista de Vertices
		El numero de Aristas
		un booleano a manera de String que nos dira si la grafica es o no dirigida"""
	listaVertices = []
	listaAristas = []
	
	"""Constructor de la clase"""
	def __init__(self, listVertex):
		self.listaVertices = listVertex

	def agregaVertice(self, elemento):
		v = Vertex(elemento)
		self.listaVertices.append(v)
	
	def agregaArista(self, vorigen, vdestino):
		a = Edges(origen,destino)
		self.listaAristas.append(a)

	def vertices(self):
		return self.listaVertices
	
	def edges(self):
		return self.listaAristas
	

	def probabilidad(self, v1, v2):
		vi = Vertice(v1)
		vn = Vertice(v2)
		ki = vi.degree()
		suma = 0
		for vertice in self.listaVertices:
			suma = suma + vertice.degree()
		return ki / suma

	def conectarConBarabasi(self, vn,vi):
		for i in range (1,n+1):
			p = probabilidad(vn,vi)
			r = random.uniform(0,1)
			if r < p:
			    agregaArista(vi,vn)
			else:
				print "error"


	def practica(self, n):
		l = self.listaVertices
		for i in range (1,n+1):
			v = Vertex(i)
			l.append(v)
		
		if len(l) == 2:
			agregaArista(l[0],l[1])
			 

	def getAristas(self):
		l = []
		for a in self.listaAristas:
			l.append(a.printArista())
		return l
		
	def getVertices(self):
		l = []
		for a in self.listaVertices:
			l.append(a.printVertice())
		return l

g = Graph([])
g.practica(2)


print g.getVertices()

print g.getAristas()