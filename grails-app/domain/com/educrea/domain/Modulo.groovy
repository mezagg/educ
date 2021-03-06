package com.educrea.domain

class Modulo {
    Integer id
    String nombre
    String descripcion
    Boolean activo
    Integer orden
    String urlImagen
    
    static hasMany = [sesiones: Sesion]
    static belongsTo = [curso: Curso]
    
    public Modulo(nombre){
        this.nombre = nombre
    }
    
    public Modulo(nombre, curso){
        this.nombre = nombre
        this.curso = curso
    }
    
    static constraints = {
         nombre blank:false 
    }
}
