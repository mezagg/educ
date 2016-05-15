package com.educrea.domain

class Sesion {
    Integer id
    String nombre
    String descripcion
    String instrucciones
    Integer orden
     
    static belongsTo = [modulo: Modulo]
    static hasMany = [actividades: Actividad]
    
    static constraints = {
        nombre size:1..50, blank: false
        
    }
}
