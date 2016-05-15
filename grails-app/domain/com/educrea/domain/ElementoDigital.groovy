package com.educrea.domain

import java.sql.Blob

class ElementoDigital {
    Integer id
    String nombre
    String descripcion
    Integer orden
    Boolean activo
    String path
    Blob archivo
    
    static constraints = {
        nombre size:1..50, blank: false
    }
}
