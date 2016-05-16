package com.educrea.domain.domicilio

class Localidad {
    Integer id
    String clave
    String nombre
    Double latitud
    Double longitud
    Double altitud
    
    static belongsTo = [municipio: Municipio]
    static hasMany = [asentamientos: Asentamiento]
    
    static constraints = {
    }
}
