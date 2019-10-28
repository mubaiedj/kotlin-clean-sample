package com.sample.infrastructure.persistence.memory

import com.sample.domain.entities.Message
import com.sample.infrastructure.persistence.MessageRepository


class InMemoryDb() : MessageRepository {
    private val messageList = ArrayList<Message>()
    override fun save(message: Message): Message {
        messageList.add(message);
        println("Type: ${message.type} - Message: ${message.content} - ${messageList.size}")
        return message
    }

    override fun getMessagesByType(type: String): List<Message> {
        return messageList.filter { message -> message.type == type }
    }
}