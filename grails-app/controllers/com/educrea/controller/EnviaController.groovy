package com.educrea.controller
import grails.plugin.springsecurity.annotation.Secured


@Secured('ROLE_ADMIN')
class EnviaController {

    def slackService 
    def index() { }
    
     def tree(){
         log.error(request.attachment)
         return 'ok'
     }
    def envia(){
        slackService.send{
               text 'Hola buenos dias.'
               username 'gmeza'
               iconEmoji ':grinning:'
               channel '#general'
               
               unfurlLinks false
               unfurlMedia false
               attachment{
                   title 'Titulo'
                   text 'Texto'
                   imageUrl 'http://www.educreaconsultoras.com.mx/wp-content/uploads/2016/03/bg_welcome.jpg'
               }
        }
        render 'ok'
    }
}
