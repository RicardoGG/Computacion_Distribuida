from Vertice import *
#Mandar codigo fuente, grafica de distribucion de grados, distribucion de coeficiente de agrupamiento

class Edges:

	origen = None
	destino = None
	def __init__(self,origen,destino):
		self.origen = origen
		self.destino = destino

	def printArista(self):
		return " [ " + str(self.origen.getElemento()) + "," + str(self.destino.getElemento()) + " ] "

	def svertex(self):
		return self.origen

	def tvertex(self):
		return self.destino
