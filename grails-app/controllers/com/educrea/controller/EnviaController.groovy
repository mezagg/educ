package com.educrea.controller
import grails.plugin.springsecurity.annotation.Secured


@Secured('ROLE_ADMIN')
class EnviaController {

    def slackService 
    def index() { }
    
    def envia(){
        slackService.send{
         text 'Lorem ipsum dolor sit amet.'
    username 'gmeza'
    iconEmoji ':hamburger:'
    channel '@general'
    unfurlLinks false
    unfurlMedia false
        }
    }
}
