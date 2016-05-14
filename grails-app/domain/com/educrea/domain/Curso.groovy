package com.educrea.domain

class Curso {
    Integer id
    String acronimo
    String nombre
    String descripcion
    String objetivo
    Boolean activo
    
    public Curso(acronimo, nombre){
        this.acronimo = acronimo
        this.nombre= nombre
    }
    
    static hasMany = [modulos: Modulo]
    
    static constraints = {
        
    }
}
