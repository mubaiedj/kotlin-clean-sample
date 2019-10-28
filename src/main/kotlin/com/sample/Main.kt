package com.sample

import com.sample.infrastructure.queue.kafka.KafkaProducer
import com.sample.domain.usecases.CreateMessageImpl
import com.sample.domain.usecases.GetMessagesByTypeImpl
import com.sample.infrastructure.api.Api
import com.sample.infrastructure.persistence.MessageGatewayImpl
import com.sample.infrastructure.persistence.memory.InMemoryDb

fun main(args: Array<String>) {
    println("Loading app...")
    val repository = InMemoryDb()
    //val repository = DocumentDb()
    val messagePublisher = KafkaProducer()
    val messageGateway = MessageGatewayImpl(repository)
    val createMessage = CreateMessageImpl(messageGateway, messagePublisher)
    val getMessagesByType = GetMessagesByTypeImpl(messageGateway)
    val api = Api(createMessage, getMessagesByType)
    api.createServer()
    println("Ready")
}