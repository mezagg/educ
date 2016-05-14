package com.educrea.controller
import grails.plugin.springsecurity.annotation.Secured


@Secured('ROLE_ADMIN')
class MensajeController {

    
    def slackService
    
    def index() { }
    
    def envia() {
        slackService.send {
            text 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras sit amet facilisis tortor. Proin dictum nibh urna, ac mattis magna semper sed.'
            username 'mathi'
            iconUrl 'https://s3.amazonaws.com/uifaces/faces/twitter/BillSKenney/128.jpg'
            iconEmoji ':hamburger:'
            channel '@mathi'
            markdown true
            linkNames 1
            parse 'full'
            unfurlLinks false
            unfurlMedia false
            attachment {
                fallback 'This is the fallback'
                color 'good'
                authorName 'Mathi Fonseca'
                authorLink 'https://github.com/mathifonseca'
                authorIcon 'https://avatars2.githubusercontent.com/u/4367808?v=3&s=460'
                title 'Some Title'
                titleLink 'http://example.com/title'
                text 'This is the attachment text'
                imageUrl 'http://wikitravel.org/upload/shared//thumb/f/fc/Montevideo.jpg/300px-Montevideo.jpg'
                markdownIn(['text','fields'])
                field {
                    title 'Title1'
                    value 'Some long attachment field value'
                    isShort false
                }
                field {
                    title 'Title2'
                    value 'A short field'
                    isShort true
                }
                field {
                    title 'Title3'
                    value 'Another short field'
                    isShort true
                }
            }
            attachment {
                pretext 'This is the pretext'
                text 'This is another attachment'
                thumbUrl 'http://static1.squarespace.com/static/548a09b7e4b09cb7481d6e1d/t/5537e336e4b05a14c754b6d2/1429726013683/'
            }
        }
    }
}
