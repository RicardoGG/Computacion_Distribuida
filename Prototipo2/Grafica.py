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
		vorigen.agregaVecino(vdestino)
		vdestino.agregaVecino(vorigen)
		a = Edges(origen,destino)
		self.listaAristas.append(a)
		return True

	def vertices(self):
		return str(self.listaVertices)
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

		for v in l:
			if len(l) == 2:
				a = Edges(l[0],l[1])
				self.listaAristas.append(a)



g = Graph([])
g.practica(2)


print g.vertices()

print g.edges()