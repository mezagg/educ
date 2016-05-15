package com.educrea.domain

class DuracionCurso {
    
    Integer duracion
    Integer numeroSesiones
    Integer totalHoras
    Integer horasPorSesion
    
    static constraints = {
        horasPorSesion (range: 2..8)
        
    }
}
