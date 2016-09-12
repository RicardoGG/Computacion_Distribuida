from Vertice import *

class Edges:

	origen = ""
	destino = ""
	def __init__(self,origen,destino,peso):
		self.origen = origen
		self.destino = destino
		

	def printArista(self):
		print self.origen.getElement(), self.destino.getElement()

	def svertex(self):
		return self.origen

	def tvertex(self):
		return self.destino
