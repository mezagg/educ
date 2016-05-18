package com.educrea.domain

class Actividad {
    Integer id
    String nombre
    String instrucciones
    String urlImagen
    Integer orden 
    static belongsTo = [sesion: Sesion]
    static hasMany = [elementos: ElementoDigital]
    Boolean activo
    
    static constraints = {
        nombre size:1..50, blank: false
    }
}
