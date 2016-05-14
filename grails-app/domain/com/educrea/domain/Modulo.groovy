package com.educrea.domain

class Modulo {
    Integer id
    String nombre
    String descripcion
     static belongsTo = [curso: Curso]
     
    static constraints = {
    }
}
