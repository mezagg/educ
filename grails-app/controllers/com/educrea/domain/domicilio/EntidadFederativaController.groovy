package com.educrea.domain.domicilio

import com.educrea.domain.Curso
import grails.converters.JSON

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
@Transactional(readOnly = true)
class EntidadFederativaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def listar(){
        render EntidadFederativa.list() as JSON
    }
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond EntidadFederativa.list(params), model:[entidadFederativaCount: EntidadFederativa.count()]
    }

    def show(EntidadFederativa entidadFederativa) {
        respond entidadFederativa
    }

    def create() {
        respond new EntidadFederativa(params)
    }

    @Transactional
    def save(EntidadFederativa entidadFederativa) {
        if (entidadFederativa == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (entidadFederativa.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond entidadFederativa.errors, view:'create'
            return
        }

        entidadFederativa.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'entidadFederativa.label', default: 'EntidadFederativa'), entidadFederativa.id])
                redirect entidadFederativa
            }
            '*' { respond entidadFederativa, [status: CREATED] }
        }
    }

    def edit(EntidadFederativa entidadFederativa) {
        respond entidadFederativa
    }

    @Transactional
    def update(EntidadFederativa entidadFederativa) {
        if (entidadFederativa == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (entidadFederativa.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond entidadFederativa.errors, view:'edit'
            return
        }

        entidadFederativa.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'entidadFederativa.label', default: 'EntidadFederativa'), entidadFederativa.id])
                redirect entidadFederativa
            }
            '*'{ respond entidadFederativa, [status: OK] }
        }
    }

    @Transactional
    def delete(EntidadFederativa entidadFederativa) {

        if (entidadFederativa == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        entidadFederativa.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'entidadFederativa.label', default: 'EntidadFederativa'), entidadFederativa.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'entidadFederativa.label', default: 'EntidadFederativa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
