package com.educrea.domain

class Domicilio {
    
    String calle
    String numero
    String codigoPostal
    
    enum TipoDomicilio {
        PERSONAL, OFICINA, FACTURACION
    }
    static constraints = {
    }
}
