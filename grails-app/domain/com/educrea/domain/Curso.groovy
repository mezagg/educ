package com.educrea.domain

class Curso {
    Integer id
    String acronimo
    String nombre
   
    String objetivo
    String descripcion
    String urlImagen
    Boolean activo
    
    public Curso(String acronimo,  String descripcion,  String nombre, String objetivo, String url ){
        this.acronimo = acronimo
        this.nombre= nombre
        this.objetivo = objetivo
        this.descripcion= descripcion
        this.urlImagen = url
        this.modalidad = ModalidadCurso.VIRTUAL
        this.activo=true
        
    }
    
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
