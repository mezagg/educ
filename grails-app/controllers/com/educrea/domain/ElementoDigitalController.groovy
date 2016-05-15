package com.educrea.domain

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
@Transactional(readOnly = true)
class ElementoDigitalController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ElementoDigital.list(params), model:[elementoDigitalCount: ElementoDigital.count()]
    }

    def show(ElementoDigital elementoDigital) {
        respond elementoDigital
    }

    def create() {
        respond new ElementoDigital(params)
    }

    @Transactional
    def save(ElementoDigital elementoDigital) {
        if (elementoDigital == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (elementoDigital.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond elementoDigital.errors, view:'create'
            return
        }

        elementoDigital.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'elementoDigital.label', default: 'ElementoDigital'), elementoDigital.id])
                redirect elementoDigital
            }
            '*' { respond elementoDigital, [status: CREATED] }
        }
    }

    def edit(ElementoDigital elementoDigital) {
        respond elementoDigital
    }

    @Transactional
    def update(ElementoDigital elementoDigital) {
        if (elementoDigital == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (elementoDigital.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond elementoDigital.errors, view:'edit'
            return
        }

        elementoDigital.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'elementoDigital.label', default: 'ElementoDigital'), elementoDigital.id])
                redirect elementoDigital
            }
            '*'{ respond elementoDigital, [status: OK] }
        }
    }

    @Transactional
    def delete(ElementoDigital elementoDigital) {

        if (elementoDigital == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        elementoDigital.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'elementoDigital.label', default: 'ElementoDigital'), elementoDigital.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'elementoDigital.label', default: 'ElementoDigital'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
