package com.sample.infrastructure.queue

import com.sample.domain.entities.Message

interface MessagePublisher{
    fun publish(message: Message)
}