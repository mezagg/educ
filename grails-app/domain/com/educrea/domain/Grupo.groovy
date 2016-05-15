package com.educrea.domain

class Grupo {
    Integer id
    String nombre
    Integer anio
    Date fechaInicial
    Date fechaFinal
    DuracionCurso duracion
    Integer numeroAlumnos
    Double precio
    Integer porcentajeDescuento
    
    static constraints = {
        precio precision:2
        fechaInicial (min: new Date())
        porcentajeDescuento (size:2)
        porcentajeDescuento (range: 0..100)
        porcentajeDescuento blank:false
    }
}
