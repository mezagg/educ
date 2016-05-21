package com.educrea.services

import com.educrea.domain.domicilio.Asentamiento


import grails.transaction.Transactional

@Transactional
class CatalogoService {

    def List buscaPorCodigoPostal(String codigoPostal) {
        log.error("buscaPorCodigoPostal:"+codigoPostal);
        return Asentamiento.findAllByCodigoPostal(codigoPostal);
        //return Asentamiento.findAll();
    }
}
