package com.educrea.domain.domicilio

class EntidadFederativa {
    Integer id

    String nombre
    String abreviatura

    public EntidadFederativa(Integer id, String abreviatura, String nombre){
        this.id = id
        this.abreviatura = abreviatura
        this.nombre = nombre
    }

    static belongsTo = [pais: Pais]
    static hasMany = [municipios: Municipio]
    static constraints = {
    }
    String toString(){
        return "id:"+id+" clave:"+clave+" nombre:"+nombre
    }
}
