CREATE DEFINER=`root`@`localhost` PROCEDURE `ingresos`(id smallint(4), nombre varchar(40), apellidos varchar(40), dni varchar(10) )
BEGIN
	insert into Pacientes values(id,nombre,apellidos, ADDDATE(current_date(),14), dni,current_date());
END