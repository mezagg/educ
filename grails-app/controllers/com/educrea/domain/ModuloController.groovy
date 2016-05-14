package com.educrea.domain

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
@Transactional(readOnly = true)
class ModuloController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Modulo.list(params), model:[moduloCount: Modulo.count()]
    }

    def show(Modulo modulo) {
        respond modulo
    }

    def create() {
        respond new Modulo(params)
    }

    @Transactional
    def save(Modulo modulo) {
        if (modulo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (modulo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond modulo.errors, view:'create'
            return
        }

        modulo.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'modulo.label', default: 'Modulo'), modulo.id])
                redirect modulo
            }
            '*' { respond modulo, [status: CREATED] }
        }
    }

    def edit(Modulo modulo) {
        respond modulo
    }

    @Transactional
    def update(Modulo modulo) {
        if (modulo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (modulo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond modulo.errors, view:'edit'
            return
        }

        modulo.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'modulo.label', default: 'Modulo'), modulo.id])
                redirect modulo
            }
            '*'{ respond modulo, [status: OK] }
        }
    }

    @Transactional
    def delete(Modulo modulo) {

        if (modulo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        modulo.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'modulo.label', default: 'Modulo'), modulo.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'modulo.label', default: 'Modulo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
