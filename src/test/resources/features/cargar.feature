# language: es
	Característica: cargar votos como junta electoral
	  Escenario: Campos rellenados con numeros positivos
	    Cuando Entra en la web
	   	Entonces Va a la zona de votaciones para gestionar
	  	Y decide gestionar una votacion que quiere
	    Entonces introduciendo todos los votos y la cuenta "administracion@juntaElectoral.es" y password "cambiar"
	    Entonces se le muestra el mensaje "Carga de votos correcta" en voteInput
	  	Escenario: votos con cuenta no administracion
	    Cuando entra en la web de nuevo
	    Entonces Va a la zona de votaciones para gestionar de nuevo parasi gestionar una votacion que quiere
	    Entonces introduciendo todos los votos y la cuenta "nosoyAdmin@no.com" y password "nop"
	    Entonces se le muestra el mensaje "Usuario incorrecto."  al no ser admin
		