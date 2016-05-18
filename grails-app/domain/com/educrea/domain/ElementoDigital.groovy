package com.educrea.domain

import java.sql.Blob

class ElementoDigital {
    Integer id
    Integer version
    String nombre
    String descripcion
    Integer orden
    Boolean activo
    String path
    Blob archivo
    static belongsTo = [actividad: Actividad]
    
    static constraints = {
        nombre size:1..50, blank: false
    }
}
