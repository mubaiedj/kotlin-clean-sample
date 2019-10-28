package com.sample.domain.usecases

import com.sample.domain.entities.Message
import com.sample.domain.gateway.MessageGateway
import com.sample.infrastructure.queue.MessagePublisher
import java.util.*

class CreateMessageImpl(private val messageGateway: MessageGateway?, private val messagePublisher: MessagePublisher?) :
    CreateMessage {
    override fun create(request: CreateMessage.Request): CreateMessage.Response {
        val message = messageGateway!!.create(request.toDomain())
        messagePublisher!!.publish(message)
        return CreateMessage.Response(message)
    }

    private fun CreateMessage.Request.toDomain(): Message {
        return Message(UUID.randomUUID().toString(), type, content)
    }
}

