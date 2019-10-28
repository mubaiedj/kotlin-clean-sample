package com.sample.infrastructure.persistence

import com.sample.domain.entities.Message


interface MessageRepository {
    fun save(message: Message): Message
    fun getMessagesByType(type: String): List<Message>
}
