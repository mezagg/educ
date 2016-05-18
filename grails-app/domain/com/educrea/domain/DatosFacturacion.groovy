package com.educrea.domain

class DatosFacturacion {
    
    String rfc
    String razonSocial
    String correo
    String nombre
    String segundoNombre
    String apellidoPaterno
    String apellidoMaterno
    Domicilio domicilio
    
    
    enum TipoPersona {
     FISICA, MORAL
    }

    
    static constraints = {
        correo blank:false, email:true
    }
}
