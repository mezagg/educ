package com.educrea.domain

class Usuario {
    
    Integer id
    
    String nombre
    String segundoNombre
    String apellidoPaterno
    String apellidoMaterno
    String telefono
    
    Date fechaNacimiento
    
    /**
    * De acuerdo al numero de cursos irá incrementando su nivel
    * dentro de la plataforma.
    **/
    Integer nivel
    String email
    Domicilio domicilio
    DatosFacturacion datosFacturacion
    
    static belongsTo  = Usuario
    
    static constraints = {
        
        email email: true, blank: false
        fechaNacimiento: blank:false
        //age min: 18
    }
}
