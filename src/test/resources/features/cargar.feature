# language: es
	Característica: cargar votos como junta electoral
	  Escenario: Campos rellenados con numeros positivos
	    Cuando Entra en la web
	   	Entonces Va a la zona de votaciones para gestionar
	  	Y decide gestionar una votacion que quiere
	    Entonces rellena los votos de los partidos
	    Y introduciendo todos los votos y la cuenta "administracion@juntaElectoral.es" y password "cambiar"
	    Entonces se le muestra el mensaje "Carga de datos correcta" referente al voto telematico
	  Escenario: votos con numero negativos
	    Cuando entra en la web
	    Entonces se ve la lista de las votaciones disponibles
	    Y decide la votacion y hace click en solicitar
	    Entonces se le piden sus datos para solicitar el voto telematico
		Y introduciendo todos los votos y la cuenta "administracion@juntaElectoral.es" y password "cambiar"
	    Entonces se le muestra el mensaje "Votos negativos" 
		Escenario: votos con cuenta no administracion
	    Cuando entra en la web
	    Entonces se ve la lista de las votaciones disponibles
	    Y decide la votacion y hace click en solicitar
	    Entonces se le piden sus datos para solicitar el voto telematico
		Y introduciendo todos los votos y la cuenta que NO sea "administracion@juntaElectoral.es" y password "cambiar"
	    Entonces se le muestra el mensaje "Votos negativos" 
		