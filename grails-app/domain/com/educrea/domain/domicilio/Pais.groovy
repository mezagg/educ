package com.educrea.domain.domicilio

class Pais implements Serializable {
    Integer id
    String iso2
    String iso3
    Integer codigoTelefono
    String nombre
    
    public Pais(String nombre, String iso2, String iso3, Integer codigoTelefono){
        this()
        this.nombre= nombre
        this.iso2 = iso2
        this.iso3 = iso3
        this.codigoTelefono = codigoTelefono
    }
    static hasMany = [estados: EntidadFederativa]
    static constraints = {
        codigoTelefono blank:true
    }
}
