package com.educrea.domain.domicilio

class TipoAsentamiento implements Serializable {
    Integer id
    String nombre
    
    public TipoAsentamiento(String nombre){
        this()
        this.nombre = nombre
    }
    
    static constraints = {
    }
}
