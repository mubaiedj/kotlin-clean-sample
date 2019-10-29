package com.sample.infrastructure.api.versions.v1.modelA

import io.javalin.apibuilder.ApiBuilder.after
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.EndpointGroup

class GETModelAHandler: EndpointGroup {
    override fun addEndpoints() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        private const val path: String = "/"
    }

    init {
        get(path) {ctx ->
            ctx.result("Hello world GETModelAHandler")
        }
        after(path) { ctx ->
            ctx.status(400)
        }
    }
}