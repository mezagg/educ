package com.educrea.domain.domicilio

class Asentamiento {
    Integer id
    String nombre
    String codigoPostal
    static belongsTo = [municipio: Municipio]
    TipoAsentamiento tipoAsentamiento
    static constraints = {
    }
}
