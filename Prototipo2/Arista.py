from Vertice import *
#Mandar codigo fuente, grafica de distribucion de grados, distribucion de coeficiente de agrupamiento

class Edges:

	origen = None
	destino = None
	def __init__(self,origen,destino):
		self.origen = origen
		self.destino = destino
		

	def __str__(self):
		cadena = self.origen.getElement(), self.destino.getElement()
		return cadena
		
	def svertex(self):
		return self.origen

	def tvertex(self):
		return self.destino
