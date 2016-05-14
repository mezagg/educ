package com.educrea.domain

class Usuario {
    
    String login
    String password
    
    String nombre
    String apellidoPaterno
    String apellidoMaterno
    String rfc
    
    Date fechaNacimiento
    
    
    int nivel
    String email
    
    static constraints = {
        login size: 5..15, blank: false, unique: true
        email email: true, blank: false
        fechaNacimiento: blank:false
        //age min: 18
    }
}
