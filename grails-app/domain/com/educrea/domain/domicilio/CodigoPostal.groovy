package com.educrea.domain.domicilio

class CodigoPostal {
    Integer id
    String clave
    static hasMany = [localidad: Localidad]
    
    static constraints = {
    }
}
