package com.sample.infrastructure.queue.kafka

import com.sample.infrastructure.queue.kafka.client.KafkaClient
import java.time.Duration

class KafkaConsumer () {
    private val kafkaClient = KafkaClient()
    fun startConsumer() {
        val consumer = kafkaClient.createConsumer("localhost:9092")
        try {
            consumer.subscribe(listOf("test"))
            while(true){
                val records = consumer.poll(Duration.ofSeconds(5))
                records.iterator().forEach {
                    println(it.value())
                }
            }
        } catch (err: Exception) {err.printStackTrace()}
    }
}