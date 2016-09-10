class Vertice:

	"""TODO VERTICE CONTIENE UN ELEMENTO Y 
	TIENE UNA LISTA DE VERTICES ADYACENTES"""
	elemento = None
	lista_vecinos = []

	
	def __init__(self, elemento):
		self.elemento = elemento

	def getValue(self):
		return str(self.elemento)

	def getDegree(self):
		degree = len(self.lista_vecinos)
		return degree
