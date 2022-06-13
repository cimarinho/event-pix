package com.example.application

import com.example.presenter.PixRequest
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer

import java.util.*

class PixApplication {


    fun sendMessage(pixRequest: PixRequest) {

        val props = Properties()
        props["bootstrap.servers"] = "localhost:9092"
        props["key.serializer"] = StringSerializer::class.java
        props["value.serializer"] = StringSerializer::class.java

        val producer =  KafkaProducer<String, String>(props)
        val objectMapper = ObjectMapper()
        objectMapper.findAndRegisterModules()
        val node = objectMapper.valueToTree<JsonNode>(pixRequest)
        val topic = "pix_test01_topic"

        val future = producer.send(ProducerRecord(topic, pixRequest.id.toString(), node.toString()))
        future.get()

    }


}