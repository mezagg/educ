package com.educrea.controller

import com.educrea.services.CatalogoService
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.converters.JSON

@Secured('ROLE_ADMIN')
@Transactional(readOnly = true)
class CatalogoController {
    CatalogoService catalogoService
    
    def index() { }
    
    def cp(String id){
        log.error("codigoPostal:"+id)
        def aa= catalogoService.buscaPorCodigoPostal(id)
        log.error(aa);
        render aa as JSON;
    }
}
