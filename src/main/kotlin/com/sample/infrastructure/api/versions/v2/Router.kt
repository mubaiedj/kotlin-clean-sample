package com.sample.infrastructure.api.versions.v2

import io.javalin.apibuilder.ApiBuilder
import io.javalin.apibuilder.EndpointGroup
import io.javalin.apibuilder.ApiBuilder.*

class Router : EndpointGroup {
    override fun addEndpoints() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    init {
        path("v2") {
            get("/") { ctx ->
                ctx.result("Hello v2")
            }
        }
    }
}