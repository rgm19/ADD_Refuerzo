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
}
