# language: es
	Característica: solicitar voto
	  Escenario: Datos del votante correctos
	    Cuando entra en /
	    Entonces se ve la lista de las votaciones disponibles
	    Y decide la votacion y hace click en solicitar
	    Entonces se le piden sus datos(correctos) para finalizar la votacion
	    Y al ser correctos se le indica con un mensaje
	    
	  Escenario: Datos del votante incorrectos
	    Cuando entra en /
	    Entonces se ve la lista de las votaciones disponibles
	    Y decide la votacion y hace click en solicitar
	    Entonces se le piden sus datos(incorrectos) para finalizar la votacion
	    Y al ser incorrectos se le indica con un mensaje
