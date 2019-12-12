package com.sample.infrastructure.persistence

import com.sample.domain.entities.Message
import com.sample.domain.gateway.MessageGateway


class MessageGatewayImpl (private val messageRepository: MessageRepository?= null) : MessageGateway {
    override fun getMessagesByType(type: String): List<Message> {
        return messageRepository!!.getMessagesByType(type)
    }

    override fun create(message: Message): Message {
        return messageRepository!!.save(message)
    }
}