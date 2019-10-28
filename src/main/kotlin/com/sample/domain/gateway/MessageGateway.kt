package com.sample.domain.gateway

import com.sample.domain.entities.Message

interface MessageGateway {
    fun create(message: Message): Message
    fun getMessagesByType(type: String): List<Message>
}
