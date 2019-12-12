package com.sample.infrastructure.queue.kafka

import com.sample.infrastructure.queue.MessagePublisher
import com.sample.infrastructure.queue.kafka.client.KafkaClient
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.util.StdDateFormat
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.apache.kafka.clients.producer.ProducerRecord
import com.sample.domain.entities.Message

class KafkaProducer(): MessagePublisher {
    private val kafkaClient = KafkaClient()

    override fun publish(message: Message) {
        val producer = kafkaClient.createProducer("127.0.0.1:9092")
        try {
            val messageJson = jsonMapper.writeValueAsString(message)
            producer.send(ProducerRecord("test", messageJson))
            producer.flush()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            producer.close()
        }
    }

    private val jsonMapper = ObjectMapper().apply {
        registerKotlinModule()
        disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        dateFormat = StdDateFormat()
    }
}