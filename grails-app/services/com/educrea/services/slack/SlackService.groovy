package com.educrea.services.slack

import grails.transaction.Transactional
import grails.plugin.slack.SlackMessage
import grails.plugin.slack.builder.SlackMessageBuilder
import grails.plugin.slack.exception.SlackMessageException
import grails.plugins.rest.client.RestBuilder
import org.springframework.http.converter.StringHttpMessageConverter
import java.nio.charset.Charset

@Transactional

class SlackService {

	def grailsApplication

    void send(Closure closure) throws SlackMessageException {

    	def message = buildMessage(closure)
        log.error("message:"+message)
    	def webhook = grailsApplication.config.slack.webhook
        log.error("webhook:"+webhook)
    	if (!webhook) throw new SlackMessageException("Slack webhook is not valid")

    	try {
    		webhook.toURL()
		} catch (Exception ex) {
			throw new SlackMessageException("Slack webhook is not valid")
		}

    	def jsonMessage = message.encodeAsJson()

    	log.error "Sending message : ${jsonMessage}"

    	def rest = new RestBuilder()

		rest.restTemplate.setMessageConverters([new StringHttpMessageConverter(Charset.forName("UTF-8"))])

		def resp = rest.post(webhook.toString()) {
			header('Content-Type', 'application/json;charset=UTF-8')
			json jsonMessage.toString()
		}

		if (resp.status != 200 || resp.text != 'ok') {
			throw new SlackMessageException("Error while calling Slack -> ${resp.text}")
		}

    }

    private SlackMessage buildMessage(Closure closure) throws SlackMessageException {

    	def builder = new SlackMessageBuilder()
        closure.delegate = builder
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure.call(builder)

        def message = builder?.message

        if (!message) throw new SlackMessageException("Cannot send empty message")

        return message

    }

}

