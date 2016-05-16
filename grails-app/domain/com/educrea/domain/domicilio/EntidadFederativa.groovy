package com.educrea.domain.domicilio

class EntidadFederativa {
    Integer id
    String clave
    String nombre
    String abreviatura
    
    static belongsTo = [pais: Pais]
    static hasMany = [municipios: Municipio]
    static constraints = {
    }
}