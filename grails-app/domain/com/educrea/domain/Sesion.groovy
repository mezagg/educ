package com.educrea.domain

class Sesion {
    Integer id
    String nombre
    String descripcion
    String instrucciones
     
    static belongsTo = [modulo: Modulo]
    static constraints = {
        nombre: blank: false
        
    }
}
