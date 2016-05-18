package com.educrea.domain

class ActividadUsuario {
    Integer id
    Actividad actividad
    Usuario usuario
    Double calificacion 
    
    static constraints = {
        calificacion (range: 5..10)
    }
}
