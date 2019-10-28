package com.sample.infrastructure.persistence.mongo

import com.sample.infrastructure.persistence.MessageRepository
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import com.sample.domain.entities.Message

class DocumentDb(): MessageRepository {

    val client = KMongo.createClient("localhost:27017")
    val database = client.getDatabase("testing")
    val col = database.getCollection<Message>()

    override fun save(message: Message): Message {
        col.insertOne(message)
        return message
    }

    override fun getMessagesByType(type: String): List<Message> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}