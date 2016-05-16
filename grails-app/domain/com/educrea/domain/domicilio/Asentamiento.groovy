package com.educrea.domain.domicilio

class Asentamiento {
    Integer id
    String nombre
    static belongsTo = [localidad: Localidad]
    TipoAsentamiento tipoAsentamiento
    static constraints = {
    }
}
