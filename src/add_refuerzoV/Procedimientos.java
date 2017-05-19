/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package add_refuerzoV;

/**
 *
 * @author ruben
 */
public class Procedimientos {
    
    //listas pacaientes por años
        /*
            USE `HOSPITAL`;
            DROP procedure IF EXISTS `listado_anios`;

            DELIMITER $$
            USE `HOSPITAL`$$
            CREATE PROCEDURE `listado_anios` ()
            BEGIN

                    Select year(fecha_alta), count(dni) as cuantos from Pacientes 
                group by year(fecha_alta);			


            END$$

            DELIMITER ; 
        */
    
    
    //ingresar pacientes que existan o no y mostrar mensaje
        /*
            USE `HOSPITAL`;
            DROP procedure IF EXISTS `ingresos`;

            DELIMITER $$
            USE `HOSPITAL`$$
            CREATE DEFINER=`root`@`localhost` PROCEDURE `ingresos`(id smallint(4), nombre varchar(40), apellidos varchar(40), dni varchar(10) )
            BEGIN
                    insert into Pacientes values(id,nombre,apellidos, ADDDATE(current_date(),14), dni,current_date());
            END$$

            DELIMITER ;
        */
}
