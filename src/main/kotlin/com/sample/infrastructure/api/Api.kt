package com.sample.infrastructure.api

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.post
import com.sample.domain.usecases.CreateMessage
import com.sample.domain.usecases.GetMessagesByType

const val PORT = 80
class Api (private val createMessage: CreateMessage, private val getMessagesByType: GetMessagesByType) {
    fun createServer(){
        val app = Javalin.create().start(PORT)
        app.routes {
            post("/message") { ctx ->
                println(ctx.body())
                val request = ctx.body<CreateMessage.Request>()
                val response =createMessage.create(request)
                ctx.json(response)
            }

            get("/message/:type") { ctx ->
                val type = ctx.pathParam("type")
                ctx.json(getMessagesByType.getByType(GetMessagesByType.Request(type)))
            }
        }
    }
}