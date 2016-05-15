package com.educrea.domain

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
@Transactional(readOnly = true)
class DuracionCursoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond DuracionCurso.list(params), model:[duracionCursoCount: DuracionCurso.count()]
    }

    def show(DuracionCurso duracionCurso) {
        respond duracionCurso
    }

    def create() {
        respond new DuracionCurso(params)
    }

    @Transactional
    def save(DuracionCurso duracionCurso) {
        if (duracionCurso == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (duracionCurso.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond duracionCurso.errors, view:'create'
            return
        }

        duracionCurso.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'duracionCurso.label', default: 'DuracionCurso'), duracionCurso.id])
                redirect duracionCurso
            }
            '*' { respond duracionCurso, [status: CREATED] }
        }
    }

    def edit(DuracionCurso duracionCurso) {
        respond duracionCurso
    }

    @Transactional
    def update(DuracionCurso duracionCurso) {
        if (duracionCurso == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (duracionCurso.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond duracionCurso.errors, view:'edit'
            return
        }

        duracionCurso.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'duracionCurso.label', default: 'DuracionCurso'), duracionCurso.id])
                redirect duracionCurso
            }
            '*'{ respond duracionCurso, [status: OK] }
        }
    }

    @Transactional
    def delete(DuracionCurso duracionCurso) {

        if (duracionCurso == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        duracionCurso.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'duracionCurso.label', default: 'DuracionCurso'), duracionCurso.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'duracionCurso.label', default: 'DuracionCurso'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
