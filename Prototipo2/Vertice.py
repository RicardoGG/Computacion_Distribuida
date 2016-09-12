from Arista import *

class Vertex:
	"""constructor de los vertices"""
	element =""
	vecinos = []
	
	
	def __init__(self, element):
		self.element = element

	def getElemento(self):
		return self.element 

	def agregaVecino(self, vecino):
		if self.vecinos.count(vecino) == 0:
			self.vecinos.append(vecino)
		
	def printVertice(self):
		print self.element, "grado: ", len(self.vecinos)

	def vecinos(self):
		return vecinos
		
	def degree(self):
		return len(self.vecinos)
