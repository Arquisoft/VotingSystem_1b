insert into USUARIOS(id, CENSUSESINFO, PASS, ENAME, NAME, NIF) VALUES(1, '13', '12345', 'pepe@gmail.com', 'Pepe', '74213763W');
	
insert into CONFIGURACION( id, name, description, application_Start, application_End, votation_Start, votation_End, multiple_Voting ) values ( 1,'Nombre', 'Descripcion', '2016-01-15 00:00:00', '2016-06-15 00:00:00', '2016-01-15 00:00:00', '2016-06-16 00:00:00', false);
insert into VOTABLE_OPTION(id, descripcion, nombre, configuration_election_id) values(1, 'PP', 'PP', 1);
insert into VOTABLE_OPTION(id, descripcion, nombre, configuration_election_id) values(2, 'PSOE', 'PSOE', 1);
insert into VOTABLE_OPTION(id, descripcion, nombre, configuration_election_id) values(3, 'Cs', 'Cs', 1);
insert into VOTABLE_OPTION(id, descripcion, nombre, configuration_election_id) values(4, 'Podemos', 'Podemos', 1);