package com.educrea.domain

import grails.test.mixin.*
import spock.lang.*

@TestFor(ElementoDigitalController)
@Mock(ElementoDigital)
class ElementoDigitalControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.elementoDigitalList
            model.elementoDigitalCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.elementoDigital!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def elementoDigital = new ElementoDigital()
            elementoDigital.validate()
            controller.save(elementoDigital)

        then:"The create view is rendered again with the correct model"
            model.elementoDigital!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            elementoDigital = new ElementoDigital(params)

            controller.save(elementoDigital)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/elementoDigital/show/1'
            controller.flash.message != null
            ElementoDigital.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def elementoDigital = new ElementoDigital(params)
            controller.show(elementoDigital)

        then:"A model is populated containing the domain instance"
            model.elementoDigital == elementoDigital
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def elementoDigital = new ElementoDigital(params)
            controller.edit(elementoDigital)

        then:"A model is populated containing the domain instance"
            model.elementoDigital == elementoDigital
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/elementoDigital/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def elementoDigital = new ElementoDigital()
            elementoDigital.validate()
            controller.update(elementoDigital)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.elementoDigital == elementoDigital

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            elementoDigital = new ElementoDigital(params).save(flush: true)
            controller.update(elementoDigital)

        then:"A redirect is issued to the show action"
            elementoDigital != null
            response.redirectedUrl == "/elementoDigital/show/$elementoDigital.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/elementoDigital/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def elementoDigital = new ElementoDigital(params).save(flush: true)

        then:"It exists"
            ElementoDigital.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(elementoDigital)

        then:"The instance is deleted"
            ElementoDigital.count() == 0
            response.redirectedUrl == '/elementoDigital/index'
            flash.message != null
    }
}
