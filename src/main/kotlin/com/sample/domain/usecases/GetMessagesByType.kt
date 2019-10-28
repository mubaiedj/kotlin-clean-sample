package com.sample.domain.usecases

import com.sample.domain.entities.Message

interface GetMessagesByType {
    fun getByType(request: Request): Response

    data class Request(val type: String)

    data class Response(val messages: List<Message>)
}