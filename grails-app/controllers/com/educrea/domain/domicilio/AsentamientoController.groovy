package com.educrea.domain.domicilio

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
@Transactional(readOnly = true)
class AsentamientoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Asentamiento.list(params), model:[asentamientoCount: Asentamiento.count()]
    }

    def show(Asentamiento asentamiento) {
        respond asentamiento
    }

    def create() {
        respond new Asentamiento(params)
    }

    @Transactional
    def save(Asentamiento asentamiento) {
        if (asentamiento == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (asentamiento.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond asentamiento.errors, view:'create'
            return
        }

        asentamiento.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'asentamiento.label', default: 'Asentamiento'), asentamiento.id])
                redirect asentamiento
            }
            '*' { respond asentamiento, [status: CREATED] }
        }
    }

    def edit(Asentamiento asentamiento) {
        respond asentamiento
    }

    @Transactional
    def update(Asentamiento asentamiento) {
        if (asentamiento == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (asentamiento.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond asentamiento.errors, view:'edit'
            return
        }

        asentamiento.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'asentamiento.label', default: 'Asentamiento'), asentamiento.id])
                redirect asentamiento
            }
            '*'{ respond asentamiento, [status: OK] }
        }
    }

    @Transactional
    def delete(Asentamiento asentamiento) {

        if (asentamiento == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        asentamiento.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'asentamiento.label', default: 'Asentamiento'), asentamiento.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'asentamiento.label', default: 'Asentamiento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
