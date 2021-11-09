package com.sample.infrastructure.api.versions.v1.modelB

import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.EndpointGroup


class GETModelBHandler: EndpointGroup {
    override fun addEndpoints() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        private const val path: String = "/"
    }

    init {
        get(path) { ctx ->
            ctx.result("Hello GETModelAHandler")
        }
    }
}