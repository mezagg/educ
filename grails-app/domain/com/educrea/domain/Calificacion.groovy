package com.educrea.domain

class Calificacion {
    Integer id
    Double calificacion
    Usuario usuario
    Curso curso
    
    static constraints = {
        calificacion blank: false
        calificacion (range: 5..10)
        
    }
}
