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
		a = Edges(vorigen,vdestino)
		self.listaAristas.append(a)

	def vertices(self):
		return self.listaVertices
	
	def edges(self):
		return self.listaAristas
	

	def probabilidad(self, v1, v2):
		ki = v2.degree()
		suma = 0
		for vertice in self.listaVertices:
			suma = suma + vertice.degree()
		return ki / suma



	def practica(self, n):
		l = self.listaVertices
		for i in range (1,n+1):
			v = Vertex(i)
			l.append(v)

		if len(l) > 2:
			a = Edges(l[0],l[1])
			self.listaAristas.append(a)
			for i in range(0,len(l)+1):
				for j in range (2,len(l)+1):
					p = self.probabilidad(l[j],l[i])
					r = random.uniform(0,1)
					if r < p:
						agregaArista(l[i],l[j])
					else:
						i = i + 1

		 							 

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
g.practica(14)


print g.getVertices()

print g.getAristas()