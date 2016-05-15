package com.educrea.domain

class Actividad {
    Integer id
    String nombre
    String instrucciones
    Integer orden 
    static belongsTo = [sesion: Sesion]
    
    static constraints = {
        nombre size:1..50, blank: false
    }
}
