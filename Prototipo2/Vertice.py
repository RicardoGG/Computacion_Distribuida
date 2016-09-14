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
		return self.element 

	def vecinos(self):
		return self.vecinos
		
	def degree(self):
		return len(self.vecinos)
