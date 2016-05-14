package com.educrea.domain

class Curso {
    Integer id
    String acronimo
    String nombre
    String descripcion
    String objetivo
    
    
    static hasMany = [modulos: Modulo]
    
    static constraints = {
        
    }
}
