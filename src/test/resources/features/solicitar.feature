# language: es
<<<<<<< HEAD
	Característica: configurar votacion  
	  Escenario: Datos de configuracion incorrectos
	    Cuando entra en /admin/configuration.xhtml
	    Entonces se ven las opciones disponibles
	    Y elige las opciones dejando campos vacios y hace click en validar
	    Entonces se le muestra un mensaje que indica que debe cubrir todos los campos
=======
	Característica: solicitar voto
	  Escenario: Datos del votante correctos
	    Cuando entra en la web
	    Entonces se ve la lista de las votaciones disponibles
	    Y decide la votacion y hace click en solicitar
	    Entonces se le piden sus datos para solicitar el voto telematico
	    Y introduce su email "pepe@gmail.com" y password "12345"
	    Entonces se le muestra el mensaje "Voto telematico admitido" referente al voto telematico
	    
	  Escenario: Datos del votante incorrectos
	    Cuando entra en la web
	    Entonces se ve la lista de las votaciones disponibles
	    Y decide la votacion y hace click en solicitar
	    Entonces se le piden sus datos para solicitar el voto telematico
	    Y introduce su email "pepe@pepe.com" y password "12345"
	    Entonces se le muestra el mensaje "Correo electronico y/o contraseña incorrectos" referente al voto telematico
>>>>>>> origin/master
