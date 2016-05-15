package com.educrea.domain

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
@Transactional(readOnly = true)
class ActividadController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Actividad.list(params), model:[actividadCount: Actividad.count()]
    }

    def show(Actividad actividad) {
        respond actividad
    }

    def create() {
        respond new Actividad(params)
    }

    @Transactional
    def save(Actividad actividad) {
        if (actividad == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (actividad.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond actividad.errors, view:'create'
            return
        }

        actividad.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'actividad.label', default: 'Actividad'), actividad.id])
                redirect actividad
            }
            '*' { respond actividad, [status: CREATED] }
        }
    }

    def edit(Actividad actividad) {
        respond actividad
    }

    @Transactional
    def update(Actividad actividad) {
        if (actividad == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (actividad.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond actividad.errors, view:'edit'
            return
        }

        actividad.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'actividad.label', default: 'Actividad'), actividad.id])
                redirect actividad
            }
            '*'{ respond actividad, [status: OK] }
        }
    }

    @Transactional
    def delete(Actividad actividad) {

        if (actividad == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        actividad.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'actividad.label', default: 'Actividad'), actividad.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'actividad.label', default: 'Actividad'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
