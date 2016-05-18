package com.educrea.domain.domicilio

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
@Transactional(readOnly = true)
class TipoAsentamientoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TipoAsentamiento.list(params), model:[tipoAsentamientoCount: TipoAsentamiento.count()]
    }

    def show(TipoAsentamiento tipoAsentamiento) {
        respond tipoAsentamiento
    }

    def create() {
        respond new TipoAsentamiento(params)
    }

    @Transactional
    def save(TipoAsentamiento tipoAsentamiento) {
        if (tipoAsentamiento == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tipoAsentamiento.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tipoAsentamiento.errors, view:'create'
            return
        }

        tipoAsentamiento.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoAsentamiento.label', default: 'TipoAsentamiento'), tipoAsentamiento.id])
                redirect tipoAsentamiento
            }
            '*' { respond tipoAsentamiento, [status: CREATED] }
        }
    }

    def edit(TipoAsentamiento tipoAsentamiento) {
        respond tipoAsentamiento
    }

    @Transactional
    def update(TipoAsentamiento tipoAsentamiento) {
        if (tipoAsentamiento == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tipoAsentamiento.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tipoAsentamiento.errors, view:'edit'
            return
        }

        tipoAsentamiento.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tipoAsentamiento.label', default: 'TipoAsentamiento'), tipoAsentamiento.id])
                redirect tipoAsentamiento
            }
            '*'{ respond tipoAsentamiento, [status: OK] }
        }
    }

    @Transactional
    def delete(TipoAsentamiento tipoAsentamiento) {

        if (tipoAsentamiento == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        tipoAsentamiento.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tipoAsentamiento.label', default: 'TipoAsentamiento'), tipoAsentamiento.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoAsentamiento.label', default: 'TipoAsentamiento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
