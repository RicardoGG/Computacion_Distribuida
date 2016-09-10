from Vertice import *

class Graph:

	list_vertex = None
	
	num_edge = None

	def __init__(self):
		self.list_vertex = [] 
		self.num_edge = 0
		

	def getNumVertex(self):
		c = len(self.list_vertex)
		return c

	def getNumEdges(self):
		return self.num_edge

	def addElement(self,element):
		global list_vertex 
		list_vertex = []
		newVertex = Vertice(element)
		self.list_vertex.append(newVertex)

	
	def printVertex(self):
		l = []
		for vertex in self.list_vertex:
			v = str(vertex.getValue())
			l.append(v)
		return l


	def verificador(self,a):
		v1 = Vertice(a)
		for vertex in self.list_vertex:
			if v1.getValue() == vertex.getValue() :
				return True
		return False

	def connect(self,a,b):
		v1 = Vertice(a)
		v2 = Vertice(b)
		if self.verificador(v1) == True  and verificador(v2) == True:
			v1.lista_vecinos.append(v2)
			v2.lista_vecinos.append(v1)
			self.num_edge+=1
			
		



g= Graph()

g.addElement(4)
g.addElement(3)
g.addElement(56)
g.addElement(42)
print g.connect(42,3)









			