package com.educrea.domain

class Sesion {
    Integer id
    String nombre
    String descripcion
    
     
    static belongsTo = [modulo: Modulo]
    static constraints = {
    }
}
