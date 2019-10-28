package com.sample.domain.usecases

import com.sample.domain.entities.Message

interface CreateMessage {
    fun create(request: Request): Response

    data class Request(val type: String,val content: String)

    data class Response(val message: Message)
}