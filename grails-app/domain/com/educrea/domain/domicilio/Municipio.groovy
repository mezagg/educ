package com.educrea.domain.domicilio

class Municipio {
    Integer id
    String clave
    String nombre
    
    static belongsTo = [entidadFederativa: EntidadFederativa]
    static hasMany = [localidades: Localidad]
    static constraints = {
    }
}
