package com.educrea.domain.utils

import java.sql.Timestamp

/**
*
*/
class Bitacora {
    Integer id
    
    enum TipoEvento{
        CURSO, USUARIO, EVALUACION, CATALOGO, ACTIVIDAD
    }
    String aplicacion
    String detalle
    Date fechaEvento
    String creadoPor
    
    static constraints = {
        fechaEvento blank:false
        //fechaEvento defaultValue: new Date()
    }
}
