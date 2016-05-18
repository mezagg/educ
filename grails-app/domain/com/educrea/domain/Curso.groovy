package com.educrea.domain

class Curso {
    Integer id
    String acronimo
    String nombre
   
    String objetivo
    String descripcion
    String urlImagen
    Boolean activo
    
    
    enum ModalidadCurso {
    VIRTUAL, PRESENCIAL
    }

    ModalidadCurso modalidad
    
    public Curso(acronimo, nombre){
        this.acronimo = acronimo
        this.nombre= nombre
    }
    
    static hasMany = [modulos: Modulo]
    
    static constraints = {
        nombre blank:false
        acronimo unique: true
        modalidad blank: false
    }
}
