package com.sample.infrastructure.api

import com.sample.domain.usecases.CreateMessage
import com.sample.domain.usecases.GetMessagesByType
import com.sample.infrastructure.api.versions.v1.Router as V1Router
import com.sample.infrastructure.api.versions.v2.Router as V2Router
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*

const val PORT = 80

class Api (private val createMessage: CreateMessage, private val getMessagesByType: GetMessagesByType) {
    fun createServer(){
        val app = Javalin.create().start(PORT)
        app.config.enableDevLogging()
        app.routes {
            V1Router()
            V2Router()
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