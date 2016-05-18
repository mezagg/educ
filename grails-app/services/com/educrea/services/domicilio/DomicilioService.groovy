package com.educrea.services.domicilio

import grails.transaction.Transactional

@Transactional
class DomicilioService {

    def buscaPorCodigoPostal(def fechaEvento) {
        log.debug("Codigo Postal"+fechaEvento)
    }
}
