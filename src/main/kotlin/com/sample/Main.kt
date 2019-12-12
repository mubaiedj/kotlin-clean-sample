package com.sample

import com.sample.infrastructure.queue.kafka.KafkaProducer
import com.sample.domain.usecases.CreateMessageImpl
import com.sample.domain.usecases.GetMessagesByTypeImpl
import com.sample.infrastructure.api.Api
import com.sample.infrastructure.persistence.MessageGatewayImpl
import com.sample.infrastructure.persistence.memory.InMemoryDb
import com.sample.infrastructure.queue.kafka.KafkaConsumer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking<Unit> {
    println("Loading app...")

    //Create repository
    val repository = InMemoryDb()
    //val repository = DocumentDb()
    val messageGateway = MessageGatewayImpl(repository)

    //Create publisher
    val messagePublisher = KafkaProducer()

    //Injecting repository in usecase
    val createMessage = CreateMessageImpl(messageGateway, messagePublisher)
    val getMessagesByType = GetMessagesByTypeImpl(messageGateway)

    //Inject usecases in web server
    val api = Api(createMessage, getMessagesByType)

    //Load web server
    api.createServer()

    //Load queue consumer
    /*launch(Dispatchers.IO) {
        KafkaConsumer().startConsumer()
    }*/

    println("Ready")
}
